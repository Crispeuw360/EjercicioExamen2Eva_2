package excepcion;

public class DeporteNoValidoException extends Exception{
	public DeporteNoValidoException(String mensaje) {
        super(mensaje);
    }
}
