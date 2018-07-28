package com.zy.myexception;

/**
 * 排序比较异常器
 * 
 * @author 赵岩
 *
 */
public class CompareInvalidException extends Exception {

	private static final long serialVersionUID = 3L;

	public CompareInvalidException(String message) {
		super(message);
	}
}
