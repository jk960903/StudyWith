package sort;
import java.util.ArrayList;
public interface SortMethod {
	int[] BubbleSort(int[] array);
	int[] SelectionSort(int[] array);
	int[] InsertSort(int[] array);
	
	int[] mergeSort(int[] array);
	int[] QuickSort(int[] array);
	int[] ShellSort(int[] array);
	
	int[] RadixSort(int[] array);
	int[] CounterSort(int[] array);
	int[] HeapSort(int[] array);
	
	
}
