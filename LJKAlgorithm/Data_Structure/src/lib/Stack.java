package lib;

public class Stack extends List implements StackMethod{
	Stack next;
	private int index;
	private int size;
	public Stack(Object data) {
		super(data);
	}
	public void Push(Stack data) {
		Stack temp=this;
		while(temp.next!=null) {
			temp=temp.next;
		}
		temp.next=data;
		temp.index=this.size;
		this.size=this.size()+1;
	}
	public Stack Pop() {
		Stack temp = this;
		for(int i=0; i<this.size()-1; i++) {
			temp=temp.next;
		}
		Stack last=temp.next;
		temp.next=null;
		return last;
		
	}
	@Override
	public boolean isEmpty() {
		if(this.size==0) {
			return true;
		}else {
			return false;
		}
	}
	

}
