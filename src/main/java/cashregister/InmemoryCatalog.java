package cashregister;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class InmemoryCatalog implements PriceQuery {

    private final Map<String, Price> unitPriceByItemCode;

    public InmemoryCatalog(ItemReference... itemReferences) {
        unitPriceByItemCode = Stream.of(itemReferences).collect(Collectors.toMap(ItemReference::getItemCode, ItemReference::buildPrice));
    }

    public Result findPrice(String itemCode) {

        Price price = unitPriceByItemCode.get(itemCode);
        if (price != null)
            return Result.found(price);
        return Result.notFound(itemCode);

    }

}
