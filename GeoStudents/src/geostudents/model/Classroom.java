/**
 * Author Saulo Lopez
 * */
package geostudents.model;

import geostudents.utils.GeoUtils;
import java.awt.geom.Point2D;

public class Classroom {
    private Point2D.Double topLeft;
    private Point2D.Double bottomRight;
    private String name;
    private Double roomSize = 20.0;
    
    public Classroom(String name, Double latitude, Double longitude) {
        this.name = name;
        Double x = GeoUtils.getMercatorProjectionX(longitude);
        Double y = GeoUtils.getMercatorProjectionY(latitude);
        
        this.topLeft = new Point2D.Double(x - roomSize/2.0, y - roomSize/2.0);
        this.bottomRight = new Point2D.Double(x + roomSize/2.0, y + roomSize/2.0);
    }

    public Point2D.Double getTopLeft() {
        return topLeft;
    }

    public Point2D.Double getBottomRight() {
        return bottomRight;
    }
}
