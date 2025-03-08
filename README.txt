Descripción General del Proyecto

    Este proyecto es un sistema de gestión de empleados para TechSolutions Inc., diseñado para manejar eficientemente la información de los empleados utilizando listas doblemente ligadas. Estas listas permiten operaciones rápidas como inserción, eliminación, búsqueda y ordenamiento. Además, el sistema calcula estadísticas clave: salario promedio, máximo, mínimo y mediana.

    Se incluye una interfaz gráfica con JOptionPane para facilitar la interacción, y una función para cargar datos desde un archivo .txt, lo que agiliza la inserción de empleados cuando se tiene una lista predefinida. Esto mejora la usabilidad y reduce el tiempo de ingreso manual de datos.

Instrucciones para Compilar y Ejecutar el Programa
    Requisitos previos:

    Asegúrate de tener instalado Java Development Kit (JDK) en tu sistema. Un entorno de desarrollo como IntelliJ IDEA, Eclipse o cualquier editor de texto con soporte para Java.

    Puedes compilarlo y ejecutarlo en tu IDE Favorito (Vscode remendado).

Decisiones de Diseño Importantes

    Interfaz Gráfica con JOptionPane

    Se decidió utilizar JOptionPane para la interfaz gráfica debido a su facilidad de implementación y su capacidad para proporcionar una experiencia de usuario intuitiva.
    JOptionPane permite mostrar cuadros de diálogo para la entrada y salida de datos, lo que simplifica la interacción con el usuario sin necesidad de desarrollar una interfaz compleja. Esta elección fue clave para reducir el tiempo de desarrollo y mantener el enfoque en la lógica del sistema.

Función para Cargar Datos desde un Archivo .txt

    Se agregó una función adicional para cargar datos desde un archivo .txt con el fin de mejorar la eficiencia al ingresar empleados. Esta función es útil cuando se tiene una lista predefinida de empleados, evitando la necesidad de ingresar manualmente cada uno. El formato del archivo es simple (nombre, ID, salario), lo que facilita su creación y modificación.