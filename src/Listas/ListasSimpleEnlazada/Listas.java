package Listas.ListasSimpleEnlazada;

public class Listas {

	private Nodo cabeza = null;
	private int cantidadLibros = 0;

	private class Nodo {
		public Libros libro;
		public Nodo siguiente = null;

		public Nodo(Libros lib) {
			this.libro = lib;

		}

		@Override
		public String toString() {
			return "Nodo@" + libro + ":: Posición " + Integer.toHexString(hashCode());
		}

	}

	public void InsertarAlPrincipio(Libros libro) {
		Nodo nodo = new Nodo(libro);
		nodo.siguiente = cabeza;
		cabeza = nodo;
		cantidadLibros++;

	}

	public void InsertarAlFinal(Libros libro) {
		Nodo nodo = new Nodo(libro);
		if (cabeza == null) {
			cabeza = nodo;
		} else {
			Nodo puntero = cabeza;
			while (puntero.siguiente != null) {
				puntero = puntero.siguiente;
			}
			puntero.siguiente = nodo;

		}
		cantidadLibros++;

	}

	public void InsertarDespues(int n, Libros libro) {
		Nodo nodo = new Nodo(libro);
		if (cabeza == null) {
			cabeza = nodo;
		} else {
			Nodo puntero = cabeza;
			int contador = 0;
			while (contador < n && puntero.siguiente != null) {
				puntero = puntero.siguiente;
				contador++;
			}
			nodo.siguiente = puntero.siguiente;
			puntero.siguiente = nodo;

		}
		cantidadLibros++;
	}

	public Libros ObtenerLibro(int n) {
		if (cabeza == null) {
			return null;
		} else {
			Nodo puntero = cabeza;
			int contador = 0;
			while (contador < n && puntero.siguiente != null) {
				puntero = puntero.siguiente;
				contador++;
			}
			if (contador != n) {
				return null;
			} else {
				return puntero.libro;
			}
		}
	}

	public boolean LaListaEstaVacia() {
		return cabeza == null;
	}

	public int ContarLibros() {
		return cantidadLibros;
	}

	public void EliminarElPrincipio() {
		if (cabeza != null) {
			Nodo primero = cabeza;
			cabeza = cabeza.siguiente;
			primero.siguiente = null;
			cantidadLibros--;
		}
	}

	public void EliminarElFinal() {
		if (cabeza != null) {
			if (cabeza.siguiente == null) {
				cabeza = null;
			} else {
				Nodo puntero = cabeza;
				while (puntero.siguiente.siguiente != null) {
					puntero = puntero.siguiente;
				}
				puntero.siguiente = null;
			}

		}
		cantidadLibros--;
	}

	public void EliminarLibroN(int n) {
		if (cabeza != null) {
			if (n == 0) {
				Nodo primero = cabeza;
				cabeza = cabeza.siguiente;
				primero.siguiente = null;
				cantidadLibros--;
			} else if (n < cantidadLibros) {
				Nodo puntero = cabeza;
				int contador = 0;
				while (contador < (n - 1)) {
					puntero = puntero.siguiente;
					contador++;
				}
				Nodo temporal = puntero.siguiente;
				puntero.siguiente = temporal.siguiente;
				temporal.siguiente = null;
				cantidadLibros--;
			}
		}

	}

	public void MostrarOrden() {
		Nodo puntero = cabeza;
		if (puntero == null) {
			System.out.println("no hay libros para mostrar");

		} else {
			while (puntero.siguiente != null) {
				System.out.println("este libro " + puntero.libro + " el siguiente --> " + puntero.siguiente);
				puntero = puntero.siguiente;
			}
			System.out.println("este libro " + puntero.libro + " el siguiente --> " + puntero.siguiente);

		}
	}

}
