package entidades;

public class Alumno extends Persona {
    private double nota;
    private String curso;

    public Alumno(String nombre, int edad, double nota, String curso) {
        super(nombre, edad);
        this.nota = nota;
        this.curso = curso;
    }

    public double getNota() {
        return nota;
    }

    public String getCurso() {
        return curso;
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "nota=" + nota +
                ", curso='" + curso + '\'' +
                ", nombre='" + nombre + '\'' +
                ", edad=" + edad +
                '}';
    }
}
