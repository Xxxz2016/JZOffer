
import java.util.Scanner;

class P09Fibonacci{
	
	public static long fibonacci(int n){
		long res = 0;
		long p1 = 0;
		long p2 = 1;
		if(n==0){
			return p1;
		}
		if(n==1){
			return p2; 
		}
		for(int i=1;i<n;i++){
			res = p1+p2;
			p1 = p2;
			p2 = res;
		}
		return res;
	}
	
	public static void main(String args[]){
		
		Scanner sc = new Scanner(System.in);
		String s;
		int n=0;
		
		while(true){
			System.out.print("input n(>0): ");			
			s = sc.nextLine();
			try{
				n = Integer.parseInt(s);
				System.out.println("the fibonacci:");
				for(int i=0;i<n;i++){
					System.out.print(fibonacci(i)+" ");
				}	
				System.out.println("");
			}catch (Exception e){
				System.out.println(e.toString());
			}
		}
	}
}
