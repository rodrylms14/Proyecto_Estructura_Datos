package src;

public class Cliente {

    private int cedula;
    private String nombre;
    private String tipo;   
    private int prioridad;  

    private Listaproductos carrito; 

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

    public void agregarProductoAlCarrito(Producto p, int cantidadComprada) {

        if (p == null || cantidadComprada <= 0) {
            System.out.println("Datos inválidos.");
            return;
        }

        // Llamamos al método que acumula si ya existe
        carrito.insertarOAcumular(p, cantidadComprada);

        System.out.println("Producto agregado al carrito.");
    }

    public double calcularTotalCarrito() {
        return carrito.calcularTotal();
    }

    @Override
    public String toString() {
        return nombre + " (cédula: " + cedula + ", tipo: " + tipo +
                ", prioridad: " + prioridad + ")";
    }
}
