

import src.Listaproductos;

public class Main {
    
    public static void main(String[] args) throws Exception{
        
        Listaproductos listaProductos  = new Listaproductos();
        listaProductos.insertarProductoInicio("01","Laptop HP", 350.000, "Computadores", 10);
        listaProductos.insertarProductoInicio("02","Laptop Lenovo", 400.0000, "Computadores", 10);
        listaProductos.insertarProductoFinal("03","Final", 30.000, "Final", 10);
        listaProductos.insertarProductoInicio("04","Laptop Acer", 250.000, "Computadores", 10);
        listaProductos.insertarProductoInicio("05","Mouse Gamer", 25.000, "Mouse", 20);
        listaProductos.insertarProductoInicio("06","Mouse ", 25.000, "Mouse", 20);
        listaProductos.insertarProductoInicio("07","Mouse 254x", 25.000, "Mouse", 20);

        System.out.println("Holaaa");

        listaProductos.modificarLista("09", "Prueba", 235.000, "PC", 8);
        listaProductos.mostrarLista();


    }
}
