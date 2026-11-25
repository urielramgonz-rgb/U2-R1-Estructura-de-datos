package src;

/*
 * Clase ListaEnlazada.
 *
 */
public class ListaEnlazada<T> {

    private Nodo<T> cabeza;
    private int tamaño;


 
//1. Metodo Agregar al inicio Uriel Ramírez
	public void agregarInicio(T dato) {

        //Crea el nuevo nodo con el dato.
        Nodo<T> nuevo = new Nodo<>(dato);

        //Hace que el nuevo nodo apunte a la cabeza.
        nuevo.setSiguiente(cabeza);

        //Y ahora la cabeza sera el nuevo nodo.
        cabeza = nuevo;

        //Lleva un contador del tamaño de la lita y lo incrementa.
        tamaño++;
    }

//2. Metodo Agregar al final Katya Valentina
	public void agregarFinal(T dato) {
        Nodo<T> nuevo = new Nodo<>(dato);

        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            Nodo<T> actual = cabeza;
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(nuevo);
        }
        tamaño++;
    }


//3. Insertar En. Jesus Manuel
	public void insertarEn(int pos, T dato) {
        // Validar posición
        if (pos < 0 || pos > tamaño) {
            System.out.println("Error: Posición fuera de rango");
            return;
        }

        Nodo<T> nuevo = new Nodo<>(dato);

        // Insertar al inicio
        if (pos == 0) {
            nuevo.setSiguiente(cabeza);
            cabeza = nuevo;
        } else {
            // Caminar hasta el nodo anterior a la posición
            Nodo<T> actual = cabeza;
            for (int i = 0; i < pos - 1; i++) {
                actual = actual.getSiguiente();
            }
            // Conectar el nuevo nodo
            nuevo.setSiguiente(actual.getSiguiente());
            actual.setSiguiente(nuevo);
        }
        tamaño++;
    }
	
//4. Eliminar Inicio. Uriel Ramírez
	public T eliminarInicio() {

    //Comprueba si la lista esta vacia.
    if (cabeza == null) {
		//Si esta vacia Lanza una excepcion termina el metodo.
        throw new java.util.NoSuchElementException("La lista está vacía");
    }

    //Guarda el primer dato de la lisa antes de eliminarlo para despues devolderlo.
    T dato = cabeza.getDato();

    //Actualiza la cabeza al siguiente nodo y asi se elimina el primero.
    cabeza = cabeza.getSiguiente();

    //Disminuye el tamaño de la lista en el contador.
    tamaño--;

    //REgresa el dato eliminado.
    return dato;
}
	
//5. Eliminar Final. Katya Valentina
	public T eliminarFinal() {
        if (cabeza == null) {
            throw new IllegalStateException("La lista está vacía");
        }

        // Caso: un solo elemento
        if (cabeza.getSiguiente() == null) {
            T dato = cabeza.getDato();
            cabeza = null;
            tamaño--;
            return dato;
        }

        // Caso general: buscar el penúltimo nodo
        Nodo<T> anterior = cabeza;
        while (anterior.getSiguiente().getSiguiente() != null) {
            anterior = anterior.getSiguiente();
        }

        T dato = anterior.getSiguiente().getDato();
        anterior.setSiguiente(null);
        tamaño--;
        return dato;
    }
	
//6. eliminar(T dato) Jesus Manuel
	public boolean eliminar(T dato) {
        // Lista vacía
        if (cabeza == null) {
            return false;
        }

        // El dato está en la cabeza
        if (cabeza.getDato().equals(dato)) {
            cabeza = cabeza.getSiguiente();
            tamaño--;
            return true;
        }

        // Buscar en el resto de la lista
        Nodo<T> actual = cabeza;
        while (actual.getSiguiente() != null) {
            if (actual.getSiguiente().getDato().equals(dato)) {
                // Saltar el nodo a eliminar
                actual.setSiguiente(actual.getSiguiente().getSiguiente());
                tamaño--;
                return true;
            }
            actual = actual.getSiguiente();
        }

        return false; // No se encontró
    }
	
//7. Obtener Uriel Ramírez
	public T obtener(int pos) {

    	//Primero verifica que la posicion que se desea obtener este dentro del rango de la lista.
    	if (pos < 0 || pos >= tamaño) {

        //Si la posicion no existe lanza una excepcion y termina el metodo.
        	throw new IndexOutOfBoundsException("No existe esa posicion en la lista");
    	}

    	//Crea una referencia para que "actual comience en la cabeza".
    	Nodo<T> actual = cabeza;

    	//Recorre la lista hasta llegar a la posicion que se necesita.
    	for (int i = 0; i < pos; i++) {

        	//En cada recorrido avanza una posicion de la lista si es que aun no llega a la posicion solicitada.
        	actual = actual.getSiguiente();
    	}

    	//Cuando encuentra la posicion solicitada la devuelve.
    	return actual.getDato();
	}

//8. Buscar. Katya Valentina
	public int buscar(T dato) {
        Nodo<T> actual = cabeza;
        int pos = 0;

        while (actual != null) {
            T valor = actual.getDato();
            if (dato == null ? valor == null : dato.equals(valor)) {
                return pos;
            }
            actual = actual.getSiguiente();
            pos++;
        }
        return -1;
    }

//9. tamaño() Y estaVacia() Jesus Emanuel
	public int tamaño() {
        return tamaño;
    }

    public boolean estaVacia() {
        return cabeza == null;
    }

}
