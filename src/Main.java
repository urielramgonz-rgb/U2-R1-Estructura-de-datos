package src;

public class Main {
    public static void main(String[] args) {
        ListaEnlazada<String> lista = new ListaEnlazada<>();

        // Probando insertarEn
        lista.insertarEn(0, "A"); // [A]
        lista.insertarEn(1, "C"); // [A, C]
        lista.insertarEn(1, "B"); // [A, B, C]
        
        System.out.println("Tamaño: " + lista.tamaño()); // 3
        System.out.println("¿Vacía?: " + lista.estaVacia()); // false

        // Probando eliminar
        System.out.println("Eliminar B: " + lista.eliminar("B")); // true
        System.out.println("Eliminar Z: " + lista.eliminar("Z")); // false
        System.out.println("Tamaño tras eliminar: " + lista.tamaño()); // 2
    }
}
