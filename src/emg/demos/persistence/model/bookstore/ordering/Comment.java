package emg.demos.persistence.model.bookstore.ordering;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table (name = "TO_COMMENT")
public class Comment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nickname;
	private String content;
	private Integer note;
	@Column(name = "POSTED_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date postedDate;

	public Comment() {
	}

	public Comment(String nickname, String content, Integer note,
			String postedDate) {
		this.nickname = nickname;
		this.content = content;
		this.note = note;

		try {
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			this.postedDate = df.parse(postedDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	public Long getId() {
		return id;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getNote() {
		return note;
	}

	public void setNote(Integer note) {
		this.note = note;
	}
}
