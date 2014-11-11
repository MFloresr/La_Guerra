import acm.graphics.GImage;


public class soldado {
	//VARIABLES
	private int x;
	private int y;
	private GImage imagen;

	//CONSTRUCTORES
	public soldado(){
        this.x = 0;
        this.y = 0;
	}

    public soldado(final int x, final int y, final GImage imagen) {
        this.x = x;
        this.y = y;
        this.imagen = imagen;
    }

}
