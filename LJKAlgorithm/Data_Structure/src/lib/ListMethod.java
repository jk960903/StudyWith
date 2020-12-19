package lib;

public interface ListMethod {
	public void add(List data);
	public void add(int index, List data);
	public void deletedata(Object data);
	public void deleteindex(int index);
	public int size();
	public List get(int index);
	public List getFirst();
	public List getLast();
	
}
