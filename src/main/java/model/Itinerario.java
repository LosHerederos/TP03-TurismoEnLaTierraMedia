package model;

import java.util.ArrayList;
import java.util.List;

public class Itinerario {

	private int idItinerario;
	private List<Atraccion> atracciones;
	private List<Promocion> promociones;

	public Itinerario(
		int idItinerario,
		List<Atraccion> atracciones,
		List<Promocion> promociones
		
	) {
		this.idItinerario = idItinerario;
		this.atracciones = atracciones;
		this.promociones = promociones;
	}

	public Itinerario(int idItinerario) {
		this(idItinerario, new ArrayList<Atraccion>(), new ArrayList<Promocion>());
	}

	public Itinerario() {
		this(0);
	}

	public int getIdItinerario() {
		return idItinerario;
	}

	public void setIdItinerario(int idItinerario) {
		this.idItinerario = idItinerario;
	}

	public List<Atraccion> getAtracciones() {
		return atracciones;
	}

	public void setAtracciones(List<Atraccion> atracciones) {
		this.atracciones = atracciones;
	}

	public List<Promocion> getPromociones() {
		return promociones;
	}

	public void setPromociones(List<Promocion> promociones) {
		this.promociones = promociones;
	}

	public boolean tiene(Sugeribles sugerencia) {
		boolean esta = false;
		if (sugerencia instanceof Atraccion) {
			esta = this.atracciones.contains((Atraccion) sugerencia);
		} else {
			esta = this.promociones.contains((Promocion) sugerencia);
		}
		return esta;
	}

	public void agregarSugerencia(Sugeribles sugerencia) {
		if (sugerencia instanceof Atraccion) {
			this.atracciones.add((Atraccion) sugerencia);
		} else {
			this.promociones.add((Promocion) sugerencia);
		}
		sugerencia.agregarVisitante();
	}
	
	public int costoTotal() {
		int total = 0;
		return total;
	}
}
