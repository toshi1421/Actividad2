# Actividad2
# Servicio de Reservas

## Comunicación con OpenFeign

¿Qué es?
Es una herramienta que permite que el servicio de Reservas llame al de Canchas de forma fácil, como si fuera una función interna.

## Cambios realizados

- Se agregó la dependencia de Spring Cloud OpenFeign.
- Se activó @EnableFeignClients en la clase principal.
- Se creó la interfaz CanchaFeignClient para conectar ambos servicios.
- Se configuró la URL del servicio de Canchas en application.properties.
