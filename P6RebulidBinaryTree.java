/* 
题目描述：输入二叉树的前序遍历和中序遍历的结果，重建出该二叉树。假设前
序遍历和中序遍历结果中都不包含重复的数字
 */

import java.util.Arrays;
 
public class P6RebulidBinaryTree{
	
	
	public static TreeNode rebulidTree(int[] preOrder, int[] inOrder){
		
		if(inOrder==null){
			return null;
		}
		
		// 找到 preOrder 中第一个出现在 inOrder 中的元素
		for(int i=0; i<preOrder.length; i++){
			for(int j=0; j<inOrder.length; j++){
				if(preOrder[i]==inOrder[j]){
					TreeNode root = new TreeNode(inOrder[j]);
					//int[] newPreOrder = Arrays.copyOfRange(preOrder,i,preOrder.length);				
					root.left = rebulidTree(preOrder, Arrays.copyOfRange(inOrder,0,j));   // 可能传入null
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