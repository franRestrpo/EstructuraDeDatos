package Arboles.ArbolBinario;



import javax.management.RuntimeErrorException;

public class ArbolesBinariosBusqueda implements InterfazArbolesBinariosBusqueda<Empleado> {
	
	private Empleado valor;
	private ArbolesBinariosBusqueda izquierdo, derecho;
	private ArbolesBinariosBusqueda Padre;

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
		insertarImp(empleado,null);
	}

	public void insertarImp(Empleado empleado, ArbolesBinariosBusqueda padre) {
		if (valor == null) {
			this.valor = empleado;
			this.Padre=padre;
		} else {
			if (empleado.compareTo(valor) < 0) {
				if (izquierdo == null)
					izquierdo = new ArbolesBinariosBusqueda();
				izquierdo.insertarImp(empleado,this);
			} else if (empleado.compareTo(valor) > 0) {
				if (derecho == null)
					derecho = new ArbolesBinariosBusqueda();
				derecho.insertarImp(empleado,this);
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
		if (valor != null) {
			if (id == valor.getId()) {
				eliminarImp(id);

			} else if (id < valor.getId() && izquierdo != null) {
				izquierdo.eliminar(id);
			} else if (id > valor.getId() && derecho != null) {
				derecho.eliminar(id);
			}
		}

	}

	private void eliminarImp(int id) {
		if(izquierdo!=null&&derecho!=null) {
			//eliminar con dos hijos
			ArbolesBinariosBusqueda minimo=derecho.minimo();
			this.valor=minimo.valor;
			derecho.eliminar(minimo.valor.getId());			
			
		}else if(izquierdo!=null ||derecho!=null) {
			//eliminar con un hijo
			ArbolesBinariosBusqueda sustituto=izquierdo!=null ? izquierdo:derecho;
			this.valor=sustituto.valor;
			this.izquierdo=sustituto.izquierdo;
			this.derecho=sustituto.derecho;
			
			
			
			
		}else {
			//eliminar nodo sin hijos
			if(Padre!=null) {
				if(this==Padre.izquierdo)Padre.izquierdo=null;
				if(this==Padre.derecho)Padre.derecho=null;
				Padre=null;
			}
			valor=null;
			
		}
		
	}

	private ArbolesBinariosBusqueda minimo() {
		if(izquierdo!=null&&!izquierdo.esVacio()) {
			return izquierdo.minimo();
		}else {
			return this;
		}
	}

	private void preordenImp(String prefijo) {
		if (valor != null) {
			System.out.println(prefijo + valor);
			if (izquierdo != null)
				izquierdo.preordenImp(prefijo + "  ");
			if (derecho != null)
				derecho.preordenImp(prefijo + "  ");
		}
	}

	private void inordenImp(String prefijo) {
		if (valor != null) {
			if (izquierdo != null)
				izquierdo.inordenImp(prefijo + "  ");
			System.out.println(prefijo + valor);
			if (derecho != null)
				derecho.inordenImp(prefijo + "  ");
		}
	}

	private void postordenImp(String prefijo) {
		if (valor != null) {
			if (izquierdo != null)
				izquierdo.postordenImp(prefijo + "  ");
			if (derecho != null)
				derecho.postordenImp(prefijo + "  ");
			System.out.println(prefijo + valor);
		}
	}

}
