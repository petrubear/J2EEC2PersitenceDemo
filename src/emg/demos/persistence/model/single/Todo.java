package emg.demos.persistence.model.single;

import javax.persistence.*;

@Entity
@NamedQuery (name = "findAllTodos", query = "SELECT t from Todo t")
public class Todo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String summary;
	@Column(length = 2000)
	private String description;

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Todo [summary=" + summary + ", description=" + description
				+ "]";
	}
}
