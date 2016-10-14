package geostudents.utils;

public class GeoUtils {
    private static final Double EARTH_EQUATORIAL_CIRCUMFERENCE = 40075017.0;
    private static final Double EARTH_MERIDIONAL_CIRCUMFERENCE = 40007860.0;

    public static Double getMercatorProjectionX(Double longitude) {
        return (longitude + 180)*(EARTH_EQUATORIAL_CIRCUMFERENCE/360.0);
    }
    
    public static Double getMercatorProjectionY(Double latitude) {
        Double result;
        Double latitudeInRad = latitude * Math.PI/180;
        Double mercN = Math.log(Math.tan((Math.PI/4) + (latitudeInRad/2)));
        result = (EARTH_MERIDIONAL_CIRCUMFERENCE/2) - (EARTH_EQUATORIAL_CIRCUMFERENCE*mercN/(2*Math.PI));
        return result;
    }
}
