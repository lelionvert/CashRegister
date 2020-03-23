package cashregister;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CashRegisterTest {

    @Test
    void calculate_total() {
        CashRegister cashRegister = new CashRegister();
        double price = 1.20;
        double quantity = 1;

        double total = cashRegister.total(price, quantity);

        assertThat(total).isEqualTo(1.20);
    }

    @Test
    void calculate_total_when_quantity_different_of_one(){
        CashRegister cashRegister = new CashRegister();
        double price = 1.2;
        double quantity = 2;

        double total = cashRegister.total(price,quantity);

        assertThat(total).isEqualTo(2.40);
    }
}
