package solution;

import java.util.ArrayList;
//十六进制字符串转成十进制
public class HexTo {
	String hexStr;
	ArrayList zeroToNine;
	ArrayList aToE;
//	String[] zeroToNine = {"0","1","2","3","4","5","6","7","8","9"};
//	String[] aToE = {"a","b","c","d","e","A","B","C","D","E"};
	public void solution() {
		String[] s = hexStr.split("");
		int length = s.length;
		int intNum = 0;//十进制数
		for(int i = 0; i <= 9; i++) {
			zeroToNine.add(i);
		}
//		for(int i = 0; i < length; i++) {
//			int temp;
//			if(zeroToNine.contains(s[i])) {
//				try {
//					intNum += s[i] * length * 16;
//				}catch(Expection e) {
//					intNum 
//				}
//			}else if(s[i].compareTo("a")) {
//				temp = 10;
//				intNum += temp * length * 16;
//			}
//			
//			length --;
//		}
	}

	public String getHexStr() {
		return hexStr;
	}

	public void setHexStr(String hexStr) {
		this.hexStr = hexStr;
	}
	
}
