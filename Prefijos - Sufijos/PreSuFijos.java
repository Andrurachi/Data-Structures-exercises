import java.util.Scanner;

public class PreSuFijos{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String palabra_bruto = sc.nextLine();
        sc.close();

        String palabra = "";

        for(int i = 0; i < palabra_bruto.length(); i++){
            if(palabra_bruto.charAt(i) != '[' && palabra_bruto.charAt(i) != ']' && palabra_bruto.charAt(i) != ','){
                palabra += Character.toString(palabra_bruto.charAt(i));
            }
        }

        ListaDoble prefijos = new ListaDoble();

        for(int i = 1; i <= palabra.length(); i++){
            String prefijo = "";
            for(int n = 0; n < i; n++){
                prefijo += palabra.charAt(n);
            }
            prefijos.agregarAlFinal(prefijo);
        }

        
        ListaDoble sufijos = new ListaDoble();

        for(int i = palabra.length()-1; i > 0; i--){

            String sufijo = "";
            for(int n = i; n < palabra.length(); n++){
                sufijo += palabra.charAt(n);
            }
            sufijos.agregarAlFinal(sufijo);
        }

        ListaDoble respuesta = new ListaDoble();
        for(int i = 0; i < palabra.length(); i++){
            if(sufijos.buscarElem(prefijos.buscarIndex(i))){
                respuesta.agregarAlFinal(prefijos.buscarIndex(i));
            }
        }


        for(int i = 0; i < respuesta.length(); i++){
            System.out.print("[" +  respuesta.buscarIndex(i) + "] \n");
        }

        System.out.print(palabra_bruto);        
        
    }  
}

class NodoDoble {

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
class ListaDoble {

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