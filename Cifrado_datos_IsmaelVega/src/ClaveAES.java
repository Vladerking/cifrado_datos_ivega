import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.util.Base64;

/**
 * Clase que implementa métodos para el cifrado y descifrado de datos utilizando AES con clave de 256 bits.
 */
public class ClaveAES {

    /**
     * Genera una clave secreta para el cifrado AES con un tamaño de 256 bits.
     *
     * @return Clave secreta generada.
     * @throws Exception Si ocurre un error al generar la clave.
     */
    public static SecretKey generarClave() throws Exception {
        KeyGenerator generadorClave = KeyGenerator.getInstance("AES"); // Algoritmo AES
        generadorClave.init(256); // Tamaño de la clave: 256 bits
        return generadorClave.generateKey(); // Genera y retorna la clave
    }

    /**
     * Cifra un texto utilizando una clave secreta y el algoritmo AES.
     *
     * @param texto Texto plano a cifrar.
     * @param claveSecreta Clave secreta para el cifrado.
     * @return Texto cifrado en formato Base64.
     * @throws Exception Si ocurre un error durante el cifrado.
     */
    public static String cifrar(String texto, SecretKey claveSecreta) throws Exception {
        Cipher cifrador = Cipher.getInstance("AES"); // Inicializar el cifrador con AES
        cifrador.init(Cipher.ENCRYPT_MODE, claveSecreta); // Configurar para cifrado
        byte[] textoCifradoBytes = cifrador.doFinal(texto.getBytes()); // Cifrar el texto
        return Base64.getEncoder().encodeToString(textoCifradoBytes); // Codificar en Base64
    }

    /**
     * Descifra un texto cifrado utilizando una clave secreta y el algoritmo AES.
     *
     * @param textoCifrado Texto cifrado en Base64.
     * @param claveSecreta Clave secreta para el descifrado.
     * @return Texto en claro descifrado.
     * @throws Exception Si ocurre un error durante el descifrado.
     */
    public static String descifrar(String textoCifrado, SecretKey claveSecreta) throws Exception {
        Cipher cifrador = Cipher.getInstance("AES"); // Inicializar el cifrador con AES
        cifrador.init(Cipher.DECRYPT_MODE, claveSecreta); // Configurar para descifrado
        byte[] textoCifradoBytes = Base64.getDecoder().decode(textoCifrado); // Decodificar Base64
        byte[] textoDescifradoBytes = cifrador.doFinal(textoCifradoBytes); // Descifrar el texto
        return new String(textoDescifradoBytes); // Retornar el texto en claro
    }
}
