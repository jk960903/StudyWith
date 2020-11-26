package Homework;

import java.util.Scanner;



class Car{
	private String Name;
	private String CarNumber;
	private int OwnNumber;
	private boolean AlreadyParked;		//������ �Ȼ������� �ƴ��� �ǹ�, false�� �����ȵȻ���
	
	public String getName() {
		return Name;
	}
	public void setName(String Name) {
		this.Name=Name;
	}
	public String getCarNumber() {
		return CarNumber;
	}
	public void setCarNumber(String CarNumber) {
		this.CarNumber=CarNumber;
	}
	
	public int getOwnNumber() {
		return OwnNumber;
	}
	public void setOwnNumber(int OwnNumber) {
		this.OwnNumber=OwnNumber;
	}
	public boolean getAlreadyParked() {			//private���� �������� �� �޼ҵ带 ���� ���ٰ���
		return AlreadyParked;
	}
	public void setAlreadyParked(boolean AlreadyParked) {	//private���� �������� �� �޼ҵ带 ���� ��������
		this.AlreadyParked=AlreadyParked;
	}
	
	
	public Car(String Name, String CarNumber,int OwnNumber, boolean AlreadyParked) {		//������
		this.Name=Name;
		this.CarNumber=CarNumber;
		this.OwnNumber=OwnNumber;
		this.AlreadyParked=AlreadyParked;
	}
}


//=================================================================================================================================
public class ParkingSimulator {
	static final String Myname="�̽���";
	public static boolean exist;
	
	
	public static int IsRegistered(String carnumber, Car[] car) {	//car�迭�� Ȯ���Ͽ� �� ��ȣ�� �ִ��� Ȯ��
		boolean exist=false;
		int CarIndex=0;
		String temp;
		for(int i=0; i<car.length;i++) {
			temp=car[i].getCarNumber();
			
			if((temp.equals(carnumber))) {
				CarIndex=car[i].getOwnNumber();
				exist=true;
				break;
			}
		}
		if(!exist) {	//���� ���� ���Ѵٸ�(�� ��ȣ�� ���°��)
			System.out.println("��ϵ��� ���� �����Դϴ�.");
		}
		
		return CarIndex;
	}

	public static int[] NowAvailable(int[][] array) {
		int[] availablePoint = new int[2];				//���ڸ��� ��ǥ�� x,y�� ��ȯ�ϱ����� ũ��2�� �迭����
		boolean toggle=false;
		availablePoint[0]=-1;
		availablePoint[1]=-1;
		for(int i=0;i<array.length;i++) {
			for(int j=0;j<array[i].length;j++) {
				if(array[i][j]==0) {
					availablePoint[0]=i;
					availablePoint[1]=j;	
					toggle=true;
					break;
				}
			}
			if(toggle) {	//���� �������� ��ã�� ������ ������ break��Ű�� �ʵ���, ���� �� �������� ã���� �극��ũ�� Ż��
				break;
			}
		}
		return availablePoint;
	}
	
	public static int[][] GetPark(int[] ParkHere, int[][] array, int OwnNumber) {
		array[ParkHere[0]][ParkHere[1]]=OwnNumber;		//���� �����Ѱ��� ��ǥ�� ���� �� ���� �ε����� �ٲ��� �� 0��°���� 1��
		return array;
	}
	
	public static int[][] GoHome(int[][] array, int whichcar) {
		for(int i=0;i<array.length;i++) {
			for(int j=0;j<array[i].length;j++) {
				if(array[i][j]==whichcar) {			//���� �ش����� ����ִ��� ��ȯ
					array[i][j]=0;
					break;
				}
			}
		}
		return array;
	}
	
	static void ShowParkingLot(int[][] array, int OwnNumber, Car[] car ) {
		for(int i=0;i<array.length;i++) {
			for(int j=0;j<array[i].length;j++) {
				
				if(array[i][j]!=0) {	//������ �迭���� �ش� ���� ã��
					if(array[i][j]==1) {
						System.out.print("("+i+","+j+"):"+car[0].getCarNumber()+"("+car[0].getName()+")");
					}
					else if(array[i][j]==2) {
						System.out.print("("+i+","+j+"):"+car[1].getCarNumber()+"("+car[1].getName()+")");
					}
					else if(array[i][j]==3) {
						System.out.print("("+i+","+j+"):"+car[2].getCarNumber()+"("+car[2].getName()+")");
					}
					else if(array[i][j]==4) {
						System.out.print("("+i+","+j+"):"+car[3].getCarNumber()+"("+car[3].getName()+")");
					}
					else if(array[i][j]==5) {
						System.out.print("("+i+","+j+"):"+car[4].getCarNumber()+"("+car[4].getName()+")");
					}
					else if(array[i][j]==6) {
						System.out.print("("+i+","+j+"):"+car[5].getCarNumber()+"("+car[5].getName()+")");
					}
				}
				else {
					System.out.print("("+i+","+j+"):____ ");	
				}
				
			}
			System.out.println("");
		}
		
	}
	
//����============================================================================================== 
	public static void main(String[] args) {
		int row,column;
		int OwnNumber;
		String temp;
		System.out.println("2016146036 �̽���");
		Car[] car; 
		car = new Car[6];
		car[0]=new Car("Kim","1111",1,false);
		car[1]=new Car("Lee","2222",2,false);
		car[2]=new Car("Kwon","3333",3,false);
		car[3]=new Car("Park","4444",4,false);
		car[4]=new Car("Choi","5555",5,false);
		car[5]=new Car("Kang","6666",6,false);
		
		System.out.print("�������� ũ��(��� ��)�� �Է��ϼ���");
		Scanner sc = new Scanner(System.in);
		row=sc.nextInt();
		column=sc.nextInt();
		System.out.println(Myname+ " �ٹ��� �����մϴ�.");
		System.out.println("");
		
		for(int i=0;i<row;i++) {				//ó���� �� ������ ������
			for(int j=0;j<column;j++) {
				System.out.print("("+i+","+j+"):____ ");
			}
			System.out.println("");
		}
	
		int[] ParkHere= new int[2];		//���������� �� ��ǥ �ޱ�����
		int[][] ParkingLot = new int[row][column];
		for(int i=0;i<row;i++) {						//������迭 0���� �ʱ�ȭ
			for(int j=0;j<column;j++) {
				ParkingLot[i][j]=0;
			}
		}
		
		
		do {
			System.out.print("���� ��ȣ�� �Է��ϼ���: ");
			temp=sc.next();
			if(temp.equals("���")) {
				break;
			}
			OwnNumber=IsRegistered(temp,car);		
			
			if(OwnNumber>0) {	//OwnNumbe�� 0���� ũ�ٴ°��� ��ϵ� ����°�
				ParkHere=NowAvailable(ParkingLot);			//���������Ѱ� ��ǥ �޾���, ParkHere�� ���� ���������Ѱ� ��ǥ�� �޾���
			
				if(car[OwnNumber-1].getAlreadyParked() != true && ParkHere[0] != -1) {	//�ش� ���� ���� �����ȵ��ְ�, �����忡 ���ڸ��� ������
					car[OwnNumber-1].setAlreadyParked(true);
					ParkingLot=GetPark(ParkHere,ParkingLot,OwnNumber);		//�������� ������迭�� �޾ƿ�
					System.out.println(temp+"�� ���� ("+ParkHere[0]+","+ParkHere[1]+")�� �����߽��ϴ�.");
					ShowParkingLot(ParkingLot,OwnNumber,car);
				}
				else if(car[OwnNumber-1].getAlreadyParked() != true && ParkHere[0] == -1) {//������ �ȵ����� �������� �������
					System.out.println("�����Դϴ�.");
				}
				else if(car[OwnNumber-1].getAlreadyParked() == true ) {			//�̹� �������ִ°��
					ParkingLot=GoHome(ParkingLot,OwnNumber);					//������迭���� �ش� �� ����� ������迭 ��ȯ
					ShowParkingLot(ParkingLot,OwnNumber,car);
					car[OwnNumber-1].setAlreadyParked(false);
					System.out.println("���� "+car[OwnNumber-1].getName()+", "+car[OwnNumber-1].getCarNumber()+"�� ���� �����߽��ϴ�.");
				}
			}
		}while(true);
		System.out.println(Myname+" ����մϴ�.");
		sc.close();
	}

}
