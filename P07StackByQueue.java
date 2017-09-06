/* 
两个队列实现栈
 */
import java.util.Queue;
import java.util.LinkedList;

public class P07StackByQueue<T>{

	private Queue<T> queue1 = new LinkedList<T>();
	private Queue<T> queue2 = new LinkedList<T>();

	
	public void push(T t){
		
		// offer进非空的队列
        if (queue1.isEmpty()&&queue2.isEmpty()) {
            queue1.offer(t);
            return;
        }

        if (queue1.isEmpty()) {
            queue2.offer(t);
            return;
        }

        if (queue2.isEmpty()) {
            queue1.offer(t);
            return;
        }

		
		
	}
	
	public T pop() throws Exception{
		
        if (queue1.isEmpty()&&queue2.isEmpty()) {
            try {
                throw new Exception("stack is empty");
            } catch (Exception e) {
            }
        }

        if (queue1.isEmpty()) {
            while (queue2.size()>1) {
                queue1.offer(queue2.poll());	// 除最后一个都offer到另一个队列
            }
            return queue2.poll();
        }

        if (queue2.isEmpty()) {
            while (queue1.size()>1) {
                queue2.offer(queue1.poll());	// 除最后一个都offer到另一个队列
            }
            return queue1.poll();
        }

        return (T) null;
			
	}
		
	public static void main(String[] args){
		
	
	}

}
