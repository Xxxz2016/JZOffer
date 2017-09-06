
/* 
题目：请实现一个函数，输入一个整数，输出该数二进制表示中 1 的个数。例如
把 9 表示成二进制是 1001；有 2 位是 1，因此如果输入 9，函数输出 2
 */
 
public class P10NumOf1InBinary{

	public static int count1InBinary(int n){
		int count = 0;
		while(n!=0){
			count++;
			n=(n-1) & n;	// n = (n-1)&n 将n的最低位的1变成0
		}
		return count;
	}

	public static void main(String args[]){
		System.out.println(count1InBinary(0x80000000));
		System.out.println(count1InBinary(0));
		System.out.println(count1InBinary(255));		
		System.out.println(count1InBinary(0xFFFFFFFF));		
	}
	
}