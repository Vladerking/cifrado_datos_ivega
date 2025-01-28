import javax.crypto.SecretKey;
import java.util.Base64;
import java.util.Scanner;

/**
 * Clase principal que gestiona la interacción del usuario con el sistema de cifrado y descifrado AES.
 */
public class Principal {
    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {

            // Generar una clave secreta de 256 bits
            SecretKey claveSecreta = ClaveAES.generarClave();
            System.out.println("Clave secreta generada: " +
                    Base64.getEncoder().encodeToString(claveSecreta.getEncoded()));

            // Pedir al usuario un texto para cifrar
            System.out.println("***** Cifrado de datos *****");
            System.out.print("Introduzca el texto que quieras cifrar: ");
            String texto = scanner.nextLine();

            // Cifrar el texto
            String textoCifrado = ClaveAES.cifrar(texto, claveSecreta);
            System.out.println("Texto cifrado: " + textoCifrado);

            // Descifrar el texto
            String textoDescifrado = ClaveAES.descifrar(textoCifrado, claveSecreta);
            System.out.println("***** Descifrado de datos *****");
            System.out.println("Texto descifrado: " + textoDescifrado);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
