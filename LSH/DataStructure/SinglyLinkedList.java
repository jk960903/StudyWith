package JksHomeWork;

public class SinglyLinkedList {
	
	private Node head;
	private Node tail;
	private int size=0;
	
	public class Node{	//inner class		�̰� public�� �ص� �ǳ�? HandmadeStack���� peek,pop�Լ��� ��ȯ���� ����
		protected Object data;				//�̰� protected�� �ص� �ǳ�? HandmadeStack���� peek,pop�Լ��� ��ȯ���� ����
		private Node next;	//�������
		public Node(Object data) {
			this.data = data;
			this.next = null;
		}
	}
	
	public Object getData(Node node) {
		return node.data;
	}

	//head -> node -> node -> node -> tail
	//newnode -> head -> node -> node -> node -> tail
	//head -> node -> node -> node -> node -> tail
	public void addFirst(Object data) {														//addFirst
		Node node = new Node(data);
		node.next = head;	//���θ��� ��尡 ���� ��带 ����Ű����, ��尡 �����ٸ� ������ null
		head = node;		//�� ��带 ������ ����
		size++;				//��� ���� ����
		if(head.next == null) {	//head������ ���ٸ�, �� ��尡 �Ѱ��ۿ� ���ٸ�
			tail = node;	//���θ����带 ���Ϸε� ����
		}
	}
	
	//�߰��� ���� add
	public void add(int index, int data) {
		if(index == 0) {	//0��° �ε����� addFirst��
			addFirst(data);																	//addFirst
		}
		else {
			Node node = new Node(data);		//���ε��� ���
			Node temp = getNode(index);		//���ε��� ��尡 �� �ε����� ���� �ִ� ���
			Node frontnode = getNode(index-1);	//�� �ε������� �ϳ� ���� ���
			frontnode.next = node;			//�ϳ� �տ� ��尡 ����Ű�°��� ���ε��� ���� ����
			node.next = temp;				//���� ���� ���� ���� ���ڸ��� �ִ� ��带 ����Ű�� ����
			size++;
			if(node.next == null) {	//���� ���� ��� �ڿ� �ƹ��͵� ������ tail�� ����
				tail = node;
			}
		}
	}
		

	//�� ���� ���� add
	public void add(int data) {															//addLast
		Node node = new Node(data);
		if(size == 0) {		//��� ���»����ϰ�� addFirst�� ó��
			addFirst(data);																//addFirst
		}
		else {
			tail.next = node;	//���� ���ϳ�尡 ���θ��� node�� ����Ű����, ������ ���� ���� ���� if���� ó���Ѵ�
			tail = node;		//���ο� ��带 ���Ϸ� ����
			size++;
		}
		
	}

	//���(ù����)������ �ڷ� Ž��
	public Node getNode(int index) {
		Node node = head;	//������ ����� ������
		for(int i=0;i<index;i++) {
			node = node.next;	//�� ��尡 ����Ű�� ���� �缳��, �װ� �ش� �ε�����ŭ �ݺ�
		}	
		return node;
	}

	
	//�� �� ����
	public Object removeFirst() {
		Node temp = head;
		head = temp.next;	//���� ������� next�� ���ο� ������ ����	
		Object returndata = temp.data;	//������ ��尡 �������ִ� data�� �ӽ÷� ����
		temp = null;	//null�� �����ϸ� ������
		size--;
		return returndata;
	}
	//�� �ڿ� ����
	public Object remove() {
		Node tailfront = getNode(size-2);	//tail��� ��ĭ �տ� ���
		Object returndata = tail.data;
		tail = null;				//���� tail�� ����
		tail = tailfront;			//���ο� tail�� ����
		size--;
		return returndata;
	}
	//�߰� ����
	public Object remove(int index) {
		if(index == 0) {
			remove();
		}
		Node target = getNode(index);			//���� ���
		Object returndata = target.data;		//������ ����� ������ �޾Ƴ���
		Node targetfront = getNode(index-1);	//���� ����� �տ� ���
		if(target == tail) {	//�����尡 ���ϳ��� �ϳ� �տ� ��带 ���Ϸ� ���� ����
			tail = targetfront;
		}
		targetfront.next =targetfront.next.next;	//�տ� ��尡 �������� �ڿ� ��带 ����Ű�� ����
		target = null;
		size--;
		return returndata;
	}
	
	public int size() {
		return size;
	}

}
