package ±¤°í»ðÀÔ;
public class Solution {
    public String solution(String play_time, String adv_time, String[] logs) {
        if(play_time.equals(adv_time))return "00:00:00";
	        String answer = "";
	        String[] play=play_time.split(":");
	        int playtime=Integer.parseInt(play[0])*3600+Integer.parseInt(play[1])*60+Integer.parseInt(play[2]);
	        String[] adv=adv_time.split(":");
	        int advtime=Integer.parseInt(adv[0])*3600+Integer.parseInt(adv[1])*60+Integer.parseInt(adv[2]);
	        int[][] time=new int[logs.length][2];
	        for(int i=0; i<logs.length; i++){
	            String[] temp=logs[i].split("-");
	            String[] start=temp[0].split(":");
	            String[] end=temp[1].split(":");
	            int starttime=Integer.parseInt(start[0])*3600+Integer.parseInt(start[1])*60+Integer.parseInt(start[2]);
	            int endtime=Integer.parseInt(end[0])*3600+Integer.parseInt(end[1])*60+Integer.parseInt(end[2]);
	            time[i][0]=starttime;
	            time[i][1]=endtime;
	        }
	        long[] total=new long[playtime+1];
	        for(int i=0; i<time.length; i++) {
	        	total[time[i][0]]++;
	        	total[time[i][1]]--;
	        }
	        for(int i=1; i<playtime; i++) {
	        	total[i]=total[i]+total[i-1];
	        }
	        for(int i=1; i<playtime; i++) {
	        	total[i]=total[i]+total[i-1];
	        }
	        int maxtime=0;
	        long max=0;
	        for(int i=advtime; i<playtime; i++) {
	        	if(max<total[i]-total[i-advtime]) {
	        		max=total[i]-total[i-advtime];
	        		maxtime=i-advtime;
	        	}
	        	
	        }
            if(maxtime!=0) maxtime=maxtime+1;
	        int hour=maxtime/3600;
	        maxtime%=3600;
	        int minute=maxtime/60;
	        maxtime%=60;
	        if(hour<10){
	            answer="0"+Integer.toString(hour)+":";
	        }else{
	            answer=Integer.toString(hour)+":";
	        }
	        if(minute<10){
	            answer=answer+"0"+Integer.toString(minute)+":";
	        }else{
	            answer=answer+Integer.toString(minute)+":";
	        }
	        if(maxtime<10){
	            answer=answer+"0"+Integer.toString(maxtime);
	        }else{
	            answer=answer+Integer.toString(maxtime);
	        }
	        return answer;   
    }
}