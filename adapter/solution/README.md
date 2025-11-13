# Solución (Adapter)

⚠️ **Intenta resolver el reto antes de ver la solución**

## Cambios Principales

1. **Interfaz `DataParser`**: Se creó una interfaz común que define el contrato que el cliente (`DataProcessor`) necesita para parsear datos
2. **Adaptadores para cada parser**: Se crearon tres adaptadores (`XmlParserAdapter`, `JsonParserAdapter`, `YamlParserAdapter`) que envuelven los parsers de terceros y traducen sus métodos específicos a la interfaz común
3. **Clases de terceros sin cambios**: Los parsers originales (`XmlParser`, `JsonParser`, `YamlParser`) permanecen intactos, ya que son bibliotecas de terceros que no podemos modificar
4. **`DataParserFactory`** (opcional): Se puede crear un Factory que encapsula la lógica de selección de adaptadores, combinando dos patrones
5. **`DataProcessor` simplificado**: Ahora solo depende de la interfaz `DataParser` y elimina todos los condicionales y dependencias directas a los parsers específicos

## Salida Esperada

```
=== Procesando datos en diferentes formatos ===

Parsing XML data: <user><name>Juan</name></user>
Reading JSON string: {"name": "María"}
Loading YAML content: name: Pedro

=== Agregando un nuevo formato ===
¿Qué tendrías que modificar para agregar soporte CSV?
```

Con la solución aplicada, agregar un nuevo formato (como CSV) solo requiere:
1. Crear un nuevo adaptador `CsvParserAdapter` que implemente `DataParser`
2. Agregar el caso en el Factory (si lo usaste)

No es necesario modificar `DataProcessor`, cumpliendo así el principio abierto/cerrado.
