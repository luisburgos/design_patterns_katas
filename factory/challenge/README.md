# Reto (Factory)

## Instrucciones
Refactoriza el código para eliminar los condicionales del método `sendNotification` y centralizar la creación de objetos de notificación. Tu solución debe permitir agregar nuevos tipos de notificaciones sin modificar la clase `NotificationService`, aplicando el principio abierto/cerrado.

## Código a Refactorizar

**Archivo: `challenge/NotificationService.java`**
```java
public class NotificationService {
    public void sendNotification(String type, String message) {
        if (type.equals("EMAIL")) {
            EmailNotification email = new EmailNotification();
            email.setMessage(message);
            email.send();
        } else if (type.equals("SMS")) {
            SmsNotification sms = new SmsNotification();
            sms.setMessage(message);
            sms.send();
        } else if (type.equals("PUSH")) {
            PushNotification push = new PushNotification();
            push.setMessage(message);
            push.send();
        }
    }
}
```

**Archivo: `challenge/EmailNotification.java`**
```java
public class EmailNotification {
    private String message;
    
    public void setMessage(String message) {
        this.message = message;
    }
    
    public void send() {
        System.out.println("Sending email: " + message);
    }
}
```

**Archivo: `challenge/SmsNotification.java`**
```java
public class SmsNotification {
    private String message;
    
    public void setMessage(String message) {
        this.message = message;
    }
    
    public void send() {
        System.out.println("Sending SMS: " + message);
    }
}
```

**Archivo: `challenge/PushNotification.java`**
```java
public class PushNotification {
    private String message;
    
    public void setMessage(String message) {
        this.message = message;
    }
    
    public void send() {
        System.out.println("Sending push notification: " + message);
    }
}
```

**Archivo: `challenge/Main.java`**
```java
public class Main {
    public static void main(String[] args) {
        NotificationService service = new NotificationService();
        
        service.sendNotification("EMAIL", "Welcome to our platform!");
        service.sendNotification("SMS", "Your code is: 1234");
        service.sendNotification("PUSH", "You have a new message");
    }
}
```

## Tips

💡 **Busca la repetición**
- Observa las tres ramas del `if-else`. 
- ¿Qué patrón se repite en cada una? Las tres hacen prácticamente lo mismo: crear un objeto, configurarlo y usarlo. 
- Cuando veas este tipo de repetición en la creación de objetos, es una señal clara de que necesitas un Factory.

💡 **Piensa en interfaces**
- Todas las clases de notificación tienen métodos similares (`setMessage` y `send`). 
- ¿Qué pasaría si todas implementaran la misma interfaz? 
- Esto te permitiría trabajar con un tipo común en lugar de tipos específicos.

💡 **Centraliza la decisión**
- La lógica de "qué tipo crear" no debería estar en `NotificationService`. 
- Crea una clase separada cuya única responsabilidad sea decidir y crear el tipo correcto de notificación basándose en el parámetro `type`.

## Recursos Adicionales

- [Refactoring Guru - Factory Pattern](https://refactoring.guru/design-patterns/factory-method)
- [Source Making - Factory Pattern](https://sourcemaking.com/design_patterns/factory_method)