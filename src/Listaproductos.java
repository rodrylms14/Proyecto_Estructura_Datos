package src;

import java.util.ArrayList;
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

    public void insertarProductoInicio(String idProducto, String nombreProducto, double precioProducto, String categoriaProducto, int cantidadProducto, ArrayList<String> listaImagenesProducto) {
        Producto nuevoProducto = new Producto(idProducto,nombreProducto, precioProducto, categoriaProducto, cantidadProducto, listaImagenesProducto);
        nuevoProducto.setSiguiente(primero);
        setPrimero(nuevoProducto);
    }

    public void insertarProductoFinal(String idProducto,String nombreProducto, double precioProducto, String categoriaProducto, int cantidadProducto, ArrayList<String> listaImagenesObj) {
        Producto nuevoProducto = new Producto(idProducto,nombreProducto, precioProducto, categoriaProducto, cantidadProducto, listaImagenesObj);
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
    // Metodo para mostrar los productos y el coste TOTAL de cada producto y tambien la suma de todos los productos en la lista
    public void mostrarLista(){
        if(primero == null){
            System.out.println("No hay datos que mostrar, porfavor ingrese un producto para poder mostrar infomacion");
            return;
        }
        Producto nodoActual = primero;
        double totalAcumulado = 0;
        while(nodoActual != null) {
            double costoProducto = nodoActual.getCantidad() * nodoActual.getPrecio();
            System.out.println(nodoActual);
            System.out.println("Costo total de los productos en Stock: " + costoProducto + "\n");
            totalAcumulado += costoProducto;
            nodoActual = nodoActual.getSiguiente();
        }
        System.out.println("El total acumulado de todos los productos en Stock es de: " +totalAcumulado);
    }
    // Metodo para modificar lista por su numero de ID 
    public void modificarLista(String idBuscar, String nuevoNombre, double nuevoPrecio, String nuevaCategoria, int nuevaCantidad, ArrayList<String> nuevaImagen) {
        Producto nodoActual = primero;
        while(nodoActual != null && !nodoActual.getId().equals(idBuscar)){
            nodoActual = nodoActual.getSiguiente();
        }
        if(nodoActual != null){
            nodoActual.setNombre(nuevoNombre);
            nodoActual.setPrecio(nuevoPrecio);
            nodoActual.setCategoria(nuevaCategoria);
            nodoActual.setCantidad(nuevaCantidad);
            nodoActual.setImagen(nuevaImagen);
        } else {
            System.out.println("Ingrese un Id de producto correcto");
        }
    }

}
