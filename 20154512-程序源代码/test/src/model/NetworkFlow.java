package model;

public class NetworkFlow {

	private String id; // Student's id
	private float restMoney;
	private int monthlyRent;
	private float currentFlow;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public float getRestMoney() {
		return restMoney;
	}

	public void setRestMoney(float restMoney) {
		this.restMoney = restMoney;
	}

	public int getMonthlyRent() {
		return monthlyRent;
	}

	public void setMonthlyRent(int monthlyRent) {
		this.monthlyRent = monthlyRent;
	}

	public float getCurrentFlow() {
		return currentFlow;
	}

	public void setCurrentFlow(float currentFlow) {
		this.currentFlow = currentFlow;
	}

}
