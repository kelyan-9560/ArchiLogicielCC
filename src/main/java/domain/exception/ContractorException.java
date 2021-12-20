package domain.exception;

public final class ContractorException extends RuntimeException {

    private final int errorCode;
    private final String libelle;

    public ContractorException(int errorCode, String libelle) {
        this.errorCode = errorCode;
        this.libelle = libelle;
    }
    
    public static ContractorException withFirstname(String firstname){
        return new ContractorException(1, "firstname is bad");
    }

    public static ContractorException withLastname(String lastname){
        return new ContractorException(2, "lastname is bad");
    }
}
