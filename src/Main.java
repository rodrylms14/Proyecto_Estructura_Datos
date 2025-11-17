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
            System.out.println("\n Menu");
            System.out.println("1) Insertar productos al inventario");
            System.out.println("2) Insertar clientes en la cola");
            System.out.println("3) Atender cliente siguiente");
            System.out.println("4) Salir");
            System.out.print("Seleccione una opcion: ");
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
                    System.out.println("Opción invalida.");
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

        System.out.print("Categoria: ");
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

        System.out.print("Cedula: ");
        int cedula = leerEntero();

        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

    System.out.println("Seleccione el tipo de cliente:");
    System.out.println("1) Basico");
    System.out.println("2) Afiliado");
    System.out.println("3) Premium");

    int opcionTipo = -1;
    while (opcionTipo < 1 || opcionTipo > 3) {
        System.out.print("Opcion (1-3): ");
        opcionTipo = leerEntero();
        if (opcionTipo < 1 || opcionTipo > 3) {
            System.out.println(" Opcion invalida. Por favor ingrese 1, 2 o 3.");
        }
    }

    String tipo;
    switch (opcionTipo) {
        case 1:
            tipo = "BASICO";
            break;
        case 2:
            tipo = "AFILIADO";
            break;
        case 3:
            tipo = "PREMIUM";
            break;
        default:
            tipo = "BASICO"; 
    }


        Cliente c = new Cliente(cedula, nombre, tipo);

        /* Insertar cliente en la cola */
        tienda.registrarCliente(c);

        System.out.println("Cliente registrado con tipo: " + tipo + ".");
        System.out.println("\n Inventario disponible ");
        tienda.mostrarInventario();

        /* Llenar carrito */
        boolean seguir = true;
        while (seguir) {

            System.out.print("\n ID del producto que quiere agregar a su carrito: ");
            String id = sc.nextLine();

            System.out.print("Cantidad: ");
            int cant = leerEntero();

            boolean agregado = tienda.agregarProductoAlCarrito(c, id, cant);

            if (!agregado) {
                System.out.println("Error al agregar el producto. Intente de nuevo.");
            }

            System.out.print("¿Desea agregar otro producto? (s/n): ");
            String r = sc.nextLine().toLowerCase();
            seguir = r.equals("s");
        }

        System.out.println("\n Carrito del cliente completado.");
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
                System.out.print("Ingrese un numero valido: ");
            }
        }
    }

    private double leerDouble() {
        while (true) {
            try {
                return Double.parseDouble(sc.nextLine());
            } catch (Exception e) {
                System.out.print("Ingrese un numero valido: ");
            }
        }
    }
}