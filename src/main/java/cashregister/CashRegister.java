package cashregister;

public class CashRegister {
    public Price total(Price price, double quantity) {
        return price.multiplyBy(quantity);
    }
}