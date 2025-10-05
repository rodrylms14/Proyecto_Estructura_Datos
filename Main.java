import java.util.ArrayList;
import java.util.Scanner;
import src.*;

public class Main {

    public static void main(String[] args) {
        menu();
    }

    /* 6 Productos cargados por default con numero de id del 01- al 06, se pueden agregar mas productos con diferente ID , tanto al inicio como al final */

    public static void menu() {
        Scanner sc = new Scanner(System.in);
        Listaproductos lista = new Listaproductos();

        datosDefault(lista);

        int opcion;
        int opc;

        do {
            System.out.println("\n===== MENU DE GESTION DE INVENTARIO =====");
            System.out.println("1. Agregar producto");
            System.out.println("2. Mostrar productos");
            System.out.println("3. Modificar producto");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); 

            switch(opcion) {
                case 1:
                do { 
                    System.out.println("Donde desea insertar el producto");
                    System.out.println("1. Inicio.");
                    System.out.println("2. Final.");
                    opc = sc.nextInt();
                    sc.nextLine();
                    
                    if(opc != 1 && opc != 2){
                        System.out.println("Opcion invalida , ingrese 1 o 2");
                    }
                    } while(opc != 1 && opc != 2);

                    System.out.print("Ingrese el ID del producto: ");
                    String id = sc.nextLine();
                    if(lista.existeId(id)) {
                        System.out.println("Ya existe un producto con el ID: " + id );
                        break;
                    }
                    System.out.print("Ingrese el nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Ingrese el precio: ");
                    double precio = sc.nextDouble();
                    sc.nextLine();
                    System.out.print("Ingrese la categorea: ");
                    String categoria = sc.nextLine();
                    System.out.print("Ingrese la cantidad: ");
                    int cantidad = sc.nextInt();
                    sc.nextLine();

                    // añadir imagen 
                    ArrayList<String> imagenes = new ArrayList<>();
                    System.out.print("Ingrese la ruta de la imagen (ej: src/images/laptop.jpg): ");
                    String ruta = sc.nextLine();
                    imagenes.add(ruta);

                    if(opc == 1){
                        lista.insertarProductoInicio(id, nombre, precio, categoria, cantidad, imagenes);
                        System.out.println("Producto agregado con exito al Inicio.");
                    } else {
                        lista.insertarProductoFinal(ruta, nombre, precio, categoria, cantidad, imagenes);
                         System.out.println("Producto agregado con exito al Final.");
                    }

                    break;

                case 2:
                    lista.mostrarLista();
                    break;

                case 3:
                    System.out.print("Ingrese el ID del producto a modificar: ");
                    String idBuscar = sc.nextLine();
                    System.out.print("Nuevo nombre: ");
                    String nuevoNombre = sc.nextLine();
                    System.out.print("Nuevo precio: ");
                    double nuevoPrecio = sc.nextDouble();
                    sc.nextLine();
                    System.out.print("Nueva categoria: ");
                    String nuevaCategoria = sc.nextLine();
                    System.out.print("Nueva cantidad: ");
                    int nuevaCantidad = sc.nextInt();
                    sc.nextLine();

                    // nueva imagen
                    ArrayList<String> nuevaImagen = new ArrayList<>();
                    System.out.print("Ingrese nueva ruta de imagen (o deje vacio para mantener): ");
                    String nuevaRuta = sc.nextLine();
                    if (!nuevaRuta.isBlank()) {
                        nuevaImagen.add(nuevaRuta);
                    }

                    lista.modificarLista(idBuscar, nuevoNombre, nuevoPrecio, nuevaCategoria, nuevaCantidad, nuevaImagen);
                    System.out.println("Producto modificado correctamente.");
                    break;

                case 4:
                    System.out.println("Hasta luego");
                    break;

                default:
                    System.out.println("Opción no valida, intente nuevamente.");
            }

        } while(opcion != 4);

        sc.close();
    }

    public static void datosDefault(Listaproductos lista) {

        //Productos cargados //

        ArrayList<String> img1 = new ArrayList<>();
        img1.add("src/images/laptop.jpg");
        lista.insertarProductoInicio("01", "Laptop", 550000, "Computadores", 10, img1);

        ArrayList<String> img2 = new ArrayList<>();
        img2.add("src/images/mouse.jpg");
        lista.insertarProductoInicio("02", "Mouse", 15000, "Mouse's", 10, img2);

        ArrayList<String> img3 = new ArrayList<>();
        img3.add("src/images/teclado.jpg");
        lista.insertarProductoInicio("03", "Teclado", 35000, "Teclados", 10, img3);

        ArrayList<String> img4 = new ArrayList<>();
        img4.add("src/images/monitor.jpg");
        lista.insertarProductoInicio("04", "Monitor", 95000, "Monitores", 10, img4);

        ArrayList<String> img5 = new ArrayList<>();
        img5.add("src/images/audifonos.jpg");
        lista.insertarProductoInicio("05", "Audífonos", 45000, "Audifonos", 10, img5);

        ArrayList<String> img6 = new ArrayList<>();
        img6.add("src/images/celular.jpg");
        lista.insertarProductoInicio("06", "Celular", 240000, "Telefonos", 10, img6);
    }
}
