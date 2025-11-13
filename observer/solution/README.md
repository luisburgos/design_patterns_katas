# Solución (Observer)

⚠️ **Intenta resolver el reto antes de ver la solución**

## Cambios Principales

1. **Interfaz `TemperatureObserver`**: Se creó una interfaz común que define el método `update()` que todos los displays deben implementar para recibir notificaciones
2. **Interfaz `TemperatureSubject`** (opcional): Define el contrato para el sujeto observable con métodos `registerObserver()`, `removeObserver()` y `notifyObservers()`, promoviendo el uso de abstracciones
3. **`WeatherStation` refactorizado**: Ahora mantiene una lista de observadores en lugar de referencias directas a displays específicos. Implementa métodos para registro/desregistro dinámico y notifica automáticamente a todos los observadores cuando cambia la temperatura
4. **Displays refactorizados**: Todas las clases de display (`PhoneDisplay`, `WebDisplay`, `TvDisplay`) ahora implementan la interfaz `TemperatureObserver`, permitiendo que sean tratados de manera uniforme
5. **Registro dinámico**: Los displays ahora se registran a sí mismos en la estación meteorológica, invirtiendo el control y eliminando el acoplamiento directo. Se pueden agregar o remover observadores en tiempo de ejecución

## Salida Esperada

```
=== Primera actualización ===
Phone display: Temperature is 25.0°C
Web display: Temperature is 25.0°C
TV display: Temperature is 25.0°C

=== Segunda actualización ===
Phone display: Temperature is 30.0°C
Web display: Temperature is 30.0°C
TV display: Temperature is 30.0°C

=== Removiendo Web Display ===

=== Tercera actualización (sin Web Display) ===
Phone display: Temperature is 22.0°C
TV display: Temperature is 22.0°C

=== Agregando un nuevo Display ===

=== Cuarta actualización (con Tablet Display) ===
Phone display: Temperature is 28.5°C
TV display: Temperature is 28.5°C
Tablet display: Temperature is 28.5°C
```

Con la solución aplicada, agregar un nuevo display (como `TabletDisplay`) solo requiere:
1. Crear una clase que implemente la interfaz `TemperatureObserver`
2. Registrarla en la `WeatherStation` usando `registerObserver()`

No es necesario modificar `WeatherStation`, cumpliendo así el principio abierto/cerrado. Además, los observadores pueden registrarse y desregistrarse dinámicamente en tiempo de ejecución, proporcionando gran flexibilidad.
