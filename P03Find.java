/*
��Ŀ������ һ����ά���飬ÿһ�д����ҵ�����ÿһ�д��ϵ��µ�������
��һ����ά�����һ���������ж��������Ƿ���������
*/

public class P03Find{
	
	public static boolean find(int[][] matric, int num){
		
		if(matric==null||matric.length==0||matric[0]==null||matric[0].length==0){
			return false;
		}
		
		// �����Ͻǿ�ʼ
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
		
		// �ȶ��壨δָ���ڴ棩
		// ��̬��ʼ������ʼֵ������ָ������
		int[][] a;
		a = new int[][]{{1,2,5},{2,4,6},{4,7,9}};
		
		// �򻯵Ķ����پ�̬��ʼ��
		int[][] m1 = {{1,2,5},{2,4,6},{4,7,9}};
		int[][] m2 = null;
		
		
		// ��̬�����ȣ�ϵͳΪ��ͬ���͵�Ԫ�ط����ֵ
		// ���Գ���Ϊ0
		int[][] m3 = new int[0][0];		// ����Ϊ0
		int[][] m4 = new int[3][0];		// ����Ϊ0
		
		//�����ȶ�̬�پ�̬��ʼ��
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
