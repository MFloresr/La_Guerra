import java.util.ArrayList;

import acm.graphics.GImage;
import acm.program.GraphicsProgram;


public class guerra extends GraphicsProgram {

	public void run(){

		ArrayList<soldado> soldados = new ArrayList<soldado>();
		for(int i = 0 ;i<20;i++){
			GImage imagen = new GImage("1.jpg",0 ,10);
			imagen.setSize(100,110);
			this.setSize(1200,600);
			soldados.add(imagen);
		}
		GImage imagen = new GImage("1.jpg",0 ,10);
		imagen.setSize(100,110);
		this.setSize(1200,600);
		add(imagen);

		GImage imagen2 = new GImage("1.jpg",0 ,120);
		imagen2.setSize(100,110);
		add(imagen2);
		for (int i = 0;i <1200;i++){
			int x =+ 4;
			imagen2.move(x, 0);
			imagen2.pause(100);

		}
		imagen2.move(10, 120);

	}
}
