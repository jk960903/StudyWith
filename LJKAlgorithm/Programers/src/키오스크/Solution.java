package 키오스크;
import java.util.Queue;
import java.util.LinkedList;
import java.util.PriorityQueue;
public class Solution {
	public static void main(String[] args) {
		String[] customers= {"10/01 23:20:25 30", "10/01 23:25:50 26", "10/01 23:31:00 05", "10/01 23:33:17 24", "10/01 23:50:25 13", "10/01 23:55:45 20", "10/01 23:59:39 03", "10/02 00:10:00 10"};
		int n=3;
		Queue<customer> queue=new LinkedList<>();
		for(int i=0; i<customers.length; i++) {
			String[] customer=customers[i].split(" ");
			int usetime=Integer.parseInt(customer[2]);
			String[] time=customer[1].split(":");
			String[] daymonth=customer[0].split("/");
			int month=Integer.parseInt(daymonth[0]);
			int day=Integer.parseInt(daymonth[1])-1;
			int hour=Integer.parseInt(time[0]);
			int minute=Integer.parseInt(time[1]);
			int second=Integer.parseInt(time[2]);
			int input=second;
			input+=minute*60;
			input+=hour*3600;
			while(month!=1) {
				if(month==2||month==4||month==6||month==7||month==9||month==11) {
					month--;
					day+=31;
				}else if(month==3) {
					day+=28;
					month--;
				}else {
					month--;
					day+=30;
				}
			}
			input+=day*86400;
			customer temp=new customer(input,usetime);
			queue.add(temp);
		}
		PriorityQueue<Kiosk> priorityQueue=new PriorityQueue<>();
		int[] count=new int[n];
		for(int i=0; i<n; i++) {
			customer temp=queue.poll();
			priorityQueue.add(new Kiosk(i+1,temp.start+(temp.use*60)));
			count[i]++;
		}
		while(!queue.isEmpty()) {
			customer temp=queue.poll();
			Kiosk kiosk=priorityQueue.poll();
			int num=kiosk.num;
			count[num-1]++;
			priorityQueue.add(new Kiosk(num,temp.start+(temp.use*60)));
		}
		int max=0;
		for(int i=0; i<n; i++) {
			max=Math.max(count[i], max);
		}
		System.out.println(max);
	}
}
class customer{
	protected int start;
	protected int use;
	protected customer(int start,int use) {
		this.start=start;
		this.use=use;
	}
}
class Kiosk implements Comparable<Kiosk>{
	int num;
	int time;
	protected Kiosk(int num,int time) {
		this.num=num;
		this.time=time;
	}
	@Override
	public int compareTo(Kiosk o) {
		return Integer.compare(this.time, o.time);
	}
	
}
