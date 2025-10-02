package estructuras;
import modelo.Producto;

public class NodoProducto {
    private Producto producto;
    private NodoProducto siguiente;

    public NodoProducto(Producto productoObj) {
        producto = productoObj;
        siguiente = null;
    }

    public Producto getProducto() { 
        return producto; 
    }
    public NodoProducto getSiguiente() { 
        return siguiente; 
    }
    public void setSiguiente(NodoProducto nuevoSiguiente) { 
        siguiente = nuevoSiguiente; 
    }
}
