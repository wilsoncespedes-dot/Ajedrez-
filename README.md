# Modelador de Ajedrez

Modelo orientado a objetos de un tablero de ajedrez en Java, con una interfaz
visual en HTML para probar las reglas de movimiento sin necesidad de compilar
nada.

## Estructura del proyecto

```
ModeladorAjedrez/
├── src/
│   └── ajedrez/
│       ├── core/                  Núcleo del modelo
│       │   ├── Color.java         Enum BLANCO / NEGRO
│       │   ├── Posicion.java      Casilla (fila, columna) + notación a1..h8
│       │   ├── Pieza.java         Clase abstracta base de toda pieza
│       │   └── Tablero.java       Tablero 8x8: coloca, mueve y consulta piezas
│       │
│       └── features/
│           ├── piezas/            Una clase por tipo de pieza
│           │   ├── Peon.java
│           │   ├── Torre.java
│           │   ├── Caballo.java
│           │   ├── Alfil.java
│           │   ├── Reina.java
│           │   └── Rey.java
│           │
│           └── juego/
│               └── Main.java      Punto de entrada de consola (demo)
│
└── interfaz/
    └── index.html                 Visualizador interactivo del tablero
```

`core` contiene lo mínimo que necesita cualquier pieza para existir
(posición, color, tablero). `features/piezas` contiene la lógica particular
de movimiento de cada pieza, heredando de `Pieza`. Esta organización no se
modificó: la interfaz se agregó como una carpeta nueva (`interfaz/`) que no
toca el código Java existente.

## Ejecutar el modelo en consola (Java)

Requiere tener el JDK instalado (`java -version` para comprobarlo).

```bash
cd ModeladorAjedrez/src
javac ajedrez/core/*.java ajedrez/features/piezas/*.java ajedrez/features/juego/*.java
java ajedrez.features.juego.Main
```

Esto imprime el tablero inicial de la demo, los movimientos posibles de la
Reina blanca y el tablero después de mover un peón, tal como está definido
en `Main.java`.

## Usar la interfaz visual (HTML)

No requiere instalar nada ni compilar Java.

1. Abre `interfaz/index.html` con doble clic (o "Abrir con" tu navegador).
2. Haz clic en una pieza propia (empiezan las blancas) para ver sus
   movimientos posibles resaltados en el tablero.
3. Haz clic en una casilla resaltada para mover la pieza ahí. Si hay una
   pieza rival, se captura automáticamente.
4. El panel derecho muestra la **ficha técnica** de la pieza seleccionada:
   qué clase Java gobierna su movimiento y una descripción de la regla.
5. El registro de jugadas y las bandejas de piezas capturadas quedan
   debajo del tablero.
6. "Reiniciar tablero" vuelve a la posición inicial estándar.

La lógica de movimiento en el HTML es una traducción directa de cada
`movimientosPosibles(Tablero)` en Java (mismas condiciones, mismo orden de
direcciones), así que el comportamiento en el navegador coincide con el
modelo Java. No incluye jaque, enroque ni promoción de peón porque el
modelo original tampoco los define — es un modelador de movimientos, no un
motor de ajedrez completo.

## Posibles próximos pasos

- Agregar detección de jaque y jaque mate.
- Agregar enroque, captura al paso y promoción de peón.
- Sumar pruebas unitarias sobre `movimientosPosibles` de cada pieza.
