package assignment1;
import java.util.ArrayList;
import java.util.Arrays;

public class StackFixedDynamic2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int arr[];
		
		stack element1 = new fixedStack();
		stack element2 = new dynamicStack();
		
		 System.out.println("Fixed Stack :" );
	      element1.show();
		
		
	      System.out.println("\nDynamic Stack :" );
	      element2.show();
	}

}

interface stack{
	public void push(int i);
	public void pop();
	public void show();
}


class fixedStack implements stack{
	int arr[] = new int[5];
	int top=-1;
	

	@Override
	public void push(int a) {
		// TODO Auto-generated method stub
		if(top<=arr.length) {
			System.out.println("Stack is Full");
			
		}
		
		else {
		
		for(int i=0;i<arr.length;i++) {
			if(top < arr.length) {
				arr[++top]=a;
				
				break;
				
				
			}
			
		}
		
		}
		
	}

	@Override
	public void pop() {
			top--;	
	}
	
	public void show() {
		
		if(top==-1) {
			System.out.println("Stack is Empty");	
		}
		else {
			
		for(int i=0;i<=top;i++) {
			System.out.println(arr[i]);
		}
		
		}
	}
		
	
}

class dynamicStack implements stack{
	
	ArrayList<Integer> dynamic = new ArrayList();

	@Override
	public void push(int i) {
		// TODO Auto-generated method stub
		dynamic.add(i);
		
	}

	@Override
	public void pop() {
		int length = dynamic.size();
		dynamic.remove(length-1);
		
	}

	@Override
	public void show() {
		if(dynamic.size()==0) {
			System.out.println("Stack is Empty");	
		}
		else {
			for(Integer a:dynamic) {
				System.out.println(a);
			}
		}
		
	}
	
}
