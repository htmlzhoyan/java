package com.zy.game;

/**
 * 游戏账号商品展示功能，可进行增，删，改，查处理;
 * 
 * @author 赵岩
 *
 */
public class Game {
	private int numId;
	private String gameId;// 游戏Id
	private char gameType;// 游戏类型，手 手游，端 端游
	private float gamePrice;// 游戏账号价格
	private int gameNum;// 游戏账号数量
	private String gameName;// 游戏名
	private String gameAreaName;// 游戏账号区
	private String gameServerName;// 游戏账号服
	private String gameTitle;// 游戏账号标题
	private String gameOperatorName;// 游戏经营者
	private boolean gameScreenShot;// 游戏是否截图
	private float gameTotalPrice;// 游戏总价
	private static int index = 1;
	{
		numId = index++;
	}

	public Game(String gameId, char gameType, float gamePrice, int gameNum, String gameName, String gameAreaName,
			String gameServerName, String gameTitle, String gameOperatorName, boolean gameScreenShot) {
		super();
		this.gameId = gameId;
		this.gameType = gameType;
		this.gamePrice = gamePrice;
		this.gameNum = gameNum;
		this.gameName = gameName;
		this.gameAreaName = gameAreaName;
		this.gameServerName = gameServerName;
		this.gameTitle = gameTitle;
		this.gameOperatorName = gameOperatorName;
		this.gameScreenShot = gameScreenShot;
		this.gameTotalPrice = gamePrice * gameNum;
	}
	
	
	
	public Game(int numId, String gameId, char gameType, float gamePrice, int gameNum, String gameName,
			String gameAreaName, String gameServerName, String gameTitle, String gameOperatorName,
			boolean gameScreenShot, float gameTotalPrice) {
		super();
		this.numId = numId;
		this.gameId = gameId;
		this.gameType = gameType;
		this.gamePrice = gamePrice;
		this.gameNum = gameNum;
		this.gameName = gameName;
		this.gameAreaName = gameAreaName;
		this.gameServerName = gameServerName;
		this.gameTitle = gameTitle;
		this.gameOperatorName = gameOperatorName;
		this.gameScreenShot = gameScreenShot;
		this.gameTotalPrice = gameTotalPrice;
	}



	public int getNumId() {
		return numId;
	}

	public String getGameId() {
		return gameId;
	}


	public char getGameType() {
		return gameType;
	}

	public void setGameType(char gameType) {
		this.gameType = gameType;
	}

	public float getGamePrice() {
		return gamePrice;
	}

	public void setGamePrice(float gamePrice) {
		this.gamePrice = gamePrice;
		this.gameTotalPrice = this.gameNum * this.gamePrice;
	}

	public float getGameNum() {
		return gameNum;
	}

	public void setGameNum(int gameNum) {
		this.gameNum = gameNum;
		this.gameTotalPrice = this.gameNum * this.gamePrice;
	}

	public String getGameName() {
		return gameName;
	}

	public void setGameName(String gameName) {
		this.gameName = gameName;
	}

	public String getGameAreaName() {
		return gameAreaName;
	}

	public void setGameAreaName(String gameAreaName) {
		this.gameAreaName = gameAreaName;
	}

	public String getGameServerName() {
		return gameServerName;
	}

	public void setGameServerName(String gameServerName) {
		this.gameServerName = gameServerName;
	}

	public String getGameTitle() {
		return gameTitle;
	}

	public void setGameTitle(String gameTitle) {
		this.gameTitle = gameTitle;
	}
	
	public String getGameOperatorName() {
		return gameOperatorName;
	}

	public static void setIndex(int index) {
		Game.index = index;
	}
	
	public void setGameOperatorName(String gameOperatorName) {
		this.gameOperatorName = gameOperatorName;
	}

	public boolean isGameScreenShot() {
		return gameScreenShot;
	}

	public void setGameScreenShot(boolean gameScreenShot) {
		this.gameScreenShot = gameScreenShot;
	}

	public float getGameTotalPrice() {
		return gameTotalPrice;
	}
	
	public static int getIndex() {
		return index;
	}
	

	
	public String GameData() {
		return "[" + numId + "," + gameId + "," + gameType + "," + gamePrice
				+ "," + gameNum + "," + gameName + "," + gameAreaName
				+ "," + gameServerName + "," + gameTitle + ","
				+ gameOperatorName + "," + (gameScreenShot == true ? 1 : 0) + "," + gameTotalPrice + "]";
	}
	
	@Override
	public String toString() {
		return "Game [numId=" + numId + ", gameId=" + gameId + ", gameType=" + gameType + ", gamePrice=" + gamePrice
				+ ", gameNum=" + gameNum + ", gameName=" + gameName + ", gameAreaName=" + gameAreaName
				+ ", gameServerName=" + gameServerName + ", gameTitle=" + gameTitle + ", gameOperatorName="
				+ gameOperatorName + ", gameScreenShot=" + gameScreenShot + ", gameTotalPrice=" + gameTotalPrice + "]";
	}

}
