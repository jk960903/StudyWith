package JksHomeWork;

public class SinglyLinkedList {
	
	private Node head;
	private Node tail;
	private int size=0;
	
	public class Node{	//inner class		이거 public로 해도 되나? HandmadeStack에서 peek,pop함수의 반환형을 위함
		protected Object data;				//이거 protected로 해도 되나? HandmadeStack에서 peek,pop함수의 반환형을 위함
		private Node next;	//다음노드
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
		node.next = head;	//새로만든 노드가 원래 헤드를 가리키게함, 헤드가 없었다면 어자피 null
		head = node;		//새 노드를 헤드노드로 지정
		size++;				//노드 개수 증가
		if(head.next == null) {	//head다음이 없다면, 즉 노드가 한개밖에 없다면
			tail = node;	//새로만든노드를 테일로도 지정
		}
	}
	
	//중간에 삽입 add
	public void add(int index, int data) {
		if(index == 0) {	//0번째 인덱스는 addFirst로
			addFirst(data);																	//addFirst
		}
		else {
			Node node = new Node(data);		//새로들어온 노드
			Node temp = getNode(index);		//새로들어온 노드가 들어갈 인덱스에 원래 있던 노드
			Node frontnode = getNode(index-1);	//그 인덱스보다 하나 앞의 노드
			frontnode.next = node;			//하나 앞에 노드가 가리키는것을 새로들어온 노드로 설정
			node.next = temp;				//새로 들어온 노드는 원래 그자리에 있던 노드를 가리키게 설정
			size++;
			if(node.next == null) {	//새로 들어온 노드 뒤에 아무것도 없으면 tail로 지정
				tail = node;
			}
		}
	}
		

	//맨 끝에 삽입 add
	public void add(int data) {															//addLast
		Node node = new Node(data);
		if(size == 0) {		//노드 없는상태일경우 addFirst로 처리
			addFirst(data);																//addFirst
		}
		else {
			tail.next = node;	//기존 테일노드가 새로만든 node를 가리키게함, 테일이 없는 경우는 위의 if에서 처리한다
			tail = node;		//새로운 노드를 테일로 설정
			size++;
		}
		
	}

	//헤드(첫번쨰)노드부터 뒤로 탐색
	public Node getNode(int index) {
		Node node = head;	//임의의 헤드노드 생성후
		for(int i=0;i<index;i++) {
			node = node.next;	//그 노드가 가리키는 노드로 재설정, 그걸 해당 인덱스만큼 반복
		}	
		return node;
	}

	
	//맨 앞 삭제
	public Object removeFirst() {
		Node temp = head;
		head = temp.next;	//기존 헤드노드의 next를 새로운 헤드노드로 설정	
		Object returndata = temp.data;	//삭제할 노드가 가지고있던 data를 임시로 받음
		temp = null;	//null로 지정하며 삭제함
		size--;
		return returndata;
	}
	//맨 뒤에 삭제
	public Object remove() {
		Node tailfront = getNode(size-2);	//tail노드 한칸 앞에 노드
		Object returndata = tail.data;
		tail = null;				//원래 tail을 삭제
		tail = tailfront;			//새로운 tail로 설정
		size--;
		return returndata;
	}
	//중간 삭제
	public Object remove(int index) {
		if(index == 0) {
			remove();
		}
		Node target = getNode(index);			//지울 노드
		Object returndata = target.data;		//지워질 노드의 데이터 받아놓음
		Node targetfront = getNode(index-1);	//지울 노드의 앞에 노드
		if(target == tail) {	//지울노드가 테일노드면 하나 앞에 노드를 테일로 새로 지정
			tail = targetfront;
		}
		targetfront.next =targetfront.next.next;	//앞에 노드가 지울노드의 뒤에 노드를 가리키게 설정
		target = null;
		size--;
		return returndata;
	}
	
	public int size() {
		return size;
	}

}
