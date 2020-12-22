package sort;

public class Sort implements SortMethod{
	
	@Override
	public int[] BubbleSort(int[] array) {
		for(int i=0; i<array.length; i++) {
			for(int j=1; j<array.length; j++) {
				if(array[j]<array[j-1]) {
					int temp=array[j];
					array[j]=array[j-1];
					array[j-1]=temp;
				}
			}
		}
		return array;
	}

	@Override
	public int[] SelectionSort(int[] array) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int[] InsertSort(int[] array) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int[] mergeSort(int[] array) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int[] QuickSort(int[] array) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int[] ShellSort(int[] array) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int[] RadixSort(int[] array) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int[] CounterSort(int[] array) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int[] HeapSort(int[] array) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
