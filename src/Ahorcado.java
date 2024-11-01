import java.util.Scanner;

public class Ahorcado {
    public static void main(String[] args) throws Exception {
        limpiarConsola();
        Scanner scanner = new Scanner(System.in);

        String palabraSecreta = "inteligencia";
        int intentosMaximos = 10;
        int intentos = 0;
        boolean palabraAdivinada = false;
        int contadorLetrasAdivinadas = 0;

        char[] letrasAdivinadas = new char[palabraSecreta.length()];

        for (int i = 0; i < letrasAdivinadas.length; i++) {
            letrasAdivinadas[i] = '_';
        }

        while(!palabraAdivinada && intentos < intentosMaximos) {

            int letrasRestantes = palabraSecreta.length() - contadorLetrasAdivinadas;

            System.out.println("\nPalabra a adivinar: " + String.valueOf(letrasAdivinadas) + " (" + letrasRestantes + (letrasRestantes > 1? " letras restantes)": " letra restante)"));

            System.out.println("Introduce una letra, por favor");
            char letra = Character.toLowerCase(scanner.next().charAt(0));

            boolean letraCorrecta = false;
            for (int i = 0; i < palabraSecreta.length(); i++) {
                if(palabraSecreta.charAt(i) == letra){
                    letrasAdivinadas[i] = letra;
                    letraCorrecta = true;
                    contadorLetrasAdivinadas++;
                }
            }

            if(!letraCorrecta) {
                intentos++;
                System.out.println("\nIncorrecto! Te quedan " + (intentosMaximos - intentos) + " intentos");
            }
            
            if(String.valueOf(letrasAdivinadas).equals(palabraSecreta)) {
                palabraAdivinada = true;
                System.out.println("\nFelicidades, has adivinado la palabra secreta: " + palabraSecreta);
            }

        }

        if(!palabraAdivinada) {
            System.out.println("\nQue pena te has quedado sin intentos! GAME OVER");
        }

        scanner.close();

    }

    static void limpiarConsola() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
