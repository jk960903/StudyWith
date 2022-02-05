package mergedKsortLists;
import java.util.*;
class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
 
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i = 0; i < lists.length; i++){
            ListNode temp = lists[i];
            while(temp != null){
                pq.add(temp.val);
                temp = temp.next;
            }
        }
        ListNode result = new ListNode();
        ListNode head = result;
        if(pq.isEmpty()) {
        	return null;
        }
        while(!pq.isEmpty()){
            head.val = pq.poll();
            if(!pq.isEmpty()){
                head.next = new ListNode(0,null);
            }
            head = head.next;
        }
        
        
        return result;
    }
}
public class Main {
	public static void main(String[] args) {
		ListNode[] lists = new ListNode[0];
		int[][] array = {{1,4,5},{1,3,4},{2,6}};
		for(int i = 0 ; i < lists.length; i++) {
			lists[i] = new ListNode();
			ListNode head = lists[i];
			ListNode temp = head;
			for(int j = 0 ; j < array[i].length; j++) {
				temp.val = array[i][j];
				if(j < array[i].length-1) {
					temp.next = new ListNode(0,null);
				}
				temp = temp.next;
			}
		}
		
		Solution solution = new Solution();
		
		ListNode result = solution.mergeKLists(lists);
		ListNode temp = result;
		while(temp != null ) {
			System.out.print(temp.val + " ");
			temp = temp.next;
		}
		
		
	}
}
