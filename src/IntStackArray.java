//implementing stack array
public class IntStackArray {
	//Array to store everything
	private int[] stack;
	
	//Storing the number of elements
	private int size;
	
	//Constructor
	public IntStackArray() {
		stack = new int[10];
		size = 0;
	}
	
	//Pushing a new value on top of the stack
	public void push(int value) {
		//Checking to see if size of array is full
		if (size == stack.length) {
			doubleCapacity();
		}
		stack[size] = value;
		size++;
	}
	
	//Pop to remove and return the value from top of the stack
	public int pop() {
		if (size == 0) {
			throw new ArrayIndexOutOfBoundsException();
		}
		int result = stack[size-1];
		//Clear old values
		stack[size - 1] = 0;
		
		size--;
		return result;
	}
	
	//Peek to return value on top of the stack
	public int peek() {
		if (size == 0) {
			throw new ArrayIndexOutOfBoundsException();
		}
		int result = stack[size-1];
		//Clear old values
		stack[size - 1] = 0;
		
		return result;
	}
	
	//returning the size of the array
	public int size() {
		return size;
	}
	
	//Capacity to return size of the underlying array
	public int capacity() {
		return stack.length;
	}
	
	//capacityRemaining to return number of unused cells in underlying arraay
	public int capacityRemaining() {
		int result = stack.length - size;
		return result;
	}
	
	//Emptying the stack
	public void empty() {
		for (int i=0; i < stack.length; i++) {
			stack[i] = 0;
		}
		size = 0;
	}
	
	//modifying array so that its capacity is equal to its size
	public void compress() {
		if (size < stack.length) {
		int newCapacity = size;
		
		int [] newStack = new int[newCapacity];
		
		for (int i=0; i<stack.length; i++) {
			newStack[i] = stack[i];
		}
		//Pointing back
		stack = newStack;
		}		
	}
	
	//Doubling the size of the array
	private void doubleCapacity() {
		int newCapacity = 2*stack.length;
		
		int [] newStack = new int[newCapacity];
		
		for (int i=0; i<stack.length; i++) {
			newStack[i] = stack[i];
		}
		//Pointing back
		stack = newStack;
	}
	
	//Main Method
	public static void main(String[] args) {
		IntStackArray stackExample = new IntStackArray();
		stackExample.push(5);
		stackExample.push(22);
		stackExample.push(9);
		
		System.out.println(stackExample.pop());
		System.out.println("Bye");
	}

}
