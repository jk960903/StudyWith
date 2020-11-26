package Homework;

import java.util.Scanner;



class Car{
	private String Name;
	private String CarNumber;
	private int OwnNumber;
	private boolean AlreadyParked;		//주차가 된상태인지 아닌지 의미, false는 주차안된상태
	
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
	public boolean getAlreadyParked() {			//private으로 돼있으니 이 메소드를 통해 접근가능
		return AlreadyParked;
	}
	public void setAlreadyParked(boolean AlreadyParked) {	//private으로 돼있으니 이 메소드를 통해 수정가능
		this.AlreadyParked=AlreadyParked;
	}
	
	
	public Car(String Name, String CarNumber,int OwnNumber, boolean AlreadyParked) {		//생성자
		this.Name=Name;
		this.CarNumber=CarNumber;
		this.OwnNumber=OwnNumber;
		this.AlreadyParked=AlreadyParked;
	}
}


//=================================================================================================================================
public class ParkingSimulator {
	static final String Myname="이승현";
	public static boolean exist;
	
	
	public static int IsRegistered(String carnumber, Car[] car) {	//car배열을 확인하여 그 번호가 있느닞 확인
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
		if(!exist) {	//만약 존재 안한다면(그 번호가 없는경우)
			System.out.println("등록되지 않은 차량입니다.");
		}
		
		return CarIndex;
	}

	public static int[] NowAvailable(int[][] array) {
		int[] availablePoint = new int[2];				//빈자리의 좌표를 x,y로 반환하기위해 크기2인 배열만듬
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
			if(toggle) {	//안쪽 포문에서 못찾고 밖으로 나가면 break시키지 않도록, 만약 밖 포문에서 찾으면 브레이크로 탈출
				break;
			}
		}
		return availablePoint;
	}
	
	public static int[][] GetPark(int[] ParkHere, int[][] array, int OwnNumber) {
		array[ParkHere[0]][ParkHere[1]]=OwnNumber;		//주차 가능한곳의 좌표의 값을 그 차의 인덱스로 바꿔줌 단 0번째차는 1로
		return array;
	}
	
	public static int[][] GoHome(int[][] array, int whichcar) {
		for(int i=0;i<array.length;i++) {
			for(int j=0;j<array[i].length;j++) {
				if(array[i][j]==whichcar) {			//지금 해당차가 어디있는지 반환
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
				
				if(array[i][j]!=0) {	//주차장 배열에서 해당 차를 찾고
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
	
//메인============================================================================================== 
	public static void main(String[] args) {
		int row,column;
		int OwnNumber;
		String temp;
		System.out.println("2016146036 이승현");
		Car[] car; 
		car = new Car[6];
		car[0]=new Car("Kim","1111",1,false);
		car[1]=new Car("Lee","2222",2,false);
		car[2]=new Car("Kwon","3333",3,false);
		car[3]=new Car("Park","4444",4,false);
		car[4]=new Car("Choi","5555",5,false);
		car[5]=new Car("Kang","6666",6,false);
		
		System.out.print("주차장의 크기(행과 열)를 입력하세요");
		Scanner sc = new Scanner(System.in);
		row=sc.nextInt();
		column=sc.nextInt();
		System.out.println(Myname+ " 근무를 시작합니다.");
		System.out.println("");
		
		for(int i=0;i<row;i++) {				//처음은 빈 주차장 보여줌
			for(int j=0;j<column;j++) {
				System.out.print("("+i+","+j+"):____ ");
			}
			System.out.println("");
		}
	
		int[] ParkHere= new int[2];		//주차가능한 곳 좌표 받기위함
		int[][] ParkingLot = new int[row][column];
		for(int i=0;i<row;i++) {						//주차장배열 0으로 초기화
			for(int j=0;j<column;j++) {
				ParkingLot[i][j]=0;
			}
		}
		
		
		do {
			System.out.print("차량 번호를 입력하세요: ");
			temp=sc.next();
			if(temp.equals("퇴근")) {
				break;
			}
			OwnNumber=IsRegistered(temp,car);		
			
			if(OwnNumber>0) {	//OwnNumbe가 0보다 크다는것은 등록된 차라는것
				ParkHere=NowAvailable(ParkingLot);			//주차가능한곳 좌표 받아줌, ParkHere에 지금 주차가능한곳 좌표가 받아짐
			
				if(car[OwnNumber-1].getAlreadyParked() != true && ParkHere[0] != -1) {	//해당 차가 아직 주차안돼있고, 주차장에 빈자리가 있으면
					car[OwnNumber-1].setAlreadyParked(true);
					ParkingLot=GetPark(ParkHere,ParkingLot,OwnNumber);		//주차후의 주차장배열을 받아옴
					System.out.println(temp+"번 차량 ("+ParkHere[0]+","+ParkHere[1]+")에 주차했습니다.");
					ShowParkingLot(ParkingLot,OwnNumber,car);
				}
				else if(car[OwnNumber-1].getAlreadyParked() != true && ParkHere[0] == -1) {//주차는 안됐지만 주차장이 꽉찬경우
					System.out.println("만차입니다.");
				}
				else if(car[OwnNumber-1].getAlreadyParked() == true ) {			//이미 주차돼있는경우
					ParkingLot=GoHome(ParkingLot,OwnNumber);					//주차장배열에서 해당 차 지우고 주차장배열 반환
					ShowParkingLot(ParkingLot,OwnNumber,car);
					car[OwnNumber-1].setAlreadyParked(false);
					System.out.println("차주 "+car[OwnNumber-1].getName()+", "+car[OwnNumber-1].getCarNumber()+"번 차량 출차했습니다.");
				}
			}
		}while(true);
		System.out.println(Myname+" 퇴근합니다.");
		sc.close();
	}

}
