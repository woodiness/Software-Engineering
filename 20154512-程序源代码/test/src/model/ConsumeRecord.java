package model;

public class ConsumeRecord {

	private String id; // Student's id
	private String time;
	private String cardreader_Id;
	private float money;

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCardreader_Id() {
		return cardreader_Id;
	}

	public void setCardreader_Id(String cardreader_Id) {
		this.cardreader_Id = cardreader_Id;
	}

	public float getMoney() {
		return money;
	}

	public void setMoney(float money) {
		this.money = money;
	}

}
