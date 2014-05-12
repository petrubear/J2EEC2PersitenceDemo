package emg.demos.persistence.model.bookstore.inheritance;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "TI_CD")
@DiscriminatorValue("C")
public class ItemCD extends Item {

	private String musicCompany;
	private Integer numberOfCDs;
	private Float totalDuration;
	private String gender;

	public ItemCD() {
	}

	public ItemCD(String title, Float price, String description,
			String musicCompany, Integer numberOfCDs, Float totalDuration,
			String gender) {
		super(title, price, description);
		this.musicCompany = musicCompany;
		this.numberOfCDs = numberOfCDs;
		this.totalDuration = totalDuration;
		this.gender = gender;
	}

	public String getMusicCompany() {
		return musicCompany;
	}

	public void setMusicCompany(String musicCompany) {
		this.musicCompany = musicCompany;
	}

	public Integer getNumberOfCDs() {
		return numberOfCDs;
	}

	public void setNumberOfCDs(Integer numberOfCDs) {
		this.numberOfCDs = numberOfCDs;
	}

	public Float getTotalDuration() {
		return totalDuration;
	}

	public void setTotalDuration(Float totalDuration) {
		this.totalDuration = totalDuration;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
}
