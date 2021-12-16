package domain.exception;

public final class TradesManException extends RuntimeException {

    private final int errorCode;
    private final String libelle;

    public TradesManException(int errorCode, String libelle) {
        this.errorCode = errorCode;
        this.libelle = libelle;
    }

    //TODO: faire un enum avec les codes erreurs et leurs libelle

    public static TradesManException withFirstname(String firstname){
        return new TradesManException(1, "firstname is bad");
    }

    public static TradesManException withLastname(String lastname){
        return new TradesManException(2, "lastname is bad");
    }

    public static TradesManException withEmail(String email){
        return new TradesManException(3, email + " is a bad");
    }

    public static TradesManException withJob(String job){
        return new TradesManException(4, "job is bad");
    }

    public static TradesManException withSkill(String skill){
        return new TradesManException(5, "skill is bad");
    }
    public static TradesManException withDailyTax(Double dailyTax){
        return new TradesManException(6, "dailyTax is bad");
    }

    public static TradesManException withDiplomas(String diplomas){
        return new TradesManException(7, "diplomas is bad");
    }
}
