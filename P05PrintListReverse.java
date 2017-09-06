/* 
题目：输入一个链表的头结点，从尾到头反过来打印出每个结点的值
 */
 
import java.util.Stack;

// Definition for singly-linked list
class ListNode{
	int val;
	ListNode next = null;
	ListNode(int val){
		this.val = val;
	}
}


public class P05PrintListReverse{

	// 栈
	public static void printListReverseByStack(ListNode headNode){
		Stack<ListNode> stack = new Stack<ListNode>();
		while(headNode!=null){
			stack.push(headNode);
			headNode=headNode.next;	
		}
		while(!stack.isEmpty()){
			System.out.println(stack.pop().val);
		}
		
	}
	
	// 递归
	// 递归要素：问题简化、终止条件
	public static void printListReverse(ListNode headNode){
		
		if(headNode!=null){
			printListReverse(headNode.next);	
			System.out.println(headNode.val);
		}
		
	}

	public static void main(String[] args){
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		node1.next = node2;
		node2.next = node3;
		
		printListReverse(node1);
	}

}
