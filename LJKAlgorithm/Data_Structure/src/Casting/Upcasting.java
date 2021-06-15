package Casting;

public class Upcasting {
	public static void main(String[] args) {
		Lab lab = new Lab("이준규",1);
		Person person = lab;
		
		//업캐스팅 되었기 때문에 person.No 는 접근 불가능 name만 접근 가능
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
