
/*
��Ŀ����ʵ��һ�����������ַ����е�ÿ���ո��滻�ɡ� %20��
*/

import java.util.Scanner;

public class P04ReplaceBlank{

	public static String replaceBlank(String s){
		
		if(s==null)
			return null;
		
		// StringΪ���ɱ���
		// str = str +"a" �ᴴ���µ��ַ�����Ч�ʵ�
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
