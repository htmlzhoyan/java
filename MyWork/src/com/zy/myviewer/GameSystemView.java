package com.zy.myviewer;

import com.zy.game.Game;

public interface GameSystemView {
	public void checkGameTotal(); // 游戏账号修改界面

	public void GameSystemAddGame();// 输入游戏账号类型

	public void GameSystemGameType();// 游戏账号默认手游类型

	public void GameSystemAddGamePrice();// 请输入游戏账号价格

	public void GameSystemAddNum();// 请输入游戏账号数量

	public void GameSystemAddNumMin();// 游戏账号数量判断最小

	public void GameSystemAddNumMax();// 游戏账号数量判断最大

	public void GameSystemAddGameName();// 游戏账号名

	public void GameSystemAddGameAreaName();// 游戏账号区

	public void GameSystemAddGameServerName();// 游戏账号服

	public void GameSystemAddGameTitle();// 游戏账号标题

	public void GameSystemAddGameOperatorName();// 游戏经营者

	public void GameSystemAddGameScreenShot();// 游戏是否截图

	public void IsGameSystemAddGameScreenShot();// 确定游戏是否截图

	public void GameSystemRemoveGame();// 输入删除游戏账号

	public void IsGameSystemRemoveGame();// 输入是否删除该游戏

	public void GameSystemModification();// 输入游戏账号ID修改游戏账号信息

	public void GameSystemFind();// 输入游戏账号ID查找游戏账号信息

	public void GameSystemInquireGame();// 按照条件展示游戏账号数据

	public void GameSystemSortGame();// 按照条件排序游戏账号内容

	public void GameSystemExceptionMessage(Exception e);// 异常展示信息

	public void GameSystemIsEnd();// 游戏账号操作完毕

	public void GameSystemShowEveryGame(Game g);// 游戏列表展示

	public void GameSystemModifier(Game g);// 输入账号修改信息

	public void GameSysteModificationGamePrice();// 请修改游戏账号价格

	public void GameSystemModificationNum();// 请修改游戏账号数量

	public void GameSystemModificationGameName();// 请修改游戏账号名

	public void GameSystemModificationGameAreaName();// 请修改游戏账号区

	public void GameSystemModificationGameServerName();// 请修改游戏账号服

	public void GameSystemModificationGameTitle();// 请修改游戏账号标题

	public void GameSystemModificationGameOperatorName();// 请修改游戏经营者

	public void GameSystemModificationGameScreenShot();// 请修改游戏是否截图

	public void IsGameSystemModificationGameScreenShot();// 游戏截图错误，取默认值

	public void GameSystemShowGameData(Object o);// 按照条件展示游戏账号数据
}
