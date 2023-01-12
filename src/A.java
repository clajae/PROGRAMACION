public class A {

    private int edad;
    private double altura;
    private double peso;

    public A() {
        edad = 15;
        altura = 1.68;
        peso = 58.9;
    }

    public String dime_datos_personales () {

        return "Datos personales de alumno: " + " Edad: " + edad + " Altura: " + altura + " Peso: " + peso;
    }

}