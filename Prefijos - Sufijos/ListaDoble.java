public class ListaDoble {

    private NodoDoble inicio, fin;
    private int length = 0;

    public ListaDoble() {
        inicio = fin = null;
    }

    //metodo vacia
    public boolean estaVacia() {
        return inicio == null;
    }

    //metodo nodos al final
    public void agregarAlFinal(String el) {
        if (!estaVacia()) {
            fin = new NodoDoble(el, fin, fin);
            fin.anterior.siguiente = fin;
        } else {
            inicio = fin = new NodoDoble(el);
        }
        length +=1;
    }

    //agregar al inicio
    public void agregarAlInicio(String el) {
        if (!estaVacia()) {
            inicio = new NodoDoble(el, inicio, null);
            inicio.siguiente.anterior = inicio;
        } else {
            inicio = fin = new NodoDoble(el);
        }
    }

    //Mostrar lista inicio a fin
    public void mostrarListaInicioFin() {
        if (!estaVacia()) {
            String datos = "<=>";
            NodoDoble auxiliar = inicio;
            while (auxiliar != null) {
                datos = datos + "[" + auxiliar.dato + "]<=>";
                auxiliar = auxiliar.siguiente;
            }
            System.out.println("Mostrando datos de inicio a fin: \n" + datos);
        }
    }

    //metodo mostrar fin a inicio
    public void mostrarListaFinInicio() {
        if (!estaVacia()) {
            String datos = "<=>";
            NodoDoble auxiliar = fin;
            while (auxiliar != null) {
                datos = datos + "[" + auxiliar.dato + "]<=>";
                auxiliar = auxiliar.anterior;
            }
            System.out.println("Mostrando datos de fin a inicio: \n" + datos);
        }
    }

    public boolean buscarElem(String elem) {
        boolean flag = false;
        int i = 0;
        while (i < length) {
            if (elem.equals(this.buscarIndex(i))) {
                flag = true;
            }
            i += 1;
        }
        return flag;
    }

    public String buscarIndex(int index){
        NodoDoble temp = inicio;
        int i = 0;
        while (i < index) {
            temp = temp.siguiente;
            i += 1;
            }
        return temp.dato;
    }

    public int length(){
        return this.length;
    }

}
