

import src.Listaproductos;

public class Main {
    
    public static void main(String[] args) throws Exception{
        
        Listaproductos listaProductos  = new Listaproductos();

        listaProductos.insertarProductoInicio("Laptop HP", 350.000, "Computadores", 10);
        listaProductos.insertarProductoInicio("Laptop Lenovo", 400.0000, "Computadores", 10);
        listaProductos.insertarProductoInicio("Laptop Acer", 250.000, "Computadores", 10);
        listaProductos.insertarProductoInicio("Mouse Gamer", 25.000, "Mouse", 20);
        listaProductos.insertarProductoInicio("Mouse ", 25.000, "Mouse", 20);
        listaProductos.insertarProductoInicio("Mouse 254x", 25.000, "Mouse", 20);

        listaProductos.mostrarLista();

        System.out.println("Holaaa");



    }
}
