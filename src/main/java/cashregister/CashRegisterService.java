package cashregister;

public class CashRegisterService {
    private CashRegister cashRegister;
    private PriceQuery priceQuery;

    public CashRegisterService(CashRegister cashRegister, PriceQuery priceQuery) {

        this.cashRegister = cashRegister;
        this.priceQuery = priceQuery;
    }

    public Result total(String itemCode, Quantity quantity) {
        Result result = priceQuery.findPrice(itemCode);
        return result.map(price -> cashRegister.total(price, quantity));
    }
}
