import java.util.ArrayList;

public class SistemaDeGestion {
	
	 private ArrayList<Bodega> bodegas;

	    public SistemaDeGestion() {
	        this.bodegas = new ArrayList<>();
	    }

	    public String agregarBodega(Bodega bodega) {
	        if (bodegas.size() < 10) {
	            bodegas.add(bodega);
	            return "Bodega agregada exitosamente.";
	        } else {
	            return "Error: No se pueden agregar más de 10 bodegas.";
	        }
	    }

	    public Bodega buscarBodega(int idBodega) {
	        for (Bodega b : bodegas) {
	            if (b.getId() == idBodega) {
	                return b;
	            }
	        }
	        return null;
	    }

	    public void mostrarEstado() {
	        for (Bodega bodega : bodegas) {
	            System.out.println(bodega);
	            bodega.mostrarTrenes();
	        }
	    }

}
