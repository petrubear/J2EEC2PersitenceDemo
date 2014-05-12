package emg.demos.persistence.model.bookstore.enumerated;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "T_CREDIT_CARD")
public class CreditCard {
	@Id
	private String number;
	private String expiryDate;
	private Integer controlNumber;
	@Enumerated(EnumType.STRING)
	// guara el nombre de la enumeracion en lugar del indice
	private CreditCardType creditCardType;

	public CreditCard() {
	}

	public CreditCard(String number, String expiryDate, Integer controlNumber,
			CreditCardType creditCardType) {
		this.number = number;
		this.expiryDate = expiryDate;
		this.controlNumber = controlNumber;
		this.creditCardType = creditCardType;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}

	public Integer getControlNumber() {
		return controlNumber;
	}

	public void setControlNumber(Integer controlNumber) {
		this.controlNumber = controlNumber;
	}

	public CreditCardType getType() {
		return creditCardType;
	}

	public void setType(CreditCardType creditCardType) {
		this.creditCardType = creditCardType;
	}
}
