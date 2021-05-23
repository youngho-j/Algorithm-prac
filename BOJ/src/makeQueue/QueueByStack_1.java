package makeQueue;

import java.util.Stack;

public class QueueByStack_1 {
	public static void main(String[] args) {
		MyQueue1 q = new MyQueue1();
		
		for(int i = 1 ; i < 8 ; i++) {
			q.addObject(i);
			System.out.println("입력 수 : " + i + ", 사이즈 : " + q.getSize());
		}
		while(q.getSize() > 0) {
			System.out.println("출력 : " + q.popObject());
		}
	}
}
class MyQueue1 {
	private Stack<Object> in;
	private Stack<Object> out;
	
	public MyQueue1() {
		this.in = new Stack<Object>();
		this.out = new Stack<Object>();
	}
	
	public void addObject(Object o) {
		in.add(o);
	}
	
	public Object popObject() {
		if(out.isEmpty()) {
			while(!in.isEmpty()) {
				out.add(in.pop());
			}
		}
		return out.pop();
	}
	
	public int getSize() {
		return in.size() + out.size();
	}
}
