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
		for(Book existingBook : books) {
			if(existingBook.getTitle().equals(book.getTitle())) {
				System.out.println("이미 동일한 제목에 서적이 등록 되어있습니다");
				return false;
				
			}
		}
		books.add(book);
		System.out.println("신규 서적이 등록 되었습니다");
		return true;
		
	}
	
	public Book GETBook(String title){	// 책에 대한 정보를 가져오는 함수
	    for (Book book : books) {
	        if (book.getTitle().equals(title)) {
	            return book;
	        }
	    }
	    System.out.println("해당 서적의 대한 정보는 존재 하지 않습니다"); // 예외처리(책 제목이 존재하지 않는경우)
		return null;
	}

	
	public Collection<Book> GETALLBook(){	//책에 대한 전체조회
		return new HashSet<>(books);
	}
	
	public void UPDATEBook(String targetTitle, String newTitle, String newAuthor, String newDay) {
        Book bookToUpdate = null;
        for (Book book : books) {
            if (book.getTitle().equals(targetTitle)) {
                bookToUpdate = book;
                break;
            }
        }
        if(bookToUpdate != null) {
        	for(Book book : books) {
        		if (!book.equals(bookToUpdate) && book.getTitle().equals(newTitle)) {
                    System.out.println("이미 같은 제목의 책이 존재합니다.");
                    return;
        		}
        	}
        	books.remove(bookToUpdate);
        	bookToUpdate.setTitle(newTitle);
        	bookToUpdate.setAutor(newAuthor);
        	bookToUpdate.setDay(newDay);
        	books.add(bookToUpdate);
        	System.out.println("해당 서적에 대한 정보가 수정 되었습니다");
        }else {
        	System.out.println("해당 서적에 대한 정보가 존재하지 않습니다");
        }
    
    }

	
	public void DELETEBook(String title) {
        Book bookToDelete = null;
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                bookToDelete = book;
                break;
            }
        }

        if (bookToDelete != null) {
            books.remove(bookToDelete);
            System.out.println("해당 서적에 대한 정보를 삭제했습니다");
        } else {
            System.out.println("해당 서적에 대한 정보가 존재하지 않습니다.");
        }
    }
}

