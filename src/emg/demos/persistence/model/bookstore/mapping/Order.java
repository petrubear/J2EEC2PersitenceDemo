package emg.demos.persistence.model.bookstore.mapping;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "T_ORDER")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Temporal(TemporalType.TIMESTAMP)
	private Date creationDate;

	/*Default Fetching Strategy
	@OneToOne	EAGER
	@ManyToOne	EAGER
	@OneToMany	LAZY
	@ManyToMany	LAZY*/
	
	// sin anotaciones por defecto crea una relacion OneToMany

	// anot1 crea tabla intermedia con el nombre indicado
	// @OneToMany
	// @JoinTable(name = "jnd_ord_line",
	// joinColumns = @JoinColumn(name = "order_fk"), inverseJoinColumns =
	// @JoinColumn(name = "order_line_fk") )

	// anot2 no crea tabla intermedia
	@OneToMany(fetch = FetchType.EAGER) //cambia el fetch por default 
	@JoinColumn(name = "ORDER_FK")
	private List<OrderLine> orderLines;

	public Order() {
		this.creationDate = new Date();
	}

	public Long getId() {
		return id;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public List<OrderLine> getOrderLines() {
		return orderLines;
	}

	public void setOrderLines(List<OrderLine> orderLines) {
		this.orderLines = orderLines;
	}
}
