package JksHomeWork;

public class StackMain {

	public static void main(String[] args) {
		HandmadeStack st = new HandmadeStack();
		st.push(10);
		//10
		st.push(20);
		//20 10
		st.push(30);
		//30 20 10
		st.push(40);
		//40 30 20 10
		st.pop();
		//30 20 10
		st.push(50);
		//50 30 20 10
		st.push(60);
		//60 50 30 20 10
		st.pop();
		st.pop();
		//30 20 10
		System.out.println(st.peek());	//30 20 10
		System.out.println(st.pop());	//(30) 20 10
		System.out.println(st.peek());	//20 10
		System.out.println(st.size());
	}

}
