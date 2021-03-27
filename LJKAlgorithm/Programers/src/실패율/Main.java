package ½ÇÆÐÀ²;

public class Main {
	public static void main(String[] args) {
		int n=4;
		int[] stages= { 4,4,4,4,4};
		Solution solution=new Solution();
		int[] answer=solution.solution(n, stages);
		for(int i=0; i<answer.length; i++) {
			System.out.println(answer[i]);
		}
	}
}
class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        int[] arrive = new int[N];
        int[] stop=new int[N];
        double[] error=new double[N];
        for(int i=0; i<stages.length; i++){
            int stage=stages[i];
            for(int j=0; j<stage; j++){
            	if(j==N) continue;
            	arrive[j]++;
            }
            if(stage>N)continue;
            stop[stage-1]++;
        }
        for(int i=0; i<error.length; i++){
            if(arrive[i]==0)break;
            error[i]=(double)stop[i]/(double)arrive[i];
        }
        for(int i=0; i<answer.length; i++){
            double max=-1;
            int stage=0;
            for(int j=0; j<answer.length; j++){
                if(error[j] > max){
                    stage=j;
                    max=error[j];
                }
            }
            error[stage]=-1;
            answer[i]=stage+1;
        }
        return answer;
    }
}
