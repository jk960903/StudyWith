package DesignCircularQueue;
import java.util.LinkedList;
class MyCircularQueue {
    LinkedList<Integer> list;
    int rear;
    int max;
    public MyCircularQueue(int k) {
        list=new LinkedList<>();
        this.max=k;
    }
    
    public boolean enQueue(int value) {
        if(list.size()==max){
            return false;
        }else{
            list.add(value);
            this.rear=value;
            return true;
        }
    }
    
    public boolean deQueue() {
        if(list.size()==0){
            return false;
        }else{
            list.removeFirst();
            return true;
        }
    }
    
    public int Front() {
        if(this.isEmpty()) return -1;
        else{
            int result=list.get(0);
            return result;
        }
    }
    
    public int Rear() {
        if(this.isEmpty())return -1;
        else{
            int result=this.rear;
            return result;
        }
    }
    
    public boolean isEmpty() {
        if(list.size()==0) return true;
        else return false;
    }
    
    public boolean isFull() {
        if(list.size()==this.max) return true;
        else return false;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
public class Solution {

}
