package JksHomeWork;

public class LinkedListMain {

	//�����ε� add, delete
	//add(index, data)�� �߰��� �ֱ� , add(data)�� �� �ڿ� �ֱ�
	//remove(index)�� �߰����� remove�� �� �ڳ�� ����
	public static void main(String[] args) {
		SinglyLinkedList list = new SinglyLinkedList(); 
		list.addFirst(10);
		//10
		list.addFirst(20);
		//20 10
		list.addFirst(30);
		//30 20 10
		list.addFirst(40);
		//40 30 20 10
		list.remove();
		//40 30 20 
		list.remove();
		//40 30 
		list.add(50);
		//40 30 50
		list.add(2,60);
		//40 30 60 50
		list.add(2,100);
		//40 30 100 60 50
		list.removeFirst();
		//30 100 60 50
		list.remove(3);
		//30 100 60
		
		
		for(int i=0;i<list.size();i++) {
			System.out.println(list.getNode(i));
		}
	}

}
