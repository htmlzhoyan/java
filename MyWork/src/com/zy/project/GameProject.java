package com.zy.project;

import java.io.IOException;
import java.util.Comparator;
import java.util.Scanner;

import com.zy.dao.FileManager;
import com.zy.dao.GameManager;
import com.zy.game.Game;
import com.zy.myexception.CompareInvalidException;
import com.zy.myexception.EmptyInvalidException;
import com.zy.myexception.FilterInvalidException;
import com.zy.myexception.NumIdInvalidException;
import com.zy.myfilter.GameFilter;
import com.zy.myviewer.GameSystemView;
import com.zy.myviewer.impl.GameSystemViewImpl;

/**
 * 
 * @author 赵岩
 *
 */

public class GameProject {
	private static final Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		GameSystemView gv = new GameSystemViewImpl();
		FileManager fg = new FileManager();
		GameManager gm = GameManager.getInstance();
		try {
			fg.ReadMehtod(gm);
		} catch (IOException e6) {
			e6.printStackTrace();
		}
		int gameID = 0;
		char gameCh = '\0';
		int num = 0;
		do {

			gv.checkGameTotal();
			num = sc.nextInt();
			switch (num) {
			case 1:

				gm.show();

				break;
			case 2:
				String gameId = "zy" + gm.GameLength() + GameManager.random();
				gv.GameSystemAddGame();
				sc.nextLine();
				char gameType = sc.nextLine().charAt(0);
				if (gameType != '手' && gameType != '端') {
					gv.GameSystemGameType();
					gameType = '端';
				}
				gv.GameSystemAddGamePrice();
				float gamePrice = sc.nextFloat();
				gv.GameSystemAddNum();
				int gameNum = sc.nextInt();
				if (gameNum == 0) {
					gv.GameSystemAddNumMin();
					gameNum = 1;
				} else if (gameNum > 10) {
					gv.GameSystemAddNumMax();
					gameNum = 10;
				}
				gv.GameSystemAddGameName();
				String gameName = sc.next();
				gv.GameSystemAddGameAreaName();
				String gameAreaName = sc.next();
				gv.GameSystemAddGameServerName();
				String gameServerName = sc.next();
				gv.GameSystemAddGameTitle();
				String gameTitle = sc.next();
				gv.GameSystemAddGameOperatorName();
				String gameOperatorName = sc.next();
				sc.nextLine();
				gv.GameSystemAddGameScreenShot();
				char game = sc.nextLine().charAt(0);
				boolean gameScreenShot;
				if (game == 'y' || game == 'Y') {
					gameScreenShot = true;
				} else if (game == 'n' || game == 'N') {
					gameScreenShot = false;
				} else {
					gv.IsGameSystemAddGameScreenShot();
					gameScreenShot = false;
				}
				Game games = new Game(gameId, gameType, gamePrice, gameNum, gameName, gameAreaName, gameServerName,
						gameTitle, gameOperatorName, gameScreenShot);
				try {
					gm.addNewGame(games);
				} catch (EmptyInvalidException e3) {
					gv.GameSystemExceptionMessage(e3);
				} // 添加游戏账号名;

				gm.show();

				break;
			case 3:
				gv.GameSystemRemoveGame();
				gameID = sc.nextInt();
				sc.nextLine();

				try {
					gm.findGametInfoByStuID(gameID);
				} catch (NumIdInvalidException e3) {
					gv.GameSystemExceptionMessage(e3);
					break;
				}
				gv.IsGameSystemRemoveGame();
				gameCh = sc.nextLine().charAt(0);
				if ('Y' == gameCh || 'y' == gameCh) {
					try {
						gm.deleteGameByID(gameID);
					} catch (NumIdInvalidException e) {
						gv.GameSystemExceptionMessage(e);
						break;
					}
				}

				gm.show();

				break;
			case 4:
				gv.GameSystemModification();
				gameID = sc.nextInt();
				try {
					gm.modifyGameInfoByID(gameID);
				} catch (NumIdInvalidException e2) {
					gv.GameSystemExceptionMessage(e2);
				}
				break;
			case 5:
				gv.GameSystemFind();
				gameID = sc.nextInt();
				try {
					gm.findGametInfoByStuID(gameID);
				} catch (NumIdInvalidException e1) {
					gv.GameSystemExceptionMessage(e1);
				}
				break;
			case 6:
				do {
					gv.GameSystemInquireGame();
					num = sc.nextInt();
					switch (num) {
					case 1:
						// 获取游戏账号类型是手游的商品。
						try {
							gm.inquireGame(new GameFilter() {

								@Override
								public boolean filter(Object object) {
									return ((Game) object).getGameType() == '手';
								}
							});
						} catch (FilterInvalidException e) {
							gv.GameSystemExceptionMessage(e);
						}

						break;
					case 2:
						// 获取游戏账号大于50元的商品
						try {
							gm.inquireGame(new GameFilter() {

								@Override
								public boolean filter(Object object) {
									return ((Game) object).getGamePrice() > 50;
								}
							});
						} catch (FilterInvalidException e) {
							gv.GameSystemExceptionMessage(e);
						}
						break;
					case 3:
						// 查找游戏账号有截图认证的商品
						try {
							gm.inquireGame(new GameFilter() {

								@Override
								public boolean filter(Object object) {
									return ((Game) object).isGameScreenShot();
								}
							});
						} catch (FilterInvalidException e) {
							gv.GameSystemExceptionMessage(e);
						}
						break;
					case 4:
						// 查找游戏大区是华北区的商品
						try {
							gm.inquireGame(new GameFilter() {

								@Override
								public boolean filter(Object object) {
									return ((Game) object).getGameAreaName() == "华北区";
								}
							});
						} catch (FilterInvalidException e) {
							gv.GameSystemExceptionMessage(e);
						}
						break;
					default:
						break;
					}
				} while (num != 5);
				break;
			case 7:
				do {
					gv.GameSystemSortGame();
					num = sc.nextInt();
					switch (num) {
					case 1:
						// 根据游戏商品价格排序
						try {
							gm.sortGame(new Comparator<Game>() {

								@Override
								public int compare(Game o1, Game o2) {
									return (int) ((o1.getGamePrice() - o2.getGamePrice()) * 100);
								}

							});
						} catch (CompareInvalidException e) {
							gv.GameSystemExceptionMessage(e);
						}
						break;
					case 2:
						// 根据游戏数量价格排序
						try {
							gm.sortGame(new Comparator<Game>() {

								@Override
								public int compare(Game o1, Game o2) {
									return (int) (o1.getGameNum() - o2.getGameNum());
								}

							});
						} catch (CompareInvalidException e) {
							gv.GameSystemExceptionMessage(e);
						}
						break;
					case 3:
						// 根据游戏总价价格排序
						try {
							gm.sortGame(new Comparator<Game>() {

								@Override
								public int compare(Game o1, Game o2) {
									return (int) ((o1.getGameTotalPrice() - o2.getGameTotalPrice()) * 100);
								}

							});
						} catch (CompareInvalidException e) {
							gv.GameSystemExceptionMessage(e);
						}
						break;
					default:
						break;
					}
				} while (num != 4);
				// 根据价格排序

			default:
				try {
					fg.WriteMethods(gm);
				} catch (IOException e5) {
					e5.printStackTrace();
				} // 游戏保存
				break;
			}

		} while (num != 8);
		gv.GameSystemIsEnd();

	}

}
