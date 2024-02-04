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
	public Book(String title) {
		this.title = title;
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
	
    @Override
    public boolean equals(Object bookElement) { 
        if (this == bookElement) { 
        	return true;
        }
        if (bookElement == null || getClass() != bookElement.getClass()) {
        	return false;
        }
        Book book = (Book) bookElement;
        return Objects.equals(title, book.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }
}


class BookManager{
	private Set<Book> books = new HashSet<>(); //set을 이용
	
	public boolean ADDBook(Book book) {
        boolean isDuplicate = books.stream()
                                   .anyMatch(existingBook -> existingBook.getTitle().equals(book.getTitle()));
        if (isDuplicate) {
            System.out.println("이미 동일한 제목에 서적이 등록 되어있습니다");
            return false;
        } else {
            books.add(book);
            System.out.println("신규 서적이 등록 되었습니다");
            return true;
        }
    }
	
	public Book GETBook(String title){
        return books.stream()
                    .filter(book -> book.getTitle().equals(title))
                    .findFirst()
                    .orElse(null); // 찾지 못하면 null 반환
    }

	
	public Collection<Book> GETALLBook(){ //책에 대한 전체조회
        return new HashSet<>(books);
    }
	
	public void UPDATEBook(String targetTitle, String newTitle, String newAuthor, String newDay) {
        books.stream()
             .filter(book -> book.getTitle().equals(targetTitle))
             .findFirst()
             .ifPresent(book -> {
                 books.remove(book);
                 book.setTitle(newTitle);
                 book.setAutor(newAuthor); // 필드 이름이 Autor에서 Author로 변경되어야 함
                 book.setDay(newDay);
                 books.add(book);
                 System.out.println("해당 서적에 대한 정보가 수정 되었습니다");
             });
    }

	
	public void DELETEBook(String title) {
        boolean removed = books.removeIf(book -> book.getTitle().equals(title));
        if (removed) {
            System.out.println("해당 서적에 대한 정보를 삭제했습니다");
        } else {
            System.out.println("해당 서적에 대한 정보가 존재하지 않습니다.");
        }
    }
}

