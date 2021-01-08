package JksHomeWork;

public class QueueMain {

	public static void main(String[] args) {
		HandmadeQueue q = new HandmadeQueue();
		q.insert(10);
		//10
		q.insert(20);
		//10 20
		q.insert(30);
		//10 20 30 
		q.insert(40);
		//10 20 30 40
		q.removeQ();
		//20 30 40
		System.out.println(q.peek());	//20
		q.removeQ();
		//30 40
		System.out.println(q.peek());	//30
		q.insert(50);
		//30 40 50
		System.out.println(q.peek());  //30
		q.removeQ();
		//40 50
		System.out.println(q.peek());	//40
		q.removeQ();
		//50
		System.out.println(q.peek());	//50
		System.out.println(q.size());	//1

	}

}
