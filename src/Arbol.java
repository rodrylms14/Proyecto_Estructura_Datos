package src;

public class Arbol {
    
    //Atributos 
    private NodoArbol raiz;

    //Metodos
    //Constructor
    public Arbol() {
        raiz = null;
    }
    //Getters 
    public NodoArbol getRaiz() {
        return raiz;
    }
    //Setters
    public void setRaiz(NodoArbol nuevaRaiz) {
        raiz = nuevaRaiz;
    }

    public boolean estaVacio() {
        return raiz == null;
    }

    public NodoArbol buscar(String idBuscar) {
        if(estaVacio()) {
            System.out.println("El arbol esta vacio");
            return null;
        }
        NodoArbol nodotemporal = raiz;
        while(nodotemporal != null && !nodotemporal.getDato().getId().equalsIgnoreCase(idBuscar)){
            String idActual = nodotemporal.getDato().getId();

            if (idBuscar.compareToIgnoreCase(idActual) < 0) {
                nodotemporal = nodotemporal.getHijoIzq();
            } else {
                nodotemporal = nodotemporal.getHijoDer();
            }
        }
        if (nodotemporal == null) {
            System.out.println("El prodcuto con ID: " + idBuscar + "no esta en el arbol \n");
            return null;
        }
        return nodotemporal;
    }

    public boolean insertar(Producto nuevoProducto) {
        NodoArbol nuevoNodo = new NodoArbol(nuevoProducto);
        if(estaVacio()) {
            raiz = nuevoNodo;
            return true;
        }
        NodoArbol nodoActual = raiz;
        NodoArbol padreActual;
        String idNuevo = nuevoProducto.getId();
        while (true) { 
            padreActual = nodoActual;

            String idActual = nodoActual.getDato().getId();

            int comparacion = idNuevo.compareToIgnoreCase(idActual);

            if (comparacion < 0 ) {
                nodoActual = nodoActual.getHijoIzq();

                if (nodoActual == null) {
                    padreActual.setHijoIzq(nuevoNodo);
                    return true;
                }
            } else if (comparacion > 0){
                nodoActual = nodoActual.getHijoDer();

                if (nodoActual == null) {
                    padreActual.setHijoDer(nuevoNodo);
                    return true;
                }
            } else {
                System.out.println("Ya existe el producto con ID: " + idNuevo + "no se inserto");
                return false;
            }
        } 
    }

    public boolean actualizarProducto(Producto nuevoProducto) {

    NodoArbol nodo = buscar(nuevoProducto.getId());

    if (nodo == null) {
        System.out.println("No se encontro un producto con el ID '" + nuevoProducto.getId() + "'. No se actualizo nada.");
        return false;
    }

    Producto existente = nodo.getDato();

    existente.setNombre(nuevoProducto.getNombre());
    existente.setPrecio(nuevoProducto.getPrecio());
    existente.setCategoria(nuevoProducto.getCategoria());
    existente.setCantidad(nuevoProducto.getCantidad());
    existente.setImagenes(nuevoProducto.getListaImagenes());

    System.out.println("Producto con ID '" + nuevoProducto.getId() + "' actualizado correctamente.");
    return true;
    }

    

    public void enOrden(NodoArbol raizTemporal) {
        if(raizTemporal != null) {
            enOrden(raizTemporal.getHijoIzq());
            System.out.println(raizTemporal.getDato() + " ");
            enOrden(raizTemporal.getHijoDer());            
        }
    }
    public void preOrden(NodoArbol raizTemporal) {
        if(raizTemporal != null) {
         System.out.println(raizTemporal.getDato() + " ");
        preOrden(raizTemporal.getHijoIzq());
        preOrden(raizTemporal.getHijoDer());
        }
    }
    public void postOrden(NodoArbol raizTemporal) {
        if(raizTemporal != null) {
            postOrden(raizTemporal.getHijoIzq());
            postOrden(raizTemporal.getHijoDer());
            System.out.println(raizTemporal.getDato() + " ");
        }
    }
    private NodoArbol getSucesor(NodoArbol nodoBorrar) {
        NodoArbol padreSucesor = nodoBorrar;
        NodoArbol sucesor = nodoBorrar;
        NodoArbol nodoActual = nodoBorrar.getHijoDer();
        while(nodoActual != null) {
            padreSucesor = sucesor;
            sucesor = nodoActual;
            nodoActual = nodoActual.getHijoIzq();
        }
        if(sucesor != nodoBorrar.getHijoDer()) {
            padreSucesor.setHijoIzq(sucesor.getHijoDer());
            sucesor.setHijoDer(sucesor.getHijoDer());
        }
        return sucesor;
    }

    public boolean borrar(String idBorrar) {
        
        if (estaVacio()) {
            System.out.println("El arbol esta vacio");
            return false;
        }

        NodoArbol nodoActual = raiz;
        NodoArbol padre = raiz;
        boolean esHijoIzq = true;

        while (nodoActual != null && !nodoActual.getDato().getId().equalsIgnoreCase(idBorrar)) {
            padre = nodoActual;

            String idActual = nodoActual.getDato().getId();
            int comparacion = idBorrar.compareToIgnoreCase(idActual);

            if (comparacion < 0) {
                esHijoIzq = true;
                nodoActual = nodoActual.getHijoIzq();
            } else {
                esHijoIzq = false;
                nodoActual = nodoActual.getHijoDer();
            }
        }

            if (nodoActual == null) {
                System.out.println("No se encontro el producto con el ID: " +idBorrar + ".");
                return false;
            }

            if (nodoActual.getHijoIzq() == null && nodoActual.getHijoDer() == null) {
                if (nodoActual == raiz) {
                    raiz = null;
                } else if (esHijoIzq) {
                    padre.setHijoIzq(null);
                } else {
                    padre.setHijoDer(null);
                }
            }

            else if (nodoActual.getHijoIzq() == null) {
                if (nodoActual == raiz) {
                    raiz = nodoActual.getHijoDer();
                } else if (esHijoIzq) {
                    padre.setHijoIzq(nodoActual.getHijoDer());
                } else {
                    padre.setHijoDer(nodoActual.getHijoDer());
                }
            }

            else {
                NodoArbol sucesor = getSucesor(nodoActual);

                if (nodoActual == raiz) {
                    raiz = sucesor;
                } else if (esHijoIzq) {
                    padre.setHijoIzq(sucesor);
                } else {
                    padre.setHijoDer(sucesor);
                }

                sucesor.setHijoIzq(nodoActual.getHijoIzq());
            }
        System.out.println("Producto con ID " +idBorrar + "Borrado");
        return true;
        
    }
}
