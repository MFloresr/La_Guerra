import java.util.Random;

public final class Aleatorio {

	private static Random r = new Random();
	private Aleatorio(){

	}

	public final static int obtener(final int max){
		return r.nextInt(max);
	}
}
