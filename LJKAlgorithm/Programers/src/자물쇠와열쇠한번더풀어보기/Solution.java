package 자물쇠와열쇠한번더풀어보기;

public class Solution {
	public int startindex;
	public int endindex;
	private int[][] key;
    private int[][] lock;
    public boolean solution(int[][] key, int[][] lock) {
    	this.key=key;
    	this.lock=lock;
        int[][] expandedlock=expandedLock(key,lock);
        
        startindex=key.length-1;
        endindex=startindex+lock.length;
        for(int r=0; r<4; r++) {
        	int to=expandedlock.length-key.length;
        	for(int i=0; i<=to; i++){
        		for(int j=0; j<=to; j++) {
        			int x=0;
        			int y;
        			for(int k=i; k<key.length+i; k++) {
        				 y=0;
        				for(int l=j; l<key.length+j; l++) {
        					expandedlock[k][l]+=key[x][y++];
        				}
        				x++;
        			}
        			if(isFull(expandedlock)) {
        				return true;
        			}
        			expandedlock=expandedLock(key,lock);
        		}
        	}
        	this.key=rotatekey(key);
        }
        return false;
    }
    public boolean isFull(int[][] expandedlock) {
    	for(int i=startindex; i<endindex; i++) {
    		for(int j=startindex; j<endindex; j++) {
    			if(expandedlock[i][j]!=1)return false;
    		}
    	}
    	return true;
    }
    public int[][] expandedLock(int[][] key,int[][] lock){
    	int[][] expandedlock=new int[lock.length+(key.length-1)*2][lock.length+(key.length-1)*2];
    	int x=0;
    	for(int i=startindex; i<endindex; i++) {
    		int y=0;
    		for(int j=startindex; j<endindex; j++) {
    			expandedlock[i][j]=lock[x][y++];
    		}
    		x++;
    	}
    	return expandedlock;
    }
    public int[][] rotatekey(int[][] key){
    	int[][] copykey=new int[key.length][key.length];
    	for(int i=0; i<key.length; i++) {
    		for(int j=0; j<key.length; j++) {
    			copykey[i][j]=key[key.length-j-1][i];
    		}
    	}
    	for(int i=0; i<key.length; i++) {
    		key[i]=copykey[i].clone();
    	}
    	return key;
    }
}
