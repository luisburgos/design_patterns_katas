# Reto (Adapter)

## Instrucciones

Refactoriza el código para que `DataProcessor` no necesite conocer los detalles específicos de cada parser de formato. Crea una interfaz común y adaptadores que permitan tratar todos los parsers de manera uniforme, aplicando polimorfismo y reduciendo el acoplamiento entre clases.

Tu solución debe permitir agregar nuevos formatos de datos sin modificar la clase `DataProcessor`, aplicando el principio abierto/cerrado.

## Código a Refactorizar

**Archivo: `challenge/DataProcessor.java`**
```java
package adapter.challenge;

public class DataProcessor {
    public void processData(String format, String data) {
        if (format.equals("XML")) {
            XmlParser xmlParser = new XmlParser();
            xmlParser.parseXmlData(data);
        } else if (format.equals("JSON")) {
            JsonParser jsonParser = new JsonParser();
            jsonParser.readJsonString(data);
        } else if (format.equals("YAML")) {
            YamlParser yamlParser = new YamlParser();
            yamlParser.loadYamlContent(data);
        }
    }
}
```

**Archivo: `challenge/XmlParser.java`**
```java
package adapter.challenge;

public class XmlParser {
    public void parseXmlData(String xmlData) {
        System.out.println("Parsing XML data: " + xmlData);
        // Lógica específica de XML
    }
}
```

**Archivo: `challenge/JsonParser.java`**
```java
package adapter.challenge;

public class JsonParser {
    public void readJsonString(String jsonString) {
        System.out.println("Reading JSON string: " + jsonString);
        // Lógica específica de JSON
    }
}
```

**Archivo: `challenge/YamlParser.java`**
```java
package adapter.challenge;

public class YamlParser {
    public void loadYamlContent(String yamlContent) {
        System.out.println("Loading YAML content: " + yamlContent);
        // Lógica específica de YAML
    }
}
```

**Archivo: `challenge/Main.java`**
```java
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
```

## Tips

💡 **Identifica la incompatibilidad**
- Los tres parsers hacen lo mismo (parsear datos) pero cada uno expone un método con nombre diferente: `parseXmlData()`, `readJsonString()`, `loadYamlContent()`.
- El patrón Adapter resuelve exactamente este problema: métodos diferentes que hacen lo mismo.
- Pregúntate: ¿qué tienen en común estas tres clases? ¿Cuál es la operación esencial que todas realizan?

💡 **Define lo que el cliente necesita**
- Pregúntate: ¿qué operación necesita realmente `DataProcessor`? Probablemente algo simple como "parsear datos".
- Crea una interfaz que represente esta necesidad desde la perspectiva del cliente, no desde la perspectiva de los parsers.
- La interfaz debe ser genérica y no estar acoplada a detalles de implementación específicos de XML, JSON o YAML.

💡 **Envuelve, no modifiques**
- No puedes (ni debes) cambiar las clases `XmlParser`, `JsonParser` o `YamlParser` porque son de terceros.
- En su lugar, crea clases "envoltorio" (wrappers) que contengan estas clases y traduzcan sus interfaces a la interfaz común que definiste.
- Cada adaptador debería tener una instancia del parser original y delegar las llamadas al método específico de ese parser.
- Una vez implementados los adaptadores, `DataProcessor` debería poder trabajar con cualquier parser a través de la interfaz común, eliminando los condicionales.

## Recursos Adicionales

- [Refactoring Guru - Adapter Pattern](https://refactoring.guru/design-patterns/adapter)
- [Source Making - Adapter Pattern](https://sourcemaking.com/design_patterns/adapter)
