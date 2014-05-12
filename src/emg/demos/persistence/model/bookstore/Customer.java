package emg.demos.persistence.model.bookstore;

import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "T_CUSTOMER")
@Access(AccessType.FIELD)
public class Customer {
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	@Temporal(TemporalType.DATE)
	private Date dateOfBirth;
	@Transient
	// no se persiste a la base
	private Integer age;
	@Temporal(TemporalType.TIMESTAMP)
	private Date creationDate;
	@Embedded
	private Address address;

	public Customer() {
	}

	public Customer(String firstName, String lastName, String email,
			String phoneNumber, Date dateOfBirth, Date creationDate) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.dateOfBirth = dateOfBirth;
		this.creationDate = creationDate;
	}

	public Long getId() {
		return id;
	}

	@Column(name = "FIRST_NAME", nullable = false, length = 50)
	// las anotaciones se pueden utilizar en el atributo
	// o en el getter del atributo
	@Access(AccessType.PROPERTY)
	// permite leer anotaciones de los getters
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "LAST_NAME", nullable = false, length = 50)
	// las anotaciones se pueden utilizar en el atributo
	// o en el getter del atributo
	@Access(AccessType.PROPERTY)
	// permite leer anotaciones de los getters
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "PHONE_NUMBER", length = 15)
	// las anotaciones se pueden utilizar en el atributo
	// o en el getter del atributo
	@Access(AccessType.PROPERTY)
	// permite leer anotaciones de los getters
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
}
