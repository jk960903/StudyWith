package FindAllAnagramsinaString;

public class Main {

}
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int[] array = new int[26];
        for(int i = 0 ; i< p.length(); i++){
            array[p.charAt(i)-'a']++;
        }
        List<Integer> list = new ArrayList<>();
        for(int i = 0 ; i < s.length() - p.length() + 1 ; i++){
            int[] temp = new int[26];
            
            for(int j = 0 ; j < p.length(); j++){
                temp[s.charAt(i+j) - 'a']++;
            }
            
            if(check(array,temp)){
                list.add(i);
            }
        }
        return list;
    }
    
    private boolean check(int[] array1 , int[] array2){
        for(int i = 0 ; i < array1.length; i++){
            if(array1[i] != array2[i]){
                return false;
            }
        }
        return true;
    }
}