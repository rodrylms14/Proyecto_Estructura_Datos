package src;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ColaClientes {

    private final ArrayList<Cliente> colaClientes;

    private Grafo grafo;
    private Tienda tienda;

    public ColaClientes() {
        colaClientes = new ArrayList<>();
    }

    public void configurarGrafoYTienda(Grafo grafo, Tienda tienda) {
        this.grafo = grafo;
        this.tienda = tienda;
    }

    public void encolar(Cliente nuevoCliente) {
        if (nuevoCliente == null) {
            System.out.println("Cliente nulo, no se puede encolar.\n");
            return;
        }

        if (existeCedula(nuevoCliente.getCedula())) {
            System.out.println("Error: Ya existe un cliente con la cédula "
                    + nuevoCliente.getCedula() + ". No se puede insertar el cliente.\n");
            return;
        }

        if (grafo != null && nuevoCliente.getUbicacion() != null && !nuevoCliente.getUbicacion().isEmpty()) {
            grafo.agregarVertice(nuevoCliente.getUbicacion());
            System.out.println("Ubicación '" + nuevoCliente.getUbicacion() + "' registrada en el grafo.\n");
        }

        colaClientes.add(nuevoCliente);
        System.out.println("Cliente agregado correctamente.\n");
    }

    public Cliente desencolar() {
        if (colaClientes.isEmpty()) {
            System.out.println("No se puede remover, la cola está vacía.\n");
            return null;
        }
        return colaClientes.remove(0);
    }

    public boolean estaVacia() {
        return colaClientes.isEmpty();
    }

    public Cliente verSiguiente() {
        if (colaClientes.isEmpty()) {
            System.out.println("La cola está vacía.\n");
            return null;
        }
        return colaClientes.get(0);
    }

    public void mostrarCola() {
        if (colaClientes.isEmpty()) {
            System.out.println("La cola está vacía.\n");
            return;
        }
        System.out.println("=== CLIENTES EN COLA ===");

        for (int i = 0; i < colaClientes.size(); i++) {
            Cliente c = colaClientes.get(i);
            System.out.println(i + " -> " + c);
        }
        System.out.println();
    }

    public void moverClientePorPosicion(int indiceOrigen, int indiceDestino) {
        if (colaClientes.isEmpty()) {
            System.out.println("La cola está vacía.\n");
            return;
        }

        if (indiceOrigen < 0 || indiceOrigen >= colaClientes.size()
                || indiceDestino < 0 || indiceDestino >= colaClientes.size()) {
            System.out.println("Índices inválidos. No se puede mover el cliente.\n");
            return;
        }

        Cliente clienteTemp = colaClientes.get(indiceOrigen);
        colaClientes.remove(indiceOrigen);
        colaClientes.add(indiceDestino, clienteTemp);

        System.out.println("Cliente " + clienteTemp.getNombre()
                + " movido de la posición " + indiceOrigen
                + " a la posición " + indiceDestino + "\n");
    }

    public boolean existeCedula(int cedulaIngresada) {
        for (Cliente c : colaClientes) {
            if (c.getCedula() == cedulaIngresada) {
                return true;
            }
        }
        return false;
    }

    public Cliente atenderConPrioridad() {
        if (colaClientes.isEmpty()) {
            System.out.println("No hay clientes en cola.");
            return null;
        }

        int indiceMejor = 0;
        int mejorPrioridad = colaClientes.get(0).getPrioridad();

        for (int i = 1; i < colaClientes.size(); i++) {
            Cliente actual = colaClientes.get(i);
            int prioridadActual = actual.getPrioridad();

            if (prioridadActual > mejorPrioridad) {
                mejorPrioridad = prioridadActual;
                indiceMejor = i;
            }
        }

        Cliente seleccionado = colaClientes.get(indiceMejor);

        if (grafo != null && tienda != null) {
            String origen = tienda.getUbicacion();
            String destino = seleccionado.getUbicacion();

            if (origen == null || origen.isEmpty() || destino == null || destino.isEmpty()) {
                System.out.println("\n⚠ No se puede calcular ruta: ubicaciones incompletas.\n");
            } else {
                Map<String, Integer> distancias = new HashMap<>();
                Map<String, String> predecesores = new HashMap<>();

                grafo.algoritmoDijkstra(origen, distancias, predecesores);

                List<String> ruta = grafo.reconstruirCamino(origen, destino, predecesores);

                Integer dist = distancias.get(destino);

                if (dist == null || dist == Integer.MAX_VALUE) {
                    System.out.println("\n⚠ No se puede atender al cliente porque su ubicación está desconectada del grafo.\n");
                    return null; 
                }

                System.out.println("\n=== RUTA DE ENTREGA (DIJKSTRA) ===");
                System.out.println("Tienda: " + origen);
                System.out.println("Cliente: " + destino);
                System.out.println("Ruta más corta: " + ruta);
                System.out.println("Distancia total: " + dist + " unidades\n");
            }
        }

        seleccionado = colaClientes.remove(indiceMejor);

        System.out.println("\nAtendiendo cliente (prioridad " + mejorPrioridad + "): "
                + seleccionado.getNombre());
        System.out.println("Carrito del cliente:");
        seleccionado.getCarrito().mostrarLista();
        System.out.println("Total a pagar: " + seleccionado.calcularTotalCarrito());
        System.out.println();

        return seleccionado;
    }

}
