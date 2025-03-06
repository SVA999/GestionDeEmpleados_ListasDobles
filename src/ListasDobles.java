import java.util.HashMap;


public class ListasDobles {
    
    private Nodo cabeza;

    public ListasDobles() {
        this.cabeza = null;
    }

    // Método para insertar un nodo al final de la lista
    public void insertar(int dato) {
        Nodo nuevoNodo = new Nodo(dato);
        if (cabeza == null) {
            cabeza = nuevoNodo;
        } else {
            Nodo actual = cabeza;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevoNodo;
        }
    }

    // Método para imprimir la lista y la frecuencia de cada dato
    public void imprimir() {
        if (cabeza == null) {
            System.out.println("\tLista vacía.");
            return;
        }
        HashMap<Integer, Integer> frecuencia = new HashMap<>();
        Nodo actual = cabeza;
        // Contar la frecuencia de cada dato
        while (actual != null) {
            int dato = actual.dato;
            frecuencia.put(dato, frecuencia.getOrDefault(dato, 0) + 1);
            actual = actual.siguiente;
        }
        // Imprimir la lista y la frecuencia
        actual = cabeza;
        String stringLista = "";
        while (actual != null) {
            stringLista += ("|" + actual.dato + "|->");
            actual = actual.siguiente;
        }
        System.out.print(stringLista + "NULL");
        System.out.println(); // Salto de línea después de imprimir la lista
        // Imprimir la frecuencia de cada dato
        System.out.println("Frecuencia de cada dato:");
        for (int dato : frecuencia.keySet()) {
            System.out.println(dato + ": " + frecuencia.get(dato));
        }
    }

    // Método para ordenar la lista en forma ascendente
    public void ordenarAscendente() {
        if (cabeza == null || cabeza.siguiente == null) {
            System.out.println("Lista vacía o con un solo elemento.");
            return;
        }
        boolean intercambio;
        do {
            intercambio = false;
            Nodo actual = cabeza;
            Nodo anterior = null;
            Nodo siguiente = cabeza.siguiente;
            while (siguiente != null) {
                if (actual.dato > siguiente.dato) {
                    if (anterior == null) {
                        cabeza = siguiente;
                    } else {
                        anterior.siguiente = siguiente;
                    }
                    actual.siguiente = siguiente.siguiente;
                    siguiente.siguiente = actual;
                    intercambio = true;
                }
                anterior = actual;
                actual = siguiente;
                siguiente = siguiente.siguiente;
            }
        } while (intercambio);
        System.out.println("Lista ordenada en forma ascendente:");
        imprimir(); // Llamada a imprimir para mostrar la lista ordenada
    }

    // Método para ordenar la lista en forma descendente
    public void ordenarDescendente() {
        if (cabeza == null || cabeza.siguiente == null) {
            System.out.println("Lista vacía o con un solo elemento.");
            return;
        }
        boolean intercambio;
        do {
            intercambio = false;
            Nodo actual = cabeza;
            Nodo anterior = null;
            Nodo siguiente = cabeza.siguiente;
            while (siguiente != null) {
                if (actual.dato < siguiente.dato) {
                    if (anterior == null) {
                        cabeza = siguiente;
                    } else {
                        anterior.siguiente = siguiente;
                    }
                    actual.siguiente = siguiente.siguiente;
                    siguiente.siguiente = actual;
                    intercambio = true;
                }
                anterior = actual;
                actual = siguiente;
                siguiente = siguiente.siguiente;
            }
        } while (intercambio);
        System.out.println("Lista ordenada en forma descendente:");
        imprimir(); // Llamada a imprimir para mostrar la lista ordenada

    }

// Método para mostrar estadísticas de la lista
    public void mostrarCaracteristicas() {
        if (cabeza == null) {
            System.out.println("Lista vacía.");
            return;
        }
        int contador = 0;
        int suma = 0;
        int minimo = cabeza.dato;
        int maximo = cabeza.dato;
        Nodo actual = cabeza;
        while (actual != null) {
            contador++;
            suma += actual.dato;
            if (actual.dato < minimo) {
                minimo = actual.dato;
            }
            if (actual.dato > maximo) {
                maximo = actual.dato;
            }
            actual = actual.siguiente;
        }
        double promedio = (double) suma / contador;
        System.out.println("Número de datos ingresados: " + contador);
        System.out.println("Dato menor: " + minimo);
        System.out.println("Dato mayor: " + maximo);
        System.out.println("Promedio de los datos: " + promedio);
    }

// Método para buscar un dato en la lista
    public void buscarDato(int datoBuscado) {
        if (cabeza == null) {
            System.out.println("Lista vacía.");
            return;
        }
        int contador = 0;
        Nodo actual = cabeza;
        while (actual != null) {
            if (actual.dato == datoBuscado) {
                contador++;
            }
            actual = actual.siguiente;
        }
        if (contador > 0) {
            System.out.println("El dato " + datoBuscado + " fue encontrado " + contador + " veces.");
        } else {
            System.out.println("El dato " + datoBuscado + " no fue encontrado.");
        }
    }

    // Método para eliminar un dato de la lista
    public void eliminarDato(int datoEliminar) {
        if (cabeza == null) {
            System.out.println("Lista vacía.");
            return;
        }
        if (cabeza.dato == datoEliminar) {
            cabeza = cabeza.siguiente;
            System.out.println("El dato " + datoEliminar + " fue eliminado.");
            return;
        }
        Nodo actual = cabeza;
        Nodo anterior = null;
        while (actual != null && actual.dato != datoEliminar) {
            anterior = actual;
            actual = actual.siguiente;
        }
        if (actual == null) {
            System.out.println("El dato " + datoEliminar + " no fue encontrado.");
        } else {
            anterior.siguiente = actual.siguiente;
            System.out.println("El dato " + datoEliminar + " fue eliminado.");
        }
    }

    public int encontrarMaximo() {
        if (cabeza == null) {
            return Integer.MIN_VALUE; // Lista vacía
        }
        Nodo actual = cabeza;
        int maximo = cabeza.dato;
        while (actual != null) {
            if (actual.dato > maximo) {
                maximo = actual.dato;
            }
            actual = actual.siguiente;
        }
        return maximo;
    }

    public int encontrarMinimo() {
        if (cabeza == null) {
            return Integer.MAX_VALUE; // Lista vacía
        }
        Nodo actual = cabeza;
        int minimo = cabeza.dato;
        while (actual != null) {
            if (actual.dato < minimo) {
                minimo = actual.dato;
            }
            actual = actual.siguiente;
        }
        return minimo;
    }

    public String calcularSuma() {
        try {
            if (cabeza == null) {
                return "Lista vacía.";
            }

            int total = 0;
            Nodo actual = cabeza;
            while (actual != null) {
                total += actual.dato;
                actual = actual.siguiente;
            }

            return "La suma de los datos es: " + total;

        } catch (Exception e) {
            throw new IllegalArgumentException("Error en datos: " + e);
        }
    }

    public String calcularProducto() {
        try {
            if (cabeza == null) {
                return "Lista vacía.";
            }

            int total = 1;
            Nodo actual = cabeza;
            while (actual != null) {
                if (actual.dato == 0) {
                    actual = actual.siguiente;
                } else {
                    total = total * actual.dato;
                    actual = actual.siguiente;
                }
            }
            return "El producto de los datos es: " + total;

        } catch (Exception e) {
            throw new IllegalArgumentException("Error en datos: " + e);
        }
    }

    public String calcularRango() {
        try {
            if (cabeza == null) {
                return "Lista vacía.";
            }
            int rango=0;
            rango = encontrarMinimo() - encontrarMaximo();
        
            return "El rango es: " + rango;

        } catch (Exception e) {
            throw new IllegalArgumentException("Error en datos: " + e);
        }
    }

}
