package lib;

public class Queue extends List implements QueueMethod{
	private Queue next;
	private int index;
	private int size;
	public Queue(Object data) {
		super(data);
	}

	@Override
	public void Enqueue(Queue queue) {
		// TODO Auto-generated method stub
		Queue temp=this;
		while(temp.next!=null) {
			temp=temp.next;
		}
		this.size=this.size+1;
		queue.index=this.index+1;
		temp.next=queue;
	}

	

	@Override
	public Queue Dequeue() {
		Queue temp=this;
		this.next=temp.next;
		return temp;
		
	}
	@Override
	public int size() {
		return this.size();
	}
}
