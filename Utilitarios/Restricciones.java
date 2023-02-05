package Utilitarios;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Restricciones {
    String correo = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
    String nombre = "[A-Z]*";
    String apellido = "[A-Z]+([ '-][A-Z]+)*";
    String numTelefono = "^[0][9][0-9]{8}$";
    String numeroAsiento = "[0-9]*";
    String numero = "[0-9]*";
    String Si = "[SI|NO]*";
    String No= "[no|NO|No|nO]*";

    public boolean controlCorreo(String cadena) {
        Pattern patter = Pattern.compile(correo);
        Matcher matcher = patter.matcher(cadena);
        return matcher.matches();
    }

    public boolean controlNombre(String cadena) {
        Pattern patter = Pattern.compile(nombre);
        Matcher matcher = patter.matcher(cadena);
        return matcher.matches();
    }

    public boolean controlApellido(String cadena) {
        Pattern patter = Pattern.compile(apellido);
        Matcher matcher = patter.matcher(cadena);
        return matcher.matches();
    }

    public boolean controlNumeroTelefono(String cadena) {
        Pattern patter = Pattern.compile(numTelefono);
        Matcher matcher = patter.matcher(cadena);
        return matcher.matches();
    }

    public boolean controlNumAsiento(String cadena) {
        Pattern patter = Pattern.compile(numeroAsiento);
        Matcher matcher = patter.matcher(cadena);
        return matcher.matches();
    }

    public boolean controlNum(String cadena) {
        Pattern patter = Pattern.compile(numero);
        Matcher matcher = patter.matcher(cadena);
        return matcher.matches();
    }

    public boolean controlSI(String cadena) {
        Pattern patter = Pattern.compile(Si);
        Matcher matcher = patter.matcher(cadena);
        return matcher.matches();
    }

    public boolean controlNO(String cadena) {
        Pattern patter = Pattern.compile(No);
        Matcher matcher = patter.matcher(cadena);
        return matcher.matches();
    }
}
