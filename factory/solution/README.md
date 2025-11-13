# Solución (Factory)

⚠️ **Intenta resolver el reto antes de ver la solución**

## Cambios Principales

1. **Interfaz `Notification`**: Se creó una interfaz común que define el contrato para todas las notificaciones
2. **Clases refactorizadas**: Todas las clases de notificación ahora implementan la interfaz `Notification`
3. **`NotificationFactory`**: Nueva clase que encapsula la lógica de creación
4. **`NotificationService` simplificado**: Ahora solo usa el Factory y la interfaz común

## Salida Esperada

```
=== Enviando notificaciones con diferentes tipos ===

Sending email: Welcome to our platform!
Sending SMS: Your code is: 1234
Sending push notification: You have a new message

=== Agregando un nuevo tipo de notificación ===
¿Qué tendrías que modificar para agregar soporte para notificaciones de Slack?
```

Con la solución aplicada, agregar un nuevo tipo de notificación (como Slack) solo requiere:
1. Crear una clase `SlackNotification` que implemente la interfaz `Notification`
2. Agregar el caso en el Factory para el tipo "SLACK"

No es necesario modificar `NotificationService`, cumpliendo así el principio abierto/cerrado.