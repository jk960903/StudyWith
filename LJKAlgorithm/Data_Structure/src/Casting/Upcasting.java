package Casting;

public class Upcasting {
	public static void main(String[] args) {
		Lab lab = new Lab("���ر�",1);
		Person person = lab;
		
		//��ĳ���� �Ǿ��� ������ person.No �� ���� �Ұ��� name�� ���� ����
	}
}
class Person{
	String name;
	
	public Person(String name) {
		this.name = name;
	}
	
}
class Lab extends Person{
	int No;
	
	public Lab(String name , int No) {
		super(name);
		this.No=No;
	}
}
