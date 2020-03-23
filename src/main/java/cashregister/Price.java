package cashregister;

import java.util.Objects;

public class Price {
    private final double price;

    private Price(double price) {
        this.price = price;
    }

    public static Price valueOf(double price) {
        return new Price(price);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Price price1 = (Price) o;
        return Double.compare(price1.price, price) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(price);
    }

    @Override
    public String toString() {
        return "Price{" +
                "price=" + price +
                '}';
    }

    public Price multiplyBy(double quantity) {
        return valueOf(price * quantity);
    }
}
