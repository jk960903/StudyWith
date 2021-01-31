package 키패드누르기;

public class Solution {
	    public static String solution(int[] numbers, String hand) {
	        String answer = "";
	        int lefthand=10;
	        int righthand=12;
	        StringBuilder sb=new StringBuilder();
	        for(int i=0; i<numbers.length; i++){
	        	if(numbers[i]==0) numbers[i]=11;
	            if(numbers[i]%3==1){
	                lefthand=numbers[i];
	                sb.append("L");
	            }else if(numbers[i]%3==2){
	                int leftdistance=0;
	                int rightdistance=0;
	                if(numbers[i]==0){
	                    numbers[i]=11;
	                }
	                if(lefthand%3==2){
	                    leftdistance=Math.abs(lefthand/3-numbers[i]/3);
	                }else{
	                    leftdistance=1+Math.abs(lefthand/3-numbers[i]/3);
	                }
	                if(righthand%3==2){
	                    rightdistance=Math.abs(righthand/3-numbers[i]/3);
	                }else{
	                    rightdistance=1+Math.abs((righthand-1)/3-numbers[i]/3);
	                }
	                if(leftdistance<rightdistance){
	                    lefthand=numbers[i];
	                    sb.append("L");
	                }else if(leftdistance>rightdistance){
	                    righthand=numbers[i];
	                    sb.append("R");
	                }else if(leftdistance==rightdistance){
	                    if(hand.equals("right")){
	                        righthand=numbers[i];
	                        sb.append("R");
	                    }else{
	                        lefthand=numbers[i];
	                        sb.append("L");
	                    }
	                }
	            }else{
	                righthand=numbers[i];
	                sb.append("R");
	            }
	        }
	        return sb.toString();
	    }
	public static void main(String[] args) {
		int[] numbers= {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
		String hand="left";
		System.out.println(solution(numbers,hand));
	}
}
