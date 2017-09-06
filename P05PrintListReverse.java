/* 
��Ŀ������һ�������ͷ��㣬��β��ͷ��������ӡ��ÿ������ֵ
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

	// ջ
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
	
	// �ݹ�
	// �ݹ�Ҫ�أ�����򻯡���ֹ����
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
