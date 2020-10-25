package Pilas;

public class MiPila implements Pila {
	private class Nodo {
		public URL url;
		public Nodo sigiente = null;

		public Nodo(URL url) {
			super();
			this.url = url;
		}

	}
	private int longitud=0;
	private Nodo cima = null;
	

	@Override
	public void apilar(URL url) {
		Nodo nodo = new Nodo(url);
		nodo.sigiente = cima;
		cima = nodo;
		longitud++;

	}

	@Override
	public void desapilar() {
		if (cima != null) {
			Nodo eliminar = cima;
			cima = cima.sigiente;
			eliminar.sigiente=null;
			longitud--;
		}

	}

	@Override
	public URL obtener() {
		if (cima == null) {
			return null;
		} else {
			return cima.url;
		}
	}

	@Override
	public int longitud() {
		return longitud;
	}

	@Override
	public boolean Vacia() {
		
		return cima==null;
	}

}
