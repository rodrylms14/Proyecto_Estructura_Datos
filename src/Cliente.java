package src;

public class Cliente {

    private int cedula;
    private String nombre;
    private String tipo;     // "BÁSICO", "AFILIADO", "PREMIUM"
    private int prioridad;   // 1 = básico, 2 = afiliado, 3 = premium

    private Listaproductos carrito; // tu lista de productos

    public Cliente(int cedula, String nombre, String tipo) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.tipo = tipo.toUpperCase().trim();
        this.prioridad = calcularPrioridadPorTipo(this.tipo);
        this.carrito = new Listaproductos();
    }

    public Cliente(int cedula, String nombre, String tipo, int prioridad) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.tipo = tipo;
        this.prioridad = prioridad;
        this.carrito = new Listaproductos();
    }

    // Getters
    public int getCedula() { return cedula; }
    public String getNombre() { return nombre; }
    public String getTipo() { return tipo; }
    public int getPrioridad() { return prioridad; }
    public Listaproductos getCarrito() { return carrito; }

    // Setters
    public void setPrioridad(int prioridad) { this.prioridad = prioridad; }

    public void setTipo(String tipo) {
        this.tipo = tipo;
        this.prioridad = calcularPrioridadPorTipo(tipo);
    }

    private int calcularPrioridadPorTipo(String tipo) {
        if (tipo == null) return 1;
        String t = tipo.toUpperCase().trim();
        switch (t) {
            case "PREMIUM":  return 3;
            case "AFILIADO": return 2;
            case "BASICO":
            case "BÁSICO":
            default:         return 1;
        }
    }

    // ➊ Agregar Producto al carrito (usando tu Listaproductos)
    // Aquí sería ideal que antes de llamar a este método le preguntes al usuario cuántas unidades quiere.
    public void agregarProductoAlCarrito(Producto p, int cantidadComprada) {
        if (p == null) {
            System.out.println("No se puede agregar un producto nulo al carrito.");
            return;
        }

        // Creamos una copia del producto SOLO para el carrito,
        // para no modificar el stock original del inventario.
        Producto copia = new Producto(
                p.getId(),
                p.getNombre(),
                p.getPrecio(),
                p.getCategoria(),
                cantidadComprada,
                p.getListaImagenes()
        );

        carrito.insertarProductoFinal(copia); // usando la nueva sobrecarga
    }

    // ➋ Calcular el total del carrito usando Listaproductos.calcularTotal()
    public double calcularTotalCarrito() {
        return carrito.calcularTotal();
    }

    @Override
    public String toString() {
        return nombre + " (cédula: " + cedula + ", tipo: " + tipo +
                ", prioridad: " + prioridad + ")";
    }
}
