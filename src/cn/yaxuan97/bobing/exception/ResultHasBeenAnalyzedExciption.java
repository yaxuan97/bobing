/**
 * 此异常用来标识：尝试分析一个已经分析过的Bobing对象
 */
package cn.yaxuan97.bobing.exception;

/**
 * @author yaxuan97
 * @version 1.0
 */
public final class ResultHasBeenAnalyzedExciption extends Exception {

	/**
	 * serialVersionUID = -1527125031126959362L
	 */
	private static final long serialVersionUID = -1527125031126959362L;

	/**
	 * 
	 */
	public ResultHasBeenAnalyzedExciption() {
		
	}

	/**
	 * @param message
	 */
	public ResultHasBeenAnalyzedExciption(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public ResultHasBeenAnalyzedExciption(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public ResultHasBeenAnalyzedExciption(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public ResultHasBeenAnalyzedExciption(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
