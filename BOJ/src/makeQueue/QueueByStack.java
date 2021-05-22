package makeQueue;

import java.util.Stack;

public class QueueByStack {
	public static void main(String[] args) {
		 MyQueue q = new MyQueue();
		 
		 for(int i = 1 ; i < 6 ; i++) {
			 q.insert(i);
			 System.out.println("사이즈 : " + q.getSize());
		 }
		 while(q.getSize() > 0) {
			 System.out.println("출력 : " + q.unpack());
		 }
	}
}

class MyQueue {
	//스택에 사용할 객체 타입을 지정해주므로서 경고표시 제거
	private Stack<Object> in;
	private Stack<Object> out;
	
	public MyQueue() {
		this.in = new Stack<Object>();
		this.out = new Stack<Object>();
	}
	
	public void insert(Object o) {
		in.add(o);
	}
	
	public Object unpack() {
		// 큐의 출력부분으로 사용되는 스택이 비었을때
		if(out.isEmpty()) {
			// 큐의 입력부분으로 사용되는 스택이 빌때까지
			while(!in.isEmpty()) {
				// 입력부분으로 사용되는 스택에서 데이터를 가져와 출력부분으로 사용되는 스택에 저장
				out.add(in.pop());				
			}
		}
		// 다 옮겨지면 꺼냄
		return out.pop();
	}
	
	public int getSize() {
		return in.size() + out.size();
	}
}
/* 스택 2개로 큐 구현하기
 * 
 * 큐 - 선입선출(입력과 출력이 다른 곳에서 일어남)
 * 스택 - 선입후출(입력과 출력이 같은 곳에서 일어남)
 * 
 * 1. 입력 스택, 출력 스택을 나눈다.
 * 2. 입력시에는 입력스택에 무조건 add 메서드를 통해 추가
 * 3. 출력시에는 출력스택이 비었는지 확인
 * 	  비었는지 확인을 하는 이유? 
 *    스택은 선입 후출이므로 예를들어 입력 스택에 1, 2를 순서 대로 넣었을 경우 출력은 2, 1 순이 됨
 *    입력스택에 있는 값을 출력을 하면서 출력스택에 저장을하게되면 입력스택에 나중에 들어온 2가 출쳑스택에 먼저 들어가고, 그 후 1이 출력스택에 들어감
 *    그렇게되면 출력스택에 있는 값의 출력순서는 1, 2가 됨
 *    그러므로 출력스택이 비어있는지 확인 후 입력스택의 모든 요소를 꺼내 출력스택에 추가해야함 
 *    
 *    만약 비어있지 않다면? 
 *    그대로 출력스택에 있는 것을 출력해주면됨
 */