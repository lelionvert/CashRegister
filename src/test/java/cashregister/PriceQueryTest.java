package cashregister;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class PriceQueryTest {

    private PriceQuery priceQuery = new InmemoryCatalog(
            ItemReference.aReference().withItemCode("APPLE").withUnitPrice(1.20).build(),
            ItemReference.aReference().withItemCode("BANANA").withUnitPrice(1.90).build()
    );

    @ParameterizedTest
    @CsvSource({"APPLE, 1.20", "BANANA, 1.90"})
    void find_the_price_given_an_item_code(String itemCode, double unitPrice) {

        assertThat(priceQuery.findPrice(itemCode)).isEqualTo(Price.valueOf(unitPrice));
    }

    @Test
    void search_an_unknow_item() {
        assertThat(priceQuery.findPrice("PEACH")).isNull();
    }
}
