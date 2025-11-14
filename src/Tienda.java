package src;

public class Tienda {

    private Arbol inventario;   // Árbol binario de búsqueda con Productos
    private ColaClientes colaClientes;   // Cola con prioridad para clientes


    public Tienda() {
        inventario = new Arbol();
        colaClientes = new ColaClientes();
    }


    public Arbol getInventario() {
        return inventario;
    }

    public ColaClientes getColaClientes() {
        return colaClientes;
    }

    public boolean registrarProducto(Producto p) {
        if (p == null) {
            System.out.println("No se puede registrar un producto nulo.");
            return false;
        }
        boolean insertado = inventario.insertar(p);
        return insertado;
    }

    public Producto buscarProducto(String id) {
        NodoArbol nodo = inventario.buscar(id);
        if (nodo == null) return null;
        return nodo.getDato();
    }

    public boolean registrarCliente(Cliente c) {
        if (c == null) {
            System.out.println("Cliente nulo, no se puede registrar.");
            return false;
        }

        colaClientes.encolar(c);
        return true;
    }

    public boolean agregarProductoAlCarrito(Cliente c, String idProducto, int cantidad) {

        if (c == null) {
            System.out.println("Cliente no válido.");
            return false;
        }

        NodoArbol nodo = inventario.buscar(idProducto);
        if (nodo == null) {
            System.out.println("No existe un producto con ese ID.");
            return false;
        }

        Producto productoOriginal = nodo.getDato();

        if (cantidad <= 0) {
            System.out.println("Cantidad inválida.");
            return false;
        }

        if (productoOriginal.getCantidad() < cantidad) {
            System.out.println("Stock insuficiente. Solo hay " + productoOriginal.getCantidad());
            return false;
        }

        productoOriginal.setCantidad(productoOriginal.getCantidad() - cantidad);

        c.agregarProductoAlCarrito(productoOriginal, cantidad);

        System.out.println("Producto agregado al carrito de " + c.getNombre());
        return true;
    }

    public void atenderCliente() {
        Cliente atendido = colaClientes.atenderConPrioridad();
        if (atendido == null) {
            System.out.println("No hay clientes para atender.");
            return;
        }

        System.out.println("Cliente atendido correctamente.");
    }

    public void mostrarInventario() {
        inventario.enOrden(inventario.getRaiz());
    }

    public void mostrarColaClientes() {
        colaClientes.mostrarCola();
    }
}