package src;

import java.util.ArrayList;

public class ColaClientes {

    private final ArrayList<Cliente> colaClientes;

    public ColaClientes() {
        colaClientes = new ArrayList<>();
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

        Cliente seleccionado = colaClientes.remove(indiceMejor);

        System.out.println("\nAtendiendo cliente (prioridad " + mejorPrioridad + "): "
                + seleccionado.getNombre());
        System.out.println("Carrito del cliente:");
        seleccionado.getCarrito().mostrarLista();   // usa tu mostrarLista()
        System.out.println("Total a pagar: " + seleccionado.calcularTotalCarrito());
        System.out.println();

        return seleccionado;
    }
}
