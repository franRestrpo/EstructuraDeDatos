package Arboles.ArbolBinario;
import java.util.Arrays;

public class principal {

	public static void main(String[] args) {
		Empleado e1 = new Empleado(20, "Pepito Perez", "Ventas", "A-252");
		Empleado e2 = new Empleado(44, "Ana Lopez", "Recursos Humanos", "b-198");
		Empleado e3 = new Empleado(18, "Elena Nito", "Ventas", "A-241");
		Empleado e4 = new Empleado(33, "Jose Gomez", "Contabilidad", "B-96");
		Empleado e5 = new Empleado(64, "Francisco Perez", "Marketing", "A-69");
		Empleado e6 = new Empleado(55, "Javier Lopez", "Informatica", "A-161");
		
		ArbolesBinariosBusqueda bst = new ArbolesBinariosBusqueda();
		Arrays.asList(e1, e2, e3, e4, e5, e6).forEach(e -> bst.insertar(e));
		
		bst.preorden();
		System.out.println("------------------------------");
		bst.eliminar(20);
		bst.preorden();
		System.out.println("------------------------------");
		bst.eliminar(44);
		bst.preorden();
		System.out.println("------------------------------");

	}

}
