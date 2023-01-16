import java.util.Scanner;

public class Circulo {

    private double radio;
    private double area;

    // MÉTODO CONSTRUCTOR DE LA CLASE CÍRCULO

    public Circulo(double radio) {
        if (radio < 0) {
            this.radio = 0;
        } else {
            this.radio = radio;
        }

    }

    // MÉTODO getRadio

    public double getRadio() {
        return this.radio;
    }

    // MÉTODO getArea

    public double getArea() {
        return area = (radio * radio * Math.PI);
    }

}


class Cilindro extends Circulo {

    private double altura;
    private double volume;

    // MÉTODO CONSTRUCTOR DE LA CLASE CÍRCULO

    public Cilindro(double radio, double altura) {
        super(radio);

        if(altura < 0) {
            this.altura = 0;
        } else {
            this.altura = altura;
        }

    }

    // MÉTODO getAltura

    public double getAltura() {
        return this.altura;
    }

    // MÉTODO getVolume

    public double getVolume(){
        return volume = getArea() * altura;
    }


}

class Main {

    public static void main(String[] args) {
        Scanner escaner = new Scanner(System.in);


        // ----------- CLASE CÍRCULO ------------ //

        System.out.println("Introduce el radio del círculo: ");
        double radio = escaner.nextDouble();

        Circulo circulo = new Circulo(radio);

        System.out.println("El radio del círculo es: " + circulo.getRadio());
        System.out.println("El área del círculo es: " + circulo.getArea());

        System.out.println("------------------------------------");

        // ----------- CLASE CILINDRO ------------ //

        System.out.println("Introduce la altura del cilindro: ");
        double altura = escaner.nextDouble();

        Cilindro cilindro = new Cilindro(radio, altura);

        System.out.println("La altura del cilindro es: " + cilindro.getAltura());
        System.out.println("El volumen del cilindro es: " + cilindro.getVolume());

    }

}
