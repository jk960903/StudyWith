package excelsheetcolumnnumber;

public class Main {

}
class Solution {
    public int titleToNumber(String columnTitle) {
        int result = 0;
        int count = 0;
        for(int i = columnTitle.length()-1; i>=0; i--){
            char temp = columnTitle.charAt(i);
            int num = temp - 'A' + 1;
            int digit = (int)Math.pow(26,count);
            result += num*digit;
            count++;
        }
        return result;
    }
}