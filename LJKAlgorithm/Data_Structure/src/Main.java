import sort.Sort;
public class Main {
	public static void main(String[] args) {
		int[] array={5,3,10,6,22,55};
		Sort sort =new Sort();
		int[] temp=new int[array.length];
		array=sort.mergeSort(array, 0, array.length-1, temp);
		for(int i=0; i<array.length; i++) {
			System.out.println(array[i]);
		}
	}
}
