package src;

public class Main {

    // Imprimir todos los elementos de la lista.
    public static void imprimirLista(ListaEnlazada<Integer> lista) {

        System.out.print("Lista: [");

        for (int i = 0; i < lista.tamaño(); i++) {

            if (i > 0) {
                System.out.print(" -> ");
            }

            System.out.print(lista.obtener(i));
        }

        System.out.println("]");
    }

    public static void main(String[] args) {

        System.out.println("\n===== PRUEBA 1: LISTA VACIA =====");

        ListaEnlazada<Integer> lista1 = new ListaEnlazada<>();

        imprimirLista(lista1);
        System.out.println("Tamaño: " + lista1.tamaño());
        System.out.println("¿Está vacía?: " + lista1.estaVacia());

        System.out.println("\n===== PRUEBA 2: UN ELEMENTO =====");

        ListaEnlazada<Integer> lista2 = new ListaEnlazada<>();

        lista2.agregarInicio(10);

        imprimirLista(lista2);

        System.out.println("Eliminar inicio: " + lista2.eliminarInicio());

        imprimirLista(lista2);

        lista2.agregarFinal(20);

        System.out.println("Eliminar final: " + lista2.eliminarFinal());

        imprimirLista(lista2);

        System.out.println("\n===== PRUEBA 3: EXTREMOS =====");

        ListaEnlazada<Integer> lista3 = new ListaEnlazada<>();

        lista3.agregarInicio(20);
        lista3.agregarInicio(10);
        lista3.agregarFinal(30);

        imprimirLista(lista3);

        System.out.println("Eliminar inicio: " + lista3.eliminarInicio());

        imprimirLista(lista3);

        System.out.println("Eliminar final: " + lista3.eliminarFinal());

        imprimirLista(lista3);

        System.out.println("\n===== PRUEBA 4: DATO INEXISTENTE =====");

        ListaEnlazada<Integer> lista4 = new ListaEnlazada<>();

        lista4.agregarFinal(10);
        lista4.agregarFinal(20);
        lista4.agregarFinal(30);

        imprimirLista(lista4);

        System.out.println("Eliminar 99: " + lista4.eliminar(99));

        imprimirLista(lista4);

        System.out.println("\n===== PRUEBA 5: POSICIONES INVALIDAS =====");

        ListaEnlazada<Integer> lista5 = new ListaEnlazada<>();

        lista5.agregarFinal(10);
        lista5.agregarFinal(20);

        imprimirLista(lista5);

        try {
            lista5.obtener(-1);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Obtener (-1): Error de posicion");
        }

        try {
            lista5.obtener(2);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Obtener (2): Error de posicion");
        }

        imprimirLista(lista5);

        System.out.println("\n===== FIN DE LAS PRUEBAS =====");
    }
}
