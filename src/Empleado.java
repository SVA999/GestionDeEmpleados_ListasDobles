public class Empleado {
    
    public String nombre;
    public float salario;
    public int id;

    public Empleado(String nombre, float salario) {
        this.nombre = nombre.trim();
        this.salario = salario;
        id = Main.IdEmpleados++;
    }
}
