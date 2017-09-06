/*
题目描述： 一个二维数组，每一行从左到右递增，每一列从上到下递增．输
入一个二维数组和一个整数，判断数组中是否含有整数。
*/

public class P03Find{
	
	public static boolean find(int[][] matric, int num){
		
		if(matric==null||matric.length==0||matric[0]==null||matric[0].length==0){
			return false;
		}
		
		// 从右上角开始
		int column = matric[0].length-1;
		int row = 0;
		
		while(row < matric.length && column >= 0){
			if(matric[row][column]==num){
				return true;
			}else if(matric[row][column]>num){
				column--;
			}else{
				row++;
			}
		}
		return false;
		
	}
	
	
	public static void main(String[] args){
		/*
			1	2	5
			2	4	6
			4	7	9
		*/
		
		// 先定义（未指向内存）
		// 静态初始化：初始值，不能指定长度
		int[][] a;
		a = new int[][]{{1,2,5},{2,4,6},{4,7,9}};
		
		// 简化的定义再静态初始化
		int[][] m1 = {{1,2,5},{2,4,6},{4,7,9}};
		int[][] m2 = null;
		
		
		// 动态：长度，系统为不同类型的元素分配初值
		// 可以长度为0
		int[][] m3 = new int[0][0];		// 长度为0
		int[][] m4 = new int[3][0];		// 长度为0
		
		//不能先动态再静态初始化
		//int[][] m5 = new int[3][3];   	
		// m5[0] = {2,3,6};
		// m5[1] = {3,8,10};		
		// m5[2] = {4,10,11};			
		// int[] m6 = new int[3];
		// m6={1,2,3};					
		
		System.out.println(find(m1, 1));
		System.out.println(find(m1, 3));
		System.out.println(find(m2, 1));
		System.out.println(find(m3, 1));
		System.out.println(find(m4, 1));
		System.out.println(find(null, 1));
		
	}
	
	
	
}
