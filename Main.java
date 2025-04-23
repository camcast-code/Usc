import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SistemaDeGestion sistema = new SistemaDeGestion();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Menú ---");
            System.out.println("1. Agregar Bodega");
            System.out.println("2. Crear Tren");
            System.out.println("3. Recibir Tren en Bodega");
            System.out.println("4. Sacar Tren de Bodega");
            System.out.println("5. Mostrar Estado");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.print("ID de la bodega: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Dirección: ");
                    String dir = scanner.nextLine();
                    System.out.print("Capacidad máxima (toneladas): ");
                    double capTon = scanner.nextDouble();
                    System.out.print("Capacidad máxima (trenes): ");
                    int capTrenes = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Tipo de carga (alimentos/quimicos): ");
                    String tipo = scanner.nextLine();
                    Bodega bodega = new Bodega(id, dir, capTon, capTrenes, tipo);
                    System.out.println(sistema.agregarBodega(bodega));
                    break;

                case 2:
                    System.out.print("ID del tren: ");
                    int idTren = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Tipo de carga (alimentos/quimicos): ");
                    String tipoTren = scanner.nextLine();
                    System.out.print("Carga máxima: ");
                    double maxCarga = scanner.nextDouble();
                    System.out.print("Carga actual: ");
                    double cargaActual = scanner.nextDouble();
                    scanner.nextLine();
                    Tren tren = new Tren(idTren, tipoTren, maxCarga, cargaActual);
                    System.out.println("Tren creado.");
                    break;

                case 3:
                    System.out.print("ID de la bodega destino: ");
                    int idBodRecibir = scanner.nextInt();
                    System.out.print("ID del tren a recibir: ");
                    int idTrenRecibir = scanner.nextInt();
                    scanner.nextLine();

                    Bodega bodegaDestino = sistema.buscarBodega(idBodRecibir);
                    if (bodegaDestino != null) {
                        Tren trenRecibir = new Tren(idTrenRecibir, "alimentos", 3000, 2500); // Simulado
                        System.out.println(bodegaDestino.recibirTren(trenRecibir));
                    } else {
                        System.out.println("Bodega no encontrada.");
                    }
                    break;

                case 4:
                    System.out.print("ID de la bodega: ");
                    int idBodSalida = scanner.nextInt();
                    System.out.print("ID del tren a salir: ");
                    int idTrenSalida = scanner.nextInt();
                    scanner.nextLine();

                    Bodega bodegaSalida = sistema.buscarBodega(idBodSalida);
                    if (bodegaSalida != null) {
                        System.out.println(bodegaSalida.darSalidaTren(idTrenSalida));
                    } else {
                        System.out.println("Bodega no encontrada.");
                    }
                    break;

                case 5:
                    sistema.mostrarEstado();
                    break;

                case 0:
                    System.out.println("Saliendo...");
                    return;

                default:
                    System.out.println("Opción inválida.");
            }
        }
    }
}
