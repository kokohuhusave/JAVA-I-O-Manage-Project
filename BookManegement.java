package Book;

import java.util.*;
public class BookManegement {

	public static void main(String[] args) {
		Scanner scanner  = new Scanner(System.in);
		BookManager Manager = new BookManager();
		
		while (true) {
            try {
                System.out.println("메뉴를 선택하세요");
                System.out.println("1.서적 전체 조회");
                System.out.println("2.서적 조회");
                System.out.println("3.신규 서적 등록");
                System.out.println("4.서적 정보 삭제");
                System.out.println("5.서적 정보 수정");
                System.out.println("0. 종료");

                int choice = scanner.nextInt();
                scanner.nextLine(); // 숫자 입력 후 남은 줄바꿈 문자 제거

                switch (choice) {
                    case 1:
                        Manager.GETALLBook().forEach(System.out::println);
                        break;

                    case 2:
                        System.out.print("조회할 책 제목을 입력하세요: ");
                        String searchTitle = scanner.nextLine();
                        System.out.println(Manager.GETBook(searchTitle));
                        break;

                    case 3:
                        System.out.println("등록할 서적의 정보를 입력하세요: ");
                        System.out.print("책 제목: ");
                        String title = scanner.nextLine();
                        System.out.print("저자명: ");
                        String author = scanner.nextLine();
                        System.out.print("발행날짜 (예: 2024/11/04): ");
                        String day = scanner.nextLine();

                        Manager.ADDBook(new Book(title, author, day));
                        break;

                    case 4:
                        System.out.print("삭제하려는 서적 제목을 입력하세요: ");
                        String deleteTitle = scanner.nextLine();
                        Manager.DELETEBook(deleteTitle);
                        break;

                    case 5:
                        System.out.print("수정하려는 서적의 현재 제목을 입력하세요: ");
                        String targetTitle = scanner.nextLine();
                        System.out.println("새로운 정보를 입력하세요: ");
                        System.out.print("새 책 제목: ");
                        String updateTitle = scanner.nextLine();
                        System.out.print("새 저자명: ");
                        String updateAuthor = scanner.nextLine();
                        System.out.print("새 발행날짜 (예: 2024/11/04): ");
                        String updateDay = scanner.nextLine();

                        Manager.UPDATEBook(targetTitle, updateTitle, updateAuthor, updateDay);
                        break;

                    case 0:
                        System.out.println("프로그램을 종료합니다.");
                        scanner.close();
                        return;

                    default:
                        System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("잘못된 입력입니다. 숫자를 입력해주세요.");
                scanner.nextLine(); // 잘못된 입력 제거
            }
        }
    }
<<<<<<< HEAD
}
=======
}
>>>>>>> fc30ef4 (오류수정)
