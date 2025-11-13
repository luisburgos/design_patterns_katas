# Kata: Adapter

## Contexto
Estás trabajando en un sistema de procesamiento de datos que debe manejar múltiples formatos (XML, JSON, YAML). Cada formato tiene su propia biblioteca de terceros con métodos diferentes para realizar la misma operación: parsear datos. El código actual tiene múltiples condicionales que verifican el tipo de formato y llaman al método específico de cada parser, lo que hace que el código sea difícil de mantener y extender.

## El Patrón: Adapter

El patrón Adapter **permite que clases con métodos incompatibles trabajen juntas**. Actúa como un traductor que convierte los métodos de una clase en los métodos que tu aplicación espera, sin necesidad de modificar el código original (principio abierto/cerrado). Esto te permite tratar todas las clases de manera uniforme, aunque internamente funcionen diferente.

El Adapter resuelve el problema de incompatibilidad de interfaces al:
- Crear una interfaz común que tu aplicación espera
- Envolver cada clase incompatible con un adaptador que implementa esa interfaz
- Traducir las llamadas de tu aplicación a los métodos específicos de cada clase

Beneficios principales:
- **Principio abierto/cerrado**: Puedes agregar nuevos adaptadores sin modificar el código existente
- **Principio de responsabilidad única**: Separa la lógica de conversión de interfaz del código de negocio
- **Polimorfismo**: Trata objetos incompatibles de manera uniforme a través de una interfaz común
- **Reducción de acoplamiento**: El código cliente no depende de las implementaciones concretas

## ¿Cuándo usar este patrón?

- **Integración con bibliotecas de terceros**: Cuando necesitas usar una clase existente que no tiene la interfaz que tu código espera y no puedes modificarla.
- **Múltiples implementaciones con interfaces diferentes**: Cuando tienes varias clases que hacen lo mismo pero con métodos diferentes (como parsers de distintos formatos).
- **Sistemas legados**: Cuando necesitas integrar código nuevo con sistemas antiguos que tienen interfaces incompatibles, sin reescribir el código existente.

## Challenge

Para poner en práctica el patrón Adapter, consulta el [README del challenge](./challenge/) que contiene un ejercicio práctico.

## Recursos Adicionales

- [Refactoring Guru - Adapter Pattern](https://refactoring.guru/design-patterns/adapter)
- [Source Making - Adapter Pattern](https://sourcemaking.com/design_patterns/adapter)
