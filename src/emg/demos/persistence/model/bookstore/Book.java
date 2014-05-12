package emg.demos.persistence.model.bookstore;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * From APress Book - Beginning Java EE 6 with Glassfish
 */

@Entity
@Table(name = "T_BOOK")
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "BOOK_TITLE", nullable = false, updatable = false)
	private String title;
	private Float price;
	@Column(length = 2000)
	private String description;
	private String isbn;
	@Column(name = "NB_OF_PAGE", nullable = false)
	private Integer nbOfPage;
	private Boolean illustrations;
	// @Basic(fetch = FetchType.LAZY)
	// el valor se obtiene solamente cuando se hace get
	// @Basic(fetch = FetchType.EAGER) es el default
	@ElementCollection(fetch = FetchType.LAZY)
	@CollectionTable(name = "T_TAG")
	private List<String> tags = new ArrayList<String>();

	public Book() {
	}

	public Book(String title, Float price, String description, String isbn,
			Integer nbOfPage, Boolean illustrations, List<String> tags) {
		this.title = title;
		this.price = price;
		this.description = description;
		this.isbn = isbn;
		this.nbOfPage = nbOfPage;
		this.illustrations = illustrations;
		this.tags = tags;
	}

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
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

	public List<String> getTags() {
		return tags;
	}

	public void setTags(ArrayList<String> tags) {
		this.tags = tags;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("Book");
		sb.append("{id=").append(id);
		sb.append(", title='").append(title).append('\'');
		sb.append(", price=").append(price);
		sb.append(", description='").append(description).append('\'');
		sb.append(", isbn='").append(isbn).append('\'');
		sb.append(", nbOfPage=").append(nbOfPage);
		sb.append(", illustrations=").append(illustrations);
		sb.append('}');
		return sb.toString();
	}
}