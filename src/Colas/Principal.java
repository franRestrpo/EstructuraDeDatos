package Colas;

public class Principal  {
	
	public static void main(String[] arg) {
	Trabajo trabajo=new Trabajo("ing", "fran ");
	Trabajo trabajo1=new Trabajo("ing", "fran restrepo");
	Trabajo trabajo2=new Trabajo("ing", "fran restrepo cuellar");
	MiColaProceso cola=new MiColaProceso();
	trabajo.setImpreso(true);
	trabajo1.setImpreso(true);
	cola.Encolar(trabajo);
	cola.Encolar(trabajo1);
	cola.Encolar(trabajo2);
	trabajo2.setImpreso(true);
	
	
	System.out.println("prueva de impresión -->"+cola.Obtener()+" numer de trabajos "+cola.getNumeroEnCola()+" "+cola.isEmpity());
	cola.Eliminar();
	cola.isEmpity();
	//cola.EliminarCola();
	System.out.println("prueva de impresión -->"+cola.Obtener()+" numer de trabajos "+cola.getNumeroEnCola()+" "+cola.isEmpity());
	cola.Eliminar();
	cola.isEmpity();
	//cola.EliminarCola();
	System.out.println("prueva de impresión -->"+cola.Obtener()+" numer de trabajos "+cola.getNumeroEnCola()+" "+cola.isEmpity());
	cola.Eliminar();
	//cola.EliminarCola();
	cola.isEmpity();
	System.out.println("prueva de impresión -->"+cola.Obtener()+" numer de trabajos "+cola.getNumeroEnCola()+" "+cola.isEmpity());
	}

}
