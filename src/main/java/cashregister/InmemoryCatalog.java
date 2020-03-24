package cashregister;

import java.util.Optional;
import java.util.function.BiFunction;
import java.util.stream.Stream;

public final class InmemoryCatalog implements PriceQuery {

    private final ItemReference[] itemReferences;

    public InmemoryCatalog(ItemReference... itemReferences) {
        this.itemReferences = itemReferences;
    }

    public Result findPrice(String itemCode) {

        return Stream.of(itemReferences)
                .filter(itemReference -> itemReference.isCodeEqualTo(itemCode))
                .map(ItemReference::buildPrice)
                .map(Result::found)
                .findFirst().orElseGet(() -> Result.notFound(itemCode));

    }

    private Result reduce(Result identity, BiFunction<Result, ItemReference, Result> reducer, ItemReference[] itemReferences){
        Result r = identity;
        for (ItemReference itemReference: itemReferences) {
            r = reducer.apply(r, itemReference);
        }
        return r;
    }
}
