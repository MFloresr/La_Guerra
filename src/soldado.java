import java.awt.Image;
import acm.graphics.GRectangle;
import acm.graphics.GImage;


public class soldado {

	//VARIABLES
	private static final String IMAGEN_POR_DEFECTO = "soldado1.jpg";
	private static final int VELOCIDAD_MAXIMA = 10;
	private GImage imagen;
	private int destino_x;
	private int destino_y;
	private int direccion_x;
	private int direccion_y;
	private int mirando_a;

	//CONSTRUCTORES
	public soldado(){
		this(new GImage(IMAGEN_POR_DEFECTO).getImage());
	}

	public soldado(final Image img){
		imagen =(new GImage(img));
		destino_x = (int) imagen.getX();
		direccion_x = 1;
		mirando_a = 1;
	}

    public soldado(final Image imagen, final int x, final int y ) {
        this(imagen);
        posiciona(x,y);
    }

    //FUNCIONES
    public final GImage get_imagen(){
    	return imagen;
    }

    public final void set_imagen(final GImage ima){
    	this.imagen = ima;
    }
    public final GRectangle get_posicion(){
    	return imagen.getBounds();
    }

    private int get_Posicion_x_int(){
    	return (int) imagen.getX();
    }

    private int get_Posicion_y_int(){
    	return (int) imagen.getY();
    }

    private int calcular_direccion_x(){
    	int x = get_Posicion_x_int();

    	if ((destino_x -x)== 0){
    		return 0;
    	}if (Math.abs(destino_x -x)<= VELOCIDAD_MAXIMA){
    		imagen.setLocation(destino_x, imagen.getY());
    		return 0;
    	}
    	return Math.abs(destino_x - x)/(destino_x - x);
    }

    private int calcular_direccion_y(){
    	int y = get_Posicion_y_int();

    	if ((destino_y -y)== 0){
    		return 0;
    	}if (Math.abs(destino_y -y)<= VELOCIDAD_MAXIMA){
    		imagen.setLocation(imagen.getX(), destino_y);
    		return 0;
    	}
    	return Math.abs(destino_y - y)/(destino_y - y);
    }

    public final void posiciona(int x,int y ){
    	imagen.setLocation(x, y);
    	direccion_x = calcular_direccion_x();
    	direccion_y = 0;
    	destino_y = 1;
    }

    public final int mover(){
    	imagen.move(direccion_x * Aleatorio.obtener(VELOCIDAD_MAXIMA), direccion_y * Aleatorio.obtener(VELOCIDAD_MAXIMA));
    	direccion_x = calcular_direccion_x();
    	direccion_y = calcular_direccion_y();
    	if (direccion_x + direccion_y == 0){
    		return 0;
    	}
    	return 1;
    }
    private final void flip_horizontal(){
        int[][] array = imagen.getPixelArray();
        int height = array.length;
        int width = array[0].length;

        for (int i = 0; i < height; i++) {
            for (int e = 0; e < width / 2; e++) {
                int a = width - e - 1;
                int temp = array[i][e];
                array[i][e] = array[i][a];
                array[i][a] = temp;
            }
        }
        imagen.setImage(new GImage(array).getImage());
    }

    public final void definir_destino(final int posicion_final){
    	destino_x = posicion_final - (int) imagen.getWidth()/2;
    	direccion_x = calcular_direccion_x();
    	if (direccion_x != mirando_a){
    		mirando_a *= -1;
    		flip_horizontal();
    	}
    }

    public final void definir_destino(final int posicionx, final int posiciony){
    	definir_destino(posicionx);
        destino_y = posiciony;
        direccion_y = calcular_direccion_y();
    }

    public final String toString(){
    	return imagen.getX() + " " + imagen.getY() + " -> "
                + destino_x + "," + destino_y + " ("
                + direccion_x + "," + direccion_y + ")";
    }
}

