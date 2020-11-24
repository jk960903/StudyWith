package 두개뽑아서더하기;
import java.util.Arrays;
import java.util.HashSet;
///프로그래머스 파일은 메인은 아무 결과가 없습니다. 
//numbers에 서로 다른 인덱스 2개를 뽑아 더한 값 을 오른차순 배열로 정렬
public class Main {
	public static void main(String[] args) {
		int[] numbers= {2,1,3,4,1};
		int[] result=solution(numbers);
		for(int i=0; i<result.length; i++) {
			System.out.print(result[i]+" ");
		}
	}
	public static int[] solution(int[] numbers) {
	        int[] answer = {};
	        HashSet<Integer> set=new HashSet<>();
	        for(int i=0; i<numbers.length; i++){
	            for(int j=i+1; j<numbers.length; j++){
	                int result=numbers[i]+numbers[j];
	                set.add(result);
	            }
	        }
	        answer=new int[set.size()];
	        int index=0;
	        for(int i : set){
	            answer[index++]=i;
	        }
	        Arrays.sort(answer);
	        return answer;
	}
}
