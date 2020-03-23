package cashregister;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class PriceQueryTest {

    private PriceQuery priceQuery = new InmemoryCatalog(
            new ItemReference("APPLE", 1.20),
            new ItemReference("BANANA", 1.90)
    );

    @ParameterizedTest
    @CsvSource({"APPLE, 1.20", "BANANA, 1.90"})
    void find_the_price_given_an_item_code(String itemCode, double unitPrice) {

        assertThat(priceQuery.findPrice(itemCode)).isEqualTo(Price.valueOf(unitPrice));
    }

}
