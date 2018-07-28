package com.zy.myviewer.impl;

import com.zy.game.Game;
import com.zy.myviewer.GameSystemView;

public class GameSystemViewImpl implements GameSystemView {

	@Override
	public void checkGameTotal() {
		System.out.println("欢迎来查看游戏账号");
		System.out.println("1. 读取所有游戏账号");
		System.out.println("2. 添加游戏账号");
		System.out.println("3. 根据ID删除游戏账号");
		System.out.println("4. 根据ID修改游戏账号信息");
		System.out.println("5. 根据ID查找游戏账号信息");
		System.out.println("6. 按照条件展示游戏账号数据");
		System.out.println("7. 按照条件排序游戏账号内容");
		System.out.println("8. 保存退出");
	}

	@Override
	public void GameSystemAddGame() {
		System.out.println("请输入游戏账号类型:手游输入 '手' 端游输入 '端';");
	}

	@Override
	public void GameSystemAddGamePrice() {
		System.out.println("请输入游戏账号价格:");

	}

	@Override
	public void GameSystemAddNum() {
		System.out.println("请输入游戏账号数量(0到10之间的整数):");

	}

	@Override
	public void GameSystemAddNumMin() {
		System.out.println("游戏账号数量不能为0,取默认值1");

	}

	@Override
	public void GameSystemAddNumMax() {
		System.out.println("游戏账号数量不能超过10,取默认值10");

	}

	@Override
	public void GameSystemAddGameName() {
		System.out.println("游戏账号名:");

	}

	@Override
	public void GameSystemAddGameAreaName() {
		System.out.println("请输入游戏账号区:");

	}

	@Override
	public void GameSystemAddGameServerName() {
		System.out.println("请输入游戏账号服:");

	}

	@Override
	public void GameSystemAddGameTitle() {
		System.out.println("请输入游戏账号标题");

	}

	@Override
	public void GameSystemAddGameOperatorName() {
		System.out.println("请输入游戏账号经营者:");

	}

	@Override
	public void GameSystemAddGameScreenShot() {
		System.out.println("请确定游戏是选择截图处理:确定打 Y,不开启打N");

	}

	@Override
	public void IsGameSystemAddGameScreenShot() {
		System.out.println("输入错误，游戏截图默认不打开");

	}

	@Override
	public void GameSystemRemoveGame() {
		System.out.println("请输入删除游戏账号ID:");

	}

	@Override
	public void IsGameSystemRemoveGame() {
		System.out.println("是否删除该游戏? Y or N");

	}

	@Override
	public void GameSystemModification() {
		System.out.println("请输入游戏账号ID修改游戏账号信息:");

	}

	@Override
	public void GameSystemFind() {
		System.out.println("请输入游戏账号ID查找游戏账号信息:");

	}

	@Override
	public void GameSystemInquireGame() {
		System.out.println("1. 查询游戏账号类型是手游的商品");
		System.out.println("2. 获取游戏账号大于50元的商品");
		System.out.println("3. 查找游戏账号有截图认证的商品");
		System.out.println("4. 查找游戏大区是华北区的商品");
		System.out.println("5. 退出");

	}

	@Override
	public void GameSystemSortGame() {
		System.out.println("1. 根据游戏商品价格升序");
		System.out.println("2. 根据游戏数量价格升序");
		System.out.println("3. 根据游戏总价价格升序");
		System.out.println("4. 退出");

	}

	@Override
	public void GameSystemIsEnd() {
		System.out.println("游戏账号操作完毕");

	}

	@Override
	public void GameSystemExceptionMessage(Exception e) {
		System.out.println(e.getMessage());

	}

	@Override
	public void GameSystemShowEveryGame(Game g) {
		System.out.println(g);

	}

	@Override
	public void GameSystemModifier(Game temp) {
		System.out.println("修改ID为" + temp.getGameId() + "的" + temp.getGameType() + "游的游戏账号信息:");
		System.out.println("## 价格:" + temp.getGamePrice() + " 数量:" + temp.getGameNum());
		System.out.println("## 游戏账号名:" + temp.getGameName() + " 游戏账号区:" + temp.getGameAreaName() + " 游戏账号服"
				+ temp.getGameServerName());
		System.out.println("## 游戏账号标题:" + temp.getGameTitle() + " 游戏经营者:" + temp.getGameOperatorName() + " 游戏是否截图:"
				+ temp.isGameScreenShot());
		System.out.println("## 游戏总价格为:" + temp.getGameTotalPrice());
		System.out.println("");
		System.out.println("1. 修改游戏账号价格");
		System.out.println("2. 修改游戏账号数量");
		System.out.println("3. 修改游戏账号名");
		System.out.println("4. 修改游戏账号区");
		System.out.println("5. 修改游戏账号服");
		System.out.println("6. 修改游戏账号标题");
		System.out.println("7. 修改游戏账号经营者");
		System.out.println("8. 修改游戏是否截图认证");
		System.out.println("9. 保存退出");

	}

	@Override
	public void GameSystemGameType() {
		System.out.println("输入错误，默认为端游类型");

	}

	@Override
	public void GameSysteModificationGamePrice() {
		System.out.println("请输入游戏账号价格:");

	}

	@Override
	public void GameSystemModificationNum() {
		System.out.println("请输入游戏账号数量:");

	}

	@Override
	public void GameSystemModificationGameName() {
		System.out.println("修改游戏账号名:");

	}

	@Override
	public void GameSystemModificationGameAreaName() {
		System.out.println("修改游戏账号区:");

	}

	@Override
	public void GameSystemModificationGameServerName() {
		System.out.println("修改游戏账号服:");

	}

	@Override
	public void GameSystemModificationGameTitle() {
		System.out.println("修改游戏账号标题");

	}

	@Override
	public void GameSystemModificationGameOperatorName() {
		System.out.println("请输入游戏账号经营者:");

	}

	@Override
	public void GameSystemModificationGameScreenShot() {
		System.out.println("请确定游戏是选择截图处理:确定打 Y,不开启打N");

	}

	@Override
	public void IsGameSystemModificationGameScreenShot() {
		System.out.println("输入错误，游戏截图默认不打开");

	}

	@Override
	public void GameSystemShowGameData(Object o) {
		System.out.println(o);

	}

}
