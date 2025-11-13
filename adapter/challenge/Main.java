package adapter.challenge;

public class Main {
    public static void main(String[] args) {
        DataProcessor processor = new DataProcessor();

        // Procesando diferentes formatos de datos
        System.out.println("=== Procesando datos en diferentes formatos ===\n");

        processor.processData("XML", "<user><name>Juan</name></user>");
        processor.processData("JSON", "{\"name\": \"María\"}");
        processor.processData("YAML", "name: Pedro");

        System.out.println("\n=== Agregando un nuevo formato ===");
        System.out.println("¿Qué tendrías que modificar para agregar soporte CSV?");
    }
}
