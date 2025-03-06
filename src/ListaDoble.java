public class ListaDoble {

    public Nodo cabeza;
    public Nodo cola;

    public int contadorEmpleados;

    public ListaDoble() {
        this.cabeza = null;
        this.cola = null;
    }

    // Método que permite insertar nodos al final
    public String InsertarEmpleado(Empleado empleado) {
        try {

            Nodo nuevoNodo = new Nodo(empleado);

            if (cabeza == null) {
                cabeza = nuevoNodo;
                cola= nuevoNodo;
                contadorEmpleados++;
                return "Empleado Insertado";
            } else {
                Nodo actual = cabeza;
                
                while (actual.siguiente != null) {
                    if (actual.empleado.id != empleado.id) {
                        actual = actual.siguiente;
                    } else{
                        return "El Empleado ya existe";
                    }                                    
                }

                cola.siguiente = nuevoNodo;
                nuevoNodo.anterior = cola;
                cola = nuevoNodo;
                contadorEmpleados++;
                return "Empleado insertado exitosamente";
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("Error al InsertarEmpleado:\n" + e);
        }

    }

    // Método para buscar un empleado en la lista
    public String BuscarEmpleado(int IdEmpleadoBuscado) {

        try {
            // Verificar lista vacia
            if (cabeza == null && cola ==null) {
                return "Lista vacía";
            }

            Nodo actual = cabeza;

            while (actual != null) {
                if (actual.empleado.id == IdEmpleadoBuscado) {
                    return "Empleado encontrado\n\tID: " + actual.empleado.id 
                    + "\n\tNombre: " + actual.empleado.nombre 
                    + "\n\tSalario: " + actual.empleado.salario;
                }
                actual = actual.siguiente;
            }
            return "El Id del empleado " + IdEmpleadoBuscado + " no fue encontrado.";

        } catch (Exception e) {
            throw new IllegalArgumentException("Error al BuscarEmpleado:\n" + e);
        }
    }

    
    // Método para eliminar un empleado de la lista
    public String EliminarEmpleado(int IdEmpleadoEliminar) {
        try {
            if (cabeza == null && cola ==null) {
                return "Lista vacía";
            } 
            Nodo actual = cabeza;
    
            while (actual != null) {
                //Al encontrarlo
                if (actual.empleado.id == IdEmpleadoEliminar) {
                    
                    //Lo encontro en la cabeza
                    if (actual.anterior == null) {
                        cabeza = actual.siguiente;                        
                    } else{
                        //En otro nodo
                        actual.anterior.siguiente = actual.siguiente;
                    }
    
                    if (actual.siguiente == null) {
                        //Lo encontro en la cola
                        cola = actual.anterior;
                    } else {
                        actual.siguiente.anterior = actual.anterior;
                    }
                    contadorEmpleados--;      
                    return "El empleado " + IdEmpleadoEliminar + " fue eliminado.";                        
                } 
                //Si no lo encuentra pasa al siguiente
                actual = actual.siguiente;
            
            }
            return "El Id de empleado " + IdEmpleadoEliminar + " no fue encontrado.";  
        } catch (Exception e) {
            throw new IllegalArgumentException("Error al EliminarEmpleado:\n" + e);
        }
    }

    // Método para imprimir la lista
    public String Imprimir() {

        try {
            // Verificar lista vacia
            if (cabeza == null && cola ==null) {
                return "Lista vacía";
            }

            Nodo actual = cabeza;

            // Imprimir la listaDoble
            String stringLista = "Empleados totales: "+contadorEmpleados;
            while (actual != null) {
                stringLista += ("\n"+actual.empleado.id+" - "+actual.empleado.nombre+" - "+actual.empleado.salario);
                actual = actual.siguiente;
            }
            //stringLista += "NULL";
            return stringLista;

        } catch (Exception e) {
            throw new IllegalArgumentException("Error al Imprimir:\n" + e);
        }
    }

// Método para mostrar estadísticas de la lista
public String MostrarCaracteristicas() {
    String reString="\n";
    if (cabeza == null) {
        return reString;
    }
    reString += "\n\tTotal empleados: "+contadorEmpleados;

    //System.out.println("empleado menor: " + minimo);
    //System.out.println("empleado mayor: " + maximo);
    //System.out.println("Promedio de los empleados: " + promedio);
    return reString;
}

/*
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
                if (actual.empleado > siguiente.empleado) {
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
                if (actual.empleado < siguiente.empleado) {
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

    public int encontrarMaximo() {
        if (cabeza == null) {
            return Integer.MIN_VALUE; // Lista vacía
        }
        Nodo actual = cabeza;
        int maximo = cabeza.empleado;
        while (actual != null) {
            if (actual.empleado > maximo) {
                maximo = actual.empleado;
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
        int minimo = cabeza.empleado;
        while (actual != null) {
            if (actual.empleado < minimo) {
                minimo = actual.empleado;
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
                total += actual.empleado;
                actual = actual.siguiente;
            }

            return "La suma de los empleados es: " + total;

        } catch (Exception e) {
            throw new IllegalArgumentException("Error en empleados: " + e);
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
                if (actual.empleado == 0) {
                    actual = actual.siguiente;
                } else {
                    total = total * actual.empleado;
                    actual = actual.siguiente;
                }
            }
            return "El producto de los empleados es: " + total;

        } catch (Exception e) {
            throw new IllegalArgumentException("Error en empleados: " + e);
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
            throw new IllegalArgumentException("Error en empleados: " + e);
        }
    }
*/
}
