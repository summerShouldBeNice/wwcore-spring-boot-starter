package com.warmwind.wwcore.core.exception;

/**
 * 工具类异常
 *
 * @author warmwind
 * @createTime 2024-02-28 23:41
 */
public class UtilException extends RuntimeException {
    private static final long serialVersionUID = 8247610319171014183L;

    public UtilException(Throwable e) {
        super(e.getMessage(), e);
    }

    public UtilException(String message) {
        super(message);
    }

    public UtilException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
