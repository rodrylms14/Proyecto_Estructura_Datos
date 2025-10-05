package src;

import java.util.ArrayList;

public class Producto {
    
    //Atributos 
    private String id;
    private String nombre;
    private double precio;
    private String categoria;
    private int cantidad;
    private ArrayList<String> listaImagenes;
    private Producto siguiente;

    //Metodos
    //Constructor

    public Producto(String idObj,String nombreObj, double precioObj, String categoriaObj, int cantidadObj, ArrayList<String> listaImagenesObj){
        id = idObj;
        nombre = nombreObj;
        precio = precioObj;
        categoria = categoriaObj;
        cantidad = cantidadObj;
        listaImagenes = (listaImagenesObj != null) ? listaImagenesObj : new ArrayList<>();        siguiente = null; 
    }

    //Getters 
    public String getId() {
        return id;
    }
    public String getNombre() {
        return nombre;
    }
    public double getPrecio() {
        return precio;
    }
    public String getCategoria() {
        return categoria;
    }
    public int getCantidad() {
        return cantidad;
    }
    public ArrayList<String> getListaImagenes () {
        return listaImagenes;
    }
    
    // Setters
    public void setId(String nuevoId) {
        id = nuevoId;
    }
    public void setNombre(String nuevonombre) {
        nombre = nuevonombre;
    }
    public void setPrecio(double nuevoprecio) {
        precio = nuevoprecio;
    }
    public void setCategoria(String nuevacategoria) {
        categoria = nuevacategoria;
    }
    public void setCantidad(int nuevacantidad) {
        cantidad = nuevacantidad;
    }
    public void setImagenes(ArrayList<String> nuevasImagen){
        listaImagenes = (nuevasImagen != null) ? nuevasImagen : new ArrayList<>();
    }

    public void agregarImagenes(ArrayList<String> rutaImagen) {
        if (rutaImagen == null || rutaImagen.isEmpty()) return;
        if (listaImagenes == null) listaImagenes = new ArrayList<>();
        listaImagenes.addAll(rutaImagen);
    }



    // toString 
    public String toString() {
        return  "Id: " + id +
                "\nProducto: " + nombre +
                "\nPrecio: " + precio +
                "\nCategoria: " + categoria +
                "\nCantidad: " + cantidad;
    }

    public Producto getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Producto Nuevosiguiente) {
        siguiente = Nuevosiguiente;
    }

}
