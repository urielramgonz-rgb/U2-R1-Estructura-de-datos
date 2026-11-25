package src;

//Clase lista enlazada
public class ListaEnlazada<T> {

    private Nodo<T> cabeza;
    private int tamaño;

//1. Metodo Agregar al inicio
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
/*
	2. agregarFinal(T dato)
	Inserta al final
	Katya Valentina

	3. insertarEn(int pos, T dato)
	Inserta en una posición
	Jesus Manuel
*/
	
//4. eliminarInicio()
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
	
/*
	5. eliminarFinal()
	Elimina y devuelve el último
	Katya Valentina

	6. eliminar(T dato)
	Elimina la primera ocurrencia; devuelve boolean
	Jesus Manuel
*/

	//7. obtener(int pos)
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
	
/*
	8. buscar(T dato)
	Devuelve la posición o -1
	Katya Valentina

	9. tamaño() Y estaVacia()
	Consulta de estado
	Jesus Manuel
*/

}
