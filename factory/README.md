# Kata: Factory Pattern

## Contexto
Estás trabajando en un sistema de notificaciones para una aplicación móvil. El sistema debe enviar notificaciones a través de diferentes canales (Email, SMS, Push) dependiendo de las preferencias del usuario. Actualmente, el código tiene múltiples condicionales para decidir qué tipo de notificación crear.

## El Patrón: Factory

El patrón Factory encapsula la lógica de creación de objetos en una clase o método separado, eliminando la necesidad de instanciar objetos directamente en el código cliente. Esto permite que el código sea más flexible y fácil de mantener, ya que centraliza la creación de objetos (encapsulamiento) y facilita añadir nuevos tipos sin modificar el código existente (principio abierto/cerrado).

El Factory resuelve el problema de múltiples condicionales al:
- Crear una interfaz común que define el contrato para todos los productos
- Encapsular la lógica de decisión (if-else/switch) en una clase Factory separada
- Delegar la responsabilidad de creación al Factory, permitiendo que el cliente trabaje solo con la interfaz

Beneficios principales:
- **Principio abierto/cerrado**: Puedes agregar nuevos tipos de productos sin modificar el código cliente
- **Principio de responsabilidad única**: Separa la lógica de creación del código de negocio
- **Polimorfismo**: Trata todos los objetos creados de manera uniforme a través de una interfaz común
- **Reducción de acoplamiento**: El código cliente no depende de las implementaciones concretas, solo de la interfaz

## ¿Cuándo usar este patrón?

- **Múltiples condicionales para crear objetos**: Cuando tienes bloques if-else o switch para decidir qué tipo de objeto crear.
- **Necesitas extensibilidad**: Cuando anticipas agregar nuevos tipos frecuentemente.
- **Creación compleja**: Cuando la lógica de creación de objetos es compleja o requiere configuración.

## Challenge

Para poner en práctica el patrón Factory, consulta el [README del challenge](./challenge/) que contiene un ejercicio práctico.

## Recursos Adicionales

- [Refactoring Guru - Factory Pattern](https://refactoring.guru/design-patterns/factory-method)
- [Source Making - Factory Pattern](https://sourcemaking.com/design_patterns/factory_method)