package lib;
import sort.Sort;
public class Main {
	public static void main(String[] args) {
		/*List list=new List(10);
		List list2=new List("100");
		for(int i=0; i<10; i++) {
			list.add(new List(i));
		}
		for(int i=0; i<list.size(); i++) {
			List data=list.get(i);
			System.out.println(data.data);
		}
		Stack stack=new Stack(10);
		stack.Push(new Stack(5));
		int date=(int) stack.Pop().data;
		System.out.println(date);
		Queue queue=new Queue(10);
		queue.Enqueue(new Queue(30));
		int temp=(int)queue.Dequeue().data;
		System.out.println(temp);*/
		Sort sort=new Sort();
		int[] array= {5,3,2,6,9,12,15,13,1,8,14};
		int[] sortedArray=sort.BubbleSort(array);
		for(int i=0; i<sortedArray.length; i++) {
			System.out.println(sortedArray[i]);
		}
	}
}
