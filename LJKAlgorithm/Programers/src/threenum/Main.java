package threenum;

public class Main {
	public static void main(String[] args) {
		int[] blocks = {15, 10, 9, 9, 13, 15, 8, 6, 10, 9};
		int[] distances = {11, 10, 6, 12, 6, 6, 10, 8, 8};
		int num = solution(blocks,distances);
		System.out.println(num);
	}
	public static int solution(int[] blocks, int[] distances) {
		int answer = 0;
        int[] breakright = new int [blocks.length];
        breakright[breakright.length-1] = 1;
        int[] breakleft = new int[blocks.length];
        breakleft[0] = 1;
        for(int i = 0 ; i<blocks.length-1; i++){
            int remain = blocks[i];
            int count = 1;
            int index = i;
            for(int j = i ; j < distances.length; j++){
                if(blocks[index] >= distances[j] || remain >= distances[j]){
                    count++;
                    index++;
                    remain = Math.max(remain - distances[j] , distances[j]);
                }else {
                	break;
                }
            }
            breakright[i] = count;
        }

        for(int i = blocks.length-1; i>0; i--) {
        	int remain = blocks[i];
        	int count = 1;
        	int index = i;
        	for(int j = i-1 ; j >=0 ; j--) {
        		if(blocks[index] >=distances[j] || remain >= distances[j]) {
        			count++;
        			index--;
        			remain = Math.max(remain - distances[j] , distances[j]);
        		}else {
        			break;
        		}
        	}
        	breakleft[i] = count;
        }


        int count = 0;
        while(count != blocks.length) {
        	int index = -1;
            int max = 0;
            int type=0;
        	for(int i = 0 ; i < blocks.length; i++) {
            	if(max < breakright[i]) {
            		type = 0;
            		index = i;
            		max = breakright[i];
            	}
            	if(max < breakleft[i]) {
            		type = 1;
            		index = i;
            		max = breakleft[i];
            	}
            	
            }
        	if(type == 0 ) {
        		for(int i =index; i <index+max; i++) {
        			if(breakright[i]!=0) {
        				count++;
        			}
        			breakright[i] = 0;
        			breakleft[i] = 0;
        			
        		}
      
        		ReBuild(breakright,breakleft);
                
        	}else {
        		for(int i = index; i > index-max; i--) {
        			if(breakleft[i]!=0) {
        				count++;
        			}
        			breakright[i]= 0;
        			breakleft[i] =0;
        			
        		}
        		
        		ReBuild(breakright,breakleft);
        	}
        	answer++;
        }
        
        return answer;
	}
	public static void ReBuild(int[] breakright, int[] breakleft) {
		for(int i = 0 ; i< breakright.length; i++) {
			int zero = 0;
			if(breakright[i] >2) {
				for(int j = i+1; j<i+breakright[i]; j++) {
					if(breakright[j] ==0) zero++;
				}
				breakright[i]-=zero;
			}
			zero=0;
			if(breakleft[i] >2) {
				for(int j=i-1; j>i-breakleft[i]; j--) {
					if(breakleft[j] ==0) zero++;
				}
				breakleft[i]-=zero;
			}
		}
	}
}
