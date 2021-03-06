package cashregister;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CashRegisterTest {

    @Test
    void calculate_total() {
        CashRegister cashRegister = new CashRegister();
        Price price = Price.valueOf(1.20);
        Quantity quantity = Quantity.valueOf(1);

        Price total = cashRegister.total(price, quantity);

        assertThat(total).isEqualTo(Price.valueOf(1.2));
    }

    @Test
    void calculate_total_when_quantity_different_of_one() {
        CashRegister cashRegister = new CashRegister();
        Price price = Price.valueOf(1.2);
        Quantity quantity = Quantity.valueOf(2);

        Price total = cashRegister.total(price, quantity);

        assertThat(total).isEqualTo(Price.valueOf(2.4));
    }
}
