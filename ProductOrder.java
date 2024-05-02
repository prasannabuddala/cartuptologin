package servlets;

public class ProductOrder {
	private int oid;
	private int pid;
	private int quanity;
	private double price;

	public ProductOrder(int oid, int pid, int quanity, double price) {
		super();
		this.oid = oid;
		this.pid = pid;
		this.quanity = quanity;
		this.price = price;
	}

	public int getOid() {
		return oid;
	}

	public void setOid(int oid) {
		this.oid = oid;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public int getQuanity() {
		return quanity;
	}

	public void setQuanity(int quanity) {
		this.quanity = quanity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}
