package domain.exception;

public final class ContractorException extends RuntimeException {

    private final int errorCode;
    private final String libelle;

    public ContractorException(int errorCode, String libelle) {
        this.errorCode = errorCode;
        this.libelle = libelle;
    }
    
    public static TradesManException withFirstname(String firstname){
        return new TradesManException(1, "firstname is bad");
    }

    public static TradesManException withLastname(String lastname){
        return new TradesManException(2, "lastname is bad");
    }
}
