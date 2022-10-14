public class NodoDoble {

    public String dato;
    NodoDoble siguiente;
    NodoDoble anterior;
    //constructor no nodos

    public NodoDoble(String el) {
        this(el, null, null);
    }

    //Constructor nodos
    public NodoDoble(String el, NodoDoble s, NodoDoble a) {
        dato = el;
        siguiente = s;
        anterior = a;
    }

}