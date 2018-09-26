/**
 * �������ģ������ʵ����
 * ʹ�ù��췽��ʵ����һ��Bobing����
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

	private final Random rand; // �����

	private int[] result; // ģ����
	String s; // ģ��������
	private int[] analyzed;

	/**
	 * Bobing() ���췽������Ҫ�κβ��������ù��췽���󣬽����������һ�ν����Ȼ���������������ȡ�����
	 */
	public Bobing() {
		rand = new Random(); // ʵ�������������
		result = new int[6]; // ��ʼ��ģ��������
		for (int i = 0; i < result.length; i++) { // ��������������һ��ģ����
			result[i] = rand.nextInt(6) + 1; // ��ÿ�������Ա��ֵ
		} // ģ�����������
	}

	/**
	 * analyze()����������ģ�������з�������ģ����ת���ɷ������ģ����
	 * 
	 * @throws ResultHasBeenAnalyzedExciption
	 */
	public void analyze() throws ResultHasBeenAnalyzedExciption {
		if (analyzed != null) {
			throw new ResultHasBeenAnalyzedExciption("ģ�����Ѿ����������ˣ� ");
		}
		analyzed = new int[6]; // ��ʼ�������������
		for (int i : result) { // ����ģ��������
			analyzed[i - 1]++; // ��ģ�����г��ֵĸ��ֵ�������ͳ��
		} // �������
	}
	
	/**
	 * calc()���������Է�����Ľ�����м��㣬�õ����ս��
	 * 
	 * @throws ResultHasBeenCalculatedExciption
	 */
	public void calc() throws ResultHasBeenCalculatedExciption {
		if (s != null) {
			throw new ResultHasBeenCalculatedExciption("����ģ���Ѿ��õ����ս���ˣ�");
		}
		if(analyzed[3] == 4 && analyzed[0] == 2) { // ������ʼ
			s = new String("���");
			return;
		}
		if (analyzed[3] == 6) {
			s = new String("������");
			return;
		}
		if (analyzed[0] == 6) {
			s = new String("��ؽ�");
			return;
		}
		if (analyzed[3] == 5) {
			s = new String("���");
			return;
		}
		if (analyzed[3] == 4) {
			s = new String("�ĺ�");
			return;
		}
		if (analyzed[3] == 3) {
			s = new String("����");
			return;
		}
		for (int i : analyzed) {
			if (i == 6) {
				s = new String("������");
				return;
			}
			if (i == 5) {
				if (analyzed[3] == 1) {
					s = new String("���ӵǿ� + һ��");
				} else {
					s = new String("���ӵǿ�");
				}
				return;
			}
			if (i == 4) {
				switch (analyzed[3]) {
				case 1:
					s = new String("�Ľ� + һ��");
					break;
				case 2:
					s = new String("�Ľ� + ����");
					break;
				case 0:
					s = new String("�Ľ�");
				default:
					break;
				}
				return;
			}
			if(analyzed[3] == 2) {
				s = new String("����");
				return;
			}
			if(analyzed[3] == 1) {
				if (analyzed[0] == 1 && analyzed[1] == 1 &&analyzed[2] == 1 &&analyzed[4] == 1) {
					s = new String("����");
				} else {
					s = new String("һ��");
				}
				return;
			}
			s = new String("��ο��");
		} // ��������
	}
	
	/**
	 * getCalc()���������õ����յĽ��
	 * */
	public String getCalc() {
		return s;
	}
	
	/**
	 * getResult()����������ȡ�������ӵ�״̬
	 * */
	public int[] getResult() {
		return result;
	}
	
	/**
	 * getAnalyze()������������ȡ�������
	 * */
	public int[] getAnalyze() {
		return analyzed;
	}
}
