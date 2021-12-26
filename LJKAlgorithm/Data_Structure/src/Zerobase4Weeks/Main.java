package Zerobase4Weeks;

public class Main {
	
	public static void main(String[] args) {
		//��ü �Խñ� ��
		int totalcount = 230;
		//���� �Խñ�
		int pageIndex = 1;
		
		Paper paper = new Paper(totalcount);
		paper.html(pageIndex);
	}
}

class Paper{
	private int totalCount;
	
	public Paper(int totalCount) {
		this.totalCount = totalCount;
	}
	
	public void html(int pageIndex) {
		//���������� �Խñ� ��
		int page_per_post = 11 ;
		//��ü ������ ����
		int totalpage = this.totalCount / page_per_post + 1;
		//�� �׺���̼Ǵ� ������ ����
		int page_per_page = 11;
		
		//���� ������
		int temppage = pageIndex / page_per_post;
		
		if(pageIndex % page_per_post !=0 ) {
			temppage++;
		}
		
		// ���� �������� nav ������ �� nav�� �������� 10�̶�� 1~10 ���� Ȯ���Ҽ� �ִ� ��
		int tempnav = (temppage-1) / page_per_page ;
		long start = tempnav*11+1;
		System.out.println("<!DOCTYPE html");
		System.out.println("<html lang=\"ko-kr\">");
		System.out.println("<head>");
		System.out.println("<meta charset=\"UTF-8\">");
		System.out.println("<title>�α���</title>");
		System.out.println("</head>");
		System.out.println("<body>");
		System.out.println("<div>");
		System.out.println("<a href=\"#\">[ó��]</a>");
		System.out.println("<a href=\"#\">[����]</a>");
		
		for(long i = start; i < start+page_per_page; i++) {
			if(i == temppage) { // ���� ������ �ϰ�� 
				System.out.println("<a href=\"#\" class='on'>"+i+"</a>");
				if(i == totalpage) { // ������ ������ �ϰ�� ����
					break;
				}
			}
			else { // �Ϲ����� ������ 
				System.out.println("<a href=\"#\">"+i+"</a>");
				if(i == totalpage) {//������ ������ �ϰ�� ����
					break;
				}
			}
		}
		System.out.println("<a href=\"#\">[����]</a>");
		System.out.println("<a href=\"#\">[������]</a>");
		System.out.println("</div>");
		System.out.println("</body>");
	}
}
