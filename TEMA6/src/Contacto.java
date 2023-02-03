import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Contacto {

    private String name;
    private String phoneNumber;

    public Contacto(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public static Contacto createContact(String name, String numeroTelefono) {
        return new Contacto(name, numeroTelefono);
    }


}

class TelefonoMovil {

    private String myNumber;
    public static ArrayList<Contacto> myContacts = new ArrayList<Contacto>();

    public TelefonoMovil(String myNumber, ArrayList<Contacto> myContacts) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<Contacto>();
    }

    /* COMO INSTANCIAR EL ARRAYLIST */

    private static int findContact(Contacto nuevoContacto) {
        return myContacts.indexOf(nuevoContacto);
    }

    private static int findContact(String encuentraContacto) {
        for (int i = 0; i < myContacts.size(); i++) {
            if (myContacts.get(i).getName().equalsIgnoreCase(encuentraContacto)) {
                return i;
            }
        }
        return -1;
    }

    public static boolean addNewContact(Contacto addContacto) {
        if (findContact(addContacto) >= 0) {
            return false;
        } else {
            myContacts.add(addContacto);
            return true;
        }

    }

    public static boolean updateContact(Contacto addContacto, Contacto updateContacto) {
        if ((findContact(addContacto) >= 0) && (findContact(updateContacto) == -1)) {
            myContacts.set(myContacts.indexOf(addContacto), updateContacto);
            return true;
        } else {
            return false;
        }

    }

    public static boolean removeContact(Contacto contacto) {
        if (findContact(contacto) >= 0) {
            myContacts.remove(contacto);
            return true;
        } else {
            return false;
        }

    }

    public static Contacto queryContact(String contacto) {
        int indice = findContact(contacto);
        if (indice >= 0) {
            return myContacts.get(indice);
        } else {
            return null;
        }

    }

    public static void printContact() {
        System.out.println("Lista de contactos: ");
        for (int i = 0; i < myContacts.size(); i++) {
            System.out.print((i+1) + ". Nombre: " + myContacts.get(i).getName() + " - Número de teléfono: " + myContacts.get(i).getPhoneNumber() + "\n");
        }
    }

}

class MainContactoFinal {

    public static void main(String[] args) {
        Scanner escaner = new Scanner(System.in);

        boolean continuar = true;
        int opciones;

        do {

            try {

                boolean volver = true;

                do {

                    System.out.println("<------ BIENVENIDO AL MENÚ DE SELECCIÓN ------->");
                    System.out.println("0. Salir");
                    System.out.println("1. Imprimir lista de contactos");
                    System.out.println("2. Agregar nuevo contacto a la lista de contactos existentes");
                    System.out.println("3. Actualizar un contacto existente de la lista de contactos");
                    System.out.println("4. Eliminar un contacto existente de la lista de contactos");
                    System.out.println("5. Buscar un contacto existente en la lista de contactos");
                    System.out.println("6. Volver a imprimir la lista de opciones");
                    System.out.println(" ");

                    opciones = escaner.nextInt();

                    if (opciones >= 0 && opciones <= 6) {

                        switch (opciones) {

                            case 0:
                                continuar = false;
                                volver = false;
                                System.out.println("Ha salido del programa");
                                System.out.println(" ");
                                break;

                            case 1:
                                TelefonoMovil.printContact();
                                System.out.println(" ");
                                break;

                            case 2:
                                Scanner opcion2 = new Scanner(System.in);

                                System.out.println("Agrega un nuevo contacto a la lista de contactos");
                                System.out.println("Introduce un nombre: ");
                                String nombre_Op1 = opcion2.nextLine();

                                if (nombre_Op1.matches("^[a-zA-Z]*$")) {

                                    System.out.println("Introduce un número de telefono: ");
                                    String telefono_Op1 = opcion2.next();
                                    if (telefono_Op1.length() == 9) {
                                        TelefonoMovil.addNewContact(Contacto.createContact(nombre_Op1, telefono_Op1));
                                        System.out.println(" ");
                                        System.out.println("El nuevo contacto " + nombre_Op1 + " con número de teléfono " + telefono_Op1 + " se ha añadido con éxito.");
                                        System.out.println(" ");
                                    } else {
                                        System.out.println("Error al introducir el número de teléfono");
                                        System.out.println("Pruebe de nuevo a agregar un nuevo contacto");
                                        System.out.println(" ");
                                    }

                                } else {
                                    System.out.println("Error al introducir el nombre. Algún carácter no válido introducido.");
                                    System.out.println(" ");
                                }


                                break;

                            case 3:
                                Scanner opcion3 = new Scanner(System.in);

                                System.out.println("Actualizar un contacto de la lista de contactos");
                                System.out.println("Introduce un nombre: ");
                                String nombre_Op2 = opcion3.nextLine();

                                if (nombre_Op2.matches("^[a-zA-Z]*$")) {

                                    if (TelefonoMovil.queryContact(nombre_Op2) == null) {
                                        System.out.println("Este contacto no existe");
                                        System.out.println("Creelo a continuación: ");
                                        System.out.println("Introduzca un nuevo nombre: ");
                                        String nombre_Op3 = opcion3.nextLine();
                                        System.out.println("Introduce un nuevo número de telefono: ");
                                        String telefono_Op3 = opcion3.next();

                                        if (telefono_Op3.length() == 9) {
                                            Contacto.createContact(nombre_Op3, telefono_Op3);
                                            TelefonoMovil.updateContact(TelefonoMovil.queryContact(nombre_Op2), Contacto.createContact(nombre_Op3, telefono_Op3));
                                            System.out.println(" ");
                                            System.out.println("El contacto se ha actualizado con éxito");
                                            System.out.println(" ");
                                        } else {
                                            System.out.println("Error al introducir el número de teléfono");
                                            System.out.println("Pruebe de nuevo a actualizar el contacto");
                                            System.out.println(" ");
                                        }

                                    } else {
                                        System.out.println("Este contacto existe");
                                        System.out.println("Actualicelo a continuación: ");
                                        System.out.println("Introduce un nuevo nombre: ");
                                        String nombre_Op3 = opcion3.nextLine();
                                        System.out.println("Introduce un nuevo número de telefono: ");
                                        String telefono_Op3 = opcion3.next();

                                        if (telefono_Op3.length() == 9) {
                                            Contacto.createContact(nombre_Op3, telefono_Op3);
                                            TelefonoMovil.updateContact(TelefonoMovil.queryContact(nombre_Op2), Contacto.createContact(nombre_Op3, telefono_Op3));
                                            System.out.println(" ");
                                            System.out.println("El contacto se ha actualizado con éxito");
                                            System.out.println(" ");
                                        } else {
                                            System.out.println("Error al introducir el número de teléfono");
                                            System.out.println("Pruebe de nuevo a crear el contacto");
                                            System.out.println(" ");
                                        }

                                    }

                                } else {
                                    System.out.println("Error al introducir el nombre. Algún carácter no válido introducido.");
                                    System.out.println(" ");
                                }

                                break;

                            case 4:
                                Scanner opcion4 = new Scanner(System.in);

                                System.out.println("Introduzca el nombre del contacto que desea eliminar: ");
                                String nombre_Op4 = opcion4.nextLine();

                                if (nombre_Op4.matches("^[a-zA-Z]*$")) {

                                    if (TelefonoMovil.queryContact(nombre_Op4) != null) {
                                        TelefonoMovil.removeContact(TelefonoMovil.queryContact(nombre_Op4));
                                        System.out.println("El contacto ha sido eliminado con éxito");
                                        System.out.println(" ");
                                    } else {
                                        System.out.println("El contacto no existe. No se pudo eliminar ningún contacto de la lista.");
                                        System.out.println(" ");
                                    }

                                } else {
                                    System.out.println("Error al introducir el nombre. Algún carácter no válido introducido.");
                                    System.out.println(" ");
                                }

                                break;

                            case 5:
                                Scanner opcion5 = new Scanner(System.in);

                                System.out.println("¿Introduzca el contacto desea buscar?");
                                String nombre_Op5 = opcion5.nextLine();

                                if (nombre_Op5.matches("^[a-zA-Z]*$")) {

                                    if (TelefonoMovil.queryContact(nombre_Op5) != null) {
                                        System.out.println("Información del contacto: ");
                                        System.out.println("Nombre: " + TelefonoMovil.queryContact(nombre_Op5).getName() + " - Número de teléfono: " + TelefonoMovil.queryContact(nombre_Op5).getPhoneNumber());
                                        System.out.println(" ");
                                    } else {
                                        System.out.println("El contacto no existe. No se ha podído obtener ninguna información.");
                                        System.out.println(" ");
                                    }

                                } else {
                                    System.out.println("Error al introducir el nombre. Algún carácter no válido introducido.");
                                    System.out.println(" ");
                                }

                                break;

                            case 6:
                                volver = false;
                                break;

                        }

                    } else {
                        System.out.println("Opción introducida no se encuentra en el menú");
                        System.out.println("Vuelva a introducir su opción de nuevo:");
                        System.out.println(" ");
                    }

                } while (volver);

            } catch (InputMismatchException ex) {
                continuar = false;
                System.out.println("Error, debe introducir un entero para seleccionar cualquier de las opciones del menú");
            }

        } while (continuar);

    }

}








