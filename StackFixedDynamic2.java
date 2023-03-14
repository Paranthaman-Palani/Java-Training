package assignment1;
import java.util.ArrayList;
import java.util.Arrays;

public class StackFixedDynamic2 {

	public static void main(String[] args) {		
		Stack fixedStack = new FixedStack();
		Stack dynamicStack = new DynamicStack();
		
		 System.out.println("Fixed Stack :" );
	      fixedStack.show();
		
	      System.out.println("\nDynamic Stack :" );
	      dynamicStack.show();
	}

}

interface Stack{
	public void push(int i);
	public void pop();
	public void show();
}


class FixedStack implements Stack{
	int arrayFixed[] = new int[5];
	int top=-1;
	
	@Override
	public void push(int a) {
		// TODO Auto-generated method stub
		if(top <= arrayFixed.length) {
			System.out.println("Stack is Full");	
		}
		else {
			for(int i=0;i<arrayFixed.length;i++) {
				if(top < arrayFixed.length) {
					arrayFixed[++top]=a;
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
				System.out.println(arrayFixed[i]);
			}	
		}
	}
		
	
}

class DynamicStack implements Stack{
	
	ArrayList<Integer> dynamic = new ArrayList();

	@Override
	public void push(int i) {	
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
