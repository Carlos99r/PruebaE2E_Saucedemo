# language: es
Característica: Flujo de compra en SauceDemo
  Como usuario autenticado
  Quiero comprar productos en SauceDemo
  Para validar que el proceso end to end funciona correctamente

  Escenario: Compra exitosa de dos productos
    Dado que el usuario inicia sesion en SauceDemo
    Cuando agrega dos productos al carrito y completa la compra
    Entonces debe visualizar la confirmacion de compra exitosa
