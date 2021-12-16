package domain.exception;

public final class LocationException extends RuntimeException {

    private final int errorCode;
    private final String libelle;

    public LocationException(int errorCode, String libelle) {
        this.errorCode = errorCode;
        this.libelle = libelle;
    }


    public static LocationException withRegion(String region){
        return new LocationException(1, "");
    }

    public static LocationException withCity(String region){
        return new LocationException(1, "");
    }
}
