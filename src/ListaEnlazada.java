package src;

/*
 * Clase ListaEnlazada.
 *
 */
public class ListaEnlazada<T> {

    private Nodo<T> cabeza;
    private int tamaño;


 
    //1. agregarInicio(T dato)
	Inserta al principio
	Uriel Ramírez

	//2. agregarFinal(T dato)
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
	//3. insertarEn(int pos, T dato)
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
    }l

	//4. eliminarInicio()
	Elimina y devuelve el primero
	Uriel Ramírez

	//5. eliminarFinal()
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

	//6. eliminar(T dato)
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

	//7. obtener(int pos)
	Devuelve el elemento en la posición
	Uriel Ramírez

	//8. buscar(T dato)
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

	//9. tamaño() Y estaVacia() public int tamaño() {
        return tamaño;
    }
    public boolean estaVacia() {
        return cabeza == null;
    }

}
