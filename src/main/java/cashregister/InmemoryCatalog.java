package cashregister;

public class InmemoryCatalog implements PriceQuery {

    private ItemReference[] itemReferences;

    public InmemoryCatalog(ItemReference...itemReferences) {
        this.itemReferences = itemReferences;
    }

    public Price findPrice(String itemCode) {
        for (ItemReference itemReference: itemReferences) {
            if(itemReference.isCodeEqualTo(itemCode)){
                return itemReference.buildPrice();
            }
        }
        return null;
    }
}
