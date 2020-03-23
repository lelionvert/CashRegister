package cashregister;

public class ItemReference {
    private double unitPrice;
    private String itemCode;

    public ItemReference(String itemCode, double unitPrice ) {
        this.itemCode = itemCode;
        this.unitPrice = unitPrice;
    }

    public boolean isCodeEqualTo(String itemCode) {
        return this.itemCode.equals(itemCode);
    }

    public Price buildPrice() {
        return Price.valueOf(unitPrice);
    }
}
