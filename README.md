<h1>Conversor de monedas</h1>
<p>Herramienta de conversión de monedas desarrollada en Java empleando ExchangeRate-API . Este proyecto forma parte del programa de desarrollador back-end de Oracle ONE(G6) de Alura Latam.</p>

<h2>Descripción del proyecto</h2>
<p>Cuenta con dos modos de uso, un modo normal y uno avanzado.</p>
<p>La interacción con el usuario es por medio de consola. </p>
<p>En el modo normal se muestra un menú de conversión de uso frecuente. En el modo avanzado se permite convertir una mayor cantidad de opciones de moneda.</p>

<h2>Características</h2>
<ul>
  <li>Java - <em>Lenguaje base en que se desarrolló la herramienta.</em></li>
  <li>ExchangeRate-API - <em>API que permite la conversión para 161 tipos de monedas diferentes.</em></li>
  <li>Gson - <em>Emplea la librería Gson para acceder a la respuesta de la API</em></li>
  <li>HttpClient, HttpRequest, HttpResponse - <em>Para realizar las peticiones a la API</em></li>
</ul>

<h2>Instalación y ejecución</h2>
<ul>
  <li>Clonar este repositorio en su computadora.</li>
  <li>Abrir el proyecto con su IDE preferido. </li>
  <li>Añadir la biblioteca Gson a las dependencias del proyecto.</li>
  <li>Ejecutar el método "main" de la clase "Main".</li>
  <li>Seguir las instrucciones de la consola. </li>
</ul>

<h2>Guía de uso</h2>
<p>Una vez iniciado el programa, lo primero que se mostrará será un menú de 10 opciones, que incluye las conversiones más frecuentes, una opción para ingresar al modo avanzado y una opción para salir.</p>

![Imagen 1](images/Tutorial-01.png)

<p>Ingresamos por consola la opción que deseemos, para este ejemplo utilizaremos 8.</p>

![Imagen 2](images/Tutorial-02.png)

<p>Una vez ingresada la opción, nos solicitará el monto a convertir, para este ejemplo usaremos 500. Una vez ingresado nos mostrará el resultado de la conversión.</p>

![Imagen 3](images/Tutorial-03.png)

<p> Una vez terminada la conversión se vuelve a mostrar el menú inicial. Esta vez ingresamos 9 para acceder al modo avanzado, con lo cual se nos mostrará un nuevo menú de 3 opciones. </p>

![Imagen 4](images/Tutorial-04.png)

<p> Ingresamos la opción 1 para iniciar la conversión. Nos despliega un nuevo menú con 16 opciones de moneda para convertir.</p>

![Imagen 5](images/Tutorial-05.png)

<p> Elegimos en este ejemplo la opción 16. Nos solicitará ingresar el monto a convertir. </p>

![Imagen 6](images/Tutorial-06.png)

<p>Para este ejemplo ingresamos 100. Nuevamente nos mostrará un menú de 16 opciones, pero esta vez para elegir la moneda destino. </p>

![Imagen 7](images/Tutorial-07.png)

<p>En este ejemplo seleccionamos la opción 12. La conversión inicia y al finalizar nos muestra el resultado.</p>

![Imagen 8](images/Tutorial-08.png)

<p>Una vez finalizada la conversión se vuelve a mostrar el menú avanzado. En este punto podemos elegir continuar convirtiendo, regresar al modo normal o salir de la herramienta.</p>

![Imagen 9](images/Tutorial-09.png)

<p>En cualquiera de los dos menú, al momento de elegir la opción salir, se nos mostrará un historial de las conversiones realizadas durante la sesión activa y posteriormente finalizará el programa.</p>

![Imagen 10](images/Tutorial-10.png)

<h2>Autor</h2>
<p>Antonio Valdez Aguayo</p>


