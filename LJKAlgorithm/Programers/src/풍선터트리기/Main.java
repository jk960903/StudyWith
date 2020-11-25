package 풍선터트리기;

public class Main {
	public static void main(String[] args) {
		int[] a= {-16,27,65,-2,58,-92,-71,-68,-61,-33};
		Solution solution=new Solution();
		int answer=solution.solution(a);
		System.out.println(answer);
	}
}
class Solution {
    public int solution(int[] a) {
        int answer = 0;// 양끝은 항상가능
        int l=1000000000;
        int r=1000000000;
        for(int i=0; i<a.length; i++){
            if(a[i]<l){
                answer++;
                l=a[i];
            }
            if(a[a.length-1-i]<r){
                answer++;
                r=a[a.length-1-i];
            }
            if(l==r){
                break;
            }
        }
        return answer + (l==r? -1:0);
    }
}