import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

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
                    String nombre = partes[0].toUpperCase();
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
            String reString = "";
            if (cabeza == null) {
                return reString;
            }
            reString += "\n|----- Estadisticas -----|\n";
            reString += "\n\tTotal empleados: " + contadorEmpleados;
            reString += "\n\t" + calcular_promedio_salario();
            reString += "\n\t" + encontrar_salario_maximo(true);
            reString += "\n\t" + encontrar_salario_minimo(true);
            reString += "\n\t" + obtener_mediana_salario();

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
            Empleado temp;

            // Ordenamiento Asendente Defaut
            if (Asendente == true) {
                do {
                    actual = cabeza;
                    intercambiado = false;
                    while (actual.siguiente != null) {
                        // Comparar los nombres completos alfabéticamente
                        if (actual.empleado.nombre.compareTo(actual.siguiente.empleado.nombre) > 0) {
                            // Intercambiar los nombres
                            temp = actual.empleado;
                            actual.empleado = actual.siguiente.empleado;
                            actual.siguiente.empleado = temp;

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
                            // Intercambiar los nombres
                            temp = actual.empleado;
                            actual.empleado = actual.siguiente.empleado;
                            actual.siguiente.empleado = temp;

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
            Empleado temp;

            // Ordenamiento Asendente Defaut
            if (Asendente == true) {
                do {
                    actual = cabeza;
                    intercambiado = false;
                    while (actual.siguiente != null) {
                        // Comparar los salarios
                        if (actual.empleado.salario > actual.siguiente.empleado.salario) {
                            // Intercambiar los salarios
                            temp = actual.empleado;
                            actual.empleado = actual.siguiente.empleado;
                            actual.siguiente.empleado = temp;

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
                        // Comparar los salarios
                        if (actual.empleado.salario < actual.siguiente.empleado.salario) {
                            // Intercambiar los salarios
                            temp = actual.empleado;
                            actual.empleado = actual.siguiente.empleado;
                            actual.siguiente.empleado = temp;

                            intercambiado = true;
                        }
                        actual = actual.siguiente;
                    }
                } while (intercambiado); // Repetir si se realizaron intercambios

                return "Lista ordenada en forma descendente\n";
            }

        } catch (Exception e) {
            throw new Exception("Error al OrdenarPorSalario:\n" + e);
        }
    }

    // Sobrecarga de orden ascendente para mostrar caracteristicas
    public ListaDoble OrdenarPorSalario() throws Exception {
        try {

            ListaDoble listaDoble = new ListaDoble();

            // Crear una lista copia para no mutar la original
            Nodo actual = this.cabeza;

            while (actual != null) {
                listaDoble.InsertarEmpleado(actual.empleado);
                actual = actual.siguiente;
            }

            if (listaDoble.cabeza == null || listaDoble.cabeza.siguiente == null) {
                return listaDoble;
            }

            boolean intercambiado;
            Empleado temp;

            // Ordenamiento Asendente Defaut
            do {
                actual = listaDoble.cabeza;
                intercambiado = false;
                while (actual.siguiente != null) {
                    // Comparar los salarios
                    if (actual.empleado.salario > actual.siguiente.empleado.salario) {
                        // Intercambiar los salarios
                        temp = actual.empleado;
                        actual.empleado = actual.siguiente.empleado;
                        actual.siguiente.empleado = temp;

                        intercambiado = true;
                    }
                    actual = actual.siguiente;
                }
            } while (intercambiado); // Repetir si se realizaron intercambios

            return listaDoble;

        } catch (Exception e) {
            throw new Exception("Error al OrdenarPorSalario:\n" + e);
        }
    }

    public String calcular_promedio_salario() throws Exception {

        try {
            // Verificar si la lista está vacía
            if (cabeza == null) {
                return "Lista vacía."; // Lanzar excepción si no hay empleados
            }

            double sumaSalarios = 0; // Variable para almacenar la suma de todos los salarios
            Nodo actual = cabeza; // Puntero para recorrer la lista, comenzando desde la cabeza

            // Recorrer la lista sumando los salarios de cada empleado
            while (actual != null) {

                sumaSalarios += actual.empleado.salario; // Sumar el salario del empleado actual
                actual = actual.siguiente; // Avanzar al siguiente nodo
            }

            // Calcular y retornar el promedio (suma de salarios / número de empleados)
            return "Salario promedio: " + sumaSalarios / contadorEmpleados;

        } catch (Exception e) {
            // Manejar excepciones y lanzar un mensaje de error personalizado
            throw new Exception("Error al calcular el promedio de salarios: " + e);
        }
    }

    public String encontrar_salario_maximo() throws Exception {
        try {
            // Verificar si la lista está vacía
            if (cabeza == null) {
                return "Lista vacía."; // Lanzar excepción si no hay empleados
            }

            float maximo = cabeza.empleado.salario; // Inicializar con el salario del primer empleado
            Nodo actual = cabeza; // Puntero para recorrer la lista, comenzando desde la cabeza
            Nodo maxEmpleado = cabeza; // Guardará el nodo con el salario máximo

            // Recorrer la lista para encontrar el salario máximo
            while (actual != null) {
                if (actual.empleado.salario > maximo) {
                    maximo = actual.empleado.salario; // Actualizar el salario máximo si se encuentra uno mayor
                    maxEmpleado = actual; // Guardar el nodo con el salario máximo
                }
                actual = actual.siguiente; // Avanzar al siguiente nodo
            }

            // Retornar el salario máximo encontrado
            return "El empleado con el salario más alto es: " + "\nNombre: " + maxEmpleado.empleado.nombre + "\n" +
                    "Salario: " + maximo;

        } catch (Exception e) {
            // Manejar excepciones y lanzar un mensaje de error personalizado
            throw new Exception("Error al encontrar el salario máximo: " + e);
        }
    }

    // Sobrecarga de Salario Max para mostrar estadisticas
    public String encontrar_salario_maximo(boolean dummy) throws Exception {
        try {

            if (cabeza == null) {
                return "";
            }
            float maximo = cabeza.empleado.salario;
            Nodo actual = cabeza;
            // Recorrer la lista para encontrar el salario máximo
            while (actual != null) {
                if (actual.empleado.salario > maximo) {
                    maximo = actual.empleado.salario;
                }
                actual = actual.siguiente;
            }
            // Retornar el salario máximo encontrado
            return "Salario maximo: " + maximo;

        } catch (Exception e) {
            // Manejar excepciones y lanzar un mensaje de error personalizado
            throw new Exception("Error al encontrar el salario máximo en Mostrar estadisticas: " + e);
        }
    }

    public String encontrar_salario_minimo() throws Exception {
        try {
            // Verificar si la lista está vacía
            if (cabeza == null) {
                return "Lista vacía."; // Lanzar excepción si no hay empleados
            }

            float minimo = cabeza.empleado.salario; // Inicializar con el salario del primer empleado
            Nodo actual = cabeza; // Puntero para recorrer la lista, comenzando desde la cabeza
            Nodo minEmpleado = cabeza; // Guardará el nodo con el salario máximo

            // Recorrer la lista para encontrar el salario mínimo
            while (actual != null) {
                if (actual.empleado.salario < minimo) {
                    minimo = actual.empleado.salario; // Actualizar el salario mínimo si se encuentra uno menor
                    minEmpleado = actual; // Guardar el nodo con el salario mínimo
                }
                actual = actual.siguiente; // Avanzar al siguiente nodo
            }

            // Retornar el salario mínimo encontrado
            return "El empleado con el salario más bajo es: " + "\nNombre: " + minEmpleado.empleado.nombre + "\n" +
                    "Salario: " + minimo;

        } catch (Exception e) {
            // Manejar excepciones y lanzar un mensaje de error personalizado
            throw new Exception("Error al encontrar el salario mínimo: " + e);
        }
    }

    // Sobrecarga de Salario Min para mostrar estadisticas
    public String encontrar_salario_minimo(boolean dummy) throws Exception {
        try {
            if (cabeza == null) {
                return "";
            }
            float minimo = cabeza.empleado.salario;
            Nodo actual = cabeza;
            // Recorrer la lista para encontrar el salario mínimo
            while (actual != null) {
                if (actual.empleado.salario < minimo) {
                    minimo = actual.empleado.salario;
                }
                actual = actual.siguiente; // Avanzar al siguiente nodo
            }
            // Retornar el salario mínimo encontrado
            return "Salario minimo: " + minimo;

        } catch (Exception e) {
            // Manejar excepciones y lanzar un mensaje de error personalizado
            throw new Exception("Error al encontrar el salario mínimo: " + e);
        }
    }

    public String obtener_mediana_salario() throws Exception {
        try {

            // Ordenar la lista por salario (ascendente)
            ListaDoble listaDobleM = OrdenarPorSalario();

            // Verificar si la lista está vacía
            if (listaDobleM.cabeza == null) {
                return "Lista vacía";
            }

            // Crear un array para almacenar los salarios
            int[] salarios = new int[contadorEmpleados];
            int index = 0;

            Nodo actual = listaDobleM.cabeza;

            // Recorrer la lista y almacenar los salarios en el array
            while (actual != null) {

                salarios[index++] = (int) actual.empleado.salario;
                actual = actual.siguiente;
            }

            // Calcular la mediana
            if (contadorEmpleados % 2 == 0) {

                int mid = contadorEmpleados / 2 - 1;
                // Si el número de empleados es par, la mediana es el promedio de los dos
                // valores centrales
                return "Mediana: " + ((salarios[mid] + salarios[mid + 1]) / 2.0);
            } else {
                // Si el número de empleados es impar, la mediana es el valor central
                int mid = contadorEmpleados / 2;
                return "Mediana: " + salarios[mid];
            }

        } catch (Exception e) {
            throw new Exception("Error al calcular la mediana de salarios: " + e); // Manejar excepciones

        }
    }
}
