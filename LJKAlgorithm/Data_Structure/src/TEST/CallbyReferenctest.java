package TEST;

public class CallbyReferenctest {
	public static void main(String[] args) {
		Test1 t = new Test1("s");
		changeReference(t);
		System.out.println(t.t);
		modifyReference(t);
		System.out.println(t.t);
	}
	public static void changeReference(Test1 b) {
		Test1 a = new Test1("b");
		b = a;
		System.out.println("1");
	}
	public static void modifyReference(Test1 c) {
		c.set("c");
	}
	
}
class Test1{
	String t;
	Test1(String t) {
		this.t = t;
	}
	public void set(String s) {
		this.t = s;
	}
}
