package Book;

import java.util.*;
public class BookManegement {

	public static void main(String[] args) {
		Scanner scanner  = new Scanner(System.in);
		BookManager Manager = new BookManager();
		
		while(true) {
			System.out.println("메뉴를 선택하세요");
			System.out.println("1.서적 전체 조회");
			System.out.println("2.서적 조회");
			System.out.println("3.신규 서적 등록");
			System.out.println("4.서적 정보 삭제");
			System.out.println("5.서적 정보 수정");
			
			int CHOICE = scanner.nextInt();
			
			switch(CHOICE) {
			case 1:
				Manager.GETALLBook().forEach(System.out::println);
				break;
			
			case 2:
				System.out.print("조회할 책제목를 입력하세요: ");
                String SEARCHTitle = scanner.next();
                System.out.println(Manager.GETBook(SEARCHTitle));	
                break;
                
			case 3:
				System.out.println("등록할 서적의 정보를 입력하세요: ");
				System.out.print("책 제목: ");
				String Title = scanner.next();
				System.out.print("저자명: ");
				String Autor = scanner.next();
				System.out.println("발행날짜입력 예시) 발행날짜: 2024/11/04");
				System.out.print("발행날짜: ");
				String Day = scanner.next();
				
				Manager.ADDBook(new Book(Title, Autor, Day));
				break;
				
			case 4:
				System.out.println("삭제하려는 서적 제목를 입력하세요");
				String DELETETitle = scanner.next();
				Manager.DELETEBook(DELETETitle);
				break;
				
			case 5:
				System.out.println("수정하려는 서적 제목를 입력하세요: ");
				String TARGETTitle = scanner.next();
				System.out.println("등록할 서적의 정보를 입력하세요: ");
				System.out.print("책 제목: ");
				String UPDATETitle = scanner.next();
				System.out.print("저자명: ");
				String UPDATEAutor = scanner.next();
				System.out.println("발행날짜입력 예시) 발행날짜: 2024/11/04");
				System.out.print("발행날짜: ");
				String UPDATEDay = scanner.next();
				
				Manager.UPDATEBook(TARGETTitle, UPDATETitle, UPDATEAutor, UPDATEDay);
				break;
			}
		}
	}
}
