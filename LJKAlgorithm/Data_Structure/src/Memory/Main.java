package Memory;

public class Main {
	static int n = 100000;
	public static void main(String[] args) {
		System.out.println(func());
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
