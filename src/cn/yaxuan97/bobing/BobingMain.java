/**
 * ��������������Ŀ�������
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
		answer.put("���", 0);
		answer.put("������", 0);
		answer.put("��ؽ�", 0);
		answer.put("���", 0);
		answer.put("�ĺ�", 0);
		answer.put("����", 0);
		answer.put("������", 0);
		answer.put("���ӵǿ� + һ��", 0);
		answer.put("���ӵǿ�", 0);
		answer.put("�Ľ� + һ��", 0);
		answer.put("�Ľ� + ����", 0);
		answer.put("�Ľ�", 0);
		answer.put("����", 0);
		answer.put("����", 0);
		answer.put("һ��", 0);
		answer.put("��ο��", 0);
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
			System.out.println("���----------------" + ":" + answer.get("���"));
			System.out.println("������----------------" + ":" + answer.get("������"));
			System.out.println("��ؽ�----------------" + ":" + answer.get("��ؽ�"));
			System.out.println("������----------------" + ":" + answer.get("������"));
			System.out.println("���-------------------" + ":" + answer.get("���"));
			System.out.println("���ӵǿ� + һ��----" + ":" + answer.get("���ӵǿ� + һ��"));
			System.out.println("���ӵǿ�-------------" + ":" + answer.get("���ӵǿ�"));
			System.out.println("�ĺ�-------------------" + ":" + answer.get("�ĺ�"));
			System.out.println("����-------------------" + ":" + answer.get("����"));
			System.out.println("����-------------------" + ":" + answer.get("����"));
			System.out.println("�Ľ� + ����----------" + ":" + answer.get("�Ľ� + ����"));
			System.out.println("�Ľ� + һ��----------" + ":" + answer.get("�Ľ� + һ��"));
			System.out.println("����-------------------" + ":" + answer.get("����"));
			System.out.println("һ��-------------------" + ":" + answer.get("һ��"));
			System.out.println("��ο��----------------" + ":" + answer.get("��ο��"));
		} catch (FileNotFoundException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}

	}
}
