package Math;

public class Math implements MathMethod{
	
	
	@Override
	public int abs(int a, int b) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int max(int[] array) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int min(int[] array) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int avaerage(int[] array) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double average(double[] array) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long average(long[] array) {
		// TODO Auto-generated method stub
		long answer=0;
		for(int i=0; i<array.length; i++) {
			answer+=array[i];
		}
		return answer/array.length;
	}

	@Override
	public int Square(int a) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double Square(double a) {
		// TODO Auto-generated method stub
		return a*a;
	}

	@Override
	public long Square(long a) {
		// TODO Auto-generated method stub
		return a*a;
	}

	@Override
	public long numCombination( int n, int r) {
		int answer=n;
		for(int i=0; i<r; i++) {
			answer=answer*(n-i);
		}
		for(int i=r; i>=1; i--) {
			answer=answer/i;
		}
		return answer;
	}
	@Override
	public long Pactorial(int n) {
		long answer=1;
		for(int i=1; i<=n; i++) {
			answer*=i;
		}
		return answer;
	}
	@Override
	public long numCombiRecursive(int n, int r) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long numPermutationRecursive(int n, int r) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long numPermutation(int n, int r) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int[] Combination(int[] array, int n, int r) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int[] Permutation(int[] array, int n, int r) {
		// TODO Auto-generated method stub
		return null;
	}

}
