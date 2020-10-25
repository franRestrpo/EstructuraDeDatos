package arbolesBinarios;

import javax.management.RuntimeErrorException;

public class ArbolesBinariosBusqueda implements InterfazArbolesBinariosBusqueda<Empleado> {
	private Empleado valor;
	private ArbolesBinariosBusqueda izquierdo, derecho;

	@Override
	public boolean esVacio() {
		return valor == null;
	}

	@Override
	public boolean esHoja() {
		return valor != null && izquierdo == null && derecho == null;
	}

	@Override
	public void insertar(Empleado empleado) {
		if (valor == null) {
			this.valor = empleado;
		} else {
			if (empleado.compareTo(valor) < 0) {
				if (izquierdo == null)
					izquierdo = new ArbolesBinariosBusqueda();
				izquierdo.insertar(empleado);
			} else if (empleado.compareTo(valor) > 0) {
				if (derecho == null)
					derecho = new ArbolesBinariosBusqueda();
				derecho.insertar(empleado);
			} else {
				throw new RuntimeErrorException(null, "Insertando elememto duplicado");
			}
		}

	}

	@Override
	public boolean existe(int id) {
		if (valor != null) {
			if (id == valor.getId()) {
				return true;
			} else if (id < valor.getId() && izquierdo != null) {
				return izquierdo.existe(id);
			} else if (id > valor.getId() && derecho != null) {
				return derecho.existe(id);
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	@Override
	public Empleado obtener(int id) {
		if (valor != null) {
			if (id == valor.getId()) {
				return valor;
			} else if (id < valor.getId() && izquierdo != null) {
				return izquierdo.obtener(id);
			} else if (id > valor.getId() && derecho != null) {
				return derecho.obtener(id);
			} else
				return null;
		} else {
			return null;
		}
	}

	@Override
	public void preorden() {
		preordenImp("");
	}

	@Override
	public void inorden() {
		inordenImp("");
	}

	@Override
	public void postorden() {
		postordenImp("");

	}

	@Override
	public void eliminar(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "" + valor;
	}
	
	private void preordenImp(String prefijo) {
		if (valor != null) {
			System.out.println(prefijo +valor);
			if (izquierdo != null) izquierdo.preordenImp(prefijo + "  ");
			if (derecho != null) derecho.preordenImp(prefijo + "  ");
		}
	}

	private void inordenImp(String prefijo) {
		if (valor != null) {
			if (izquierdo != null) izquierdo.inordenImp(prefijo + "  ");
			System.out.println(prefijo+valor);
			if (derecho != null) derecho.inordenImp(prefijo + "  ");
		}
	}

	private void postordenImp(String prefijo) {
		if (valor != null) {
			if (izquierdo != null) izquierdo.postordenImp(prefijo + "  ");
			if (derecho != null) derecho.postordenImp(prefijo + "  ");
			System.out.println(prefijo+valor);
		}
	}

}
