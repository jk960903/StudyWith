package Æø¹ß¹®ÀÚ¿­;
import java.io.*;
import java.util.Stack;
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> stack = new Stack<>();
	    char[] string = br.readLine().toCharArray();
	    String bomb = br.readLine();

	    int length = string.length;
	    int bombLength = bomb.length();
	    for (int index = 0; index < length; index++) {
	      stack.push(string[index]);
	      if (stack.size() >= bombLength) {
	        if (isBomb(stack, bomb)) {
	          for (int b = 0; b < bombLength; b++) {
	            stack.pop();
	          }
	        }
	      }
	    }
	    StringBuilder sb = new StringBuilder();
	    for (Character ch : stack) {
	      sb.append(ch);
	    }
	    if (sb.length() == 0) {
	    	System.out.println("FRULA");
	    } else {
	    	System.out.println(sb);
	    }
	  }

	  private static boolean isBomb(Stack<Character> stack, String bomb) {
	    for (int index = 0; index < bomb.length(); index++) {
	      if (stack.get(stack.size() - bomb.length() + index) != bomb.charAt(index)) {
	        return false;
	      }
	    }
	    return true;
	  }
}
