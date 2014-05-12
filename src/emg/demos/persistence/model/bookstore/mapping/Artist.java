package emg.demos.persistence.model.bookstore.mapping;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "T_ARTIST")
public class Artist {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String firstName;
	private String lastName;
	@ManyToMany
	@JoinTable(name = "JND_ARTIST_CD", joinColumns = @JoinColumn(name = "ARTIST_FK"), inverseJoinColumns = @JoinColumn(name = "CD_FK"))
	// owner define la relacion
	private List<CD> appearsOnCDs;

	public Artist() {
	}

	public Artist(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Long getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public List<CD> getAppearsOnCDs() {
		return appearsOnCDs;
	}

	public void setAppearsOnCDs(List<CD> appearsOnCDs) {
		this.appearsOnCDs = appearsOnCDs;
	}

	public void appearsOn(CD cd) {
		if (appearsOnCDs == null)
			appearsOnCDs = new ArrayList<CD>();
		appearsOnCDs.add(cd);
	}
}
