package cashregister;

public final class InmemoryCatalog implements PriceQuery {

    private final ItemReference[] itemReferences;

    public InmemoryCatalog(ItemReference... itemReferences) {
        this.itemReferences = itemReferences;
    }

    public Result findPrice(String itemCode) {
        for (ItemReference itemReference : itemReferences) {
            if (itemReference.isCodeEqualTo(itemCode)) {
                return Result.found(itemReference.buildPrice());
            }
        }
        return Result.notFound(itemCode);
    }
}
