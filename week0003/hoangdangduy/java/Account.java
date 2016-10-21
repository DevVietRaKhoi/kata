public class Account {
	private String name;
	private Double money;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

	public Account(String name, Double money) {
		super();
		this.name = name;
		this.money = money;
	}

	public Account() {
		super();
	}
}
