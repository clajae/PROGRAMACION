import java.util.Arrays;

public class Estudiante implements Comparable<Estudiante> {

    public String nombre;
    public int edad;
    public int altura;

    public Estudiante(String nombre, int altura, int edad) {
        this.nombre = nombre;
        this.edad = edad;
        this.altura = altura;
    }

    // --------- MÉTODOS GETTERS Y SETTERS -------- //

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", altura=" + altura +
                '}';
    }

// ------------------------------------------- //

    @Override
    public int compareTo(Estudiante o) {
        int resultado = 0;

        if (this.altura < o.altura) {
            resultado = 1;
        } else if (this.altura > o.altura) {
            resultado = -1;
        } else {
            if (this.edad < o.edad) {
                resultado = 1;
            } else if (this.edad > o.edad) {
                resultado = -1;
            } else {
                resultado = 0;
            }
        }
        return resultado;
    }

}

class Main_Estudiante {
    public static void main(String[] args) {

        Estudiante[] estudiante = {
                new Estudiante("Patri",170, 12),
                new Estudiante("Manuel",190, 43),
                new Estudiante("Javier",200, 72),
                new Estudiante("Alicia",160, 52),
                new Estudiante("Alberto",120, 35)
        };

        System.out.println("Lista de estudiantes desordenada: ");
        System.out.println(" ");
        for (int i = 0; i < estudiante.length; i++) {
            System.out.println(estudiante[i]);
        }

        System.out.println(" ");

        Arrays.sort(estudiante);

        System.out.println("Lista de estudiantes ordenada: ");
        System.out.println(" ");
        for (int i = 0; i < estudiante.length; i++) {
            System.out.println(estudiante[i]);
        }

    }
}