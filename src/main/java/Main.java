import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Cabina> Lc = new ArrayList<>();
        int opcion;

        do {
            System.out.println("\nCabinas Montenegro:");
            System.out.println("1. Crear cabina");
            System.out.println("2. Registrar llamada");
            System.out.println("3. Mostrar información por id");
            System.out.println("4. Mostrar consolidado total");
            System.out.println("5. Reiniciar cabina");
            System.out.println("6. Salir");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1 -> {
                    System.out.print("Ingrese ID numérica para la cabina: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    if (buscarCabina(Lc, id) == null) {
                        System.out.print("Ingrese ubicación de la cabina: ");
                        String ubicacion = scanner.nextLine();
                        Lc.add(new Cabina(id, ubicacion));
                        System.out.println("Cabina creada exitosamente \n" +
                                " tenga presenta la Id y la ubicacion de la cabina. ");
                    } else {
                        System.out.println("Ya existe una cabina con este ID.");
                    }
                }
                case 2 -> {
                    System.out.print("Ingrese ID de la cabina: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    Cabina cabina = buscarCabina(Lc, id);
                    if (cabina != null) {
                        System.out.print("Tipo de llamada \n (1: Local \n 2: Larga distancia \n 3: Celular): ");
                        int tipo = scanner.nextInt();
                        System.out.print("Ingrese duración en minutos: ");
                        int minutos = scanner.nextInt();
                        cabina.registrarLlamada(tipo, minutos);
                    } else {
                        System.out.println("Cabina no encontrada.");
                    }
                }
                case 3 -> {
                    System.out.print("Ingrese ID de la cabina: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    Cabina cabina = buscarCabina(Lc, id);
                    if (cabina != null) {
                        cabina.mostrarInfo();
                    } else {
                        System.out.println("Cabina no encontrada.");
                    }
                }
                case 4 -> {
                    int totalLlamadas = Lc.stream().mapToInt(Cabina::getTotalLlamadas).sum();
                    int duracionTotal = Lc.stream().mapToInt(Cabina::getDuracionTotal).sum();
                    int costoTotal = Lc.stream().mapToInt(Cabina::getCostoTotal).sum();
                    System.out.println("\nConsolidado de todas las cabinas:");
                    System.out.printf("Total de llamadas: %d%n", totalLlamadas);
                    System.out.printf("Duración total: %d minutos%n", duracionTotal);
                    System.out.printf("Costo total: $%d pesos%n", costoTotal);
                }
                case 5 -> {
                    System.out.print("Ingrese ID de la cabina: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    Cabina cabina = buscarCabina(Lc, id);
                    if (cabina != null) {
                        cabina.reiniciarCabina();
                    } else {
                        System.out.println("Cabina no encontrada.");
                    }
                }
                case 6 -> System.out.println("Saliendo del sistema...");
                default -> System.out.println("Opción inválida, intente de nuevo.");
            }
        } while (opcion != 6);

        scanner.close();
    }

    private static Cabina buscarCabina(ArrayList<Cabina> cabinas, int id) {
        return cabinas.stream().filter(c -> c.getId() == id).findFirst().orElse(null);
    }
}
