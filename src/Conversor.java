import java.util.Scanner;
import javax.swing.JOptionPane;

public class Conversor {
    public static void main(String[] args) {
        int opcionMenuPrincipal = mostrarMenuPrincipal();
        while (opcionMenuPrincipal != 3) {
            if (opcionMenuPrincipal == 1) {
                convertirDivisas();
            } else if (opcionMenuPrincipal == 2) {
                convertirTemperatura();
            }
            opcionMenuPrincipal = mostrarMenuPrincipal();
        }
        JOptionPane.showMessageDialog(null, "Programa terminado");
    }

    public static int mostrarMenuPrincipal() {
        String[] opciones = {"Conversión de divisas", "Conversión de temperatura", "Salir"};
        int opcionSeleccionada = JOptionPane.showOptionDialog(null, "Selecciona una opción", "Menú principal", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opciones, opciones[0]);
        return opcionSeleccionada + 1;
    }

    public static void convertirDivisas() {
        String[] opciones = {"MXN a USD", "MXN a EUR", "MXN a GBP", "MXN a JPY", "MXN a KRW", "USD a MXN", "EUR a MXN", "GBP a MXN", "JPY a MXN", "KRW a MXN"};
        String opcionSeleccionada = (String) JOptionPane.showInputDialog(null, "Selecciona una opción", "Conversión de divisas", JOptionPane.PLAIN_MESSAGE, null, opciones, opciones[0]);
        String[] monedas = opcionSeleccionada.split(" a ");
        String de = monedas[0];
        String a = monedas[1];
        String mensaje = "Ingresa la cantidad a convertir de " + de + " a " + a;
        double cantidad = obtenerCantidad(mensaje);
        double resultado = 0;
        if (de.equals("MXN") && a.equals("USD")) {
            resultado = cantidad / 20;
        } else if (de.equals("MXN") && a.equals("EUR")) {
            resultado = cantidad / 23;
        } else if (de.equals("MXN") && a.equals("GBP")) {
            resultado = cantidad / 27;
        } else if (de.equals("MXN") && a.equals("JPY")) {
            resultado = cantidad / 0.18;
        } else if (de.equals("MXN") && a.equals("KRW")) {
            resultado = cantidad / 0.018;
        } else if (de.equals("USD") && a.equals("MXN")) {
            resultado = cantidad * 20;
        } else if (de.equals("EUR") && a.equals("MXN")) {
            resultado = cantidad * 23;
        } else if (de.equals("GBP") && a.equals("MXN")) {
            resultado = cantidad * 27;
        } else if (de.equals("JPY") && a.equals("MXN")) {
            resultado = cantidad * 0.18;
        } else if (de.equals("KRW") && a.equals("MXN")) {
            resultado = cantidad * 0.018;
        }
        String mensajeResultado = cantidad + " " + de + " equivale a " + resultado + " " + a;
        JOptionPane.showMessageDialog(null, mensajeResultado);
        mostrarOpcionesSeguirUsandoPrograma();
    }

    public static void convertirTemperatura() {
        String[] opciones = {"Celsius a Fahrenheit", "Fahrenheit a Celsius", "Celsius a Kelvin", "Kelvin a Celsius"};
        String opcionSeleccionada = (String) JOptionPane.showInputDialog(null, "Selecciona una opción", "Conversión de temperatura", JOptionPane.PLAIN_MESSAGE, null, opciones, opciones[0]);
        String[] temperaturas = opcionSeleccionada.split(" a ");
        String de = temperaturas[0];
        String a = temperaturas[1];
        String mensaje = "Ingresa la temperatura en " + de;
        double cantidad = obtenerCantidad(mensaje);
        double resultado = 0;
        if (de.equals("Celsius") && a.equals("Fahrenheit")) {
            resultado = (cantidad * 9 / 5) + 32;
        } else if (de.equals("Fahrenheit") && a.equals("Celsius")) {
            resultado = (cantidad - 32) * 5 / 9;
        } else if (de.equals("Celsius") && a.equals("Kelvin")) {
            resultado = cantidad + 273.15;
        } else if (de.equals("Kelvin") && a.equals("Celsius")) {
            resultado = cantidad - 273.15;
        }
        String mensajeResultado = cantidad + " " + de + " equivale a " + resultado + " " + a;
        JOptionPane.showMessageDialog(null, mensajeResultado);
        mostrarOpcionesSeguirUsandoPrograma();
    }

    public static double obtenerCantidad(String mensaje) {
        double cantidad = 0;
        boolean esNumeroValido = false;
        while (!esNumeroValido) {
            String cantidadTexto = JOptionPane.showInputDialog(null, mensaje);
            try {
                cantidad = Double.parseDouble(cantidadTexto);
                esNumeroValido = true;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Ingresa un número válido");
            }
        }
        return cantidad;
    }

    public static void mostrarOpcionesSeguirUsandoPrograma() {
        int opcionSeleccionada = JOptionPane.showOptionDialog(null, "¿Desea seguir utilizando el programa?", "Continuar", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, new String[] {"Sí", "No", "Cancelar"}, "Sí");
        if (opcionSeleccionada == 1 || opcionSeleccionada == 2) {
            JOptionPane.showMessageDialog(null, "Programa terminado");
            System.exit(0);
        }
    }
}