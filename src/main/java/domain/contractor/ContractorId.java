package domain.contractor;

import java.util.Objects;

public final class ContractorId {

    private final String id;

    public ContractorId(String id) {
        this.id = id;
    }

    public static ContractorId of(String id){
        return new ContractorId(id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContractorId that = (ContractorId) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
