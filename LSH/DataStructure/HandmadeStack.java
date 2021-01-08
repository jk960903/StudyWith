package JksHomeWork;

public class HandmadeStack extends SinglyLinkedList {
	SinglyLinkedList st = new SinglyLinkedList(); 
	private int size=0;
	
	public void push(int data) {
		st.add(data);
		size++;
	}
	
	//위(뒤)에서 부터 빼기
	public Object pop() {
		Node returndata = st.getNode(size-1);
		st.remove();
		size--;
		return returndata.data;
	}
	
	//제일 위의 값(맨 뒤값) 보기
	public Object peek() {
		Node returndata = st.getNode(size-1);
		return returndata.data;
	}
	
	public int size() {
		return size;
	}
}
