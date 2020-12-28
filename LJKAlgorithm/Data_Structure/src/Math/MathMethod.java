package Math;

public interface MathMethod {
	long numCombination(int n,int r);
	long numCombiRecursive(int n,int r);
	long numPermutationRecursive(int n,int r);
	long numPermutation(int n,int r);
	long Pactorial(int n);
	int[] Combination(int[] array,int n,int r);
	int[] Permutation(int[] array,int n,int r);
	
	int abs(int a,int b);
	int max(int[] array);
	int min(int[] array);
	
	int avaerage(int[] array);
	double average(double[] array);
	long average(long[] array);
	
	int Square(int a);
	double Square(double a);
	long Square(long a);
	
	
}
