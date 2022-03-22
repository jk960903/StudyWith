package n번째순서찾기;

public class Main {

}
class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        ArrayList<Integer> list=new ArrayList<>();
        long factorial=1;
        for(int i=1; i<=n; i++){
            factorial*=i;
            list.add(i);
        }
        int index=0;
        long remain=k-1;
        while(n>0){
            factorial/=n;
            answer[index++]=list.get((int)(remain/factorial));
            list.remove((int)(remain/factorial));
            remain%=factorial;
            n--;
        }
        return answer;
    }

}