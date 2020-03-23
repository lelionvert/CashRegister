package cashregister;

import java.util.Objects;

public abstract class Result {
    public static Result found(Price price) {
        return new Found(price);
    }

    public static Result notFound(String invalidItemCode) {
        return new NotFound(invalidItemCode);
    }

    private static class Found extends Result {
        private final Price price;

        private Found(Price price) {
            this.price = price;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Found found = (Found) o;
            return Objects.equals(price, found.price);
        }

        @Override
        public int hashCode() {
            return Objects.hash(price);
        }

        @Override
        public String toString() {
            return "Found{" +
                    "price=" + price +
                    '}';
        }
    }

    public static class NotFound extends Result {
        private final String invalidItemCode;

        public NotFound(String invalidItemCode) {
            this.invalidItemCode = invalidItemCode;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            NotFound notFound = (NotFound) o;
            return Objects.equals(invalidItemCode, notFound.invalidItemCode);
        }

        @Override
        public int hashCode() {
            return Objects.hash(invalidItemCode);
        }

        @Override
        public String toString() {
            return "NotFound{" +
                    "invalidItemCode='" + invalidItemCode + '\'' +
                    '}';
        }
    }
}
