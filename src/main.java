public class main {

    public static void main(String[] args) {

        B objetoB = new B();

        objetoB.dime_alergias_alimenticias("si");
        objetoB.dime_alergias_medicamentos("si");

        System.out.println(objetoB.dime_datos_personales() + " " + objetoB.dime_alergias());

    }

}
