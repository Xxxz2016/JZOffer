
/* 
��Ŀ����ʵ��һ������������һ��������������������Ʊ�ʾ�� 1 �ĸ���������
�� 9 ��ʾ�ɶ������� 1001���� 2 λ�� 1������������ 9��������� 2
 */
 
public class P10NumOf1InBinary{

	public static int count1InBinary(int n){
		int count = 0;
		while(n!=0){
			count++;
			n=(n-1) & n;	// n = (n-1)&n ��n�����λ��1���0
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