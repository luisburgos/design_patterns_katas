# Kata: Observer

## Contexto
Estás trabajando en un sistema de estación meteorológica que debe mostrar la temperatura en múltiples dispositivos (teléfono, web, TV). Actualmente, la estación meteorológica conoce explícitamente cada display y debe actualizarlos manualmente cuando cambia la temperatura. Si necesitas agregar un nuevo tipo de display (como una tablet), debes modificar la clase `WeatherStation`, violando el principio abierto/cerrado y creando un alto acoplamiento.

## El Patrón: Observer

El patrón Observer permite que **cuando un objeto cambia su estado, todos los objetos interesados reciban una notificación automática** sin que el primero tenga que conocerlos directamente. Esto reduce el acoplamiento porque eliminas las dependencias directas entre quien notifica y quien escucha, haciendo que ambos dependan de abstracciones en lugar de clases concretas (principio de inversión de dependencias).

El Observer resuelve el problema de dependencias directas al:
- Definir una relación uno-a-muchos entre objetos, donde el cambio en uno notifica automáticamente a todos sus dependientes
- Permitir que los observadores se registren y desregistren dinámicamente
- Hacer que tanto el sujeto como los observadores dependan de abstracciones (interfaces)

Beneficios principales:
- **Principio abierto/cerrado**: Puedes agregar nuevos observadores sin modificar el sujeto
- **Principio de inversión de dependencias**: Tanto el sujeto como los observadores dependen de abstracciones
- **Bajo acoplamiento**: El sujeto no conoce las clases concretas de sus observadores
- **Flexibilidad**: Los observadores pueden registrarse y desregistrarse dinámicamente en tiempo de ejecución

## ¿Cuándo usar este patrón?

- **Notificaciones automáticas**: Cuando un cambio en un objeto requiere actualizar otros objetos, pero no sabes cuántos o cuáles son de antemano.
- **Desacoplamiento**: Cuando quieres que dos componentes interactúen sin que uno dependa directamente del otro, manteniendo bajo acoplamiento.
- **Sistemas de eventos**: Cuando necesitas implementar un sistema de suscripción donde múltiples partes del sistema reaccionan a cambios de estado sin dependencias directas.

## Challenge

Para poner en práctica el patrón Observer, consulta el [README del challenge](./challenge/) que contiene un ejercicio práctico.

## Recursos Adicionales

- [Refactoring Guru - Observer Pattern](https://refactoring.guru/design-patterns/observer)
- [Source Making - Observer Pattern](https://sourcemaking.com/design_patterns/observer)
