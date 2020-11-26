package Homework;
 
import java.util.Arrays; 
public class NumberFrequency {
	private static int N, M, S; 
	private static int[] generateRandomNumber() {

		int[] array = new int[N];
		for(int i=0;i<N;i++) {
			double a=Math.random();		//N의 크기로 만든 배열에 난수 삽입
			array[i] = (int)(a*M);
		}
		return array;
	}

	private static int[] countFrequency(int[] numbers){

		Arrays.sort(numbers);
		int countnumber;
		int index=0;
		int level=S;
		if(M%S==0) {			//count배열의 개수 정하기
			countnumber=M/S;
		}
		else {
			countnumber=M/S+1;
		}
		int[] count = new int[countnumber];	//각 구간별 개수를 담는 배열
		for(int i=0;i<count.length;i++) {	//count배열 초기화
			count[i]=0;
		}
		
		int i=0;
		while(i<numbers.length) {
				if(numbers[i]<level) {		//구간보다 작은 원소일때 count배열값 한개씩 늘리기
					count[index]++;
					i++;			
				}
				else {
					index++;
					level=S*(index+1);		//한 구간을 넘었을때 count배열의 인덱스 올려주고 구간도 바꿔줌
				}
		}
		return count;
	}
	private static void printFrequency(int[] frequencies) {
		System.out.print(M+" "+N+" "+S);
		System.out.println("");
		for(int i=0;i<frequencies.length;i++) {
			if(S*(i+1)<M) {
				System.out.println("[" + (S*i) + "," + S*(i+1) + "):" + frequencies[i]);
			}
			else if(S*(i+1)>=M) {
				System.out.println("["+(S*i)+","+ M +"):"+frequencies[i]);
			}
		}
	}
	public static void main(String[] args) {
	N = Integer.parseInt(args[0]);		//원소개수
	M = Integer.parseInt(args[1]);		//최대값
	S = Integer.parseInt(args[2]);		//구간
	System.out.println("2016146036 이승현");
	int[] randomNumbers = generateRandomNumber();
	int[] frequencies = countFrequency(randomNumbers);
	printFrequency(frequencies);
	}
}