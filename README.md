# Calculadora de Impuestos del Refresco

Programa realizado para calcular el impuesto y el precio final de los refrescos con ese impuesto añadido.

Caso de estudio: cafetería escolar que realizaba previamente el cálculo del precio final.

Reglas que debemos considerar:
- El programa debe utilizar la clase Scanner para la entrada de datos.
- Validar que el usuario ingrese un valor numérico positivo.

## ¿Por qué usar "hasNextDouble()" en lugar de "try-catc"?

"hasNextDouble()" es un método de Scanner que VERIFICA si el siguiente dato ingresado es un double, SIN intentar leerlo.

Ventajas sobre "try-catch":
1. Es la forma "explícita" y recomendada por la comunidad Java.
2. Evita el "abuso de excepciones" para control de flujo.
3. El código se lee de forma natural: "mientras no sea double, error".
4. Es preventivo, no reactivo: preguntamos antes de actuar.

Si usáramos "nextDouble()" directamente y el usuario ingresa texto, el programa lanzaría "InputMismatchException" y se detendría. Con "hasNextDouble()", lo prevenimos antes de que ocurra.