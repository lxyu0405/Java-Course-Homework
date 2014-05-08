package _7Homework;

import java.io.*;
public class _19_17_BitOutputStreamTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String test = "010000100100001001101";
		File fileDat = new File("C:\\Users\\Xiaoyu.lu\\Desktop\\Exercise19_17.dat");
		_19_17_BitOutputStream outp = new _19_17_BitOutputStream(fileDat);
		outp.writeBit(test);
		outp.close();
	}

}
