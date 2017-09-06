
/* 
题目描述：用两个栈实现一个队列，实现对了的两个函数 appendTail 和
deleteHead，分别完成在队列尾插入结点和在队列头部删除结点的功能。
 */
 
import java.util.Stack;
 
public class P07QueueByStack<T>{

	private Stack<T> stack1 = new Stack<T>();
	private Stack<T> stack2 = new Stack<T>();
	
	public void appendTail(T t){
		stack1.push(t);
	}
	
	public T deleteHead() throws Exception{
		
		if(stack2.isEmpty()){
			while(!stack1.isEmpty()){
				stack2.push(stack1.pop());
			}
		}
		
		if(stack2.isEmpty()){
			throw new Exception("队列为空，不能删除");
		}
		
		return stack2.pop();
				
	}
		
	public static void main(String[] args) throws Exception{
		P7QueueByStack<String> p7Queue=new P7QueueByStack<>();
		p7Queue.appendTail("1");
		p7Queue.appendTail("2");
		p7Queue.appendTail("3");
		p7Queue.deleteHead();
	
	}

}
