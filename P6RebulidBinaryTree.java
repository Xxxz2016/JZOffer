/* 
��Ŀ�����������������ǰ���������������Ľ�����ؽ����ö�����������ǰ
������������������ж��������ظ�������
 */

import java.util.Arrays;
 
public class P6RebulidBinaryTree{
	
	
	public static TreeNode rebulidTree(int[] preOrder, int[] inOrder){
		
		if(inOrder==null){
			return null;
		}
		
		// �ҵ� preOrder �е�һ�������� inOrder �е�Ԫ��
		for(int i=0; i<preOrder.length; i++){
			for(int j=0; j<inOrder.length; j++){
				if(preOrder[i]==inOrder[j]){
					TreeNode root = new TreeNode(inOrder[j]);
					//int[] newPreOrder = Arrays.copyOfRange(preOrder,i,preOrder.length);				
					root.left = rebulidTree(preOrder, Arrays.copyOfRange(inOrder,0,j));   // ���ܴ���null
					root.right = rebulidTree(preOrder, Arrays.copyOfRange(inOrder,j+1,inOrder.length));
					return root;
				}
			}
		}
		
		return null;
	}
	
	public static void main(String[] args){
		
		int[] preOrder = {1,2,4,7,3,5,6,8};
		int[] inOrder = {4,7,2,1,5,3,8,6};
		System.out.println("preOrder: " + Arrays.toString(preOrder));
		System.out.println("inOrder: " + Arrays.toString(inOrder));
		// System.out.println("inOrder: " + inOrder.toString()); // inOrder: [I@15db9742
		
		Tree mTree = new Tree(rebulidTree(preOrder, inOrder));
		mTree.display();
	}
	
}