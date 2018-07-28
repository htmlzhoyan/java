package com.zy.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

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
public class GameManager {

	private List<Game> allGame = new ArrayList<Game>();
	private static final Scanner sc = new Scanner(System.in);
	GameSystemView gv = new GameSystemViewImpl();

	private static GameManager gms = null;

	private GameManager() {
	}
   
	public List<Game> getAllGame() {
		return allGame;
	}
	
	public static GameManager getInstance() {
		System.out.println(GameManager.class);
		synchronized (GameManager.class) {
			if (null == gms) {
				gms = new GameManager();
			}
		}
		return gms;
	}

	/**
	 * 添加游戏账号
	 * 
	 * @param newGame
	 *            游戏账号信息
	 * @return
	 * @throws EmptyInvalidException
	 *             游戏信息为空，无法添加
	 * @throws IOException
	 */
	public boolean addNewGame(Game newGame) throws EmptyInvalidException {
		if (newGame == null) {
			throw new EmptyInvalidException("游戏信息为空，无法添加");
		}
		this.allGame.add(newGame);
		return true;
	}

	public void show() {
		for (Game game : allGame) {
			gv.GameSystemShowEveryGame(game);
		}
	}

	/**
	 * 根据ID删除游戏账号
	 * 
	 * @param numId
	 *            游戏账号Id
	 * @throws NumIdInvalidException
	 *             自定义异常，游戏ID不合法异常！！！
	 */
	public void deleteGameByID(int numId) throws NumIdInvalidException {
		int index = findGameIndexById(numId);
		if (-1 == index) {
			throw new NumIdInvalidException("商品里没有该游戏账号的Id");
		}
		this.allGame.remove(index);
	}

	/**
	 * 根据ID修改游戏账号信息
	 * 
	 * @param numId
	 *            游戏账号Id
	 * @throws NumIdInvalidException
	 *             自定义异常，游戏ID不合法异常！！！
	 */
	public void modifyGameInfoByID(int numId) throws NumIdInvalidException {
		int index = findGameIndexById(numId);
		if (-1 == index) {

			throw new NumIdInvalidException("商品里没有该游戏账号的Id");
		}
		// 获取下标为index 的学生类对象
		Game temp = this.allGame.get(index);
		int choose = 0;
		do {
			gv.GameSystemModifier(temp);
			choose = sc.nextInt();
			switch (choose) {
			case 1:
				gv.GameSysteModificationGamePrice();
				float gamePrice = sc.nextFloat();
				temp.setGamePrice(gamePrice);
				break;
			case 2:
				gv.GameSystemModificationNum();
				int gameNum = sc.nextInt();
				temp.setGameNum(gameNum);
				break;
			case 3:
				gv.GameSystemModificationGameName();
				String gameName = sc.next();
				temp.setGameName(gameName);
				break;
			case 4:
				gv.GameSystemModificationGameAreaName();
				String gameAreaName = sc.next();
				temp.setGameAreaName(gameAreaName);
				break;
			case 5:
				gv.GameSystemModificationGameServerName();
				String gameServerName = sc.next();
				temp.setGameServerName(gameServerName);
				break;
			case 6:
				gv.GameSystemModificationGameTitle();
				String gameTitle = sc.next();
				temp.setGameTitle(gameTitle);
				break;
			case 7:
				gv.GameSystemModificationGameOperatorName();
				String gameOperatorName = sc.next();
				temp.setGameOperatorName(gameOperatorName);
				break;
			case 8:
				gv.GameSystemModificationGameScreenShot();
				char game = sc.next().charAt(0);
				boolean gameScreenShot;
				if (game == 'y' || game != 'Y') {
					gameScreenShot = true;
				} else if (game == 'n' || game != 'N') {
					gameScreenShot = false;
				} else {
					gv.IsGameSystemModificationGameScreenShot();
					gameScreenShot = false;
				}
				temp.setGameScreenShot(gameScreenShot);
				break;
			default:
				break;
			}

		} while (choose != 9);

	}

	/**
	 * 根据ID查找游戏账号信息
	 * 
	 * @param numId
	 * @throws NumIdInvalidException
	 *             自定义异常，游戏ID不合法异常！！！
	 */
	public void findGametInfoByStuID(int numId) throws NumIdInvalidException {
		int index = findGameIndexById(numId);
		if (-1 == index) {
			throw new NumIdInvalidException("商品里没有该游戏账号的Id");
		}
		gv.GameSystemShowEveryGame(this.allGame.get(index));

	}

	/**
	 * 按照条件展示游戏账号数据
	 * 
	 * @param com
	 * @throws FilterInvalidException
	 *             过滤器异常
	 */
	public void inquireGame(GameFilter com) throws FilterInvalidException {
		if (null == com) {
			throw new FilterInvalidException("过滤异常！");
		}
		List<Object> list = new ArrayList<Object>();
		for (Object object : allGame) {
			if (com.filter(object)) {
				list.add(object);
			}
		}
		for (Object object : list) {
			gv.GameSystemShowGameData(object);
		}

	}

	/**
	 * 按照条件排序游戏账号内容
	 * 
	 * @param com
	 *            账号Id
	 * @throws CompareInvalidException
	 *             比较器异常
	 */
	public void sortGame(Comparator<Game> com) throws CompareInvalidException {
		if (null == com) {
			throw new CompareInvalidException("比较器异常!");
		}

		ArrayList<Game> list = new ArrayList<Game>();
		for (Game game : this.allGame) {
			list.add(game);
		}

		for (int i = 0; i < list.size() - 1; i++) {
			int index = i;
			for (int j = i + 1; j < list.size(); j++) {

				if (com.compare(list.get(index), list.get(j)) > 0) {
					index = j;
				}
			}
			if (index != i) {
				Game temp = list.get(index);
				list.set(index, list.get(i));
				list.set(i, temp);
			}
		}
		for (Game game : list) {
			gv.GameSystemShowEveryGame(game);
		}

	}

	/**
	 * 提供查询操作，找出当前指定ID 账号所在的下标位置
	 * 
	 * @param numId
	 *            账号id
	 * @return 返回-1没有找到
	 * @throws NumIdInvalidException
	 *             自定义异常，游戏ID不合法异常！！！
	 */
	private int findGameIndexById(int numId) throws NumIdInvalidException {
		int index = -1;
		if (numId < 1) {
			throw new NumIdInvalidException("商品里没有该游戏账号的Id");
		}
		for (int i = 0; i < this.allGame.size(); i++) {
			if ((allGame.get(i)).getNumId() == numId) {
				index = i;
				break; // 找到跳出循环
			}
		}
		return index;
	}
	/*
	 * 随机获取长度为10的英文字母
	 */
	public static String random() {
		String word = "abcdefghijklmnopqlstuvwxyz";
		String temp = "";
		for (int i = 0; i < 10; i++) {
			int num = (int) (Math.random() * word.length());
			char attr = word.charAt(num);
			if (temp.contains(attr + "")) {
				i--;
			} else {
				temp += attr;
			}
		}
		return temp;
	}

	/*
	 * 获取账号数组长度
	 */
	public int GameLength() {
		return this.allGame.size();
	}

}
