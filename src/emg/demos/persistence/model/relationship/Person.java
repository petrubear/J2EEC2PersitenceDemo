package emg.demos.persistence.model.relationship;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private String id;
	private String firstName;
	private String lastName;
	private Family family;
	@Transient
	private String nonsenseField = ""; // Transient indica que la columna no se
										// persiste!
	private List<Job> jobList = new ArrayList<Job>();

	public String getId() {
		return id;
	}

	public void setId(String Id) {
		this.id = Id;
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

	@ManyToOne
	public Family getFamily() {
		return family;
	}

	public void setFamily(Family family) {
		this.family = family;
	}

	public String getNonsenseField() {
		return nonsenseField;
	}

	public void setNonsenseField(String nonsenseField) {
		this.nonsenseField = nonsenseField;
	}

	@OneToMany
	public List<Job> getJobList() {
		return this.jobList;
	}

	public void setJobList(List<Job> nickName) {
		this.jobList = nickName;
	}
}
