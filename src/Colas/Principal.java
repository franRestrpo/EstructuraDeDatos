package Colas;

public class Principal  {
	
	public static void main(String[] arg) {
	Trabajo trabajo=new Trabajo("ing", "fran ");
	Trabajo trabajo1=new Trabajo("ing", "fran restrepo");
	Trabajo trabajo2=new Trabajo("ing", "fran restrepo cuellar");
	MiColaProceso cola=new MiColaProceso();
	cola.Encolar(trabajo);
	cola.Encolar(trabajo1);
	cola.Encolar(trabajo2);
	
	}

}
