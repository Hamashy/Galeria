package galeria;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Galeria {

    Scanner leer = new Scanner(System.in);

    ArrayList artistas = new ArrayList();

    public static void main(String[] args) {
        Galeria obj = new Galeria();
    }

    public Galeria() {
        cargarGaleria();
        imprimirGaleria();
        menu();

    }

    public void cargarGaleria() {
        int numObras = 0;
        int numArtistas = 0;
        String linea;
        String[] datos = new String[3];
        File Archivo = new File("/Users/carlosmorales/Documents/CodigosPython/galeria.txt");
        try {
            FileReader reader = new FileReader(Archivo);
            BufferedReader buffer = new BufferedReader(reader);

            linea = buffer.readLine();
            numArtistas = Integer.parseInt(linea);
            for (int i = 0; i < numArtistas; i++) {
                linea = buffer.readLine();
                datos = linea.split("&");
                Artista valor = (Artista) new Artista(datos[0], datos[1], datos[2]);
                artistas.add(valor);

            }

            linea = buffer.readLine();
            numObras = Integer.parseInt(linea);

            for (int j = 0; j < numObras; j++) {
                linea = buffer.readLine();
                datos = linea.split("&");
                for (int k = 0; k < numArtistas; k++) {
                    Artista obj = (Artista) artistas.get(k);
                    if (obj.getNombre().compareToIgnoreCase(datos[0]) == 0) {
                        Obras art = (Obras) new Obras(datos[1], datos[2], Integer.parseInt(datos[3]));
                        obj.obras.add(art);
                    }
                }
            }

            buffer.close();
            reader.close();

        } catch (Exception e) {
            System.out.println("Error al cargar el Archivo");
        }
    }

    public void imprimirGaleria() {
        for (int i = 0; i < artistas.size(); i++) {
            Artista dato = (Artista) artistas.get(i);

            System.out.println("///////////////////////////////////////////////");
            System.out.println("///Nombre: " + dato.getNombre());
            System.out.println("///Nacimiento: " + dato.getFecha());
            System.out.println("///Nacionalidad: " + dato.getNacionalidad());
            System.out.println("///////////////////////////////////////////////");
            System.out.println("");

            for (int j = 0; j < dato.obras.size(); j++) {
                Obras valor = (Obras) dato.obras.get(j);
                System.out.println("Obra: " + valor.getNombre());
                System.out.println("Descriptcion: " + valor.getDescripcion());
                System.out.println("Precio: " + valor.getPrecio());
                System.out.println("");
            }
        }
    }

    public void menu() {
        int opc = 0;

        System.out.println("M E N Ú   P R I N C I P A L");
        System.out.println("");
        System.out.println("1. Afiliar artista");
        System.out.println("2. Eliminar artista");
        System.out.println("3. Ingresar Obra");
        System.out.println("4. Eliminar obra");
        System.out.println("5. Vender artista");
        System.out.println("6. Reporte de ventas");
        System.out.println("7. Salir");
        System.out.println("");
        System.out.print("Escoja una opcion: ");

        opc = leer.nextByte();
        switch (opc) {
            case 1:
                afiliarArtista();
                imprimirGaleria();
                break;
            case 2: eliminarArtista();
                    imprimirGaleria();
                break;

            case 3: agregarObra();
                    imprimirGaleria();
                break;
            case 4:
                break;
            case 5:
                break;

            case 6:
                break;
            case 7:
               // escribirArchivo();
                System.exit(0);
                break;

            default:
                System.out.println("Error al escoger una opcion");
                menu();

        }
        menu();

    }

    public void afiliarArtista() {
        String nombre, nacionalidad, nacimiento = "";
        nombre = leer.nextLine();
        System.out.print("Digite el nombre del artista: ");
        nombre = leer.nextLine();
        
        boolean existe = buscarArtista(nombre);
        if (existe == true) {
            System.out.println("El artista ya existe");
        } else {
            System.out.print("Digite el nacimiento del artista: ");
            nacimiento = leer.nextLine();
            System.out.print("Digite la nacionalidad del artista: ");
            nacionalidad = leer.nextLine();
            Artista obj = (Artista) new Artista(nombre, nacimiento, nacionalidad);
            artistas.add(obj);
        }

    }

    public boolean buscarArtista(String nombre) {
        boolean encontro = false;
        for (int j = 0; j < artistas.size(); j++) {
            Artista obj = (Artista) artistas.get(j);
            if (obj.getNombre().compareToIgnoreCase(nombre) == 0) {
                encontro = true;
            }
        }
        return encontro;
    }
    
    public void eliminarArtista(){
        String nom;
        boolean encont = false;
        nom = leer.nextLine();
        System.out.print("Digite el nombre del artista:");
        nom = leer.nextLine();
        for (int j = 0; j < artistas.size(); j++) {
            Artista obj = (Artista) artistas.get(j);
            if (obj.getNombre().compareToIgnoreCase(nom) == 0) {
                artistas.remove(j);
                encont = true;
            }
        }
        
        if (encont == true) {
            System.out.println("El artista ha sido eliminado");
            System.out.println("");
        }else { System.out.println("El artista buscado no se encontro");
                System.out.println("");
        }   
    }
    
    public void agregarObra(){
        String nom, nomObra, descripcion;
        int valor;
        boolean encont = false;
        nom = leer.nextLine();
        System.out.print("Digite el nombre del artista:");
        nom = leer.nextLine();
        for (int j = 0; j < artistas.size(); j++) {
            Artista obj = (Artista) artistas.get(j);
            if (obj.getNombre().compareToIgnoreCase(nom) == 0) {
                System.out.print("Digite el nombre de la obra:");
                nomObra = leer.nextLine();
                System.out.print("Digite la descripcion de la obra:");
                descripcion = leer.nextLine();
                System.out.print("Digite el nombre de la obra:");
                valor = leer.nextInt();
                Obras obr  = (Obras) new Obras (nomObra,descripcion,valor);
                obj.obras.add(obr);
                encont = true;
            }
        }
        
        if (encont == true) {
            System.out.println("La obra ha sido adicionada");
            System.out.println("");
        }else { System.out.println("El artista buscado no se encontro");
                System.out.println("");
        }  
    }
    
    public void escribirArchivo(){
        File arch = new File ("/Users/carlosmorales/Documents/CodigosPython/galeria2.txt");
        try {
            PrintWriter writer = new PrintWriter(arch);
            
            int tamart=artistas.size();
            writer.println(tamart);
            
            writer.close();
        } catch (Exception e) {
        }
        
        
    }

}
