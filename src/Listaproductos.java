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

    public void insertarProductoInicio(String idProducto, String nombreProducto, double precioProducto, String categoriaProducto, int cantidadProducto) {
        Producto nuevoProducto = new Producto(idProducto,nombreProducto, precioProducto, categoriaProducto, cantidadProducto);
        nuevoProducto.setSiguiente(primero);
        setPrimero(nuevoProducto);
    }

    public void insertarProductoFinal(String idProducto,String nombreProducto, double precioProducto, String categoriaProducto, int cantidadProducto) {
        Producto nuevoProducto = new Producto(idProducto,nombreProducto, precioProducto, categoriaProducto, cantidadProducto);
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

    public void modificarLista(String idBuscar, String nuevoNombre, double nuevoPrecio, String nuevaCategoria, int nuevaCantidad) {
        Producto nodoActual = primero;
        while(nodoActual != null && !nodoActual.getId().equals(idBuscar)){
            nodoActual = nodoActual.getSiguiente();
        }
        if(nodoActual != null){
            nodoActual.setNombre(nuevoNombre);
            nodoActual.setPrecio(nuevoPrecio);
            nodoActual.setCategoria(nuevaCategoria);
            nodoActual.setCantidad(nuevaCantidad);
        } else {
            System.out.println("Ingrese un Id de producto correcto");
        }
    }

   /*  public void modificarLista(String idBuscar, String nuevoNombre, double nuevoPrecio, String nuevaCategoria, int nuevaCantidad) {
        Producto nodoActual = primero;
        while(nodoActual != null && nodoActual.getId() != Integer.parseInt(idBuscar)){
            nodoActual = nodoActual.getSiguiente();
        }
        if(nodoActual != null){
            nodoActual.setNombre(nuevoNombre);
            nodoActual.setPrecio(nuevoPrecio);
            nodoActual.setCategoria(nuevaCategoria);
            nodoActual.setCantidad(nuevaCantidad);
        } else {
            System.out.println("Ingrese un Id de producto correcto");
        }
    }*/

}
