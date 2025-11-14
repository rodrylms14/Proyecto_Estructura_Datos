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
        
        if(existeId(idProducto)) {
            System.out.println("Ya existe un producto con el ID: " + idProducto );
            return;
        }
        Producto nuevoProducto = new Producto(idProducto,nombreProducto, precioProducto, categoriaProducto, cantidadProducto, listaImagenesProducto);
        nuevoProducto.setSiguiente(primero);
        setPrimero(nuevoProducto);
        System.out.println("Prodcuto agregado con ID: " + idProducto);
    }

    public void insertarProductoFinal(Producto producto) {
        if (producto == null) {
            System.out.println("No se puede insertar un producto nulo en la lista.");
            return;
        }

        if (existeId(producto.getId())) {
            System.out.println("Ya existe un producto con el ID: " + producto.getId());
            return;
        }

        if (primero == null) {
            setPrimero(producto);
        } else {
            Producto nodoActual = primero;
            while (nodoActual.getSiguiente() != null) {
                nodoActual = nodoActual.getSiguiente();
            }
            nodoActual.setSiguiente(producto);
        }
    }

    public boolean existeId(String idProducto) {
        Producto nodoActual = primero;
        while (nodoActual != null) {
            if (nodoActual.getId().equals(idProducto)) {
                return true;
            }
            nodoActual = nodoActual.getSiguiente();
        }
        return false; 
    }

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

    public double calcularTotal() {
        double total = 0;
        Producto nodoActual = primero;
        while (nodoActual != null) {
            double costoProducto = nodoActual.getCantidad() * nodoActual.getPrecio();
            total += costoProducto;
            nodoActual = nodoActual.getSiguiente();
        }
        return total;
    }

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
            nodoActual.setImagenes(nuevaImagen);
        } else {
            System.out.println("Ingrese un Id de producto correcto");
        }
    }

    public void insertarOAcumular(Producto base, int cantidadExtra) {
        if (base == null || cantidadExtra <= 0) return;

        Producto nodoActual = primero;

        while (nodoActual != null) {
            if (nodoActual.getId().equalsIgnoreCase(base.getId())) {
                nodoActual.setCantidad(nodoActual.getCantidad() + cantidadExtra);
                return;
            }
            nodoActual = nodoActual.getSiguiente();
        }

        Producto copia = new Producto(
                base.getId(),
                base.getNombre(),
                base.getPrecio(),
                base.getCategoria(),
                cantidadExtra,
                base.getListaImagenes()
        );

        insertarProductoFinal(copia);
    }


}
