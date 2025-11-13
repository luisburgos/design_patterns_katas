# Reto (Observer)

## Instrucciones

Refactoriza el código para que `WeatherStation` no conozca directamente a los displays específicos. Implementa el patrón Observer de manera que nuevos displays puedan registrarse dinámicamente para recibir actualizaciones sin modificar la clase `WeatherStation`, reduciendo el acoplamiento y aplicando el principio de inversión de dependencias.

Tu solución debe permitir agregar nuevos tipos de displays sin modificar la clase `WeatherStation`, aplicando el principio abierto/cerrado.

## Código a Refactorizar

**Archivo: `challenge/WeatherStation.java`**
```java
package observer.challenge;

public class WeatherStation {
    private float temperature;
    private PhoneDisplay phoneDisplay;
    private WebDisplay webDisplay;
    private TvDisplay tvDisplay;

    public WeatherStation() {
        this.phoneDisplay = new PhoneDisplay();
        this.webDisplay = new WebDisplay();
        this.tvDisplay = new TvDisplay();
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;

        phoneDisplay.updateTemperature(temperature);
        webDisplay.updateTemperature(temperature);
        tvDisplay.updateTemperature(temperature);
    }
}
```

**Archivo: `challenge/PhoneDisplay.java`**
```java
package observer.challenge;

public class PhoneDisplay {
    public void updateTemperature(float temp) {
        System.out.println("Phone display: Temperature is " + temp + "°C");
    }
}
```

**Archivo: `challenge/WebDisplay.java`**
```java
package observer.challenge;

public class WebDisplay {
    public void updateTemperature(float temp) {
        System.out.println("Web display: Temperature is " + temp + "°C");
    }
}
```

**Archivo: `challenge/TvDisplay.java`**
```java
package observer.challenge;

public class TvDisplay {
    public void updateTemperature(float temp) {
        System.out.println("TV display: Temperature is " + temp + "°C");
    }
}
```

**Archivo: `challenge/Main.java`**
```java
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
```

## Tips

💡 **Rompe las dependencias directas**
- Actualmente `WeatherStation` conoce explícitamente a `PhoneDisplay`, `WebDisplay` y `TvDisplay`.
- ¿Qué pasaría si quisieras agregar un `TabletDisplay`? Tendrías que modificar `WeatherStation`.
- Necesitas una forma de que los displays se "registren" sin que `WeatherStation` los conozca de antemano.
- El patrón Observer elimina estas dependencias directas mediante el uso de una abstracción común.

💡 **Identifica los observadores**
- En lugar de tener variables individuales para cada display, considera mantener una colección (lista) de "observadores interesados".
- Cuando cambie la temperatura, simplemente recorre esta lista y notifica a todos.
- ¿Qué tipo deberían tener los elementos de esta lista? Una interfaz común que todos los displays implementen.
- Esta interfaz debe definir un método que `WeatherStation` pueda llamar para notificar cambios (por ejemplo, `update()`).

💡 **Invierte el control**
- En lugar de que `WeatherStation` cree los displays (como lo hace en el constructor), permite que los displays se agreguen a sí mismos a la estación.
- Necesitarás métodos como `registerObserver()` y `removeObserver()` en `WeatherStation`.
- Esto es inversión de dependencias en acción: ambos dependerán de una abstracción (la interfaz del observador).
- Una vez implementado, podrás agregar o quitar displays dinámicamente sin modificar `WeatherStation`.

## Recursos Adicionales

- [Refactoring Guru - Observer Pattern](https://refactoring.guru/design-patterns/observer)
- [Source Making - Observer Pattern](https://sourcemaking.com/design_patterns/observer)
