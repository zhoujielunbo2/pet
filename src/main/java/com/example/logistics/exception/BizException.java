package com.example.logistics.exception;

import com.example.logistics.common.CsaBizResponseCode;

/**
 * 统一异常基类 Created by zhangyang
 */
public abstract class BizException extends Exception {

	private static final long serialVersionUID = 4017807731579426070L;

	public BizException() {
	}

	public BizException(String message) {
		super(message);
	}

	public BizException(String message, Throwable cause) {
		super(message, cause);
	}

	public BizException(Throwable cause) {
		super(cause);
	}

	public BizException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public abstract CsaBizResponseCode getErrorCode();

	public abstract String getFriendMessage();
}
