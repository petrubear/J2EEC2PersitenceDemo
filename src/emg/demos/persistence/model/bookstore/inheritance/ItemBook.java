package emg.demos.persistence.model.bookstore.inheritance;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "TI_BOOK")
@DiscriminatorValue("B")
/*
@AttributeOverrides({ @AttributeOverride(name = "id",
column = @Column(name = "book_id")), @AttributeOverride(name = "title",
column = @Column(name = "book_title")), @AttributeOverride(name = "description",
                     column = @Column(name = "book_description"))
})
*/
public class ItemBook extends Item {

	private String isbn;
	private String publisher;
	private Integer nbOfPage;
	private Boolean illustrations;

	public ItemBook() {
	}

	public ItemBook(String title, Float price, String description, String isbn,
			String publisher, Integer nbOfPage, Boolean illustrations) {
		super(title, price, description);
		this.isbn = isbn;
		this.publisher = publisher;
		this.nbOfPage = nbOfPage;
		this.illustrations = illustrations;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public Integer getNbOfPage() {
		return nbOfPage;
	}

	public void setNbOfPage(Integer nbOfPage) {
		this.nbOfPage = nbOfPage;
	}

	public Boolean getIllustrations() {
		return illustrations;
	}

	public void setIllustrations(Boolean illustrations) {
		this.illustrations = illustrations;
	}
}
