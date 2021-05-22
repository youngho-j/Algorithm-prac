package makeQueue;

import java.util.Stack;

public class QueueByStack {
	public static void main(String[] args) {
		 MyQueue q = new MyQueue();
		 
		 for(int i = 1 ; i < 6 ; i++) {
			 q.insert(i);
			 System.out.println("������ : " + q.getSize());
		 }
		 while(q.getSize() > 0) {
			 System.out.println("��� : " + q.unpack());
		 }
	}
}

class MyQueue {
	//���ÿ� ����� ��ü Ÿ���� �������ֹǷμ� ���ǥ�� ����
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
		// ť�� ��ºκ����� ���Ǵ� ������ �������
		if(out.isEmpty()) {
			// ť�� �Էºκ����� ���Ǵ� ������ ��������
			while(!in.isEmpty()) {
				// �Էºκ����� ���Ǵ� ���ÿ��� �����͸� ������ ��ºκ����� ���Ǵ� ���ÿ� ����
				out.add(in.pop());				
			}
		}
		// �� �Ű����� ����
		return out.pop();
	}
	
	public int getSize() {
		return in.size() + out.size();
	}
}
/* ���� 2���� ť �����ϱ�
 * 
 * ť - ���Լ���(�Է°� ����� �ٸ� ������ �Ͼ)
 * ���� - ��������(�Է°� ����� ���� ������ �Ͼ)
 * 
 * 1. �Է� ����, ��� ������ ������.
 * 2. �Է½ÿ��� �Է½��ÿ� ������ add �޼��带 ���� �߰�
 * 3. ��½ÿ��� ��½����� ������� Ȯ��
 * 	  ������� Ȯ���� �ϴ� ����? 
 *    ������ ���� �����̹Ƿ� ������� �Է� ���ÿ� 1, 2�� ���� ��� �־��� ��� ����� 2, 1 ���� ��
 *    �Է½��ÿ� �ִ� ���� ����� �ϸ鼭 ��½��ÿ� �������ϰԵǸ� �Է½��ÿ� ���߿� ���� 2�� ��r���ÿ� ���� ����, �� �� 1�� ��½��ÿ� ��
 *    �׷��ԵǸ� ��½��ÿ� �ִ� ���� ��¼����� 1, 2�� ��
 *    �׷��Ƿ� ��½����� ����ִ��� Ȯ�� �� �Է½����� ��� ��Ҹ� ���� ��½��ÿ� �߰��ؾ��� 
 *    
 *    ���� ������� �ʴٸ�? 
 *    �״�� ��½��ÿ� �ִ� ���� ������ָ��
 */