package observer.challenge;

public class Main {
    public static void main(String[] args) {
        WeatherStation station = new WeatherStation();

        System.out.println("=== Actualizando temperatura ===\n");

        station.setTemperature(25.5f);

        System.out.println("\n=== Nueva actualización ===\n");

        station.setTemperature(30.0f);

        System.out.println("\n=== Agregando un nuevo display ===");
        System.out.println("¿Qué tendrías que modificar para agregar un TabletDisplay?");
        System.out.println("¿Cómo podrías permitir que los displays se registren dinámicamente?");
    }
}
