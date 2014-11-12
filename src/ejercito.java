import java.util.ArrayList;
import java.util.List;


public class ejercito {

	//VARIABLES PUBLICAS
	public static String NOMBRE_EJERCITO = "Ejercito";
	public static int ALTURA_FILA = 50 ;
	public static int AMPLADA_FILA = 78;

	//VARIABLES PRIVADAS
	private int filas_ejercito;
	private String nombre;
	private List<soldado> soldados;
	private int dimensiones_campo_batalla;
    private int posicion_principal;
    private int posicion_final;
    private boolean formando;

	//FUNCIONES
    public ejercito(final String identificador) {

        if (identificador != null) {
            nombre = identificador;
        } else {
            nombre = NOMBRE_EJERCITO;
        }
        soldados = new ArrayList<soldado>();
        filas_ejercito = 1;
    }

    public ejercito(final String identificador, final int tamano_campo) {
        this(identificador);
        dimensiones_campo_batalla = tamano_campo;
    }

}
