package emg.demos.persistence.model.bookstore.ordering;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

@Entity
@Table(name = "TO_NEWS")
public class OrderingNews {

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Long id;
	@Column(nullable = false)
	private String content;
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	@OrderBy("postedDate DESC") //ASC
	private List<Comment> comments;

	public OrderingNews() {
	}

	public OrderingNews(String content) {
		this.content = content;
	}

	public Long getId() {
		return id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void addComment(Comment comment) {
		if (comments == null)
			comments = new ArrayList<Comment>();
		comments.add(comment);
	}

	public List<Comment> getComments() {
		return comments;
	}
}
