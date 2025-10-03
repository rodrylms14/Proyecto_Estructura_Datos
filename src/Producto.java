package src;

import java.util.ArrayList;

public class Producto {
    
    //Atributos 

    private String nombre;
    private double precio;
    private String categoria;
    private int cantidad;
    private ArrayList<String> listaImagenes;
    private Producto siguiente;

    //Metodos
    //Constructor

    public Producto(String nombreObj, double precioObj, String categoriaObj, int cantidadObj){
        nombre = nombreObj;
        precio = precioObj;
        categoria = categoriaObj;
        cantidad = cantidadObj;
        listaImagenes = new ArrayList<>();
        siguiente = null;
    }

    //Getters 
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
    // Setters
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

    // toString 
    public String toString() {
        return "Producto: " + nombre +
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
