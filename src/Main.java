package src;

import java.util.Scanner;

public class Main {

    private Tienda tienda = new Tienda();
    private Grafo grafo = new Grafo();
    private Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        new Main().run();
    }

    public void run() {

        // =====================================
        // CONFIGURAR COLA PARA USAR GRAFO + TIENDA
        // =====================================
        tienda.getColaClientes().configurarGrafoYTienda(grafo, tienda);

        // =====================================
        // UBICACIÓN DE LA TIENDA (SAN JOSÉ)
        // =====================================
        String ubicacionTienda = "SAN_JOSE";
        tienda.setUbicacion(ubicacionTienda);
        grafo.agregarVertice(ubicacionTienda);

        // =====================================
        // PROVINCIAS (VÉRTICES DEL GRAFO)
        // =====================================
        grafo.agregarVertice("ALAJUELA");
        grafo.agregarVertice("CARTAGO");
        grafo.agregarVertice("HEREDIA");
        grafo.agregarVertice("GUANACASTE");
        grafo.agregarVertice("PUNTARENAS");
        grafo.agregarVertice("LIMON");

        // =====================================
        // CONEXIONES ENTRE PROVINCIAS (ARISTAS)
        // =====================================
        grafo.agregarArista("SAN_JOSE", "ALAJUELA", 20);
        grafo.agregarArista("SAN_JOSE", "CARTAGO", 25);
        grafo.agregarArista("SAN_JOSE", "HEREDIA", 15);

        grafo.agregarArista("ALAJUELA", "HEREDIA", 20);
        grafo.agregarArista("ALAJUELA", "PUNTARENAS", 110);
        grafo.agregarArista("ALAJUELA", "GUANACASTE", 140);

        grafo.agregarArista("CARTAGO", "LIMON", 95);

        grafo.agregarArista("HEREDIA", "LIMON", 165);

        grafo.agregarArista("GUANACASTE", "PUNTARENAS", 80);

        // =====================================
        // PRODUCTOS PRECARGADOS (TIENDA TECNOLÓGICA)
        // =====================================
        tienda.registrarProducto(new Producto("T001", "Laptop Lenovo IdeaPad 3", 285000, "Laptops", 10, null));
        tienda.registrarProducto(new Producto("T002", "Mouse Gamer Logitech G203", 15000, "Perifericos", 40, null));
        tienda.registrarProducto(new Producto("T003", "Teclado Mecánico Redragon K552", 25000, "Perifericos", 25, null));
        tienda.registrarProducto(new Producto("T004", "Monitor Samsung 24 FHD", 85000, "Monitores", 12, null));
        tienda.registrarProducto(new Producto("T005", "Audifonos Sony WH-CH510", 32000, "Audio", 18, null));
        tienda.registrarProducto(new Producto("T006", "Disco SSD Kingston 480GB", 29000, "Almacenamiento", 50, null));

        // =====================================
        // MENU PRINCIPAL
        // =====================================
        int opcion;
        do {
            System.out.println("\n===== MENU PRINCIPAL =====");
            System.out.println("1) Insertar productos al inventario");
            System.out.println("2) Insertar clientes en la cola");
            System.out.println("3) Atender cliente siguiente");
            System.out.println("4) Insertar ubicación (vértice)");
            System.out.println("5) Insertar conexión (arista)");
            System.out.println("6) Mostrar grafo");
            System.out.println("7) Salir");
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
                    insertarVertice();
                    break;

                case 5:
                    insertarArista();
                    break;

                case 6:
                    grafo.mostrarGrafo();
                    break;

                case 7:
                    System.out.println("Bye...");
                    break;

                default:
                    System.out.println("Opción invalida.");
            }

        } while (opcion != 7);
    }


    private void insertarVertice() {
        System.out.print("Nombre de la nueva ubicación: ");
        String nombre = sc.nextLine().toUpperCase();
        grafo.agregarVertice(nombre);
        System.out.println("Ubicación agregada correctamente.\n");
    }

    private void insertarArista() {
        System.out.print("Ubicación origen: ");
        String origen = sc.nextLine().toUpperCase();

        System.out.print("Ubicación destino: ");
        String destino = sc.nextLine().toUpperCase();

        System.out.print("Distancia: ");
        int peso = leerEntero();

        grafo.agregarArista(origen, destino, peso);
        System.out.println("Arista agregada correctamente.\n");
    }

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
        }

        String tipo = switch (opcionTipo) {
            case 1 -> "BASICO";
            case 2 -> "AFILIADO";
            case 3 -> "PREMIUM";
            default -> "BASICO";
        };

        Cliente c = new Cliente(cedula, nombre, tipo);

        System.out.println("Seleccione provincia de entrega:");
        System.out.println("1) San José");
        System.out.println("2) Alajuela");
        System.out.println("3) Cartago");
        System.out.println("4) Heredia");
        System.out.println("5) Guanacaste");
        System.out.println("6) Puntarenas");
        System.out.println("7) Limón");

        System.out.print("Opción provincia: ");
        int opUbi = leerEntero();

        String ubicacion = switch (opUbi) {
            case 1 -> "SAN_JOSE";
            case 2 -> "ALAJUELA";
            case 3 -> "CARTAGO";
            case 4 -> "HEREDIA";
            case 5 -> "GUANACASTE";
            case 6 -> "PUNTARENAS";
            case 7 -> "LIMON";
            default -> "SAN_JOSE";
        };

        c.setUbicacion(ubicacion);
        grafo.agregarVertice(ubicacion);

        tienda.registrarCliente(c);

        System.out.println("Cliente registrado con ubicación: " + ubicacion);
        System.out.println("\n Inventario disponible ");
        tienda.mostrarInventario();

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
            seguir = sc.nextLine().equalsIgnoreCase("s");
        }

        System.out.println("\n Carrito del cliente completado.");
    }


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
