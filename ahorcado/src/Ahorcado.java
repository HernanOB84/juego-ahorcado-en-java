import java.util.Scanner;

public class Ahorcado {
    public static void main(String[] args) throws Exception {
        
        //para que los usuarios puedan escribir
        Scanner scanner = new Scanner(System.in);
        
        //declaraciones y asignaciones
        String palabraSecreta = "inteligencia";
        int intentosMaximos = 10;
        int intentos = 0;
        boolean estaAdividanada = false;

        //Arreglo
        char []letrasAdivinadas = new char[palabraSecreta.length()];
        
        //Estructura de control: iterativa (bucle FOR)
        for (int i = 0; i < letrasAdivinadas.length; i++) {
            letrasAdivinadas[i] = '_'; //hacemos esto para que se vayan llenando de guiones que va a contener la cantidad de guiones proporcional a la palabra a adivinar
            //System.out.print(letrasAdivinadas[i]); con este System podemos ver y comprobar los "guionesbajos" propor a la palabra secreta
        }

        //Estructura de control: iterativa (bucle while)
                //es necesario que ambas sentencias sean verdaderas. Al negar el boolean estaAdivinada se convierte en true=verdadero
        while (!estaAdividanada && intentos < intentosMaximos) {
                                                                //es la palabra hecha en chars (completa) del arreglo letrasAdivinadas
                                                                //pero a medida que vayan apareciendo la palabras correctas
                                                                //van aparecer los guiones y letras correctas "adivinadas"
                                                                //ejemplo: i____i____i_
            System.out.println("Palabra a adivinar: " + String.valueOf(letrasAdivinadas) + " ( " + palabraSecreta.length()+ " letras)");
            System.out.println("Introduce una letra, por favor");
                                    //por si el usuario escribe una letra en Mayuscula la hace Minuscula
            char letra = Character.toLowerCase(scanner.nextLine().charAt(0)); //usamos el metodo charArt que es de la clase String para que solo tome la 1ra letra 
                                                    // ya que el método Scanner toma String es decir palabras
            
            boolean letraCorrecta = false;

            for (int i = 0; i < palabraSecreta.length(); i++) {
                //estructura de control de tipo condicional
                if (palabraSecreta.charAt(i)== letra) {
                    letrasAdivinadas[i] = letra; //asi la letra que adivinamos reemplaza al "guion bajo" en la posición correcta
                    letraCorrecta = true; //para no perder un intrnto y no se vayan reduciendo cuando adivinamos la letra
                }
            }

            if (!letraCorrecta) {
                intentos++;
                System.out.println("Incorrecto! Te quedan " + (intentosMaximos - intentos) + " intentos." );

            }
                //al ir completandose la letras correctas reemplazando los guiones va a ser igual "equals"
                //a "palabraSecreta" al darse la condición te deja el mensaje "Felicitaciones"
            if (String.valueOf(letrasAdivinadas).equals(palabraSecreta)) {
                estaAdividanada = true;
                System.out.println("¡Felicidades! Has adivinado la palabra secreta: " + palabraSecreta);
            }
        }

        if (!estaAdividanada) {
            System.out.println("Qué pena te has quedado sin intentos! GAME OVER");
        }

        scanner.close();
        
    }
}

