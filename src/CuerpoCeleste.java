import sun.util.resources.cldr.ru.LocaleNames_ru_UA;

import java.util.*;

public class CuerpoCeleste {

    public enum TipoCuerpoCeleste {ESTRELLA, PLANETA, PLANETA_ENANO, LUNA, COMETA, ASTEROIDE};
    private String nombre;
    private double periodoOrbital;
    private Set<CuerpoCeleste> satelites = new HashSet<>();
    private TipoCuerpoCeleste tipoCuerpo;

    public CuerpoCeleste(String nombre, double periodoOrbital, TipoCuerpoCeleste tipoCuerpo) {
        this.nombre = nombre;
        this.periodoOrbital = periodoOrbital;
        this.tipoCuerpo = tipoCuerpo;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPeriodoOrbital() {
        return periodoOrbital;
    }

    public TipoCuerpoCeleste getTipoCuerpo() {
        return tipoCuerpo;
    }

    public Set<CuerpoCeleste> getSatelites() {
        return new HashSet<>(satelites);
    }

    public boolean addSatelite (CuerpoCeleste a) {
        return satelites.add(a);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CuerpoCeleste that = (CuerpoCeleste) o;
        return Double.compare(that.periodoOrbital, periodoOrbital) == 0 && Objects.equals(nombre, that.nombre) && Objects.equals(satelites, that.satelites) && tipoCuerpo == that.tipoCuerpo;
    }

    @Override
    public int hashCode() {
        Random numRandom = new Random();
        return Objects.hash(nombre, tipoCuerpo) + numRandom.nextInt(100) + 1;
    }

    @Override
    public String toString() {
        return nombre + ": " + tipoCuerpo + ", " + periodoOrbital;
    }

}

class Planeta extends CuerpoCeleste {

    public Planeta(String nombrePlaneta, double periodoOrbital) {
        super(nombrePlaneta, periodoOrbital, TipoCuerpoCeleste.PLANETA);
    }

    public boolean addSatelite () {
        if (getTipoCuerpo() == TipoCuerpoCeleste.LUNA) {
            return addSatelite();
        } else {
            return false;
        }
    }

}

class PlanetaEnano extends CuerpoCeleste {

    public PlanetaEnano(String nombrePlanetaEnano, double periodoOrbital) {
        super(nombrePlanetaEnano, periodoOrbital, TipoCuerpoCeleste.PLANETA_ENANO);
    }

}

class Luna extends CuerpoCeleste {

    private int numero;
    public Luna(String nombreLuna, double periodoOrbital) {
        super(nombreLuna, periodoOrbital, TipoCuerpoCeleste.LUNA);
    }

}

class MainCuerpoCeleste {

    static HashMap<String, CuerpoCeleste> sistemaSolar = new HashMap<>();
    static Set<CuerpoCeleste> planetas = new HashSet<>();

    public static void main(String[] args) {

        // ----------- PLANETAS ----------- //

        ArrayList<CuerpoCeleste> cuerpoPlaneta = new ArrayList<>();

        // MERCURIO
        cuerpoPlaneta.add(new Planeta("Mercurio", 88));
        sistemaSolar.put("Mer", cuerpoPlaneta.get(0));
        planetas.add(cuerpoPlaneta.get(0));
        // VENUS
        cuerpoPlaneta.add(new Planeta("Venus", 225));
        sistemaSolar.put("Ven", cuerpoPlaneta.get(1));
        planetas.add(cuerpoPlaneta.get(1));
        // LA TIERRA
        cuerpoPlaneta.add(new Planeta("La Tierra", 365));
        sistemaSolar.put("Tie", cuerpoPlaneta.get(2));
        planetas.add(cuerpoPlaneta.get(2));
        // MARTE
        cuerpoPlaneta.add(new Planeta("Marte", 687));
        sistemaSolar.put("Mar", cuerpoPlaneta.get(3));
        planetas.add(cuerpoPlaneta.get(3));
        // JUPITER
        cuerpoPlaneta.add(new Planeta("Jupiter", 4332));
        sistemaSolar.put("Jup", cuerpoPlaneta.get(4));
        planetas.add(cuerpoPlaneta.get(4));
        // SATURNO
        cuerpoPlaneta.add(new Planeta("Saturno", 10759));
        sistemaSolar.put("Sat", cuerpoPlaneta.get(5));
        planetas.add(cuerpoPlaneta.get(5));
        // URANO
        cuerpoPlaneta.add(new Planeta("Urano", 30660));
        sistemaSolar.put("Ura", cuerpoPlaneta.get(6));
        planetas.add(cuerpoPlaneta.get(6));
        // NEPTUNO
        cuerpoPlaneta.add(new Planeta("Neptuno", 165));
        sistemaSolar.put("Nep", cuerpoPlaneta.get(7));
        planetas.add(cuerpoPlaneta.get(7));
        // PLUTON
        cuerpoPlaneta.add(new Planeta("Pluton", 248));
        sistemaSolar.put("Plu", cuerpoPlaneta.get(8));
        planetas.add(cuerpoPlaneta.get(8));

        // ---------- AÑADIR EL 2do PLUTON --------- //

        // PLUTON 2 (ENANO)
        CuerpoCeleste cuerpoEnano = new PlanetaEnano("Pluton", 884);
        sistemaSolar.put("Plu", cuerpoEnano);
        planetas.add(cuerpoEnano);

        // ----------- LUNAS ----------- //

        ArrayList<CuerpoCeleste> cuerpoLuna = new ArrayList<>();

        // LA LUNA
        cuerpoLuna.add(new Luna("Luna", 27));
        sistemaSolar.put("Lun", cuerpoLuna.get(0));
        cuerpoPlaneta.get(2).addSatelite(cuerpoLuna.get(0));
        // DEIMOS
        cuerpoLuna.add(new Luna("Deimos", 1.3));
        sistemaSolar.put("Dei", cuerpoLuna.get(1));
        cuerpoPlaneta.get(3).addSatelite(cuerpoLuna.get(1));
        // PHOBOS
        cuerpoLuna.add(new Luna("Phobos", 0.3));
        sistemaSolar.put("Pho", cuerpoLuna.get(2));
        cuerpoPlaneta.get(3).addSatelite(cuerpoLuna.get(2));
        // IO
        cuerpoLuna.add(new Luna("Io", 1.8));
        sistemaSolar.put("Io", cuerpoLuna.get(3));
        cuerpoPlaneta.get(4).addSatelite(cuerpoLuna.get(3));
        // EUROPA
        cuerpoLuna.add(new Luna("Europa", 3.5));
        sistemaSolar.put("Eur", cuerpoLuna.get(4));
        cuerpoPlaneta.get(4).addSatelite(cuerpoLuna.get(4));
        // GANYMEDE
        cuerpoLuna.add(new Luna("Ganymede", 7.1));
        sistemaSolar.put("Gan", cuerpoLuna.get(5));
        cuerpoPlaneta.get(4).addSatelite(cuerpoLuna.get(5));
        // CALLISTO
        cuerpoLuna.add(new Luna("Callisto", 16.7));
        sistemaSolar.put("Callisto", cuerpoLuna.get(6));
        cuerpoPlaneta.get(4).addSatelite(cuerpoLuna.get(6));


        // -------- IMPRIMIR PLANETAS --------- //

        System.out.println("PLANETAS: ");
        System.out.println(planetas);
        System.out.println(" ");


        // ---------- IMPRIMIR LAS LUNAS DEL PLANETA MARTE -------- //

        System.out.println("LUNAS DE MARTE: ");
        System.out.println(sistemaSolar.get("Mar").getSatelites());


        // ---------- CREAR EL HASH SET DE LUNAS ----------- //

        Set<CuerpoCeleste> lunas = new HashSet<>();

        for (CuerpoCeleste a: planetas) {
            lunas.addAll(a.getSatelites());
        }

        System.out.println(" ");


        // ---------- IMPRIMIR LA COLECCIÓN LUNAS ---------- //

        System.out.println("LUNAS: ");
        System.out.println(lunas);
        System.out.println(" ");


        // -------------- OPERACIONES CON SET -------------- //

        System.out.println("DIFERENCIA ENTRE PLANETAS Y LUNAS: ");
        planetas.removeAll(lunas);
        System.out.println(planetas);
        System.out.println(" ");

        System.out.println(planetas);
        System.out.println(lunas);
        System.out.println("");

        System.out.println("INTERSECCIÓN ENTRE PLANETAS Y LUNAS: ");
        planetas.retainAll(lunas);
        System.out.println(planetas);
        System.out.println(" ");

        System.out.println("UNIÓN ENTRE PLANETAS Y LUNAS: ");
        planetas.addAll(lunas);
        System.out.println(planetas);

    }

}
