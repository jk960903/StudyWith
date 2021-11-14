package Memory;

public class Main {
	static int n = 100000;
	public static void main(String[] args) {
		System.gc();
		long before = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
		Test test = new Test(10);
		System.gc();
		long after = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
		System.out.println((after-before)/1024/1024);
		//System.out.println(func());
	}
	public static int func() {
		if(n==1) {
			return n;
		}
		else {
			return n+func();
		}
	}
	
}
class Test{
	int n;
	
	public Test(int n) {
		this.n = n;
	}
}
