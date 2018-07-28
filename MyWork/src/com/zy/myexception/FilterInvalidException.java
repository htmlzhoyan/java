package com.zy.myexception;

/**
 * 过滤器异常
 * 
 * @author 赵岩
 *
 */
public class FilterInvalidException extends Exception {

	private static final long serialVersionUID = 2L;

	public FilterInvalidException(String message) {
		super(message);
	}
}
