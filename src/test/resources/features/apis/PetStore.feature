@TiendaMascota
Feature: Tienda de Mascotas


@CrearMascota
Scenario: Crear nueva Mascota

  Given el Usuario accede a la tienda
  When crea una nueva mascota "Rocky" en "doggie" con codigo "290"
  Then la respuesta es correcta

@ConsultaMascota
Scenario: Consulta de Mascota

  Given el Usuario accede a la tienda
  When consulta una mascota de ID "290"
  Then la respuesta es correcta