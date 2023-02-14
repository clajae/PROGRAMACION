import java.util.*;

class Song {

    private String titulo;
    private double duracion;

    public Song(String titulo, double duracion) {
        this.titulo = titulo;
        this.duracion = duracion;
    }

    public String getTitulo() {
        return titulo;
    }

    @Override
    public String toString() {
        return titulo + " - Duración: " + duracion + " min";
    }

}

public class Album {

    private String nombre;
    private String artista;
    private ArrayList<Song> canciones = new ArrayList<>();

    public Album(String nombre, String artista) {
        this.nombre = nombre;
        this.artista = artista;
        this.canciones = new ArrayList<Song>();
    }

    private Song findSong(String tituloCacion) {
        for (int i = 0; i < canciones.size(); i++) {
            if (canciones.get(i).getTitulo().equalsIgnoreCase(tituloCacion)) {
                return canciones.get(i);
            }
        }
        return null;
    }

    public boolean addSong(String tituloCancion, double duracionCancion) {
        if (findSong(tituloCancion) == null) {
            canciones.add(new Song(tituloCancion, duracionCancion));
            return true;
        } else {
            return false;
        }
    }

    public boolean addToPlayList(int numPistaCancion, LinkedList<Song> listaReproduccion) {
        if ((numPistaCancion >= 0) && (numPistaCancion < listaReproduccion.size())) {
            listaReproduccion.add(this.canciones.get(numPistaCancion));
            return true;
        } else {
            return false;
        }
    }

    public boolean addToPlayList(String tituloCancion, LinkedList<Song> listaReproduccion) {
        Song cancion = findSong(tituloCancion);

        if (cancion == null) {
            System.out.println("La canción " + tituloCancion + " no se encuentra en el álbum");
            return false;
        } else {
            listaReproduccion.add(cancion);
            return true;
        }
    }

}

class MainAlbumFinal {

    static LinkedList<Song> listaReproduccion = new LinkedList<>();
    static Scanner escaner = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<Album> album = new ArrayList<>();

        Album album1 = new Album("Bizarrap Mix","Bizarrap");
        album1.addSong("Shakira B.10",3.15);
        album1.addSong("Duki B.11",3.3);
        album1.addSong("Quevedo B.12",2.34);
        album1.addSong("Villano B.13",2.55);
        album1.addSong("Paulo B.14",3);
        album1.addSong("Residente B.15",3.1);
        album1.addSong("Tiago B.16",3.4);
        album.add(album1);

        Album album2 = new Album("Donde quiero estar", "Quevedo");
        album2.addSong("Ahora Qué",2.51);
        album2.addSong("Yankee",3.14);
        album2.addSong("Vista al Mar",3);
        album2.addSong("Playa del Inglés",3.57);
        album2.addSong("Sin Señal",3.05);
        album2.addSong("Dame",3.51);
        album2.addSong("Luces Azules",2.4);
        album.add(album2);

        album1.addToPlayList("Villano B.13",listaReproduccion); // VILLANO
        album1.addToPlayList(0,listaReproduccion); // SHAKIRA
        album2.addToPlayList("Vista al Mar",listaReproduccion); // VISTA AL MAR
        album2.addToPlayList(0,listaReproduccion); // AHORA QUÉ
        album1.addToPlayList("Duki B.11",listaReproduccion); // DUKI

        play();
    }

    public static void imprimirListaReproduccion(LinkedList<Song> listaReproduccion) {
        if (listaReproduccion.isEmpty()) {
            System.out.println("Esta lista de reproducción está vacía");
        } else {
            for (Song cancion: listaReproduccion) {
                System.out.println(cancion);
            }
        }

    }

    public static void imprimirMenu() {
        System.out.println("0 - Salir de la lista de reproducción");
        System.out.println("1 - Reproducir la siguiente canción de la lista");
        System.out.println("2 - Reproducir la canción previa de la lista");
        System.out.println("3 - Repetir la canción actual");
        System.out.println("4 - Imprimir la lista de canciones de la playlist");
        System.out.println("5 - Volver a imprimir el menú");
        System.out.println("6 - Eliminar la canción actual de la playlist");
    }

    public static void play() {
        imprimirMenu();
        ListIterator<Song> iter = listaReproduccion.listIterator();
        System.out.println(" ");

        if (listaReproduccion.isEmpty()) {
            System.out.println("La lista de reproducción está vacía");
            return;
        } else {
            System.out.println("Se está reproduciendo: " + iter.next());
            iter.previous();
        }

        System.out.println("Seleccione una opción: ");

        boolean salir = false;

        while (!salir) {

            int opciones = escaner.nextInt();

            switch (opciones) {

                case 0:
                    System.out.println("Se ha salido de la lista de reproducción");
                    salir = true;
                    break;

                case 1:
                    if (iter.hasNext()) {
                        iter.next();
                        if (iter.hasNext()) {
                            System.out.println("Reproduciendo: " + iter.next());
                            System.out.println(" ");
                            iter.previous();
                        } else {
                            System.out.println("Ha llegado al final de la playlist, no hay más canciones en la lista");
                            System.out.println(" ");
                        }
                    }
                    imprimirMenu();
                    break;

                case 2:
                    if (iter.hasPrevious()) {
                        System.out.println("Reproduciendo: " +iter.previous());
                        System.out.println(" ");
                    } else {
                        System.out.println("Ha llegado al comienzo de la playlist, no hay más canción delante de esta última");
                        System.out.println(" ");
                    }
                    imprimirMenu();
                    break;

                case 3:
                    if (iter.hasNext()) {
                        if (iter.hasNext()) {
                            System.out.println("Se está reproduciendo actualmente: " + iter.next());
                            System.out.println(" ");
                            iter.previous();
                        } else if (iter.hasPrevious()) {
                            System.out.println("Se está reproduciendo actualmente: " + iter.previous());
                            System.out.println(" ");
                            iter.next();
                        }
                    } else if (iter.hasPrevious()) {
                        if (iter.hasNext()) {
                            System.out.println("Se está reproduciendo actualmente: " + iter.next());
                            System.out.println(" ");
                            iter.previous();
                        } else if (iter.hasPrevious()) {
                            System.out.println("Se está reproduciendo actualmente: " + iter.previous());
                            System.out.println(" ");
                            iter.next();
                        }
                    } else {
                        System.out.println("No hay canciones en la lista de reproducción");
                        System.out.println(" ");
                    }
                    imprimirMenu();
                    break;

                case 4:
                    imprimirListaReproduccion(listaReproduccion);
                    System.out.println(" ");
                    imprimirMenu();
                    break;

                case 5:
                    imprimirMenu();
                    break;

                case 6:
                    if (iter.hasNext()) {
                        iter.next();
                        iter.remove();
                        if (iter.hasNext()) {
                            System.out.println("Debido a que has eliminado una canción, ahora sonará: " + iter.next());
                            System.out.println(" ");
                            iter.previous();
                        } else if (iter.hasPrevious()) {
                            System.out.println("Debido a que has eliminado una canción, ahora sonará: " + iter.previous());
                            System.out.println(" ");
                            iter.next();
                        }
                    } else if (iter.hasPrevious()) {
                        iter.previous();
                        iter.remove();
                        if (iter.hasNext()) {
                            System.out.println("Debido a que has eliminado una canción, ahora sonará: " + iter.next());
                            System.out.println(" ");
                            iter.previous();
                        } else if (iter.hasPrevious()) {
                            System.out.println("Debido a que has eliminado una canción, ahora sonará: " + iter.previous());
                            System.out.println(" ");
                            iter.next();
                        }
                    } else {
                        System.out.println("No hay canciones en la lista de reproducción");
                        System.out.println(" ");
                    }
                    imprimirMenu();
                    break;

            }

        }

    }

}
