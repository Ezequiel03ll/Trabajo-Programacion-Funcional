package entidades;

public class Empleado extends Persona{
    private String departamento;
    private double salario;

    public Empleado(String nombre, int edad, String departamento, double salario) {
        super(nombre, edad);
        this.departamento = departamento;
        this.salario = salario;
    }

    public String getDepartamento() { return departamento; }
    public double getSalario() { return salario; }

    @Override
    public String toString() {
        return "Empleado{" +
                "departamento='" + departamento + '\'' +
                ", salario=" + salario +
                ", nombre='" + nombre + '\'' +
                ", edad=" + edad +
                '}';
    }
}