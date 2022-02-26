package compareversionnumbers;

public class Main {
	public static void main(String[] args) {
		String version1 = "0.1";
		String version2 = "1.1";
		
		Solution solution = new Solution();
		
		System.out.println(solution.compareVersion(version1, version2));
	}
}
class Solution {
    public int compareVersion(String version1, String version2) {
        String[] ver1 = version1.split("\\.");
        String[] ver2 = version2.split("\\.");
        
        int i = 0 ;
        
        while(i < ver1.length || i < ver2.length){
            if(i < ver1.length && i < ver2.length){
                if(Integer.parseInt(ver1[i]) < Integer.parseInt(ver2[i])){
                    return -1;
                }else if(Integer.parseInt(ver1[i]) > Integer.parseInt(ver2[i])){
                    return 1;
                }
            }else if(i < ver1.length){
                if(Integer.parseInt(ver1[i]) != 0) return 1;
            }else if(i < ver2.length){
                if(Integer.parseInt(ver2[i]) != 0) return -1;
            }
            i++;
        }
        
        return 0;
    }
}