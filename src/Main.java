package src;

import java.util.Scanner;

public class Main {

    private Tienda tienda = new Tienda();
    private Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        new Main().run();
    }

    public void run() {
        int opcion;
        do {
            System.out.println("\n Menú");
            System.out.println("1) Insertar productos al inventario");
            System.out.println("2) Insertar clientes en la cola");
            System.out.println("3) Atender cliente siguiente");
            System.out.println("4) Salir");
            System.out.print("Seleccione una opción: ");
            opcion = leerEntero();

            switch (opcion) {

                case 1:
                    insertarProductoInventario();
                    break;

                case 2:
                    insertarClienteConCarrito();
                    break;

                case 3:
                    atenderCliente();
                    break;

                case 4:
                    System.out.println("Bye...");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 4);
    }

   /*Insertar producto en inventario*/

    private void insertarProductoInventario() {

        System.out.println("\n Insertar producto al inventario");

        System.out.print("ID del producto: ");
        String id = sc.nextLine();

        System.out.print("Nombre del producto: ");
        String nombre = sc.nextLine();

        System.out.print("Precio: ");
        double precio = leerDouble();

        System.out.print("Categoría: ");
        String categoria = sc.nextLine();

        System.out.print("Cantidad disponible: ");
        int cantidad = leerEntero();

        Producto p = new Producto(id, nombre, precio, categoria, cantidad, null);

        if (tienda.registrarProducto(p)) {
            System.out.println("Producto insertado correctamente en el inventario.");
        } else {
            System.out.println("Error: el producto no pudo registrarse.");
        }
    }

    /*Insertar cliente y llenar su carrito*/

    private void insertarClienteConCarrito() {

        System.out.println("\n Registrar cliente e insertarlo en la cola");

        System.out.print("Cédula: ");
        int cedula = leerEntero();

        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Tipo (BÁSICO/AFILIADO/PREMIUM): ");
        String tipo = sc.nextLine();

        Cliente c = new Cliente(cedula, nombre, tipo);

        /*Insertar cliente en la cola de prioridad*/
        tienda.registrarCliente(c);

        System.out.println("Cliente registrado.");
        System.out.println(" Inventario\n");
        tienda.mostrarInventario();

        /*Llenar carrito*/
        boolean seguir = true;
        while (seguir) {

            System.out.print("\n ID del producto que quiere agregar a su carrito: ");
            String id = sc.nextLine();

            System.out.print("Cantidad: ");
            int cant = leerEntero();

            tienda.agregarProductoAlCarrito(c, id, cant);

            System.out.print("¿Desea agregar otro producto? (s/n): ");
            String r = sc.nextLine().toLowerCase(); /*por si acaso*/
            seguir = r.equals("s");
        }

        System.out.println("Carrito del cliente completado.\n");
    }

    /*Atender cliente siguiente y generar factura*/

    private void atenderCliente() {
        System.out.println("\n Cliente siguiente");
        tienda.atenderCliente();
    }



    private int leerEntero() {
        while (true) {
            try {
                return Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.print("Ingrese un número válido: ");
            }
        }
    }

    private double leerDouble() {
        while (true) {
            try {
                return Double.parseDouble(sc.nextLine());
            } catch (Exception e) {
                System.out.print("Ingrese un número válido: ");
            }
        }
    }
}