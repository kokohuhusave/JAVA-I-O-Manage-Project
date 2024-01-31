package Book;

import java.util.*;

public class Book {
	private UUID id; 		//사용자 id
	
	private String title;	//책 제목
	
	private String Autor;	//책 저자
	
	private String Day;		//책 발행 날짜
	
	public Book(String title, String Autor, String Day) {
		this.id = UUID.randomUUID();
		
		this.title = title;
		
		this.Autor = Autor;
		
		this.Day = Day;
	}
	
	public UUID getId() {
		return this.id;
	}
	
	public void setId(UUID id) {
		this.id = id;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getAutor() {
		return this.Autor;
	}
	
	public void setAutor(String Autor) {
		this.Autor = Autor;
	}
	
	public String getDay() {
		return this.getDay();
	}
	
	public void setDay(String Day) {
		this.Day = Day;
	}
	
	@Override
	public String toString() {
		return "Book[" + " id= " + id + " title = " + title + " Autor = " + Autor + " Day = " + Day + " ]";
	}
}


class BookManager{
	private Map<UUID, Book> books = new HashMap<>(); //헤시 맵을 통한 
	
	public void ADDBook(Book book) { // 책에 대한 신규레코드 추가 함수
		books.put(book.getId(), book);
	}
	
	public Book GETBook(String title){	// 책에 대한 정보를 가져오는 함수
	    for (Book book : books.values()) {
	        if (book.getTitle().equals(title)) {
	            return book;
	        }
	    }
	    System.out.println("해당 서적의 대한 정보는 존재 하지 않습니다"); // 예외처리(책 제목이 존재하지 않는경우)
		return null;
	}

	
	public Collection<Book> GETALLBook(){	//책에 대한 전체조회
		return books.values();
	}
	
	public void UPDATEBook(String TARGETTitle, String newTitle, String newAuthor, String newDay) {
	    UUID bookIdToUpdate = null;
	    for (Map.Entry<UUID, Book> entry : books.entrySet()) {
	        if (entry.getValue().getTitle().equals(TARGETTitle)) {
	            bookIdToUpdate = entry.getKey();
	            break; // 일치하는 첫 번째 책을 찾으면 반복 종료
	        }
	    }

	    if (bookIdToUpdate != null) {
	        Book book = books.get(bookIdToUpdate);
	        book.setTitle(newTitle); // 새로운 제목으로 업데이트
	        book.setAutor(newAuthor);
	        book.setDay(newDay);
	    }
	    else if(bookIdToUpdate == null) {
	    	System.out.println("해당 서적의 대한 정보는 존재 하지 않습니다");
	    }
	}

	
	public void DELETEBook(String title) {		
	    UUID bookIdToDelete = null;
	    for (Map.Entry<UUID, Book> entry : books.entrySet()) {
	        if (entry.getValue().getTitle().equals(title)) {
	            bookIdToDelete = entry.getKey();
	            break;
	        }
	    }

	    if (bookIdToDelete != null) {
	        books.remove(bookIdToDelete); // 일치하는 책을 맵에서 삭제
	    }
	    else if(bookIdToDelete == null) {
	    	System.out.println("해당 서적의 대한 정보는 존재 하지 않습니다");
	    }
	}
	
}

