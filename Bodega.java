import java.util.ArrayList;

public class Bodega {
	
	    private int id;
	    private String direccion;
	    private double capacidadMaximaToneladas;
	    private int capacidadMaximaTrenes;
	    private String tipoCarga;
	    private ArrayList<Tren> trenes;

	    public Bodega(int id, String direccion, double capacidadMaximaToneladas, int capacidadMaximaTrenes, String tipoCarga) {
	        this.id = id;
	        this.direccion = direccion;
	        this.capacidadMaximaToneladas = capacidadMaximaToneladas;
	        this.capacidadMaximaTrenes = capacidadMaximaTrenes;
	        this.tipoCarga = tipoCarga;
	        this.trenes = new ArrayList<>();
	    }

	    public int getId() {
	        return id;
	    }

	    public double getUsoActualToneladas() {
	        return trenes.stream().mapToDouble(Tren::getCargaActual).sum();
	    }

	    public int getUsoActualTrenes() {
	        return trenes.size();
	    }

	    public String recibirTren(Tren tren) {
	        if (!tren.getTipoCarga().equalsIgnoreCase(this.tipoCarga)) {
	            return "Error: Tipo de carga incompatible.";
	        }
	        if (getUsoActualTrenes() >= capacidadMaximaTrenes) {
	            return "Error: Capacidad máxima de trenes alcanzada.";
	        }
	        if (getUsoActualToneladas() + tren.getCargaActual() > capacidadMaximaToneladas) {
	            return "Error: Capacidad máxima en toneladas superada.";
	        }

	        trenes.add(tren);
	        return "Tren " + tren.getId() + " recibido en Bodega " + id + ".";
	    }

	    public String darSalidaTren(int idTren) {
	        for (Tren tren : trenes) {
	            if (tren.getId() == idTren) {
	                trenes.remove(tren);
	                return "Tren " + idTren + " ha salido de la Bodega " + id + ".";
	            }
	        }
	        return "Tren no encontrado en esta bodega.";
	    }

	    @Override
	    public String toString() {
	        return "Bodega " + id + " (" + tipoCarga + ") - " + direccion +
	               " | Trenes: " + getUsoActualTrenes() + "/" + capacidadMaximaTrenes +
	               ", Toneladas: " + getUsoActualToneladas() + "/" + capacidadMaximaToneladas;
	    }

	    public void mostrarTrenes() {
	        for (Tren tren : trenes) {
	            System.out.println("   - " + tren);
	        }
	    }
	

}
