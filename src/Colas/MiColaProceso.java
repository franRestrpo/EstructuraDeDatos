package Colas;

public class MiColaProceso implements ColaProceso {
	
	private class NodoProceso {
		public Trabajo trabajo;
		public NodoProceso siguiente;
		

		public NodoProceso(Trabajo trabajo) {
			this.trabajo = trabajo;
			this.siguiente = null;
		}
		@Override
		public String toString() {
			return getClass().getName()+"@"+trabajo+":"+this.siguiente+toString().hashCode();
		}
	}

	private NodoProceso cabeza, ultimo;
	private int NumeroEnCola;

	@Override
	public void Encolar(Trabajo t) {
		NodoProceso nuevoNodo = new NodoProceso(t);
		if (cabeza == null) {
			cabeza = nuevoNodo;
		} else {
			ultimo.siguiente = nuevoNodo;
		}
		ultimo = nuevoNodo;
		NumeroEnCola = getNumeroEnCola() + 1;
	}

	@Override
	public void Eliminar() {
		if (cabeza != null) {
			NodoProceso eliminar = cabeza;
			cabeza = cabeza.siguiente;
			eliminar.siguiente = null;
			NumeroEnCola = getNumeroEnCola() - 1;
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
	@Override
	public boolean isEmpity() {
		if(cabeza!= null)return false;
		else return true;
	}
	

	public int getNumeroEnCola() {
		return NumeroEnCola;
	}
	
	public boolean EliminarCola() {
		NodoProceso eliminar =cabeza;
		if (cabeza!=null) {
			
		while(cabeza.siguiente!=null) {
				eliminar=cabeza;
				cabeza=cabeza.siguiente;
				eliminar.siguiente=null;
		}

				cabeza = null;
				ultimo = null;
				NumeroEnCola =0;
	
		}
		return true;
	}



}

