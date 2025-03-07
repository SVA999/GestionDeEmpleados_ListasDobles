import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ListaDoble {

    public Nodo cabeza;
    public Nodo cola;

    public int contadorEmpleados;

    public ListaDoble() {
        this.cabeza = null;
        this.cola = null;
    }

    public String CargarDatos() throws Exception {
        try {
            // Ruta del archivo
            String archivoRuta = "src\\empleadosDB.txt";

            // Leer el archivo y cargar las Empleados
            try (BufferedReader br = new BufferedReader(new FileReader(archivoRuta))) {
                String linea;
                while ((linea = br.readLine()) != null) {
                    // Dividir la línea por el punto y coma
                    String[] partes = linea.split(";");
                    String nombre = partes[0];
                    int salario = Integer.parseInt(partes[1]);

                    // Crear una Empleado y agregarla a la lista
                    this.InsertarEmpleado(new Empleado(nombre, salario));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return "Carga exitosa";

        } catch (Exception e) {
            throw new Exception("Ha ocurrido un error al calcular el costo: " + e);
        }

    }

    // Método que permite insertar nodos al final
    public String InsertarEmpleado(Empleado empleado) throws Exception {
        try {

            Nodo nuevoNodo = new Nodo(empleado);

            if (cabeza == null) {
                cabeza = nuevoNodo;
                cola = nuevoNodo;
                contadorEmpleados++;
                return "Empleado Insertado";
            } else {
                Nodo actual = cabeza;

                while (actual.siguiente != null) {
                    if (actual.empleado.id != empleado.id) {
                        actual = actual.siguiente;
                    } else {
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
            throw new Exception("Error al InsertarEmpleado:\n" + e);
        }

    }

    // Método para buscar un empleado en la lista
    public String BuscarEmpleado(int IdEmpleadoBuscado) throws Exception {

        try {
            // Verificar lista vacia
            if (cabeza == null && cola == null) {
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
            throw new Exception("Error al BuscarEmpleado:\n" + e);
        }
    }

    // Método para eliminar un empleado de la lista
    public String EliminarEmpleado(int IdEmpleadoEliminar) throws Exception {
        try {
            if (cabeza == null && cola == null) {
                return "Lista vacía";
            }
            Nodo actual = cabeza;

            while (actual != null) {
                // Al encontrarlo
                if (actual.empleado.id == IdEmpleadoEliminar) {

                    // Lo encontro en la cabeza
                    if (actual.anterior == null) {
                        cabeza = actual.siguiente;
                    } else {
                        // En otro nodo
                        actual.anterior.siguiente = actual.siguiente;
                    }

                    if (actual.siguiente == null) {
                        // Lo encontro en la cola
                        cola = actual.anterior;
                    } else {
                        actual.siguiente.anterior = actual.anterior;
                    }
                    contadorEmpleados--;
                    return "El empleado " + IdEmpleadoEliminar + " fue eliminado.";
                }
                // Si no lo encuentra pasa al siguiente
                actual = actual.siguiente;

            }
            return "El Id de empleado " + IdEmpleadoEliminar + " no fue encontrado.";
        } catch (Exception e) {
            throw new Exception("Error al EliminarEmpleado:\n" + e);
        }
    }

    // Método para Imprimir la lista
    public String Imprimir() throws Exception {

        try {
            // Verificar lista vacia
            if (cabeza == null && cola == null) {
                return "Lista vacía";
            }

            Nodo actual = cabeza;

            // Imprimir la listaDoble
            String stringLista = "Empleados totales: " + contadorEmpleados;
            while (actual != null) {
                stringLista += ("\n" + actual.empleado.id + " - " + actual.empleado.nombre + " - "
                        + actual.empleado.salario);
                actual = actual.siguiente;
            }
            // stringLista += "NULL";
            return stringLista;

        } catch (Exception e) {
            throw new Exception("Error al Imprimir:\n" + e);
        }
    }

    // Método para mostrar estadísticas de la lista
    public String MostrarCaracteristicas() throws Exception {
        try {
            String reString = "\n";
            if (cabeza == null) {
                return reString;
            }
            reString += "\n\tTotal empleados: " + contadorEmpleados;

            // System.out.println("empleado menor: " + minimo);
            // System.out.println("empleado mayor: " + maximo);
            // System.out.println("Promedio de los empleados: " + promedio);
            return reString;

        } catch (Exception e) {
            throw new Exception("Error al MostrarCaracteristicas:\n" + e);
        }
    }

    // Método para ordenar la lista por nombres de forma ascendente/desendente
    public String OrdenarPorNombre(boolean Asendente) throws Exception {
        try {
            if (cabeza == null || cabeza.siguiente == null) {
                return "Lista vacía o con un solo elemento.";

            }
            Nodo actual;
            boolean intercambiado;
            String temp;

            // Ordenamiento Asendente Defaut
            if (Asendente == true) {
                do {
                    actual = cabeza;
                    intercambiado = false;
                    while (actual.siguiente != null) {
                        // Comparar los nombres completos alfabéticamente
                        if (actual.empleado.nombre.compareTo(actual.siguiente.empleado.nombre) > 0) {
                            // Intercambiar los nombres
                            temp = actual.empleado.nombre;
                            actual.empleado.nombre = actual.siguiente.empleado.nombre;
                            actual.siguiente.empleado.nombre = temp;

                            intercambiado = true;
                        }
                        actual = actual.siguiente;
                    }
                } while (intercambiado); // Repetir si se realizaron intercambios

                return "Lista ordenada en forma ascendente\n";

            } else { // Ordenamiento Descendente
                do {
                    actual = cabeza;
                    intercambiado = false;
                    while (actual.siguiente != null) {
                        // Comparar los nombres completos alfabéticamente
                        if (actual.empleado.nombre.compareTo(actual.siguiente.empleado.nombre) < 0) {
                            // Intercambiar los nombres
                            temp = actual.empleado.nombre;
                            actual.empleado.nombre = actual.siguiente.empleado.nombre;
                            actual.siguiente.empleado.nombre = temp;

                            /*
                            // Intercambiar las conexiones de los nodos en la lista doblemente enlazada
                            Nodo siguienteNodo = actual.siguiente;
                            Nodo nodoAnterior = actual.anterior;

                            // Actualizar las referencias de los nodos adyacentes
                            if (nodoAnterior != null) {
                                nodoAnterior.siguiente = siguienteNodo;
                            }
                            if (siguienteNodo.siguiente != null) {
                                siguienteNodo.siguiente.anterior = actual;
                            }

                            // Intercambiar los punteros "anterior" y "siguiente"
                            actual.siguiente = siguienteNodo.siguiente;
                            siguienteNodo.anterior = actual.anterior;
                            actual.anterior = siguienteNodo;
                            siguienteNodo.siguiente = actual;
                            */

                            intercambiado = true;
                        }
                        actual = actual.siguiente;
                    }
                } while (intercambiado); // Repetir si se realizaron intercambios

                return "Lista ordenada en forma descendente\n";
            }

        } catch (Exception e) {
            throw new Exception("Error al OrdenarPorNombre:\n" + e);
        }
    }

    // Método para ordenar la lista por salario en forma ascendente/desendente
    public String OrdenarPorSalario(boolean Asendente) throws Exception {
        try {
            if (cabeza == null || cabeza.siguiente == null) {
                return "Lista vacía o con un solo elemento.";

            }
            Nodo actual;
            boolean intercambiado;
            float temp;

            // Ordenamiento Asendente Defaut
            if (Asendente == true) {
                do {
                    actual = cabeza;
                    intercambiado = false;
                    while (actual.siguiente != null) {
                        // Comparar los salarios
                        if (actual.empleado.salario > actual.siguiente.empleado.salario) {
                            // Intercambiar los salarios
                            temp = actual.empleado.salario;
                            actual.empleado.salario = actual.siguiente.empleado.salario;
                            actual.siguiente.empleado.salario = temp;

                            intercambiado = true;
                        }
                        actual = actual.siguiente;
                    }
                } while (intercambiado); // Repetir si se realizaron intercambios

                return "Lista ordenada en forma ascendente\n";

            } else { // Ordenamiento Descendente
                do {
                    actual = cola;
                    intercambiado = false;
                    while (actual.siguiente != null) {
                        // Comparar los salarios
                        if (actual.empleado.salario < actual.siguiente.empleado.salario) {
                            // Intercambiar los salarios
                            temp = actual.empleado.salario;
                            actual.empleado.salario = actual.siguiente.empleado.salario;
                            actual.siguiente.empleado.salario = temp;

                            intercambiado = true;
                        }
                        actual = actual.siguiente;
                    }
                } while (intercambiado); // Repetir si se realizaron intercambios

                return "Lista ordenada en forma descendente\n";
            }

        } catch (Exception e) {
            throw new Exception("Error al MostrarCaracteristicas:\n" + e);
        }
    }

    /*
     * public int encontrarMaximo() {
     * if (cabeza == null) {
     * return Integer.MIN_VALUE; // Lista vacía
     * }
     * Nodo actual = cabeza;
     * int maximo = cabeza.empleado;
     * while (actual != null) {
     * if (actual.empleado > maximo) {
     * maximo = actual.empleado;
     * }
     * actual = actual.siguiente;
     * }
     * return maximo;
     * }
     * 
     * public int encontrarMinimo() {
     * if (cabeza == null) {
     * return Integer.MAX_VALUE; // Lista vacía
     * }
     * Nodo actual = cabeza;
     * int minimo = cabeza.empleado;
     * while (actual != null) {
     * if (actual.empleado < minimo) {
     * minimo = actual.empleado;
     * }
     * actual = actual.siguiente;
     * }
     * return minimo;
     * }
     * 
     * public String calcularSuma() {
     * try {
     * if (cabeza == null) {
     * return "Lista vacía.";
     * }
     * 
     * int total = 0;
     * Nodo actual = cabeza;
     * while (actual != null) {
     * total += actual.empleado;
     * actual = actual.siguiente;
     * }
     * 
     * return "La suma de los empleados es: " + total;
     * 
     * } catch (Exception e) {
     * throw new IllegalArgumentException("Error en empleados: " + e);
     * }
     * }
     * 
     * public String calcularProducto() {
     * try {
     * if (cabeza == null) {
     * return "Lista vacía.";
     * }
     * 
     * int total = 1;
     * Nodo actual = cabeza;
     * while (actual != null) {
     * if (actual.empleado == 0) {
     * actual = actual.siguiente;
     * } else {
     * total = total * actual.empleado;
     * actual = actual.siguiente;
     * }
     * }
     * return "El producto de los empleados es: " + total;
     * 
     * } catch (Exception e) {
     * throw new IllegalArgumentException("Error en empleados: " + e);
     * }
     * }
     * 
     * public String calcularRango() {
     * try {
     * if (cabeza == null) {
     * return "Lista vacía.";
     * }
     * int rango=0;
     * rango = encontrarMinimo() - encontrarMaximo();
     * 
     * return "El rango es: " + rango;
     * 
     * } catch (Exception e) {
     * throw new IllegalArgumentException("Error en empleados: " + e);
     * }
     * }
     */
}
