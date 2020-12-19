package lib;

public class List implements ListMethod{
	Object data;
	List next;
	int index;
	int size;
	public List(Object data) {
		this.data=data;
		this.next=null;
		this.index=0;
	}
	public void add(List data) {
		List temp=this;
		while(temp.next!=null) {
			temp=temp.next;
		}
		temp.next=data;
		data.index=this.size;
		this.size+=1;
	}
	@Override
	public void add(int index, List data) {
		List temp=this;
		for(int i=0; i<index; i++) {
			temp=temp.next;
		}
		temp.next=data;
		temp.index=index;
		this.size+=1;
	}
	@Override
	public void deletedata(Object data) {
		List temp=this;
		while(temp.next!=null) {
			if(temp.data==data) {
				temp.next=temp.next.next;
				break;
			}
			temp=temp.next;
			//여기 메모리 할당이 들어가야할 것 같은데
		}
		
	}
	@Override
	public void deleteindex(int index) {
		// TODO Auto-generated method stub
		List temp=this;
		for(int i=0; i<index-1; i++) {
			temp=temp.next;
		}
		temp.next=temp.next.next;
		//여기 메모리 할당이 들어가야하지 않을까?
	}
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return this.size;
	}
	public List get(int index) {
		List temp=this;
		for(int i=0; i<index; i++) {
			temp=temp.next;
		}
		return temp;
	}
	public List getLast() {
		List temp=this;
		while(temp.next!=null) {
			temp=temp.next;
		}
		return temp;
	}
	public List getFirst() {
		return this;
	}
	
	
	
}
