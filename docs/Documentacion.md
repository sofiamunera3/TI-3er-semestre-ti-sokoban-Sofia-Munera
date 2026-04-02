# Análisis y especificación del problema y los requerimientos funcionales

---

## **Cliente**
Empresa de desarrollo de software

## **Usuario**
Jugador

## **Contexto del problema**

El sistema es una aplicación que implementa el juego Sokoban, permitiendo a los usuarios registrarse, jugar diferentes niveles y analizar su desempeño. El usuario interactúa como jugador, ingresando sus datos para acceder al juego. Dentro del sistema, puede cargar niveles definidos en archivos JSON, controlar el movimiento del personaje en un tablero bidimensional y resolver los niveles ubicando cajas en posiciones objetivo. El sistema gestiona la lógica del juego, incluyendo validación de movimientos, interacción con objetos del entorno, detección de victoria y almacenamiento del estado de la partida. Además, permite visualizar estadísticas, rankings y ejecutar soluciones automáticas mediante algoritmos de búsqueda

---

# **Requerimientos funcionales (listado)**

- RF1 - Registrar Jugador
- RF2 - Cargar niveles
- RF3 - Iniciar juego
- RF4 - Mostrar tablero
- RF5 - Mover jugador
- RF6 - Empujar cajas
- RF7 - Validar movimientos
- RF8 - Verificación de victoria
- RF9 - Guardar/Cargar partida
- RF10 - Mostrar estadísticas del jugador
- RF11 - Ranking de jugadores
- RF12 - Deshacer movimiento
- RF13 - Solución automática
- RF14 - Mostrar cronómetro y contadores
- RF15 - Selección de nivel
- RF16 - Menú principal
- RF17 - Mostrar resultado del juego
- RF18 - Manual de usuario

---

# **Requerimientos no funcionales**

- RNF1 - El sistema debe desarrollarse en Java utilizando JavaFX.
- RNF2 - El sistema debe seguir el patrón de diseño MVC.
- RNF3 - El sistema debe almacenar partidas y datos de jugadores en archivos persistentes.
- RNF4 - La interfaz gráfica debe ser clara, visualmente entendible y fácil de usar.
- RNF5 - El código fuente del proyecto debe estar escrito en inglés.
- RNF6 - El sistema debe permitir realizar cambios o ampliaciones sin afectar el funcionamiento principal.
- RNF7 - El sistema debe responder de forma inmediata a las acciones del jugador durante la partida.

---

# **Requerimientos de proceso (listado)**

- RP1 - El proyecto debe desarrollarse aplicando metodologías ágiles.
- RP2 - El control de versiones debe gestionarse mediante Git y GitHub con Gitflow.
- RP3 - El repositorio debe incluir al menos 15 commits significativos con buenas prácticas de calidad.
- RP4 - El proyecto debe incluir pruebas unitarias automatizadas.
- RP5 - El proyecto debe documentarse en un archivo README.md.
- RP6 - El diseño del sistema debe representarse mediante diagramas UML.

---

# **Especificación de Requerimientos Funcionales**

---

## **Identificador y nombre**
**RF1 - Registrar Jugador**

### **Resumen**
El sistema debe permitir registrar un jugador mediante un formulario que solicite nombre completo, correo electrónico, nombre de usuario, avatar y nivel de experiencia. El sistema valida que la información ingresada cumpla con las condiciones definidas y, si los datos son correctos, crea y almacena el perfil del jugador para que pueda acceder al juego.

### **Entradas**

| Nombre entrada | Tipo de dato | Condición valores válidos |
|---|---|---|
| Nombre completo | String | Mínimo 5 caracteres, solo letras y espacios |
| Correo electrónico | String | Debe cumplir formato válido, por ejemplo usuario@correo.com |
| Username | String | No debe estar vacío |
| Avatar | String | Debe existir una selección válida |
| Nivel de experiencia | String | Debe ser Principiante, Avanzado o Experto |

### **Resultado o Postcondición**
El jugador queda registrado e incorporado al sistema.

### **Salidas**

| Nombre salida | Tipo de dato | Formato |
|---|---|---|
| Mensaje de confirmación | String | “Registro exitoso” |
| Estado de registro | Boolean | true / false |
| Perfil del jugador | Objeto | Información almacenada del jugador |

---

## **Identificador y nombre**
**RF2 - Cargar niveles**

### **Resumen**
El sistema debe permitir cargar los niveles del juego desde archivos en formato JSON. Para hacerlo, primero debe validar que el archivo exista, tenga una estructura correcta y contenga la información necesaria para construir el tablero.

### **Entradas**

| Nombre entrada | Tipo de dato | Condición valores válidos |
|---|---|---|
| Archivo de nivel | Archivo JSON | Debe existir y tener estructura válida |
| Datos del tablero | Objeto | Deben corresponder a un nivel definido |
| Elementos del nivel | Lista | No debe estar vacía |

### **Resultado o Postcondición**
El nivel queda cargado correctamente en memoria.

### **Salidas**

| Nombre salida | Tipo de dato | Formato |
|---|---|---|
| Mensaje de carga | String | “Nivel cargado exitosamente” |
| Estado de carga | Boolean | true / false |
| Nivel cargado | Objeto | Estructura lógica del tablero |

---

## **Identificador y nombre**
**RF3 - Iniciar juego**

### **Resumen**
El sistema debe permitir iniciar una partida una vez el jugador haya sido registrado y haya seleccionado un nivel válido. Al iniciar, el sistema debe preparar el tablero, ubicar al jugador y los demás elementos del juego, activar el cronómetro y dejar la interfaz lista para recibir movimientos.
### **Entradas**

| Nombre entrada | Tipo de dato     | Condición valores válidos |
|---|------------------|---|
| Jugador registrado | Objeto           | Debe existir previamente |
| Nivel seleccionado | Int              | Debe corresponder a un nivel disponible |
| Comando de inicio | Boolean / String | Debe activarse la opción de iniciar |

### **Resultado o Postcondición**
La partida comienza y el tablero queda habilitado para jugar.

### **Salidas**

| Nombre salida | Tipo de dato | Formato |
|---|---|---|
| Estado de partida | Boolean | true / false |
| Tablero inicial | Objeto | Representación del juego al inicio |
| Mensaje de inicio | String | “Juego iniciado” |

---

## **Identificador y nombre**
**RF4 - Mostrar tablero**

### **Resumen**
El sistema debe representar visualmente el estado actual del juego en pantalla, mostrando la posición del jugador, las cajas, los muros, los objetivos y los espacios libres. Cada vez que ocurra un cambio en el estado del juego, la interfaz debe actualizarse para reflejar correctamente el tablero. Esto garantiza coherencia entre la lógica interna y la vista mostrada al usuario.

### **Entradas**

| Nombre entrada | Tipo de dato | Condición valores válidos |
|---|---|---|
| Estado del tablero | Objeto | Debe existir y estar cargado |
| Elementos del juego | Lista | Debe contener los objetos del tablero |
| Posiciones | Coordenadas | Deben ser válidas dentro de la matriz |

### **Resultado o Postcondición**
El tablero se muestra correctamente en la interfaz.

### **Salidas**

| Nombre salida | Tipo de dato | Formato |
|---|---|---|
| Tablero visual | Interfaz gráfica | Representación 2D |
| Estado de visualización | Boolean | true / false |
| Elementos  | Lista| Jugador, cajas, muros, objetivos |

---

## **Identificador y nombre**
**RF5 - Mover jugador**

### **Resumen**
El sistema debe permitir mover al jugador en las cuatro direcciones posibles: arriba, abajo, izquierda y derecha. Antes de ejecutar el movimiento, debe comprobar que la dirección ingresada sea válida y que la posición destino se encuentre dentro de los límites del tablero.

### **Entradas**

| Nombre entrada | Tipo de dato | Condición valores válidos |
|---|---|---|
| Dirección de movimiento | String | Debe ser Arriba, Abajo, Izquierda o Derecha |
| Posición actual del jugador | Coordenada | Debe existir dentro del tablero |
| Casilla destino | Coordenada | Debe corresponder a una posición válida |

### **Resultado o Postcondición**
El jugador cambia de posición si el movimiento es válido.

### **Salidas**

| Nombre salida | Tipo de dato | Formato |
|---|---|---|
| Nueva posición del jugador | Coordenada | (x, y) |
| Estado del movimiento | Boolean | true / false |
| Tablero actualizado | Objeto | Estado posterior al movimiento |

---

## **Identificador y nombre**
**RF6 - Empujar cajas**

### **Resumen**
El sistema debe permitir empujar una caja cuando el jugador intenta moverse hacia una casilla ocupada por ella y la casilla siguiente se encuentra libre.

### **Entradas**

| Nombre entrada | Tipo de dato | Condición valores válidos |
|---|---|---|
| Dirección de movimiento | String | Debe ser Arriba, Abajo, Izquierda o Derecha |
| Posición del jugador | Coordenada | Debe estar junto a una caja |
| Posición de la caja | Coordenada | Debe existir una caja en esa casilla |
| Casilla siguiente | Coordenada | Debe estar libre para permitir el empuje |

### **Resultado o Postcondición**
La caja cambia de posición y el jugador ocupa la casilla anterior de la caja.

### **Salidas**

| Nombre salida | Tipo de dato | Formato |
|---|---|---|
| Nueva posición de la caja | Coordenada | (x, y) |
| Estado de empuje | Boolean | true / false |
| Contadores actualizados | Int | Valores numéricos |
| Estado del tablero | Objeto | Tablero posterior al empuje |

---

## **Identificador y nombre**
**RF7 - Validar movimientos**

### **Resumen**
El sistema debe validar cada movimiento solicitado por el jugador antes de ejecutarlo. Para ello, debe revisar si la casilla destino está dentro del tablero, si no está bloqueada por un muro o una caja inmóvil, y si cumple las reglas del juego.

### **Entradas**

| Nombre entrada | Tipo de dato | Condición valores válidos |
|---|---|---|
| Dirección solicitada | String | Debe pertenecer al conjunto de movimientos permitidos |
| Posición actual | Coordenada | Debe ser válida dentro del tablero |
| Casilla destino | Coordenada | Debe existir dentro de los límites del tablero |
| Contenido de casilla | String / Objeto | Puede ser libre, muro, caja u objetivo |

### **Resultado o Postcondición**
El sistema determina si el movimiento puede ejecutarse o debe rechazarse.

### **Salidas**

| Nombre salida | Tipo de dato | Formato |
|---|---|---|
| Resultado de validación | Boolean | true / false |
| Motivo de rechazo | String | “Movimiento inválido” si aplica |
| Acción permitida | String | “Mover”, “Empujar” o “Bloquear” |

---

## **Identificador y nombre**
**RF8 - Verificación de victoria**

### **Resumen**
El sistema debe verificar después de cada jugada si el nivel ha sido completado. Para ello, compara la ubicación actual de las cajas con las posiciones objetivo o revisa si se ha alcanzado la condición de cumplimiento definida para el nivel.

### **Entradas**

| Nombre entrada | Tipo de dato | Condición valores válidos |
|---|---|---|
| Posiciones de cajas | Lista | No debe estar vacía |
| Posiciones objetivo | Lista | No debe estar vacía |
| Estado del nivel | Objeto | Debe corresponder a una partida activa |

### **Resultado o Postcondición**
El sistema determina si el nivel fue completado.

### **Salidas**

| Nombre salida | Tipo de dato | Formato |
|---|---|---|
| Estado de victoria | Boolean | true / false |
| Resultado del nivel | String | “Victoria” si se cumple la condición |
| Estado final del tablero | Objeto | Configuración final del nivel |

---

## **Identificador y nombre**
**RF9 - Guardar/Cargar partida**

### **Resumen**
El sistema debe permitir almacenar el estado actual de una partida para continuarla después, o recuperar una partida previamente guardada. Cuando el usuario elige guardar, el sistema serializa la información del tablero, del jugador y del progreso actual. Cuando elige cargar, el sistema restaura esos datos y reconstruye el estado de la partida exactamente como estaba.

### **Entradas**

| Nombre entrada | Tipo de dato | Condición valores válidos |
|---|---|---|
| Estado del juego | Objeto | Debe existir para guardar o restaurar |
| Acción | String | Debe ser “Guardar” o “Cargar” |
| Archivo de guardado | Archivo JSON | Debe existir si la acción es cargar |

### **Resultado o Postcondición**
La partida queda almacenada o restaurada correctamente.

### **Salidas**

| Nombre salida | Tipo de dato | Formato |
|---|---|---|
| Mensaje de acción | String | “Partida guardada” / “Partida cargada” |
| Estado de operación | Boolean | true / false |
| Archivo generado o leído | Archivo | Formato serializable |

---

## **Identificador y nombre**
**RF10 - Mostrar estadísticas del jugador**

### **Resumen**
El sistema debe mostrar información relacionada con el desempeño del jugador en sus partidas, como cantidad de movimientos, empujes, tiempo invertido, niveles completados y victorias. Estos datos deben recuperarse del historial almacenado y organizarse de forma clara para que el usuario pueda consultar su progreso.

### **Entradas**

| Nombre entrada | Tipo de dato | Condición valores válidos |
|---|---|---|
| Identificador del jugador | String / Objeto | Debe corresponder a un jugador registrado |
| Historial de partidas | Lista | Puede contener una o varias partidas registradas |

### **Resultado o Postcondición**
Las estadísticas del jugador quedan visibles en pantalla.

### **Salidas**

| Nombre salida | Tipo de dato | Formato |
|---|---|---|
| Estadísticas del jugador | Lista / Tabla | Datos organizados |
| Estado de consulta | Boolean | true / false |
| Resumen de desempeño | String | Información general del historial |

---

## **Identificador y nombre**
**RF11 - Ranking de jugadores**

### **Resumen**
El sistema debe generar y mostrar un ranking de jugadores a partir de su desempeño en el juego. Para construirlo, debe comparar criterios como niveles completados, tiempo, movimientos o puntaje, y luego ordenar a los jugadores según el criterio establecido.

### **Entradas**

| Nombre entrada | Tipo de dato | Condición valores válidos |
|---|---|---|
| Lista de jugadores | Lista | Debe contener jugadores registrados |
| Estadísticas acumuladas | Lista / Objeto | Deben existir datos de desempeño |
| Criterio de orden | String | Debe ser un criterio permitido por el sistema |

### **Resultado o Postcondición**
Se genera y visualiza un ranking actualizado de jugadores.

### **Salidas**

| Nombre salida | Tipo de dato | Formato |
|---|---|---|
| Ranking de jugadores | Tabla / Lista | Orden descendente o ascendente según criterio |
| Posición del jugador | Int | Número entero |
| Resumen de clasificación | String | Lista ordenada de jugadores |

---

## **Identificador y nombre**
**RF12 - Deshacer movimiento**

### **Resumen**
El sistema debe permitir al jugador regresar al estado inmediatamente anterior del juego después de haber realizado un movimiento. Para esto, debe conservar un historial de estados previos y recuperar el más reciente cuando el usuario solicite deshacer. Si no existe historial, la acción no debe ejecutarse y el estado del juego debe mantenerse igual.

### **Entradas**

| Nombre entrada | Tipo de dato | Condición valores válidos               |
|---|---|-----------------------------------------|
| Comando de deshacer | String | Debe ser “Undo” o “Ctrl+Z”              |
| Historial de movimientos | Lista | Debe contener al menos un estado previo |

### **Resultado o Postcondición**
El juego regresa al estado inmediatamente anterior si existe historial.

### **Salidas**

| Nombre salida | Tipo de dato | Formato |
|---|---|---|
| Estado restaurado | Objeto | Estado anterior del tablero |
| Confirmación de deshacer | Boolean | true / false |
| Mensaje de resultado | String | “Movimiento deshecho” o equivalente |

---

## **Identificador y nombre**
**RF13 - Solución automática**

### **Resumen**
El sistema debe permitir ejecutar una solución automática para ciertos niveles definidos, utilizando un algoritmo de búsqueda previamente seleccionado. Una vez activada esta opción, el sistema calcula una secuencia válida de movimientos y la reproduce para mostrar cómo se resuelve el nivel. Esta funcionalidad está pensada como apoyo o demostración en niveles avanzados.

### **Entradas**

| Nombre entrada | Tipo de dato | Condición valores válidos |
|---|---|---|
| Nivel actual | Int  | Debe corresponder a un nivel habilitado para esta función |
| Algoritmo de solución | String | Debe ser un algoritmo permitido |
| Estado inicial del tablero | Objeto | Debe existir y ser resoluble |

### **Resultado o Postcondición**
El sistema ejecuta una solución automática del nivel.

### **Salidas**

| Nombre salida | Tipo de dato | Formato |
|---|---|---|
| Secuencia de movimientos | Lista | Lista ordenada |
| Estado de ejecución | Boolean | true / false |
| Resultado visual | Interfaz gráfica | Animación o reproducción de la solución |

---

## **Identificador y nombre**
**RF14 - Mostrar cronómetro y contadores**

### **Resumen**
El sistema debe mostrar durante la partida un cronómetro y contadores de apoyo, como número de movimientos y cantidad de empujes. Estos valores deben actualizarse en tiempo real a medida que el jugador interactúa con el tablero. Su propósito es brindar retroalimentación constante sobre el desempeño del usuario dentro del nivel.

### **Entradas**

| Nombre entrada | Tipo de dato | Condición valores válidos |
|---|---|---|
| Tiempo transcurrido | Int | Debe ser mayor o igual a 0 |
| Cantidad de movimientos | Int | Debe ser mayor o igual a 0 |
| Cantidad de empujes | Int | Debe ser mayor o igual a 0 |

### **Resultado o Postcondición**
Los contadores se mantienen visibles y actualizados durante la partida.

### **Salidas**

| Nombre salida | Tipo de dato | Formato |
|---|---|---|
| Cronómetro | String | mm:ss |
| Contador de movimientos | Int | Número entero |
| Contador de empujes | Int | Número entero |

---

## **Identificador y nombre**
**RF15 - Selección de nivel**

### **Resumen**
El sistema debe permitir al jugador seleccionar uno de los niveles disponibles antes de iniciar la partida. Una vez realizada la selección, el sistema carga la configuración correspondiente y deja preparado el tablero del nivel elegido. Esto asegura que el usuario pueda escoger su dificultad o progreso antes de comenzar a jugar.

### **Entradas**

| Nombre entrada | Tipo de dato | Condición valores válidos |
|---|--------------|---|
| Nivel seleccionado | Int          | Debe estar entre los niveles disponibles |
| Opción de selección | String       | Debe provenir del menú de niveles |

### **Resultado o Postcondición**
El nivel elegido queda cargado y listo para iniciar.

### **Salidas**

| Nombre salida | Tipo de dato | Formato |
|---|---|---|
| Nivel cargado | Objeto | Configuración del tablero |
| Confirmación de selección | Boolean | true / false |
| Mensaje de selección | String | “Nivel seleccionado” |

---

## **Identificador y nombre**
**RF16 - Menú principal**

### **Resumen**
El sistema debe presentar al usuario un menú principal desde el cual pueda acceder a las funciones generales del juego, como iniciar partida, cargar partida, consultar estadísticas, revisar el ranking o abrir el manual de usuario. Este menú funciona como punto de entrada al sistema y debe facilitar la navegación entre las opciones disponibles.

### **Entradas**

| Nombre entrada | Tipo de dato | Condición valores válidos |
|---|---|---|
| Opción seleccionada | String | Debe corresponder a una opción válida del menú |

### **Resultado o Postcondición**
El sistema dirige al usuario hacia la funcionalidad seleccionada.

### **Salidas**

| Nombre salida | Tipo de dato | Formato |
|---|---|---|
| Pantalla destino | String | Vista asociada a la opción elegida |
| Estado de navegación | Boolean | true / false |
| Opción ejecutada | String | Nombre de la funcionalidad abierta |

---

## **Identificador y nombre**
**RF17 - Mostrar resultado del juego**

### **Resumen**
El sistema debe mostrar al finalizar la partida un resultado claro que indique si el jugador logró completar el nivel o no. Esta información se genera con base en el estado final del juego y puede incluir un mensaje visual acompañado de datos resumidos del desempeño alcanzado.

### **Entradas**

| Nombre entrada | Tipo de dato | Condición valores válidos |
|---|---|---|
| Estado de victoria | Boolean | Debe ser true o false |
| Datos finales de partida | Objeto | Deben existir al terminar el nivel |

### **Resultado o Postcondición**
El usuario visualiza el resultado final de la partida.

### **Salidas**

| Nombre salida | Tipo de dato | Formato |
|---|---|---|
| Resultado del juego | String | “Victoria” o “Game Over” |
| Resumen final | String / Tabla | Información final de la partida |
| Pantalla de cierre | Vista | Interfaz de resultado |

---

## **Identificador y nombre**
**RF18 - Manual de usuario**

### **Resumen**
El sistema debe permitir al usuario consultar un manual con instrucciones básicas de uso, controles del juego, explicación de la interfaz y descripción general de las funcionalidades disponibles. Esta información debe presentarse de forma clara para facilitar la comprensión del funcionamiento del sistema.

### **Entradas**

| Nombre entrada | Tipo de dato | Condición valores válidos |
|---|---|---|
| Solicitud de manual | Boolean | Debe activarse desde el menú o la interfaz |

### **Resultado o Postcondición**
El manual de usuario queda visible y disponible para consulta.

### **Salidas**

| Nombre salida | Tipo de dato | Formato |
|---|---|---|
| Manual de usuario | String / Documento | Texto informativo organizado |
| Estado de visualización | Boolean | true / false |
| Pantalla de ayuda | Vista | Sección informativa del sistema |

---

# **Diseño de casos de prueba**

---

# **Setups**

| ID Setup | Nombre | Descripción |
|---|---|---|
| Setup1 | Formulario de registro disponible | El sistema se encuentra en la pantalla de registro con los campos habilitados para ingresar nombre, correo, username, avatar y nivel de experiencia. |
| Setup2 | Módulo de carga de niveles disponible | El sistema permite seleccionar y cargar archivos JSON de niveles desde una ubicación válida. |
| Setup3 | Partida iniciada con tablero activo | Existe una partida en curso con tablero cargado, jugador posicionado y elementos visibles. |
| Setup4 | Partida activa con historial de movimientos | El juego se encuentra en ejecución y ya se han realizado movimientos válidos almacenados en historial. |
| Setup5 | Partida activa sin historial de movimientos | El tablero está cargado, pero el jugador aún no ha realizado ninguna acción. |
| Setup6 | Partida guardada previamente | Existe al menos un archivo de guardado válido disponible para ser restaurado. |
| Setup7 | Jugador con estadísticas registradas | El jugador existe y cuenta con historial de partidas, movimientos, empujes, tiempos y victorias. |
| Setup8 | Jugador registrado sin estadísticas | El jugador existe dentro del sistema, pero no tiene historial de partidas registradas. |
| Setup9 | Menú principal disponible | El usuario se encuentra en la pantalla principal del sistema con todas las opciones visibles. |
| Setup10 | Nivel experto cargado | El sistema tiene cargado un nivel habilitado para ejecutar la solución automática. |
| Setup11 | Módulo de manual disponible | El sistema tiene habilitada la opción de consultar el manual de usuario. |
| Setup12 | Partida finalizada | El juego terminó y existe un estado final de victoria o derrota. |

---

## **RF1 - Registrar Jugador**
**Técnica aplicada: Partición de Equivalencia**

### **Tabla de clases de equivalencia**

| Criterio | Clases válidas (V) | Clases inválidas (I) |
|---|---|---|
| Nombre | V1: Mínimo 5 caracteres, solo letras y espacios | I1: Menos de 5 caracteres |
|  |  | I2: Contiene números o símbolos |
| Correo electrónico | V2: Formato válido (usuario@correo.com) | I3: Formato inválido |
| Username | V3: Campo no vacío | I4: Campo vacío |

### **Casos de prueba**

| ID | Descripción | Setup | Datos de prueba | Pasos | Resultado esperado | Estado |
|---|---|---|---|---|---|---|
| CP01 | Verificar registro exitoso con datos válidos | Setup1 | Nombre: Valeria Castaño<br>Correo: valeria@correo.com<br>Username: valecs | 1. Ingresar al formulario<br>2. Digitar datos válidos<br>3. Seleccionar Registrar | El sistema muestra “Registro exitoso” y el estado de registro es true | Aceptado |
| CP02 | Verificar rechazo de nombre con longitud menor al mínimo | Setup1 | Nombre: Vale<br>Correo: valeria@correo.com<br>Username: valecs | 1. Ingresar nombre inválido<br>2. Completar los demás campos<br>3. Seleccionar Registrar | El sistema rechaza el registro e indica error en el nombre | Rechazado |
| CP03 | Verificar rechazo de nombre con caracteres no permitidos | Setup1 | Nombre: Vale123<br>Correo: valeria@correo.com<br>Username: valecs | 1. Ingresar nombre con números<br>2. Completar los demás campos<br>3. Seleccionar Registrar | El sistema rechaza el registro e indica que el nombre solo admite letras y espacios | Rechazado |
| CP04 | Verificar rechazo de correo con formato inválido | Setup1 | Nombre: Valeria Castaño<br>Correo: valeriacorreo.com<br>Username: valecs | 1. Ingresar correo inválido<br>2. Completar los demás campos<br>3. Seleccionar Registrar | El sistema rechaza el registro e indica error en el correo | Rechazado |
| CP05 | Verificar rechazo de Username vacío | Setup1 | Nombre: Valeria Castaño<br>Correo: valeria@correo.com<br>Username: vacío | 1. Dejar Username vacío<br>2. Completar los demás campos<br>3. Seleccionar Registrar | El sistema rechaza el registro y el estado es false | Rechazado |

---

## **RF2 - Cargar niveles**
**Técnica aplicada: Partición de Equivalencia**

### **Tabla de clases de equivalencia**

| Criterio | Clases válidas (V) | Clases inválidas (I) |
|---|---|---|
| Archivo nivel | V1: Archivo JSON existente y con estructura válida | I1: Archivo inexistente |
|  |  | I2: Archivo JSON con estructura inválida |
| Elementos del nivel | V2: Lista con elementos válidos | I3: Lista vacía |

### **Casos de prueba**

| ID | Descripción | Setup | Datos de prueba | Pasos | Resultado esperado | Estado |
|---|---|---|---|---|---|---|
| CP01 | Verificar carga correcta de un nivel válido | Setup2 | Archivo: nivel1.json válido | 1. Seleccionar archivo<br>2. Cargar nivel | El sistema muestra “Nivel cargado exitosamente” y el estado es true | Aceptado |
| CP02 | Verificar rechazo de archivo inexistente | Setup2 | Archivo: ruta inexistente | 1. Intentar cargar archivo inexistente | El sistema no carga el nivel y el estado es false | Rechazado |
| CP03 | Verificar rechazo de JSON inválido | Setup2 | Archivo: JSON mal formado | 1. Seleccionar archivo inválido<br>2. Intentar cargar | El sistema rechaza el archivo | Rechazado |
| CP04 | Verificar rechazo de archivo sin elementos válidos | Setup2 | Archivo: JSON con lista vacía | 1. Cargar archivo<br>2. Procesar nivel | El sistema no carga el nivel | Rechazado |

---

## **RF3 - Iniciar juego**
**Técnica aplicada: Tabla de Decisión**

### **Tabla de decisión**

| Condiciones/Acciones | R1 | R2 | R3 |
|---|---|---|---|
| Jugador registrado | Sí | No | Sí |
| Nivel seleccionado | Sí | Sí | No |
| Iniciar partida | X |  |  |
| Mostrar error |  | X | X |

### **Casos de prueba**

| Caso | Jugador registrado | Nivel seleccionado | Resultado esperado | Comentarios |
|---|---|---|---|---|
| 1 | Sí | Sí | Partida iniciada | El tablero queda listo para jugar |
| 2 | No | Sí | Inicio rechazado | No existe un jugador válido |
| 3 | Sí | No | Inicio rechazado | No se ha elegido un nivel |

---

## **RF4 - Mostrar tablero**
**Técnica aplicada: Tabla de Decisión**

### **Tabla de decisión**

| Condiciones/Acciones | R1 | R2 | R3 |
|---|---|---|---|
| Tablero cargado | Sí | No | Sí |
| Elementos del juego disponibles | Sí | Sí | No |
| Mostrar tablero | X |  |  |
| Mostrar error |  | X | X |

### **Casos de prueba**

| Caso | Tablero cargado | Elementos disponibles | Resultado esperado | Comentarios |
|---|---|---|---|---|
| 1 | Sí | Sí | Tablero visible | Se renderizan correctamente todos los elementos |
| 2 | No | Sí | Visualización rechazada | No existe tablero cargado |
| 3 | Sí | No | Visualización rechazada | No existen elementos para mostrar |

---

## **RF5 - Mover jugador**
**Técnica aplicada: Tabla de Decisión**

### **Tabla de decisión**

| Condiciones/Acciones | R1 | R2 | R3 | R4 |
|---|---|---|---|---|
| Dirección válida | Sí | Sí | Sí | No |
| Posición dentro del tablero | Sí | No | Sí | No |
| Casilla destino libre | Sí | No | No | No |
| Mover jugador | X |  |  |  |
| Actualizar posición | X |  |  |  |
| Rechazar movimiento |  | X | X | X |

### **Casos de prueba**

| Caso | Dirección válida | Dentro del tablero | Casilla destino libre | Resultado esperado | Comentarios |
|---|---|---|---|---|---|
| 1 | Sí | Sí | Sí | Movimiento aceptado | El jugador cambia a la nueva posición |
| 2 | Sí | No | No | Movimiento rechazado | La posición sale del tablero |
| 3 | Sí | Sí | No | Movimiento rechazado | La casilla tiene muro o caja |
| 4 | No | No | No | Movimiento rechazado | La dirección no es válida |

---

## **RF6 - Empujar cajas**
**Técnica aplicada: Tabla de Decisión**

### **Tabla de decisión**

| Condiciones/Acciones | R1 | R2 | R3 | R4 |
|---|---|---|---|---|
| Existe caja en la posición | Sí | Sí | Sí | No |
| Casilla siguiente libre | Sí | Sí | No | No |
| Caja llega a objetivo | Sí | No | No | No |
| Desplazar caja y jugador | X | X |  |  |
| Actualizar contadores | X | X |  |  |
| Sumar punto | X |  |  |  |
| Rechazar empuje |  |  | X | X |

### **Casos de prueba**

| Caso | Caja existente | Casilla siguiente libre | Caja llega a objetivo | Resultado esperado | Comentarios |
|---|---|---|---|---|---|
| 1 | Sí | Sí | Sí | Empuje aceptado | Se mueve caja, jugador y suma punto |
| 2 | Sí | Sí | No | Empuje aceptado | Se mueve caja y jugador, sin punto |
| 3 | Sí | No | No | Empuje rechazado | La casilla siguiente está ocupada |
| 4 | No | No | No | Empuje rechazado | No hay caja en la posición |

---

## **RF7 - Validar movimientos**
**Técnica aplicada: Tabla de Decisión**

### **Tabla de decisión**

| Condiciones/Acciones | R1 | R2 | R3 | R4 |
|---|---|---|---|---|
| Dirección válida | Sí | Sí | Sí | No |
| Casilla dentro del tablero | Sí | Sí | No | No |
| Casilla libre o acción permitida | Sí | No | No | No |
| Validar como permitido | X |  |  |  |
| Rechazar movimiento |  | X | X | X |

### **Casos de prueba**

| Caso | Dirección válida | Casilla dentro del tablero | Acción permitida | Resultado esperado | Comentarios |
|---|---|---|---|---|---|
| 1 | Sí | Sí | Sí | Movimiento válido | Se permite la acción |
| 2 | Sí | Sí | No | Movimiento inválido | La casilla está bloqueada |
| 3 | Sí | No | No | Movimiento inválido | Sale de los límites |
| 4 | No | No | No | Movimiento inválido | Dirección no reconocida |

---

## **RF8 - Verificación de victoria**
**Técnica aplicada: Tabla de Decisión**

### **Tabla de decisión**

| Condiciones/Acciones | R1 | R2 | R3 | R4 |
|---|---|---|---|---|
| Posiciones caja no vacías | Sí | Sí | Sí | No |
| Posiciones objetivo no vacías | Sí | Sí | Sí | Sí |
| Todas las cajas en objetivo | Sí | No | No | No |
| Activar estado de victoria | X |  |  |  |
| Mostrar “Victoria” | X |  |  |  |
| Mantener estado sin victoria |  | X | X | X |

### **Casos de prueba**

| Caso | Cajas en objetivo | Listas válidas | Resultado esperado | Comentarios |
|---|---|---|---|---|
| 1 | Sí | Sí | Victoria | Todas las cajas están en los objetivos |
| 2 | No | Sí | Sin victoria | No se cumple la condición |
| 3 | No | No | Sin victoria | Faltan datos requeridos |

---

## **RF9 - Guardar/Cargar partida**
**Técnica aplicada: Partición de Equivalencia**

### **Tabla de clases de equivalencia**

| Criterio | Clases válidas (V) | Clases inválidas (I) |
|---|---|---|
| Estado del juego | V1: Objeto existente | I1: Objeto nulo |
| Acción | V2: Guardar | I2: Acción inválida |
|  | V3: Cargar | I3: Archivo inexistente |

### **Casos de prueba**

| ID | Descripción | Setup | Datos de prueba | Pasos | Resultado esperado | Estado |
|---|---|---|---|---|---|---|
| CP01 | Verificar guardado correcto de una partida | Setup3 | Estado del juego válido<br>Acción: Guardar | 1. Abrir partida<br>2. Seleccionar Guardar | El sistema muestra “Partida guardada” y el estado es true | Aceptado |
| CP02 | Verificar carga correcta de una partida guardada | Setup6 | Acción: Cargar | 1. Seleccionar Cargar<br>2. Elegir archivo guardado | El sistema restaura correctamente la partida | Aceptado |
| CP03 | Verificar rechazo de acción inválida | Setup3 | Acción: Eliminar | 1. Ingresar acción no válida | El sistema rechaza la operación | Rechazado |
| CP04 | Verificar rechazo al guardar sin partida activa | Setup2 | Estado del juego: nulo<br>Acción: Guardar | 1. Intentar guardar sin partida | El sistema no guarda la partida | Rechazado |
| CP05 | Verificar rechazo al cargar archivo inexistente | Setup2 | Acción: Cargar<br>Archivo: inexistente | 1. Intentar cargar archivo inexistente | El sistema no carga la partida | Rechazado |

---

## **RF10 - Mostrar estadísticas del jugador**
**Técnica aplicada: Partición de Equivalencia**

### **Tabla de clases de equivalencia**

| Criterio | Clases válidas (V) | Clases inválidas (I) |
|---|---|---|
| Datos del jugador | V1: Jugador existente con estadísticas | I1: Jugador inexistente |
|  |  | I2: Jugador sin estadísticas |

### **Casos de prueba**

| ID | Descripción | Setup | Datos de prueba | Pasos | Resultado esperado | Estado |
|---|---|---|---|---|---|---|
| CP01 | Verificar visualización de estadísticas registradas | Setup7 | Jugador con historial | 1. Ingresar a Estadísticas<br>2. Seleccionar jugador | El sistema muestra la tabla de estadísticas | Aceptado |
| CP02 | Verificar comportamiento con jugador sin estadísticas | Setup8 | Jugador sin historial | 1. Ingresar a Estadísticas<br>2. Seleccionar jugador | El sistema informa que no hay estadísticas disponibles | Rechazado |
| CP03 | Verificar comportamiento con jugador inexistente | Setup9 | Jugador no registrado | 1. Intentar consultar estadísticas | El sistema no muestra estadísticas | Rechazado |

---

## **RF11 - Ranking de jugadores**
**Técnica aplicada: Partición de Equivalencia**

### **Tabla de clases de equivalencia**

| Criterio | Clases válidas (V) | Clases inválidas (I) |
|---|---|---|
| Lista de jugadores | V1: Jugadores con estadísticas registradas | I1: Lista vacía |
| Criterio de orden | V2: Criterio válido | I2: Criterio no permitido |

### **Casos de prueba**

| ID | Descripción | Setup | Datos de prueba | Pasos | Resultado esperado | Estado |
|---|---|---|---|---|---|---|
| CP01 | Verificar ranking generado correctamente | Setup7 | Jugadores con estadísticas | 1. Abrir ranking<br>2. Consultar clasificación | El sistema muestra la lista ordenada de jugadores | Aceptado |
| CP02 | Verificar comportamiento con lista vacía | Setup9 | Lista de jugadores vacía | 1. Abrir ranking | El sistema informa que no hay datos para mostrar | Rechazado |
| CP03 | Verificar rechazo de criterio inválido | Setup9 | Criterio: Aleatorio | 1. Seleccionar criterio inválido | El sistema no genera el ranking | Rechazado |

---

## **RF12 - Deshacer movimiento**
**Técnica aplicada: Transición de Estados**

### **Tabla de transición de estados**

| Estado Actual | Evento | Nuevo Estado | Válido? |
|---|---|---|---|
| Con historial de movimientos | Undo | Estado anterior | Sí |
| Con historial de movimientos | Ctrl+Z | Estado anterior | Sí |
| Con historial de movimientos | Cmd+Z | Estado anterior | Sí |
| Sin historial de movimientos | Undo | Estado actual sin cambios | No |

### **Casos de prueba**

| ID | Descripción | Setup | Datos de prueba | Pasos | Resultado esperado | Estado |
|---|---|---|---|---|---|---|
| CP01 | Verificar que Undo regrese al estado anterior | Setup4 | Comando: Undo | 1. Realizar movimiento<br>2. Ejecutar Undo | El tablero regresa al estado anterior | Aceptado |
| CP02 | Verificar que Ctrl+Z regrese al estado anterior | Setup4 | Comando: Ctrl+Z | 1. Realizar movimientos<br>2. Ejecutar Ctrl+Z | El tablero regresa al estado anterior | Aceptado |
| CP03 | Verificar que Cmd+Z regrese al estado anterior | Setup4 | Comando: Cmd+Z | 1. Realizar movimientos<br>2. Ejecutar Cmd+Z | El tablero regresa al estado anterior | Aceptado |
| CP04 | Verificar rechazo de Undo sin historial | Setup5 | Comando: Undo | 1. Iniciar tablero nuevo<br>2. Ejecutar Undo | El sistema no cambia el tablero | Rechazado |

---

## **RF13 - Solución automática**
**Técnica aplicada: Tabla de Decisión**

### **Tabla de decisión**

| Condiciones/Acciones | R1 | R2 | R3 | R4 |
|---|---|---|---|---|
| Nivel habilitado | Sí | Sí | No | No |
| Algoritmo válido | Sí | No | Sí | No |
| Ejecutar solución automática | X |  |  |  |
| Mostrar secuencia de movimientos | X |  |  |  |
| Rechazar ejecución |  | X | X | X |

### **Casos de prueba**

| Caso | Nivel habilitado | Algoritmo válido | Resultado esperado | Comentarios |
|---|---|---|---|---|
| 1 | Sí | Sí | Solución ejecutada | El sistema resuelve automáticamente el nivel |
| 2 | Sí | No | Ejecución rechazada | El algoritmo no es permitido |
| 3 | No | Sí | Ejecución rechazada | La función no está disponible |
| 4 | No | No | Ejecución rechazada | No se cumplen condiciones |

---

## **RF14 - Mostrar cronómetro y contadores**
**Técnica aplicada: Análisis de Valor Límite (BVA)**

### **Casos de prueba**

| Caso | Valor probado | Otros requisitos | Resultado esperado |
|---|---|---|---|
| T1 | Tiempo = -1 | Empujes = 0; Movimientos = 0 | Dato inválido |
| T2 | Tiempo = 0 | Empujes = 0; Movimientos = 0 | El cronómetro muestra 00:00 |
| T3 | Tiempo = 1 | Empujes = 0; Movimientos = 0 | El cronómetro muestra 00:01 |
| E1 | Empujes = -1 | Tiempo y movimientos válidos | Dato inválido |
| E2 | Empujes = 0 | Tiempo y movimientos válidos | El contador muestra 0 |
| E3 | Empujes = 1 | Tiempo y movimientos válidos | El contador muestra 1 |
| M1 | Movimientos = -1 | Tiempo y empujes válidos | Dato inválido |
| M2 | Movimientos = 0 | Tiempo y empujes válidos | El contador muestra 0 |
| M3 | Movimientos = 1 | Tiempo y empujes válidos | El contador muestra 1 |

---

## **RF15 - Selección de nivel**
**Técnica aplicada: Análisis de Valor Límite (BVA)**

### **Casos de prueba**

| Caso | Nivel seleccionado | Otros requisitos | Resultado esperado |
|---|---|---|---|
| L1 | 0 | Menú de selección activo | Rechazado |
| L2 | 1 | Menú de selección activo | Aceptado; tablero listo |
| L3 | 2 | Menú de selección activo | Aceptado; tablero listo |
| L4 | 3 | Menú de selección activo | Aceptado; tablero listo |
| L5 | 4 | Menú de selección activo | Rechazado |

---

## **RF16 - Menú principal**
**Técnica aplicada: Partición de Equivalencia**

### **Tabla de clases de equivalencia**

| Criterio | Clases válidas (V) | Clases inválidas (I) |
|---|---|---|
| Opción seleccionada | V1: Iniciar juego, Cargar partida, Estadísticas, Ranking, Manual | I1: Valor distinto a las opciones del menú |

### **Casos de prueba**

| ID | Descripción | Setup | Datos de prueba | Pasos | Resultado esperado | Estado |
|---|---|---|---|---|---|---|
| CP01 | Navegar a Iniciar juego | Setup9 | Opción: Iniciar juego | 1. Abrir menú<br>2. Seleccionar opción | Navega a inicio de juego | Aceptado |
| CP02 | Navegar a Cargar partida | Setup9 | Opción: Cargar partida | 1. Abrir menú<br>2. Seleccionar opción | Navega a carga de partida | Aceptado |
| CP03 | Navegar a Estadísticas | Setup9 | Opción: Estadísticas | 1. Abrir menú<br>2. Seleccionar opción | Navega a estadísticas | Aceptado |
| CP04 | Navegar a Ranking | Setup9 | Opción: Ranking | 1. Abrir menú<br>2. Seleccionar opción | Navega al ranking | Aceptado |
| CP05 | Navegar a Manual | Setup9 | Opción: Manual | 1. Abrir menú<br>2. Seleccionar opción | Navega al manual | Aceptado |
| CP06 | Rechazar opción inválida | Setup9 | Opción: Configuración | 1. Abrir menú<br>2. Seleccionar opción inválida | No navega; opción no válida | Rechazado |

---

## **RF17 - Mostrar resultado del juego**
**Técnica aplicada: Tabla de Decisión**

### **Tabla de decisión**

| Condiciones/Acciones | R1 | R2 |
|---|---|---|
| Estado de victoria | Sí | No |
| Mostrar “Victoria” | X |  |
| Mostrar “Game Over” |  | X |

### **Casos de prueba**

| Caso | Estado de victoria | Resultado esperado | Comentarios |
|---|---|---|---|
| 1 | Sí | Mostrar “Victoria” | Ganó el nivel |
| 2 | No | Mostrar “Game Over” | No completó el nivel |

---

## **RF18 - Manual de usuario**
**Técnica aplicada: Partición de Equivalencia**

### **Tabla de clases de equivalencia**

| Criterio | Clases válidas (V) | Clases inválidas (I) |
|---|---|---|
| Solicitud de manual | V1: True | I1: False |

### **Casos de prueba**

| ID | Descripción | Setup | Datos de prueba | Pasos | Resultado esperado | Estado |
|---|---|---|---|---|---|---|
| CP01 | Mostrar manual con solicitud verdadera | Setup11 | Solicitud: true | 1. Seleccionar Manual<br>2. Confirmar | Se muestra el manual | Aceptado |
| CP02 | No mostrar manual con solicitud falsa | Setup11 | Solicitud: false | 1. No activar solicitud | No se muestra el manual | Rechazado |

---