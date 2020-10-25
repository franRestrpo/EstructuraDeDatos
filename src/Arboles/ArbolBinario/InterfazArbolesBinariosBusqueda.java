package Arboles.ArbolBinario;

public interface InterfazArbolesBinariosBusqueda <T extends Comparable> {

	void insertar(T empleado);
	boolean existe(int id);
	T obtener(int id);
	boolean esHoja();
	boolean esVacio();
	void preorden();
	void inorden();
	void postorden();
	void eliminar(int id);
	
}
