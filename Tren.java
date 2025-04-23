
public class Tren {
	 private int id;
	    private String tipoCarga; // "alimentos" o "quimicos"
	    private double cargaMaxima;
	    private double cargaActual;

	    public Tren(int id, String tipoCarga, double cargaMaxima, double cargaActual) {
	        this.id = id;
	        this.tipoCarga = tipoCarga;
	        this.cargaMaxima = cargaMaxima;
	        this.cargaActual = cargaActual;
	    }

	    public int getId() {
	        return id;
	    }

	    public String getTipoCarga() {
	        return tipoCarga;
	    }

	    public double getCargaActual() {
	        return cargaActual;
	    }

	    @Override
	    public String toString() {
	        return "Tren " + id + " - Tipo: " + tipoCarga + ", Carga: " + cargaActual + "/" + cargaMaxima + " toneladas";
	    }
	}


