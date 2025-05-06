public class Cafe {

    private TipoDeCafe tipo;


    public Cafe(TipoDeCafe tipo) {
        this.tipo = tipo;
    }

    public TipoDeCafe getTipo() {
        return tipo;
    }
    public double getPrecio() {
        return tipo.getPrecio();
    }

    @Override
    public String toString() {
        return "Café: " + tipo;
    }

}
