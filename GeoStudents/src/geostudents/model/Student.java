/**
 * Author Saulo Lopez
 * */
package geostudents.model;

import geostudents.utils.GeoUtils;
import java.awt.geom.Point2D;

public class Student {
    private String name;
    private Point2D.Double position;

    public Student(String name, Double latitude, Double longitude) {
        this.name = name;
        Double x = GeoUtils.getMercatorProjectionX(longitude);
        Double y = GeoUtils.getMercatorProjectionY(latitude);
        position = new Point2D.Double(x, y);
    }
    
    public Point2D.Double getPosition() {
        return position;
    }
    
    @Override
    public String toString() {
        return "Name = " + name + ", position = " + position.toString();
    }
}
