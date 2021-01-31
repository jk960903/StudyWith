package 호텔방배정;
import java.util.HashMap;
public class Solution {
	public static void main(String[] args) {
		Method method=new Method();
		long[] number= {1, 3,4,1,3,1};
		long[] answer=method.solution(10,number);
		for(int i=0; i<answer.length; i++) {
			System.out.println(answer[i]);
		}
	}
}
class Method{
	public long[] solution(long k,long[] room_number) {
		long[] answer=new long[room_number.length];
		HashMap<Long,Long> map=new HashMap<>();
		for(int i=0; i<room_number.length; i++) {
			answer[i]=findroom(room_number[i],map);
		}
		return answer;
	}
	public long findroom(long roomnumber,HashMap<Long,Long> map) {
		if(!map.containsKey(roomnumber)) {
			map.put(roomnumber,roomnumber+1);
			return roomnumber;
		}
		long next=map.get(roomnumber);
		long empty=findroom(next,map);
		map.put(roomnumber,empty);
		return empty;
	}
}
