
/* 
题目描述：把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的
旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如数
组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为 1
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
