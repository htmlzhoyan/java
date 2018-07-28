package com.zy.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.zy.game.Game;

public class FileManager {
	/**
	 * 文件读取
	 * @param gm 
	 * 
	 * @throws IOException
	 */
	public void ReadMehtod(GameManager gm) throws IOException {
		// 缓冲字符输入流读取数据
		File file = new File("./data/game.txt");

		if (!file.exists()) {
			return;
		}
		/*
		 * 如果文件初始为空，默认填充10条数据。
		 */
		if (file.length() == 0) {
			for (int i = 0; i < 10; i++) {
				String gameId = "zy" + i + GameManager.random();// 随机生成10位英文字母
				char gameType = Math.random() > 0.5 ? '手' : '端';
				float gamePrice = (float) (Math.random() * 100);
				int gameNum = (int) (Math.random() * 10 + 1);
				String gameName = "地下城与勇士";// 游戏账号名
				String gameAreaName = Math.random() > 0.5 ? "华南区" : "华北区";// 游戏账号区
				String gameServerName = Math.random() > 0.5 ? "河南一区" : "河南二区";// 游戏账号服;
				String gameTitle = Math.random() > 0.5 ? "全是正品" : "绝不找回";// 游戏账号标题;
				String gameOperatorName = "腾讯";// 游戏账号经营者
				boolean gameScreenShot = Math.random() > 0.5;// 游戏账号是否截图
				Game games = new Game(gameId, gameType, gamePrice, gameNum, gameName, gameAreaName, gameServerName,
						gameTitle, gameOperatorName, gameScreenShot);
				gm.getAllGame().add(games);
			}
			return;
		}

		BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
		String dataStr = null;

		while ((dataStr = bufferedReader.readLine()) != null) {
			if (dataStr.endsWith("]")) {
				dataStr = dataStr.substring(1, dataStr.length() - 1);
				String[] elem = dataStr.split(",");
				int numId = Integer.valueOf(elem[0]);
				String gameId = elem[1];
				char gameType = elem[2].charAt(0);
				;
				float gamePrice = Float.valueOf(elem[3]);
				int gameNum = Integer.valueOf(elem[4]);
				String gameName = elem[5];
				String gameAreaName = elem[6];
				String gameServerName = elem[7];
				String gameTitle = elem[8];
				String gameOperatorName = elem[9];
				boolean gameScreenShot = elem[10].equals("1") ? true : false;
				float gameTotalPrice = Float.valueOf(elem[11]);
				gm.getAllGame().add(new Game(numId, gameId, gameType, gamePrice, gameNum, gameName, gameAreaName,
						gameServerName, gameTitle, gameOperatorName, gameScreenShot, gameTotalPrice));

			} else {
				Game.setIndex(Integer.valueOf(dataStr.substring(dataStr.indexOf(":") + 1)));
			}

		}
		bufferedReader.close();
	}

	/**
	 * 文件写入
	 * 
	 * @throws IOException
	 */
	public void WriteMethods(GameManager gm) throws IOException {

		File file = new File("./data/game.txt");
		if (file.exists()) {
			file.delete();
		}
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));

		for (Game game : gm.getAllGame()) {
			bufferedWriter.write(game.GameData());
			bufferedWriter.newLine();
		}

		// 将game类中的统计计数变量index写入到文件中，保存
		bufferedWriter.write("index:" + Game.getIndex());

		bufferedWriter.close();
	}
}
