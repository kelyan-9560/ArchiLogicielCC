package domain.exception;

public final class TradesManException extends RuntimeException {

    public TradesManException(int errorCode, TradesManExceptions tradesManExceptions, String detail) {
    }

    public static TradesManException withFirstname(String firstname){
        return new TradesManException(1, TradesManExceptions.BAD_FIRSTNAME, "firstname is bad");
    }

    public static TradesManException withLastname(String lastname){
        return new TradesManException(2, TradesManExceptions.BAD_LASTNAME, "lastname is bad");
    }

    public static TradesManException withEmail(String email){
        return new TradesManException(3, TradesManExceptions.BAD_EMAIL, email + " is a bad");
    }

    public static TradesManException withJob(String job){
        return new TradesManException(4, TradesManExceptions.BAD_JOB, "Job is bad");
    }

    public static TradesManException withSkill(String skill){
        return new TradesManException(5, TradesManExceptions.BAD_SKILL, "Skill is bad");
    }

    public static TradesManException withDailyTax(Double dailyTax){
        return new TradesManException(6, TradesManExceptions.BAD_DAILY_TAX, "dailyTax is bad");
    }

    public static TradesManException withDiplomas(String diplomas){
        return new TradesManException(7, TradesManExceptions.BAD_DIPLOMA,"diplomas is bad");
    }

    public static TradesManException tradesManNotFound(){
        return new TradesManException(8, TradesManExceptions.NOT_FOUND, "Trades Man not found");
    }

    public static TradesManException failedInsertion(){
        return new TradesManException(8, TradesManExceptions.FAILED_INSERTION, "Error in inserting trades man");
    }

    public static TradesManException noTradesMan(){
        return new TradesManException(8, TradesManExceptions.NO_TRADES_MAN, "There is no trades man");
    }
}
