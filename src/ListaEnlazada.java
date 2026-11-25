package src;

/*
 * Clase ListaEnlazada.
 * Jesús Manuel Hernández Exiga
 * 25/11/26
 */
public class ListaEnlazada<T> {

    private Nodo<T> cabeza;
    private int tamaño;

 /*
    1. agregarInicio(T dato) - Uriel Ramírez
    2. agregarFinal(T dato) - Katya Valentina
    3. insertarEn(int pos, T dato) - Jesus Manuel
    4. eliminarInicio() - Uriel Ramírez
    5. eliminarFinal() - Katya Valentina
    6. eliminar(T dato) - Jesus Manuel
    7. obtener(int pos) - Uriel Ramírez
    8. buscar(T dato) - Katya Valentina
    9. tamaño() Y estaVacia() - Jesus Manuel
*/
    /**
     * 3. Inserta un dato en una posición específica.
     */
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

    /**
     * 6. Elimina la primera ocurrencia del dato. Devuelve boolean.
     */
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

    /**
     * 9. Consulta de estado: Tamaño
     */
    public int tamaño() {
        return tamaño;
    }

    /**
     * 9. Consulta de estado: Esta Vacía
     */
    public boolean estaVacia() {
        return cabeza == null;
    }
}
