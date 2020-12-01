package fpHEAP;

public class Item {
	//key refer to priority
	public int key;
	public Object value;
	
	public int getKey() {
		return key;
	}
	public void setKey(int key) {
		this.key = key;
	}
	public Object getValue() {
		return value;
	}
	public void setValue(Object value) {
		this.value = value;
	}
	
	public Item() {
		// TODO Auto-generated constructor stub
	}
	public Item(int key, Object value) {
		super();
		this.key = key;
		this.value = value;
	}
	
	
	
	

}
