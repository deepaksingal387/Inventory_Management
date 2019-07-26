import java.io.Serializable;
public class Item implements Serializable {

	private String ItemName;
	private int ItemId;
	private String ItemCategory;
	private float ItemSellingCost;
	private String ItemExpiry;
	private float ItemStockWorth;
	private String Wholesaler;
	private String DateOfPurchase;
	private int Stock;
	private float PurchasingCost;
	
	
	
	
	//Constructor
	
	public int getItemId() {
		return ItemId;
	}


	public Item(String itemName, int itemId, String itemCategory, float itemSellingCost, String itemExpiry,
			 String wholesaler, String dateOfPurchase, int stock, float purchasingCost) {
		super();
		ItemName = itemName;
		ItemId = itemId;
		ItemCategory = itemCategory;
		ItemSellingCost = itemSellingCost;
		ItemExpiry = itemExpiry;
		Wholesaler = wholesaler;
		DateOfPurchase = dateOfPurchase;
		Stock = stock;
		PurchasingCost = purchasingCost;
		ItemStockWorth = purchasingCost*stock;
	}


	//toString
	@Override
	public String toString() {
		return " \n ItemName=" + ItemName + "\n ItemId=" + ItemId + "\n ItemCategory=" + ItemCategory
				+ "\n Wholesaler=" + Wholesaler + "\n DateOfPurchase=" + DateOfPurchase + "\n Stock="
				+ Stock  + "\n ItemExpiry=" + ItemExpiry + "\n PurchasingCost=" + PurchasingCost + "\n ItemSellingCost=" + ItemSellingCost + "\n ItemStockWorth="
						+ ItemStockWorth ;
	}
	
	
	
	
	
	
	
	
}
