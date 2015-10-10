package sale.actions;

/**
 * 封装采购表单的JavaBean
 */
public class PurchaseBean
{	
	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
	
	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	private String price = "";
	private String code = "";
}