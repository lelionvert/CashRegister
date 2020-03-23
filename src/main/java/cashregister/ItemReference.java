package cashregister;

public final class ItemReference {
    private final double unitPrice;
    private final String itemCode;

    private ItemReference(String itemCode, double unitPrice) {
        this.itemCode = itemCode;
        this.unitPrice = unitPrice;
    }

    public static Builder aReference() {
        return new Builder();
    }

    public static class Builder {
        private double unitPrice;
        private String itemCode;
        
        private Builder() {
        }

        public Builder withItemCode(String itemCode) {
            this.itemCode = itemCode;
            return this;
        }

        public Builder withUnitPrice(double unitPrice) {
            this.unitPrice = unitPrice;
            return this;
        }

        public ItemReference build() {
            return new ItemReference(itemCode,unitPrice);
        }

    }

    public boolean isCodeEqualTo(String itemCode) {
        return this.itemCode.equals(itemCode);
    }

    public Price buildPrice() {
        return Price.valueOf(unitPrice);
    }
}
