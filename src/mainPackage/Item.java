package mainPackage;
import java.math.BigDecimal;

public class Item {
	private String name;
	private BigDecimal price;
	private int count;
	
	Item(String name, BigDecimal price, int count){
		this.name = name;
		this.price = price;
		this.count = count;
		
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	
}
