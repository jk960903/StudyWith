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
		data.size=this.size+1;
	}
	@Override
	public void add(int index, Object data) {
		for(int i=0; i<index; i++) {
			this.next=next;
		}
	}
	@Override
	public void deletedata(Object data) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void deleteindex(int inde) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return this.size;
	}
	
	
	
}
