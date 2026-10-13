import java.util.Scanner;

/**
 * Programa realizado para calcular el impuesto y el precio final de los
 * refrescos cobn ese impuesto añadiodo, descripción mas detallada en archivo
 * REDME.md
 *
 * @author VARGAS GONZALEZ RICARDO ALONSO
 * @version 1.0
 */
public class App {

    // ========================================
    // Constante para la tasa de impuesto (16%)
    // ========================================
    // Se usa "static final" porque la tasa de impuesto no cambia durante
    // la ejecución del programa, lo que la declara como una constante, no una variable.
    // Utilizamos "double" porque el impuesto se calcula con decimales, 
    //además, necesitamos precisión decimal en los cálculos.
    // Si usáramos "int" o "float", perderíamos decimales.
    static final double TASA_IMPUESTO = 0.16;

    public static void main(String[] args) {
        // ========================================
        // Crear objeto Scanner para leer datos del teclado
        // ========================================
        // Scanner es la clase estándar de Java para leer entrada del usuario.
        // la importamos desde java.util.Scanner.
        Scanner teclado = new Scanner(System.in);

        // ========================================
        // Datos de identificación del estudiante
        // ========================================
        // Se imprimen los datos del alumno como parte de la entrega, 
        // si bien, el trabajo no lo solicita, en otra materia se 
        // requería y termine guardandolo como una practca común de mi código
        System.out.println("=====================================");
        System.out.println("Nombre: VARGAS GONZALEZ RICARDO ALONSO");
        System.out.println("Matricula: ES261104750");
        System.out.println("Grupo: DS-DFPR-2602-B1-009");
        System.out.println("=====================================\n");

        // ========================================
        // Declaración de variables
        // ========================================
        double precio = 0.0;
        double impuesto;
        double precioFinal;

        // "datosValidos" es una bandera (flag) que ayudará a 
        // controlar el ciclo de validación.
        // Empieza en "false" porque aún no tenemos un dato válido de inicio.
        boolean datosValidos = false;

        // ========================================
        // Validación: el precio debe ser > 0, 
        // esto conlleva a excluir tambien nbumeros negativos
        // ========================================
        // Se usa un ciclo "while" que se repite mientras "datosValidos" sea false.
        // Dentro del ciclo, se valida la entrada del usuario.
        while (!datosValidos) {
            System.out.print("Ingrese el precio del refresco: ");

            // ----------------------------------------
            // aqui me plnantee una duda interesante, conforme buscaba información y ejemplos en stack overflow 
            // ¿Por qué usamos hasNextDouble() en lugar de try-catch?
            // lo cual desarrollo en el README.md
            if (teclado.hasNextDouble()) {

                // Si el dato es un double, lo leemos con nextDouble()
                precio = teclado.nextDouble();

                // ----------------------------------------
                // Operador relacional: >
                // ----------------------------------------
                // Usamos el operador ">" para validar que el precio sea
                // mayor que cero, si el precio es <= 0, mostramos error,
                // como mencioné esto permite que no haya tampoco numeros negativos
                if (precio > 0) {
                    datosValidos = true; // Dato válido, salimos del ciclo
                } else {
                    System.out.println("Error: el precio debe ser mayor que cero.");
                }
            } else {
                // Si el dato NO es un double, mostramos error y limpiamos el buffer.
                // "teclado.next()" consume el dato inválido para que el usuario
                // pueda ingresar uno nuevo sin que el programa se quede en bucle.
                System.out.println("Error: debe ingresar un valor numérico.");
                teclado.next(); // Limpiar el buffer
            }
        }

        // ========================================
        // Cálculo del impuesto y precio final
        // ========================================

        impuesto = precio * TASA_IMPUESTO;

        // ----------------------------------------
        // Operador aritmético: suma (+)
        // ----------------------------------------
        // El precio final se calcula sumando el impuesto al precio original.
        // Fórmula: precioFinal = precio + impuesto
        precioFinal = precio + impuesto;

        // ========================================
        // Mostrar resultados
        // ========================================

        System.out.println("\n--- RESULTADO DEL CÁLCULO ---");
        System.out.println("Precio sin impuesto: $" + precio);
        System.out.println("Impuesto (16%): $" + impuesto);
        System.out.println("Precio final: $" + precioFinal);
        System.out.println("--------------------------------");

        // ========================================
        // Cerrar el Scanner
        // ========================================
        // Finalmente,. con base en lo que aprendi de stackoverflow es
        // una buena práctica cerrar el Scanner al terminar de usarlo
        // para liberar los recursos del sistema.
        teclado.close();
    }
}
