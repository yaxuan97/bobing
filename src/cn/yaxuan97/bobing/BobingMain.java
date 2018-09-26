/**
 * 此类是整个程序的可运行类
 */
package cn.yaxuan97.bobing;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Date;
import java.util.HashMap;

import cn.yaxuan97.bobing.exception.ResultHasBeenAnalyzedExciption;
import cn.yaxuan97.bobing.exception.ResultHasBeenCalculatedExciption;

/**
 * @since 1.0
 * @author yaxuan97
 * @version 1.1
 */
public class BobingMain {
	public static HashMap<String, Integer> answer = new HashMap<String, Integer>();
	private static File logs;
	private static File dir;
	/**
	 * @param args
	 */
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		int count = Integer.parseInt(args[0]);
		Date now = new Date();
		int min = now.getMinutes();
		int sec = now.getSeconds();
		int h = now.getHours();
		int month = now.getMonth();
		int day = now.getDay();
		int year = now.getYear() + 1900;
		String time = new String(year + "-" + month + "-" + day + "-" + h + "-" + min + "-" + sec);
		dir = new File("logs/");
		if (!dir.exists()) {
			dir.mkdir();
		}
		logs = new File("logs/simc" + time + ".log");
		answer.put("插金花", 0);
		answer.put("红六勃", 0);
		answer.put("遍地锦", 0);
		answer.put("五红", 0);
		answer.put("四红", 0);
		answer.put("三红", 0);
		answer.put("黑六勃", 0);
		answer.put("五子登科 + 一秀", 0);
		answer.put("五子登科", 0);
		answer.put("四进 + 一秀", 0);
		answer.put("四进 + 二举", 0);
		answer.put("四进", 0);
		answer.put("对堂", 0);
		answer.put("二举", 0);
		answer.put("一秀", 0);
		answer.put("安慰奖", 0);
		try {
			FileOutputStream output = new FileOutputStream(logs, true);
			Writer out = new OutputStreamWriter(output);
			
			for (int i = 0; i < count; i++) {
				Bobing bb = new Bobing();
				try {
					bb.analyze();
				} catch (ResultHasBeenAnalyzedExciption e) {
					e.printStackTrace();
				}
				try {
					bb.calc();
				} catch (ResultHasBeenCalculatedExciption e) {
					e.printStackTrace();
				}
				String s = bb.getCalc();
				int[] result = bb.getResult();
				out.write("The " + i + " simc:");
				for (int j : result) {
					out.write(j + " ");
				}
				out.write("answer:" + s);
				out.write("\r\n");
				answer.replace(s, answer.get(s) + 1);
			}
			out.close();
			System.out.println("插金花----------------" + ":" + answer.get("插金花"));
			System.out.println("红六勃----------------" + ":" + answer.get("红六勃"));
			System.out.println("遍地锦----------------" + ":" + answer.get("遍地锦"));
			System.out.println("黑六勃----------------" + ":" + answer.get("黑六勃"));
			System.out.println("五红-------------------" + ":" + answer.get("五红"));
			System.out.println("五子登科 + 一秀----" + ":" + answer.get("五子登科 + 一秀"));
			System.out.println("五子登科-------------" + ":" + answer.get("五子登科"));
			System.out.println("四红-------------------" + ":" + answer.get("四红"));
			System.out.println("对堂-------------------" + ":" + answer.get("对堂"));
			System.out.println("三红-------------------" + ":" + answer.get("三红"));
			System.out.println("四进 + 二举----------" + ":" + answer.get("四进 + 二举"));
			System.out.println("四进 + 一秀----------" + ":" + answer.get("四进 + 一秀"));
			System.out.println("二举-------------------" + ":" + answer.get("二举"));
			System.out.println("一秀-------------------" + ":" + answer.get("一秀"));
			System.out.println("安慰奖----------------" + ":" + answer.get("安慰奖"));
		} catch (FileNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}

	}
}
