import java.util.*;

public class Ubicacion {
    private int id;
    private String descripcion;
    private Map<String, Integer> exits;

    public Ubicacion(int id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
        this.exits = new HashMap<>();
    }

    public int getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Map<String, Integer> getExits() {
        return exits;
    }

    public void addExit(String direccion, int idUbicacion) {
        exits.put(direccion, idUbicacion);
    }
}

class MainUbicacion {

    public static void main(String[] args) {
        Map<Integer, Ubicacion> ubicaciones = new HashMap<>();

        /* CREAR OBJETOS DE TIPO UBICACION */
        Ubicacion ubicacion0 = new Ubicacion(0, "Estás sentado en la clase de programación");
        Ubicacion ubicacion1 = new Ubicacion(1, "Estás en la cima de una montaña");
        Ubicacion ubicacion2 = new Ubicacion(2, "Estás bañándote en la playa");
        Ubicacion ubicacion3 = new Ubicacion(3, "Estás dentro de un edificio muy alto");
        Ubicacion ubicacion4 = new Ubicacion(4, "Estás de pie en un puente");
        Ubicacion ubicacion5 = new Ubicacion(5, "Estás en un bosque");

        /* AÑADIR UBICACIONES */
        ubicaciones.put(0, ubicacion0);
        ubicaciones.put(1, ubicacion1);
        ubicaciones.put(2, ubicacion2);
        ubicaciones.put(3, ubicacion3);
        ubicaciones.put(4, ubicacion4);
        ubicaciones.put(5, ubicacion5);

        /* POSIBLES SALIDAS */
        ubicacion1.addExit("N", 5);
        ubicacion1.addExit("S", 4);
        ubicacion1.addExit("E", 3);
        ubicacion1.addExit("O", 2);

        ubicacion2.addExit("N", 5);

        ubicacion3.addExit("O", 1);

        ubicacion4.addExit("N", 1);
        ubicacion4.addExit("O", 2);

        ubicacion5.addExit("S", 1);
        ubicacion5.addExit("O", 2);


        String ub = "";
        int ubicacionActual = 1;

        for (int i = 0; i < ubicaciones.size(); i++) {
            ubicaciones.get(i).addExit("Q", 0);
        }

        do {
            try {
                System.out.println("Ubicación actual: " + ubicaciones.get(ubicacionActual).getDescripcion());
                System.out.println("Puedes ir a las siguientes ubicaciones: " + ubicaciones.get(ubicacionActual).getExits().keySet()); // EL KEYSET SE UTILIZA PARA QUE EN VEZ DE SACAR EL VALOR COMO (INTEGER, UBICACION (lETRA)) ME SALGA COMO UNA MATRÍZ DE POSIBLES VALORES
                Scanner escaner = new Scanner(System.in);
                ub = escaner.next();
                ubicacionActual = ubicaciones.get(ubicacionActual).getExits().get(ub.toUpperCase());
            } catch (NullPointerException e) {
                System.out.println("Dirección introducida no es correcta");
            }
        } while (!ub.equalsIgnoreCase("Q"));

        System.out.println("Has finalizado el juego");


    }

}