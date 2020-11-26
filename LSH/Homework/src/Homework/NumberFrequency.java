package Homework;
 
import java.util.Arrays; 
public class NumberFrequency {
	private static int N, M, S; 
	private static int[] generateRandomNumber() {

		int[] array = new int[N];
		for(int i=0;i<N;i++) {
			double a=Math.random();		//N�� ũ��� ���� �迭�� ���� ����
			array[i] = (int)(a*M);
		}
		return array;
	}

	private static int[] countFrequency(int[] numbers){

		Arrays.sort(numbers);
		int countnumber;
		int index=0;
		int level=S;
		if(M%S==0) {			//count�迭�� ���� ���ϱ�
			countnumber=M/S;
		}
		else {
			countnumber=M/S+1;
		}
		int[] count = new int[countnumber];	//�� ������ ������ ��� �迭
		for(int i=0;i<count.length;i++) {	//count�迭 �ʱ�ȭ
			count[i]=0;
		}
		
		int i=0;
		while(i<numbers.length) {
				if(numbers[i]<level) {		//�������� ���� �����϶� count�迭�� �Ѱ��� �ø���
					count[index]++;
					i++;			
				}
				else {
					index++;
					level=S*(index+1);		//�� ������ �Ѿ����� count�迭�� �ε��� �÷��ְ� ������ �ٲ���
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
	N = Integer.parseInt(args[0]);		//���Ұ���
	M = Integer.parseInt(args[1]);		//�ִ밪
	S = Integer.parseInt(args[2]);		//����
	System.out.println("2016146036 �̽���");
	int[] randomNumbers = generateRandomNumber();
	int[] frequencies = countFrequency(randomNumbers);
	printFrequency(frequencies);
	}
}