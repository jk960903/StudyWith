package JksHomeWork;


public class HandmadeQueue extends SinglyLinkedList {
	SinglyLinkedList q = new SinglyLinkedList(); 
	private int size=0;
	
	public void insert(int data) {
		//super()�޼ҵ�
		q.add(data);
		size++;
	}
	
	public Object removeQ() {
		Node returndata = q.getNode(0);
		q.removeFirst();
		size--;
		return returndata.data;
	}
	
	//�� �հ� �б�
	public Object peek() {
		return q.getNode(0).data;
	}
	
	public int size() {
		return size;
	}
}
