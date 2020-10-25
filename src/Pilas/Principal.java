package Pilas;

public class Principal {

	public static void main(String[] args) {
		URL google = new URL("https://www.google.com.co/");
		URL makigas= new URL("https://www.makigas.es/");
		Pila pila = new MiPila();
		imprimirEstado(pila);
		pila.apilar(google);
		imprimirEstado(pila);
		pila.apilar(makigas);
		imprimirEstado(pila);
		while(!pila.Vacia()){
			pila.desapilar();
			imprimirEstado(pila);
		}

	}

	private static void imprimirEstado(Pila pila) {
		if (pila.Vacia()) {
			System.out.println("No hay nada en la pila");
		}else {
			System.out.println("L= "+pila.longitud()+" URL "+ pila.obtener().getUrl());
		}
		
	}

}
