
class Cabina {
    private int id;
    private String ubicacion;
    private int totalLlamadas;
    private int duracionTotal;
    private int costoTotal;

    public Cabina() {
    }

    public Cabina(int id, String ubicacion, int totalLlamadas, int duracionTotal, int costoTotal) {
        this.id = id;
        this.ubicacion = ubicacion;
        this.totalLlamadas = totalLlamadas;
        this.duracionTotal = duracionTotal;
        this.costoTotal = costoTotal;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public int getTotalLlamadas() {
        return totalLlamadas;
    }

    public void setTotalLlamadas(int totalLlamadas) {
        this.totalLlamadas = totalLlamadas;
    }

    public int getDuracionTotal() {
        return duracionTotal;
    }

    public void setDuracionTotal(int duracionTotal) {
        this.duracionTotal = duracionTotal;
    }

    public int getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(int costoTotal) {
        this.costoTotal = costoTotal;
    }

    public Cabina(int id, String ubicacion) {
        this.id = id;
        this.ubicacion = ubicacion;
        this.totalLlamadas = 0;
        this.duracionTotal = 0;
        this.costoTotal = 0;
    }

    public int getId() {
        return id;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void registrarLlamada(int tipo, int minutos) {
        int costo = switch (tipo) {
            case 1 -> minutos * 50;
            case 2 -> minutos * 350;
            case 3 -> minutos * 150;
            default -> {
                System.out.println("Tipo de llamada inválido");
                yield 0;
            }
        };
        if (costo > 0) {
            totalLlamadas++;
            duracionTotal += minutos;
            costoTotal += costo;
            System.out.println("Llamada registrada exitosamente.");
        }
    }

    public void mostrarInfo() {
        System.out.printf("Cabina ID: %d | Ubicación: %s%n", id, ubicacion);
        System.out.printf("Total de llamadas: %d%n", totalLlamadas);
        System.out.printf("Duración total: %d minutos%n", duracionTotal);
        System.out.printf("Costo total: $%d pesos%n", costoTotal);
    }

    public void reiniciarCabina() {
        totalLlamadas = 0;
        duracionTotal = 0;
        costoTotal = 0;
        System.out.println("Cabina reiniciada correctamente.");
    }
}