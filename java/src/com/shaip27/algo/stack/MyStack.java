package com.shaip27.algo.stack;

public class MyStack {
	
	static final int size = 10;
	int[] array = new int[size];
	int top;
	
	MyStack() {
		top = -1;
	}
	
	
	void push(int element) {
		
		if(isFull()) {
			System.out.println("Stack is overflow");
			return;
		}
		array[++top] = element;
		System.out.println("Pushed element :" + element );
	}
	
	int pop() {
		
		if(top < 0) {
			System.out.println("Stack is underflow");
			return 0;
		}else {
			int value = array[top--];
			System.out.println("Poped the element:" + value);
			return value;
		}
		
	}
	
	int peek() {
		if(top < 0) {
			System.out.println("Stack is underflow");
			return 0;
		}else {
			int value = array[top];
			System.out.println("Stack Top value is:" + value);
			return value;
		}
	}
	
	boolean isEmptry() {
		return (top < 0);
	}
	
	boolean isFull() {
		return (top == size -1);
	}
	
	

	public static void main(String[] args) {
		MyStack stack = new MyStack();
		
		for(int i=1;i<=10;i++) {
			stack.push(i);
		}
		stack.pop();
		stack.push(11);
		stack.peek();
	
	}

}
