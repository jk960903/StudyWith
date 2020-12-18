package lib;

public class Main {
	public static void main(String[] args) {
		List list=new List(10);
		List list2=new List("100");
		list.add(new List(10));
		
		list.add(new List(50));
	}
}
