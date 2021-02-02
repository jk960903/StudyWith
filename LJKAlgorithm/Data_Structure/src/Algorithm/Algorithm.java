package Algorithm;
public class Algorithm implements AlgorithmMethod{
	@Override
	public int lowerBound(int[] data,int value) {
		int left=0;
		int right=data.length;
		int mid=0;
		while(left<right) {
			mid=(left+right)/2;
			if(data[mid]<=value) {
				right=mid;
			}else {
				left=mid+1;
			}
		}
		return left;
	}
	@Override
	public int upperBound(int[] data,int value) {
		int left=0;
		int right=data.length;
		int mid=0;
		while(left<right) {
			mid=(left+right)/2;
			if(data[mid]<=value) {
				left=mid+1;
			}else {
				right=mid;
			}
		}
		return left;
	}
}
