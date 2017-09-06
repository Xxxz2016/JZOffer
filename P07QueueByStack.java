
/* 
��Ŀ������������ջʵ��һ�����У�ʵ�ֶ��˵��������� appendTail ��
deleteHead���ֱ�����ڶ���β��������ڶ���ͷ��ɾ�����Ĺ��ܡ�
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
			throw new Exception("����Ϊ�գ�����ɾ��");
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
