package src;

public class NodoArbol {

    private Producto dato;
    private NodoArbol hijoizq;
    private NodoArbol hijoder;

    public NodoArbol(Producto productoNuevo) {
        dato = productoNuevo;
        hijoizq = hijoder = null;
    }

    public Producto getDato() {
        return dato;
    }
    public NodoArbol getHijoIzq() {
        return hijoizq;
    }
    public NodoArbol getHijoDer() {
        return hijoder;
    }

    public void setDato(Producto nuevoDato) {
        dato = nuevoDato;
    }

    public void setHijoIzq(NodoArbol nuevoHijoizq) {
        hijoizq = nuevoHijoizq;
    }
    public void setHijoDer(NodoArbol nuevoHijoDer) {
        hijoder = nuevoHijoDer;
    }

    public void imprimir() {
        System.out.println(dato.toString());
    }

}
