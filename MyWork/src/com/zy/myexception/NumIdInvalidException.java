package com.zy.myexception;

/**
 * 自定义异常，游戏ID不合法异常！！！
 * 
 * @author 赵岩
 *
 */
public class NumIdInvalidException extends Exception {

	private static final long serialVersionUID = 1L;

	public NumIdInvalidException(String message) {
		super(message);
	}
}
