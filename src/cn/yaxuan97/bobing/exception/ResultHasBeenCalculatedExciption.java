/**
 * 此异常用来标识：尝试计算一个已经计算过结果的Bobing对象
 */
package cn.yaxuan97.bobing.exception;

/**
 * @author yaxuan97
 * @version 1.0
 */
public class ResultHasBeenCalculatedExciption extends Exception {

	/**
	 * serialVersionUID = 1127320954943257501L
	 */
	private static final long serialVersionUID = 1127320954943257501L;

	/**
	 * 
	 */
	public ResultHasBeenCalculatedExciption() {
	}

	/**
	 * @param message
	 */
	public ResultHasBeenCalculatedExciption(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public ResultHasBeenCalculatedExciption(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public ResultHasBeenCalculatedExciption(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public ResultHasBeenCalculatedExciption(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
