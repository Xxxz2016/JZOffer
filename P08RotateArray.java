
/* 
��Ŀ��������һ�������ʼ�����ɸ�Ԫ�ذᵽ�����ĩβ�����ǳ�֮Ϊ�����
��ת������һ����������������һ����ת�������ת�������СԪ�ء�������
��{3,4,5,1,2}Ϊ{1,2,3,4,5}��һ����ת�����������СֵΪ 1
 */
 
import java.util.Arrays;

public class P08RotateArray{
	
	public static Integer findMinNum(int[] array){
		
		if(array == null){
			return null;
		}
		
		int len = array.length-1;
		
		if(len==0){
			return array[0];
		}
		
		if(array[0]==array[len]){
			return findMinNum(Arrays.copyOfRange(array, 1 , len));
		}
		
		if(array[0]<array[len]){
			return array[0];
		}
		
		if(array[len/2]>array[0]){
			return findMinNum(Arrays.copyOfRange(array, len/2+1 , len+1));
		}else if(array[len/2]<array[0]){
			return findMinNum(Arrays.copyOfRange(array, 0, len/2+1));
		}
		
		return null;
	}
	
	public static void main(String args[]){
		
		int[] array1 = {3,4,5,1,2};
		int[] array2 = {1,2,3,4,5};
		int[] array3 = {1,0,1,1,1};
		int[] array4 = {1,2};
		int[] array5 = {2};
		int[] array6 = null;
		int[] array7 = new int[3];
		
		System.out.println(findMinNum(array1));
		System.out.println(findMinNum(array2));
		System.out.println(findMinNum(array3));
		System.out.println(findMinNum(array4));
		System.out.println(findMinNum(array5));
		System.out.println(findMinNum(array6));
		System.out.println(findMinNum(array7));
	}
}
