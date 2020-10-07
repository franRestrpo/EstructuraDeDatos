package Colas;

public class MiColaProceso implements ColaProceso {
	
	
	private class NodoProceso {
		public Trabajo trabajo;
		public NodoProceso siguiente;

		public NodoProceso(Trabajo trabajo) {
			this.trabajo = trabajo;
			this.siguiente = null;
		}
	}

	private NodoProceso cabeza, ultimo;

	@Override
	public void Encolar(Trabajo t) {
		NodoProceso nuevoNodo = new NodoProceso(t);
		if (cabeza == null) {
			cabeza = nuevoNodo;
			ultimo = nuevoNodo;
		} else {
			ultimo.siguiente = nuevoNodo;
		}
		ultimo = nuevoNodo;
	}

	@Override
	public void Eliminar() {
		if (cabeza != null) {
			NodoProceso eliminar = cabeza;
			cabeza = cabeza.siguiente;
			eliminar.siguiente = null;
			if (cabeza == null) {
				ultimo = null;
			}
		}
	}

	@Override
	public Trabajo Obtener() {
		if (cabeza == null) {
			return null;
		} else {
			return cabeza.trabajo;
		}
	}

}
