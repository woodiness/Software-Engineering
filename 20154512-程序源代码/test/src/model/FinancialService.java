package model;

public class FinancialService {

	private String id; // Student's id
	private String card_Id;
	private float rest;// 餘額
	private String bankcard;
	private boolean condition;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCard_Id() {
		return card_Id;
	}

	public void setCard_Id(String card_Id) {
		this.card_Id = card_Id;
	}

	public float getRest() {
		return rest;
	}

	public void setRest(float rest) {
		this.rest = rest;
	}

	public String getBankcard() {
		return bankcard;
	}

	public void setBankcard(String bankcard) {
		this.bankcard = bankcard;
	}

	public boolean isCondition() {
		return condition;
	}

	public void setCondition(boolean condition) {
		this.condition = condition;
	}

}
