package cashregister;

public final class InmemoryCatalog implements PriceQuery {

    private final ItemReference[] itemReferences;

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
