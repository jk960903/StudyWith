package JksHomeWork;

public class HandmadeStack extends SinglyLinkedList {
	SinglyLinkedList st = new SinglyLinkedList(); 
	private int size=0;
	
	public void push(int data) {
		st.add(data);
		size++;
	}
	
	//��(��)���� ���� ����
	public Object pop() {
		Node returndata = st.getNode(size-1);
		st.remove();
		size--;
		return returndata.data;
	}
	
	//���� ���� ��(�� �ڰ�) ����
	public Object peek() {
		Node returndata = st.getNode(size-1);
		return returndata.data;
	}
	
	public int size() {
		return size;
	}
}
