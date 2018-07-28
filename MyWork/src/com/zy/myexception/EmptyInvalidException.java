package com.zy.myexception;

/**
 * 空信息异常
 * 
 * @author 赵岩
 *
 */

public class EmptyInvalidException extends Exception {

	private static final long serialVersionUID = 4L;

	public EmptyInvalidException(String message) {
		super(message);
	}

}
