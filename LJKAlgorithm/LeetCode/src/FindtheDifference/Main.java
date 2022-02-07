package FindtheDifference;

public class Main {
	class Solution {
	    public char findTheDifference(String s, String t) {
	        int[] first = new int[26];
	        int[] second = new int[26];
	        
	        for(int i = 0 ; i< s.length(); i++){
	            first[s.charAt(i)-'a']++;
	        }
	        
	        for(int j = 0 ; j < t.length(); j++){
	            second[t.charAt(j)-'a']++;
	        }
	        int temp = 0;
	        for(int i = 0 ; i < 26; i++){
	            if(first[i] != second[i]){
	                temp = i+(int)'a';
	            }
	        }
	        char result = (char)temp;
	        return result;
	    }
	}
}
