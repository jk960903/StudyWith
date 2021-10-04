package 부족한금액계산하기;

public class Main {

}
class Solution {
    public long solution(int price, int money, int count) {
        long temp = ((long)count*(long)(count+1)/2)*(long)price;
        if(money-temp>=0) return 0;
        return (long)Math.abs(money-temp);
    }
}
