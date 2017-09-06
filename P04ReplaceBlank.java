
/*
题目：请实现一个函数，把字符串中的每个空格替换成“ %20”
*/

import java.util.Scanner;

public class P04ReplaceBlank{

	public static String replaceBlank(String s){
		
		if(s==null)
			return null;
		
		// String为不可变类
		// str = str +"a" 会创建新的字符串，效率低
		// StringBuffer append()
		StringBuffer outputBuffer=new StringBuffer();
		for(int i=0;i<s.length();i++){
			if(s.charAt(i)==' '){
				outputBuffer.append("%20");
			}else {
				outputBuffer.append(String.valueOf(s.charAt(i))); //char -> String
			}
		}
		return new String(outputBuffer);
		
	}
	
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Input String: ");
		String s = sc.nextLine();
		System.out.print("Replaced String: ");
		System.out.println(replaceBlank(s));
		
	}
	
}
