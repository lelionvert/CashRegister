package cashregister;

import java.util.Objects;

public class Quantity {

    private final double quantity;

    private Quantity(double quantity) {
        this.quantity = quantity;
    }

    public static Quantity valueOf(double quantity) {
        return new Quantity(quantity);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Quantity quantity1 = (Quantity) o;
        return Double.compare(quantity1.quantity, quantity) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(quantity);
    }

    @Override
    public String toString() {
        return "Quantity{" +
                "quantity=" + quantity +
                '}';
    }

    public double multiplyBy(double price) {
        return quantity * price;
    }
}
