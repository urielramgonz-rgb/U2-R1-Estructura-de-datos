package src;

public class Main {

    public static void main(String[] args) {

        System.out.println("===== PRUEBA 1: LISTA VACIA =====");

        ListaEnlazada<Integer> lista1 = new ListaEnlazada<>();

        System.out.println("¿Esta vacia?: " + lista1.estaVacia());
        System.out.println("Tamaño: " + lista1.tamaño());
        System.out.println("Buscar 10: " + lista1.buscar(10));
        System.out.println("Eliminar 10: " + lista1.eliminar(10));

        // Comprobar eliminación al inicio con lista vacía.
        try {
            lista1.eliminarInicio();
        } catch (java.util.NoSuchElementException e) {
            System.out.println("Correcto: No se puede eliminar al inicio.");
        }

        // Comprobar eliminación al final con lista vacía.
        try {
            lista1.eliminarFinal();
        } catch (IllegalStateException e) {
            System.out.println("Correcto: No se puede eliminar al final.");
        }

        System.out.println("\n===== PRUEBA 2: UN ELEMENTO =====");

        ListaEnlazada<Integer> lista2 = new ListaEnlazada<>();

        lista2.agregarInicio(10);

        System.out.println("Tamaño: " + lista2.tamaño());
        System.out.println("Elemento: " + lista2.obtener(0));

        System.out.println("Eliminar primero: "
                + lista2.eliminarInicio());

        System.out.println("¿Esta vacia?: " + lista2.estaVacia());

        lista2.agregarFinal(20);

        System.out.println("Nuevo elemento: " + lista2.obtener(0));

        System.out.println("Eliminar ultimo: "
                + lista2.eliminarFinal());

        System.out.println("Tamaño final: " + lista2.tamaño());

        System.out.println("\n===== PRUEBA 3: EXTREMOS =====");

        ListaEnlazada<Integer> lista3 = new ListaEnlazada<>();

        // Insertar elementos.
        lista3.agregarInicio(20);
        lista3.agregarInicio(10);
        lista3.agregarFinal(30);

        System.out.println("Primer elemento: " + lista3.obtener(0));
        System.out.println("Ultimo elemento: "
                + lista3.obtener(lista3.tamaño() - 1));

        System.out.println("Tamaño: " + lista3.tamaño());

        // Eliminar elementos.
        System.out.println("Eliminar inicio: "
                + lista3.eliminarInicio());

        System.out.println("Eliminar final: "
                + lista3.eliminarFinal());

        System.out.println("Elemento restante: "
                + lista3.obtener(0));

        System.out.println("Tamaño final: " + lista3.tamaño());

        System.out.println("\n===== PRUEBA 4: DATO INEXISTENTE =====");

        ListaEnlazada<Integer> lista4 = new ListaEnlazada<>();

        lista4.agregarFinal(10);
        lista4.agregarFinal(20);
        lista4.agregarFinal(30);

        boolean eliminado = lista4.eliminar(99);

        System.out.println("¿Se elimino el dato 99?: " + eliminado);

        System.out.println("Tamaño actual: " + lista4.tamaño());

        System.out.println("Los elementos siguen siendo:");
        System.out.println(lista4.obtener(0));
        System.out.println(lista4.obtener(1));
        System.out.println(lista4.obtener(2));

        System.out.println("\n===== PRUEBA 5: POSICIONES INVALIDAS =====");

        ListaEnlazada<Integer> lista5 = new ListaEnlazada<>();

        lista5.agregarFinal(10);
        lista5.agregarFinal(20);

        // Intentar obtener una posición negativa.
        try {
            lista5.obtener(-1);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Correcto: No existe la posicion -1.");
        }

        // Intentar obtener una posición igual al tamaño.
        try {
            lista5.obtener(2);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Correcto: No existe la posicion 2.");
        }

        // Intentar insertar en posiciones inválidas.
        lista5.insertarEn(-1, 50);
        lista5.insertarEn(3, 50);

        System.out.println("Tamaño despues de intentar insertar: "
                + lista5.tamaño());

        System.out.println("Elementos originales: "
                + lista5.obtener(0) + ", "
                + lista5.obtener(1));

        System.out.println("\n===== FIN DE LAS PRUEBAS =====");
    }
}
