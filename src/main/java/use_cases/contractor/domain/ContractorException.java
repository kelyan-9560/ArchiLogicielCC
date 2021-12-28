package use_cases.contractor.domain;

public final class ContractorException extends RuntimeException {


    public ContractorException(int errorCode, ContractorExceptionTags contractorExceptionTags, String detail) {
    }
    
    public static ContractorException withFirstname(String firstname){
        return new ContractorException(1, ContractorExceptionTags.BAD_FIRSTNAME, "Firstname is bad");
    }

    public static ContractorException withLastname(String lastname){
        return new ContractorException(2, ContractorExceptionTags.BAD_LASTNAME, "Lastname is bad");
    }
}
