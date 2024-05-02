package servlets;

public class CartItem {
	private int pid;
	private int quantity;

	public CartItem(int prodId, int quantity) {
		// super();
		this.pid = prodId;
		this.quantity = quantity;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int prodId) {
		this.pid = prodId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
