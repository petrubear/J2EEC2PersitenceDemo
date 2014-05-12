package emg.demos.persistence.model.bookstore.mapping;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "T_CD")
public class CD {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String title;
	private Float price;
	private String description;
	@ManyToMany(mappedBy = "appearsOnCDs") //reverse owner usa mappedby
	private List<Artist> createdByArtists;

	public CD() {
	}

	public CD(String title, Float price, String description) {
		this.title = title;
		this.price = price;
		this.description = description;
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

	public List<Artist> getCreatedByArtists() {
		return createdByArtists;
	}

	public void setCreatedByArtists(List<Artist> createdByArtists) {
		this.createdByArtists = createdByArtists;
	}

	public void createdBy(Artist artist) {
		if (createdByArtists == null)
			createdByArtists = new ArrayList<Artist>();
		createdByArtists.add(artist);
	}
}
