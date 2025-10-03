package src;
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

    public void insertarProductoInicio(String nombreProducto, double precioProducto, String categoriaProducto, int cantidadProducto) {
        Producto nuevoProducto = new Producto(nombreProducto, precioProducto, categoriaProducto, cantidadProducto);
        nuevoProducto.setSiguiente(primero);
        setPrimero(nuevoProducto);
    }

    public void insertarProductoFinal(String nombreProducto, double precioProducto, String categoriaProducto, int cantidadProducto) {
        Producto nuevoProducto = new Producto(nombreProducto, precioProducto, categoriaProducto, cantidadProducto);
        if(primero == null) {
            setPrimero(nuevoProducto); 
        } else {
            Producto nodoActual = primero;
            while(nodoActual.getSiguiente() != null){
                nodoActual = nodoActual.getSiguiente();
            }
            nodoActual.setSiguiente(nuevoProducto);
        }
    }

    public void mostrarLista(){
        if(primero == null){
            System.out.println("No hay datos que mostrar, porfavor ingrese un producto para poder mostrar infomacion");
            return;
        }
        Producto nodoActual = primero;
        while(nodoActual != null) {
            System.out.println(nodoActual);
            nodoActual = nodoActual.getSiguiente();
        }
    }

}
