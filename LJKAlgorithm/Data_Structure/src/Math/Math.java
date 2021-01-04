package Math;

public class Math implements MathMethod{
	
	//절대값 반환
	@Override
	public int abs(int a) {
		// TODO Auto-generated method stub
		if(a<0) {
			return -a;
		}else {
			return a;
		}
	}
	@Override
	public long abs(long a) {
		if(a<0) {
			return -a;
		}else {
			return a;
		}
	}
	@Override
	public double abs(double a) {
		if(a<0) {
			return -a;
		}else {
			return a;
		}
	}
	//정렬안된 곳에서 맥스값을 찾는것 오름차순 정렬이 되었다면 array.length-1 반환하면됨
	//내림차순이라면 반대로 0인덱스 반환
	@Override
	public int max(int[] array) {
		int max=0;
		for(int i=0; i<array.length; i++) {
			if(max<array[i]) {
				max=array[i];
			}
		}
		return max;
	}
	@Override
	public long max(long[] array) {
		long max=0;
		for(long num : array) {
			if(max<num) {
				max=num;
			}
		}
		return max;
	}
	@Override 
	public double max(double[] array) {
		double max=0;
		for(double num : array) {
			if(max<num) {
				max=num;
			}
		}
		return max;
	}
	@Override
	public int min(int[] array) {
		int min=Integer.MAX_VALUE;
		for(int num : array) {
			if(num<min) {
				min=num;
			}
		}
		return min;
	}
	@Override
	public long min(long[] array) {
		long min=Long.MAX_VALUE;
		for(long num : array) {
			if(num<min) {
				min=num;
			}
		}
		return min;
	}
	@Override
	public double min(double[] array) {
		double min=Double.MAX_VALUE;
		for(double num : array) {
			if(num<min) {
				min=num;
			}
		}
		return min;
	}
	@Override
	public int avaerage(int[] array) {
		int answer=0;
		for(int num : array) {
			answer+=num;
		}
		return answer/array.length;
	}

	@Override
	public double average(double[] array) {
		double answer=0;
		for(double num : array) {
			answer+=num;
		}
		return answer/array.length;
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
		return a*a;
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
		if(r==0) {
			return 1;
		}
		return n*numPermutationRecursive(n-1,r-1);
	}

	@Override
	public long numPermutation(int n, int r) {
		// TODO Auto-generated method stub
		long answer=1;
		for(int i=0; i<r; i++) {
			answer*=(n-i);
		}
		return answer;
	}

	@Override
	public int[][] Combination(int[] array, int n, int r,int depth) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int[] Permutation(int[] array, int n, int r) {
		// TODO Auto-generated method stub
		return null;
	}

}
