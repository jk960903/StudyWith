package Test;
import java.util.*;
public class Main {
	public static void main(String[] args) {
		Solution solution = new Solution();
		//String[][] places ={{"POPOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, {"PXOPX", "OXOXP", "OXPXX", "OXXXP", "POOXX"}, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};
		//int[] answer = solution.solution(places);
		//boolean[] temp = new boolean[100];
		//String[] s = {"D 2","C","U 3","C","D 4","C","U 2","Z","Z"};
		//String s = "aaaa" - "bbbb";
		//for(int i = 0; i< answer.length; i++) {
		//	System.out.println(answer[i]);
		//}
		//String temp =solution.solution(8, 2, s);
		//System.out.println(temp);
		ArrayList<Integer> list = new ArrayList<>();
		Long one =Long.valueOf(1);
		Long two=Long.valueOf(1);
		if(one==two) System.out.println("clear");
		int num=list.get(0);
	}
}

class Solution {
    public String solution(int n, int k, String[] cmd) {
    	String answer = "";
        Node head = new Node();
        Node now = head.AddLast(0,head);
        head = now;
        int length = n;
        for(int i = 0 ; i < n ; i++){
            now = now.AddLast(i,now);
        }
        now = head;
        for(int i = 0 ; i<= k ; i++){
            now = now.next;
        }
        Stack<deleted> stack = new Stack<>();
        for(int i = 0 ; i < cmd.length; i++){
            char temp = cmd[i].charAt(0);
            if(temp == 'U'){
                String[] temps = cmd[i].split(" ");
                for(int j = 0 ; j< Integer.parseInt(temps[1]); j++){
                    now = now.pre;
                }
            }else if(temp == 'D'){
                String[] temps = cmd[i].split(" ");
                for(int j = 0 ; j < Integer.parseInt(temps[1]); j++){
                    now = now.next;
                }
            }else if(temp == 'C'){
                if(now.next == null){
                    stack.push(new deleted(length-1, now.index));
                    now = now.DeleteLast(now);
                    length -- ;
                }else if(now.pre == null){
                	stack.push(new deleted(0,now.index));
                	length--;
                    now = now.DeleteFirst(now,head);
                }else{
                	int deleteindex = now.index;
                    now = now.Delete(now);
                    int count = 0 ;
                	Node tempn = head.next;
                	while(!(tempn.index == now.index)) {
                		count++;
                		tempn=tempn.next;
                	}
                	stack.push(new deleted(count-1,deleteindex));
                	length -- ;
                	
                }
            }else{
                deleted getstack = stack.pop();
                int index = getstack.index;
                int num = getstack.num;
                Node tempn = head.next;
                for(int j = 0 ; j <index-1; j++){
                    tempn = tempn.next;
                }
                if(tempn.next !=null){
                    tempn.AddNode(num, tempn);
                }else{
                    tempn.AddLast(num, tempn);
                }
                length++;
            }
        }
        boolean[] check = new boolean[n];
        Node find = head.next;
        while(find.next != null) {
        	check[find.index]=true;
        	find=find.next;
        }
        check[find.index]=true;
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < n ; i++) {
        	if(check[i]) sb.append('O');
        	else sb.append('X');
        }
        return sb.toString();
    }
}
class Node {
    int index;
    Node next;
    Node pre;
    Node(){
        this.next = null;
        this.pre = null;
    }
    Node(int index){
        this.index = index;
    }
    public Node AddLast(int index,Node tail){
        Node newNode = new Node(index);
        tail.next = newNode;
        newNode.pre = tail;
        tail = tail.next;
        return tail;
    }
    public Node AddFirst(int index , Node Front){
        Node newNode = new Node(index);
        newNode.next = Front;
        Front.pre = newNode;
        Front = newNode;
        return Front;
    }
    public void AddNode(int index, Node now){
        Node newNode = new Node(index);
        newNode.next = now.next;
        newNode.pre = now;
        newNode.next.pre = newNode;
        now.next = newNode;
    }
    public Node DeleteFirst(Node now , Node head){
        Node nextNode = now.next;
        nextNode.pre = head;
        head.next = nextNode;
        now.pre = null;
        now.next = null;
        return nextNode;
    }
    public Node DeleteLast(Node now){
        now.pre.next = null;
        Node temp = now.pre;
        now.pre = null;
        return temp;
    }
    public Node Delete(Node now){
        Node preNode = now.pre;
        Node nextNode= now.next;
        preNode.next = nextNode;
        nextNode.pre = preNode;
        now.next= null;
        now.pre = null;
        return nextNode;
    }
}
class deleted{
    int index;
    int num;
    deleted(int index , int num){
        this.index = index;
        this.num = num;
    }
}