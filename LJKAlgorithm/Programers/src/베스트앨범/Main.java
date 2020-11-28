package ����Ʈ�ٹ�;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
//��Ʈ���� ����Ʈ���� �帣 ���� ���� ���� ����� �뷡�� �� ���� ��� ����Ʈ �ٹ��� ����Ϸ� �մϴ�. �뷡�� ���� ��ȣ�� �����ϸ�, �뷡�� �����ϴ� ������ ������ �����ϴ�.
//���� �뷡�� ���� ����� �帣�� ���� �����մϴ�.
//�帣 ������ ���� ����� �뷡�� ���� �����մϴ�.
//�帣 ������ ��� Ƚ���� ���� �뷡 �߿����� ���� ��ȣ�� ���� �뷡�� ���� �����մϴ�.
public class Main {
	public static void main(String[] args) {
		String[] genres= {"classic", "pop", "classic", "classic", "classic","dance"	};
		int[] plays= {300, 600, 150, 300, 300,2000};
		//String[] genres= {"classic"};
		//int[] plays= {100};
		Solution solution=new Solution();
		int[] answer=solution.solution(genres, plays);
		for(int i=0; i<answer.length; i++) {
			System.out.println(answer[i]);
		}
	}
}

class Solution {
    public int[] solution(String[] genres, int[] plays) {
    	int[] answer = {};
        HashMap<String,Integer> genresMap=new HashMap<>();
        HashSet<String> genresSet=new HashSet<>();
        HashMap<String,LinkedList<Integer>> listmap=new HashMap<>();
        HashMap<String,LinkedList<Integer>> indexmap=new HashMap<>();
        for(int i=0; i<genres.length; i++){
            if(genresMap.containsKey(genres[i])){
                genresMap.put(genres[i],genresMap.get(genres[i])+plays[i]);
                LinkedList<Integer> templist= listmap.get(genres[i]);
                LinkedList<Integer> tempindex=indexmap.get(genres[i]);
                if(plays[i]>templist.get(0)){
                 	templist.add(0,plays[i]);
                 	tempindex.add(0,i);
                }else if(plays[i]==templist.get(0)) {
                	if(plays[i]==templist.get(1)) {
                		templist.add(plays[i]);
                		tempindex.add(i);
                	}else {
                		templist.add(1,plays[i]);
                		tempindex.add(1,i);
                	}
                }
                else if(templist.size()>=2&&plays[i]==templist.get(1)){
                	templist.add(i);
                	tempindex.add(i);
                }else if(templist.size()>=2&&plays[i]>templist.get(1)){
                    templist.add(1,plays[i]);
                    tempindex.add(1,i);
                }else{
                    templist.add(plays[i]);
                    tempindex.add(i);
                }
                listmap.put(genres[i],templist);
                indexmap.put(genres[i],tempindex);
            }else{
                genresSet.add(genres[i]);
                genresMap.put(genres[i],plays[i]);
                LinkedList<Integer> templist=new LinkedList<>();
                LinkedList<Integer> tempindex=new LinkedList<>();
                templist.add(plays[i]);
                listmap.put(genres[i],templist);
                tempindex.add(i);
                indexmap.put(genres[i],tempindex);
            }
        }
        LinkedList<Integer> answerlist=new LinkedList<>();
        LinkedList<String> genreslist=InsertSort(genresMap,genresSet);
        for(int i=0; i<genreslist.size(); i++){
            String temp=genreslist.get(i);
            LinkedList<Integer> templist=indexmap.get(temp);
            answerlist.add(templist.get(0));
            if(templist.size()>=2){
                answerlist.add(templist.get(1));
            }
        }
        answer=new int[answerlist.size()];
        for(int i=0; i<answerlist.size(); i++){
           answer[i]=answerlist.get(i);
        }
        
        return answer;
    }
    public LinkedList<String> InsertSort(HashMap<String,Integer> map,HashSet<String> set){

    	LinkedList<Integer> list=new LinkedList<>();
        LinkedList<String> answer=new LinkedList<>();
        for(String s : set){
            if(list.size()==0){
                list.add(map.get(s));
                answer.add(s);
            }else{
                for(int i=0; i<list.size(); i++){
                    if(map.get(s)>list.get(i)){
                        list.add(i,map.get(s));
                        answer.add(i,s);
                        break;
                    }
                    if(i==list.size()-1){
                        list.add(map.get(s));
                        answer.add(s);
                        break;
                    }
                }
            }
        }
        return answer;
    }
    
}