package Euclides.animacion;

import java.util.Timer;
import java.util.TimerTask;

import javafx.stage.Stage;

public class ResizeAnimation extends Timer{
	
	public ResizeAnimation(){}

	public void start(final Stage obj,final int width,final int height,final long delay,final long period){

		this.scheduleAtFixedRate(
			new TimerTask() {

		        int i=0;
		        @Override
		        public void run() {
		            if (i<width){
			            obj.setWidth(obj.getWidth()+1);
		            }

		            if (i<height){
		            	obj.setWidth(obj.getHeight()+1);
		            }

		            if(i >= width  &&  i >= height){
		                this.cancel();
		            }

		            i++;
		        }
		    }
		,delay, period);

	}

}
