/**
 * 这个类是模拟结果的实体类
 * 使用构造方法实例化一个Bobing对象
 */
package cn.yaxuan97.bobing;

import java.io.Serializable;
import java.util.Random;

import cn.yaxuan97.bobing.exception.ResultHasBeenCalculatedExciption;
import cn.yaxuan97.bobing.exception.ResultHasBeenAnalyzedExciption;

/**
 * @author yaxuan97
 * @version 1.0
 */
public class Bobing implements Serializable {
	/**
	 * serialVersionUID = 8991522951957235267L;
	 */
	private static final long serialVersionUID = 8991522951957235267L;

	private final Random rand; // 随机数

	private int[] result; // 模拟结果
	String s; // 模拟结果文字
	private int[] analyzed;

	/**
	 * Bobing() 构造方法不需要任何参数。调用构造方法后，将会随机生成一次结果。然后调用其他方法获取结果。
	 */
	public Bobing() {
		rand = new Random(); // 实例化随机数对象
		result = new int[6]; // 初始化模拟结果对象
		for (int i = 0; i < result.length; i++) { // 利用随机数，获得一次模拟结果
			result[i] = rand.nextInt(6) + 1; // 对每个数组成员赋值
		} // 模拟结果创建完成
	}

	/**
	 * analyze()方法用来对模拟结果进行分析，将模拟结果转换成分析后的模拟结果
	 * 
	 * @throws ResultHasBeenAnalyzedExciption
	 */
	public void analyze() throws ResultHasBeenAnalyzedExciption {
		if (analyzed != null) {
			throw new ResultHasBeenAnalyzedExciption("模拟结果已经被分析过了！ ");
		}
		analyzed = new int[6]; // 初始化分析结果对象
		for (int i : result) { // 遍历模拟结果数组
			analyzed[i - 1]++; // 对模拟结果中出现的各种点数进行统计
		} // 分析完成
	}
	
	/**
	 * calc()方法用来对分析后的结果进行计算，得到最终结果
	 * 
	 * @throws ResultHasBeenCalculatedExciption
	 */
	public void calc() throws ResultHasBeenCalculatedExciption {
		if (s != null) {
			throw new ResultHasBeenCalculatedExciption("本次模拟已经得到最终结果了！");
		}
		if(analyzed[3] == 4 && analyzed[0] == 2) { // 分析开始
			s = new String("插金花");
			return;
		}
		if (analyzed[3] == 6) {
			s = new String("红六勃");
			return;
		}
		if (analyzed[0] == 6) {
			s = new String("遍地锦");
			return;
		}
		if (analyzed[3] == 5) {
			s = new String("五红");
			return;
		}
		if (analyzed[3] == 4) {
			s = new String("四红");
			return;
		}
		if (analyzed[3] == 3) {
			s = new String("三红");
			return;
		}
		for (int i : analyzed) {
			if (i == 6) {
				s = new String("黑六勃");
				return;
			}
			if (i == 5) {
				if (analyzed[3] == 1) {
					s = new String("五子登科 + 一秀");
				} else {
					s = new String("五子登科");
				}
				return;
			}
			if (i == 4) {
				switch (analyzed[3]) {
				case 1:
					s = new String("四进 + 一秀");
					break;
				case 2:
					s = new String("四进 + 二举");
					break;
				case 0:
					s = new String("四进");
				default:
					break;
				}
				return;
			}
			if(analyzed[3] == 2) {
				s = new String("二举");
				return;
			}
			if(analyzed[3] == 1) {
				if (analyzed[0] == 1 && analyzed[1] == 1 &&analyzed[2] == 1 &&analyzed[4] == 1) {
					s = new String("对堂");
				} else {
					s = new String("一秀");
				}
				return;
			}
			s = new String("安慰奖");
		} // 分析结束
	}
	
	/**
	 * getCalc()方法用来得到最终的结果
	 * */
	public String getCalc() {
		return s;
	}
	
	/**
	 * getResult()方法用来获取所有骰子的状态
	 * */
	public int[] getResult() {
		return result;
	}
	
	/**
	 * getAnalyze()方法用了来获取分析结果
	 * */
	public int[] getAnalyze() {
		return analyzed;
	}
}
