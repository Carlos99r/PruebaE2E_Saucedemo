Automatizacion E2E SauceDemo con Serenity BDD

1. Prerequisitos

Antes de ejecutar el proyecto, la maquina local debe contar con lo siguiente:

- Sistema operativo Windows 10 o superior
- IDE IntelliJ IDEA
- JDK 1.8 configurado en la variable de entorno JAVA_HOME
- Gradle Wrapper incluido en el proyecto
- Google Chrome instalado
- ChromeDriver compatible con la version local de Chrome, si el entorno no permite descarga automatica
- Conexion a internet para descargar dependencias de Gradle, si no se encuentran en cache local

Versiones usadas en el proyecto:

- Java 8
- Gradle 7.6.4
- Serenity BDD 2.6.0
- Cucumber 6 integrado con Serenity
- JUnit 4.13.2
- SLF4J Simple 1.7.36

2. Comandos de instalacion

Ubicarse en la raiz del proyecto y ejecutar los siguientes comandos segun corresponda.

Clonar el proyecto:

git clone https://github.com/Carlos99r/PruebaE2E_Saucedemo.git
cd Saucedemo

Descargar dependencias y compilar en Windows:

gradlew.bat clean testClasses

Descargar dependencias y compilar en Git Bash u otra terminal compatible:

./gradlew clean testClasses

Este comando descarga las dependencias declaradas en build.gradle y compila las clases de prueba.

3. Instrucciones para ejecutar los test

1. Abrir una terminal en la raiz del proyecto.
2. Verificar la version de Java:

java -version

3. Ejecutar la automatizacion.

En Windows:

gradlew.bat clean test aggregate

En Git Bash u otra terminal compatible:

./gradlew clean test aggregate

4. Esperar la finalizacion de la ejecucion.
5. Revisar el reporte generado por Serenity en la siguiente ruta:

target\site\serenity\index.html

Flujo automatizado cubierto:

- Abrir la aplicacion SauceDemo
- Iniciar sesion con un usuario valido
- Agregar productos al carrito
- Ingresar al carrito
- Completar el checkout
- Validar el mensaje final de compra

4. Informacion adicional

- La configuracion principal de Serenity se encuentra en src/test/resources/serenity.conf
- El escenario funcional esta definido en src/test/resources/features/purchase_flow.feature
- El runner principal se encuentra en src/test/java/com/saucedemo/runners/PurchaseRunner.java
- Si el entorno corporativo bloquea la descarga automatica del driver, se debe configurar manualmente un chromedriver.exe compatible con la version local de Chrome
- Si Chrome se actualiza y el driver queda desfasado, la ejecucion puede presentar errores al iniciar el navegador
- El mensaje final validado por la automatizacion es estricto. Si la aplicacion muestra un texto distinto al esperado, aunque visualmente sea similar, la prueba fallara
