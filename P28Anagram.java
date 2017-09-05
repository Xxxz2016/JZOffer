
// 输入一个字符串，输出字符串的全排列


import java.util.Scanner;
import java.util.Arrays;
public class P28Anagram{
	
	private static char[] charArray;
	private static int length;    

	public static void doAnagram(int len){
		
		if(len == 1){
			System.out.println(Arrays.toString(charArray));     // basecase
		}else{
			for(int i=0;i<len;i++){
				swap(i,len-1);	
				doAnagram(len-1); 
				swap(i,len-1);
			}
		}
	} 
	
	private static void swap(int i, int j){
		char temp;
		temp = charArray[i];
		charArray[i] = charArray[j];  
		charArray[j] = temp;
	}
	
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		System.out.print("input word: ");
		String s = sc.nextLine();  
		
		charArray = new char[100];
		length = s.length();
		charArray = s.toCharArray();
		
		doAnagram(length);
	}
}
