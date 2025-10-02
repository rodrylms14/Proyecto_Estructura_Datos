package estructuras;
import modelo.Producto;
public class Listaproductos {
	
    //Clase lista enlazada simple

    //Atributos
    private Producto primero;

    //Metodos
    //Constructor

    public Listaproductos() {
        primero = null;
    }

    // Getters

    public Producto getPrimero() {
        return primero;
    }

    //Setters 
    public void setPrimero(Producto nuevoPrimero) {
        primero = nuevoPrimero;
    }

}
