# Batalla elemental

Pequeño juego de combate por turnos en Java. Está pensado como ejemplo para
estudiar clases, herencia, interfaces, enumeraciones y separación de lógica.

## Requisitos

- Java 21
- No es necesario instalar Maven: el proyecto incluye Maven Wrapper.

## Ejecutar el juego

En Windows, abre una terminal en la carpeta del proyecto y ejecuta:

```powershell
.\mvnw.cmd spring-boot:run
```

En macOS o Linux:

```bash
./mvnw spring-boot:run
```

Escribe el nombre del personaje y elige una acción:

- `1`: atacar al gólem. El enemigo contraataca si sigue vivo.
- `2`: usar la poción, que recupera hasta 25 puntos de vida. Solo hay una.
- `0`: salir de la partida.

Gana quien reduzca primero a cero los puntos de vida del otro personaje.

## Ejecutar las pruebas

En Windows:

```powershell
.\mvnw.cmd test
```

En macOS o Linux:

```bash
./mvnw test
```

Las pruebas comprueban el daño de combate, la curación, el daño elemental de
las armas y que un personaje derrotado no pueda seguir combatiendo.
