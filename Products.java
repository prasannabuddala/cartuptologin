package servlets;

public class Products {
	private int pid;
	private String pname;
	private double pprice;
	private String pimag;
	private int pcatid;
	private int hsncode;

	public Products(int pid, String pname, double pprice, String pimag, int pcatid, int hsncode) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.pprice = pprice;
		this.pimag = pimag;
		this.pcatid = pcatid;
		this.hsncode = hsncode;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public double getPprice() {
		return pprice;
	}

	public void setPprice(double pprice) {
		this.pprice = pprice;
	}

	public String getPimag() {
		return pimag;
	}

	public void setPimag(String pimag) {
		this.pimag = pimag;
	}

	public int getPcatid() {
		return pcatid;
	}

	public void setPcatid(int pcatid) {
		this.pcatid = pcatid;
	}

	public int getHsncode() {
		return hsncode;
	}

	public void setHsncode(int hsncode) {
		this.hsncode = hsncode;
	}

}