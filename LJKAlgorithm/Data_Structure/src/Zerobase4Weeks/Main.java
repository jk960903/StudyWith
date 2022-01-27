package Zerobase4Weeks;

public class Main {
	
	public static void main(String[] args) {
		//전체 게시글 수
		int totalcount = 230;
		//현재 게시글
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
		//한페이지당 게시글 수
		int page_per_post = 11 ;
		//전체 페이지 개수
		int totalpage = this.totalCount / page_per_post + 1;
		//한 네비게이션당 페이지 개수
		int page_per_page = 11;
		
		//현재 페이지
		int temppage = pageIndex / page_per_post;
		
		if(pageIndex % page_per_post !=0 ) {
			temppage++;
		}
		
		// 현재 페이지의 nav 페이지 한 nav당 페이지가 10이라면 1~10 인지 확인할수 있는 것
		int tempnav = (temppage-1) / page_per_page ;
		long start = tempnav*11+1;
		System.out.println("<!DOCTYPE html");
		System.out.println("<html lang=\"ko-kr\">");
		System.out.println("<head>");
		System.out.println("<meta charset=\"UTF-8\">");
		System.out.println("<title>로그인</title>");
		System.out.println("</head>");
		System.out.println("<body>");
		System.out.println("<div>");
		System.out.println("<a href=\"#\">[처음]</a>");
		System.out.println("<a href=\"#\">[이전]</a>");
		
		for(long i = start; i < start+page_per_page; i++) {
			if(i == temppage) { // 현재 페이지 일경우 
				System.out.println("<a href=\"#\" class='on'>"+i+"</a>");
				if(i == totalpage) { // 마지막 페이지 일경우 종료
					break;
				}
			}
			else { // 일반적인 페이지 
				System.out.println("<a href=\"#\">"+i+"</a>");
				if(i == totalpage) {//마지막 페이지 일경우 종료
					break;
				}
			}
		}
		System.out.println("<a href=\"#\">[다음]</a>");
		System.out.println("<a href=\"#\">[마지막]</a>");
		System.out.println("</div>");
		System.out.println("</body>");
	}
}
