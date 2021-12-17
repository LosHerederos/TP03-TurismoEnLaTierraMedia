package model;

import java.util.ArrayList;
import java.util.Iterator;
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
			if (!esta) {
				Iterator<Promocion> promocion = this.promociones.listIterator();
				while (!esta && promocion.hasNext()) {
					esta = promocion.next().getAtracciones().contains(sugerencia);
				}
			}
		} else {
			esta = this.promociones.contains((Promocion) sugerencia);
			if (!esta) {
				Iterator<Atraccion> atraccion = ((Promocion) sugerencia).getAtracciones().listIterator();
				while (!esta && atraccion.hasNext()) {
					esta = this.atracciones.contains(atraccion.next());
				}
				if (!esta && sugerencia instanceof PromocionAXB) {
					Iterator<Atraccion> atraccionPaga = ((PromocionAXB) sugerencia).getAtraccionesPagas().listIterator();
					while (!esta && atraccionPaga.hasNext()) {
						esta = this.atracciones.contains(atraccionPaga.next());
					}
				}
			}
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
		for (Atraccion atraccion: this.atracciones) {
			total += atraccion.getCosto();
		}
		for (Promocion promocion: this.promociones) {
			total += promocion.getCosto();
		}
		return total;
	}
	
	public double tiempoTotal() {
		double total = 0.0;
		for (Atraccion atraccion: this.atracciones) {
			total += atraccion.getTiempo();
		}
		for (Promocion promocion: this.promociones) {
			total += promocion.getTiempo();
		}
		return total;
	}
	@Override
	public String toString() {
		String listadoDeAtracciones = "[";
		for (Atraccion atraccion : atracciones) {
			listadoDeAtracciones += atraccion.getNombre() + ", ";
		}
		listadoDeAtracciones += "]";
		String listadoDePromociones = "[";
		for (Promocion promocion : promociones) {
			listadoDePromociones += promocion.getNombre() + ", ";
		}
		listadoDePromociones += "]";
		return "Atracciones: " + listadoDeAtracciones
				+ "\nPromociones: " + listadoDePromociones;

	}
}
