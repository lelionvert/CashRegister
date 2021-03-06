package cashregister;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;

public abstract class Result {
    public static Result found(Price price) {
        return new Found(price);
    }

    public static Result notFound(String invalidItemCode) {
        return new NotFound(invalidItemCode);
    }

    private Result() {}

    public abstract Result map(Function<Price, Price> f);

    public abstract void ifFound(Consumer<Price> consumer);

    public abstract void ifNotFound(Consumer<String> consumer);

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

        @Override
        public Result map(Function<Price, Price> f) {
            return Result.found(f.apply(price));
        }

        @Override
        public void ifFound(Consumer<Price> consumer) {
            consumer.accept(price);
        }

        @Override
        public void ifNotFound(Consumer<String> consumer) {
        }
    }

    private static class NotFound extends Result {
        private final String invalidItemCode;

        private NotFound(String invalidItemCode) {
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

        @Override
        public Result map(Function<Price, Price> f) {
            return this;
        }

        @Override
        public void ifFound(Consumer<Price> consumer) {
        }

        @Override
        public void ifNotFound(Consumer<String> consumer) {
            consumer.accept(invalidItemCode);
        }
    }
}
