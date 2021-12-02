package ZeroBase;

public class Problem1 {
	public static void main(String[] args) {
		char name1 = '¿Ã';
		char name2 = '¡ÿ';
		char name3 = '±‘';
		
		int intname1 = 0;
		int intname2 = 0;
		int intname3 = 0;
		
		for(int i = 0 ; i < Character.MAX_VALUE; i++) {
			if(i == (int)name1) {
				intname1 = i;
			}
			if(i == (int)name2) {
				intname2 = i;
			}
			if(i == (int)name3) {
				intname3 = i;
			}
		}
		
		System.out.printf("0x%x , 0x%x , 0x%x",intname1,intname2,intname3);
	}
}
