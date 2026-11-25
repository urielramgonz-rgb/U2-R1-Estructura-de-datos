package src;

/*
 * Clase ListaEnlazada.
 *
 */
public class ListaEnlazada<T> {

    private Nodo<T> cabeza;
    private int tamaño;


 /*
    1. agregarInicio(T dato)
	Inserta al principio
	Uriel Ramírez

	2. agregarFinal(T dato)
	Inserta al final
	Katya Valentina
	

	3. insertarEn(int pos, T dato)
	Inserta en una posición
	Jesus Manuel

	4. eliminarInicio()
	Elimina y devuelve el primero
	Uriel Ramírez

	5. eliminarFinal()
	Elimina y devuelve el último
	Katya Valentina

	6. eliminar(T dato)
	Elimina la primera ocurrencia; devuelve boolean
	Jesus Manuel

	7. obtener(int pos)
	Devuelve el elemento en la posición
	Uriel Ramírez

	8. buscar(T dato)
	Devuelve la posición o -1
	Katya Valentina

	9. tamaño() Y estaVacia()
	Consulta de estado
	Jesus Manuel
*/

	    /*
     * 2. agregarFinal
     * Inserta al final
     * Katya Valentina
     */
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

    /*
     * 5. eliminarFinal()
     * Elimina y devuelve el último
     * Katya Valentina
     */
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

    /*
     * 8. buscar(T dato)
     * Devuelve la posición o -1
     * Katya Valentina
     */
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

}
