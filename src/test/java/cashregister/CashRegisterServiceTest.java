package cashregister;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CashRegisterServiceTest {

    private CashRegisterService cashRegisterService;

    @BeforeEach
    void setUp() {
        cashRegisterService = new CashRegisterService(
                new CashRegister(),
                new InmemoryCatalog(
                        ItemReference.aReference().withItemCode("APPLE").withUnitPrice(1.20).build()
                ));
    }

    @ParameterizedTest
    @CsvSource({"APPLE, 1, 1.20"})
    void total_is_product_of_quantity_by_item_price_corresponding_to_existing_item_code(
            String itemCode, double quantity, double unitPrice) {

        Result total = cashRegisterService.total(itemCode, Quantity.valueOf(quantity));

        assertThat(total).isEqualTo(Result.found(Price.valueOf(quantity * unitPrice)));

        total.ifFound(System.out::println);
    }

    @Test
    void unknown_item_code() {
        Result total = cashRegisterService.total("PEACH", Quantity.valueOf(1));

        assertThat(total).isEqualTo(Result.notFound("PEACH"));

        total.ifNotFound(System.out::println);
    }
}
