import java.util.*;

public class MaquinaCafe {
    private ArrayList<Cafe> historialVentas;

    /**
     * Cuando se crea la MaquinaCafe-> contructor..se crea el historial de ventas-> Encender la maquina.
     */
    public MaquinaCafe() {
        historialVentas = new ArrayList<>();
    }

    /**
     * Mostrar el Menu y luego llamarlo instanciando la clase y llamando el método...
     * Se recorre los Enum, y se muestra
     */
    public void mostrarMenu() {
        System.out.println("Seleccione una opción:");
        for (int i = 0; i < TipoDeCafe.values().length; i++) {
            System.out.println((i + 1) + ". " + formatearNombre(TipoDeCafe.values()[i]).toUpperCase() +" ->"+ TipoDeCafe.values()[i].getPrecio() +"€" );
        }
    }

    public void servirCafe(int opcion, double dinero) {
        if (opcion < 1 || opcion > TipoDeCafe.values().length) {
            System.out.println("Opción no válida");
            return;
        }

        TipoDeCafe tipo = TipoDeCafe.values()[opcion - 1];
        double precio = tipo.getPrecio();

        if (dinero < precio) {
            System.out.printf("Dinero insuficiente. El %s cuesta %.2f € y usted introdujo %.2f €.%n",
                    formatearNombre(tipo), precio, dinero);
            return; //salir del metodo..anticipadamente
        }

        double cambio = dinero - precio;
        Cafe cafe = new Cafe(tipo);
        historialVentas.add(cafe);

        System.out.printf("Aquí tiene su %s. Cambio: %.2f €%n",
                formatearNombre(tipo), cambio);
    }

    public void mostrarHistorial() {
        double totalVentas = 0;
        System.out.println("\nHistorial de cafés servidos:");
        int[] contador = new int[TipoDeCafe.values().length]; //  Tenemos 8 productos
       /* */
        for (Cafe cafe : historialVentas) {
            contador[cafe.getTipo().ordinal()]++; //ordinal() es un metodo de los enum que utiliza los indices como en los array
            totalVentas += cafe.getPrecio();
        }
        for (int i = 0; i < TipoDeCafe.values().length; i++) {
            TipoDeCafe tipo = TipoDeCafe.values()[i];
            //%-20s: Ocupa un total de 20 caracteres de ancho.
            System.out.printf("%-20s: %2d Unidades Vendidas (%.2f €)%n",
                    formatearNombre(tipo).toUpperCase(), contador[i], contador[i] * tipo.getPrecio());
        }

        //tenemos creado el historial..ahora creamos una coleccion que no tenga repetidos....
        System.out.println("Total de Ventas: " + totalVentas +  "€");

    }



    private String formatearNombre(TipoDeCafe tipo) {
        return tipo.name().toLowerCase().replace("_", " ");
    }
}