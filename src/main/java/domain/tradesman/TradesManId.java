package domain.tradesman;

import java.util.Objects;

public final class TradesManId {

    private final String id;

    private TradesManId(String id) {
        this.id = id;
    }

    public static TradesManId of(String id) {
        return new TradesManId(id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TradesManId that = (TradesManId) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
