package Euclides.animacion;

import Euclides.vistas.EuclidesRectangle;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.util.Duration;

public class RectangleAnimation {
	
	public static final double SCALE_5 = 6F;

	public static void start(EuclidesRectangle rect,double scale){

	    RotateTransition rt = new RotateTransition(Duration.millis(1000), rect);
	    rt.setByAngle(720);
	    rt.play();

	    ScaleTransition st = new ScaleTransition(Duration.millis(1000),rect);
	    st.setToX(scale);
	    st.setToY(scale);
	    st.play();
	}

}
