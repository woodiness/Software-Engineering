package model;

public class CardReader {

	private String id;
	private String category;
	private String bankcard;
	private float bill;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getBankcard() {
		return bankcard;
	}

	public void setBankcard(String bankcard) {
		this.bankcard = bankcard;
	}

	public float getBill() {
		return bill;
	}

	public void setBill(float bill) {
		this.bill = bill;
	}

}
