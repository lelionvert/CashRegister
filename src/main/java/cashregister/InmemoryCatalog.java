package cashregister;

import java.util.function.BiFunction;

public final class InmemoryCatalog implements PriceQuery {

    private final ItemReference[] itemReferences;

    public InmemoryCatalog(ItemReference... itemReferences) {
        this.itemReferences = itemReferences;
    }

    public Result findPrice(String itemCode) {

        return reduce(Result.notFound(itemCode),(result, itemReference) -> {
            if (itemReference.isCodeEqualTo(itemCode)) {
                return Result.found(itemReference.buildPrice());
            }else{
                return result;
            }
        }, itemReferences);

    }

    private Result reduce(Result identity, BiFunction<Result, ItemReference, Result> reducer, ItemReference[] itemReferences){
        Result r = identity;
        for (ItemReference itemReference: itemReferences) {
            r = reducer.apply(r, itemReference);
        }
        return r;
    }
}
