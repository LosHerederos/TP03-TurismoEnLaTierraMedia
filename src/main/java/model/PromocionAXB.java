package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PromocionAXB extends Promocion {

	private List<Atraccion> atraccionesPagas;

	public PromocionAXB(
		int idPromocion,
		String nombre,
		String descripcion,
		String imagen,
		List<Atraccion> atracciones,
		TipoDeAtraccion tipoDeAtraccion,
		List<Atraccion> atraccionesPagas
	) {
		super(idPromocion, nombre, descripcion, imagen, atracciones, tipoDeAtraccion);
		this.atraccionesPagas = atraccionesPagas;
	}

	public PromocionAXB() {
		this(0, "", "", "", new ArrayList<Atraccion>(), null, new ArrayList<Atraccion>());
	}

	public List<Atraccion> getAtraccionesPagas() {
		return atraccionesPagas;
	}

	public void setAtraccionesPagas(List<Atraccion> atraccionesPagas) {
		this.atraccionesPagas = atraccionesPagas;
	}
	
	@Override
	public int getCosto() {
		int costoTotal = 0;
		for (Atraccion atraccion : atraccionesPagas) {
			costoTotal += atraccion.getCosto();
		}
		return costoTotal;
	}

	@Override
	public double getTiempo() {
		double tiempoTotal = super.getTiempo();
		for (Atraccion atraccion : atraccionesPagas) {
			tiempoTotal += atraccion.getTiempo();
		}
		return tiempoTotal;
	}

	@Override
	public boolean tieneCupoCompleto() {
		boolean cupoCompleto = false;
		if (super.tieneCupoCompleto()) {
			cupoCompleto = true;
		} else {
			Iterator<Atraccion> atraccion = atraccionesPagas.listIterator();
			while(atraccion.hasNext()) {
				if (atraccion.next().tieneCupoCompleto()) {
					cupoCompleto = true;
				}
			}
		}
		return cupoCompleto;
	}

	@Override
	public void agregarVisitante() {
		if (!this.tieneCupoCompleto()) {
			super.agregarVisitante();
			for (Atraccion atraccion : atraccionesPagas) {
				atraccion.agregarVisitante();
			}
		}
	}

	@Override
	public String toString() {
		String listadoDeAtraccionesPagas = "[";
		for (Atraccion atraccion : atraccionesPagas) {
			listadoDeAtraccionesPagas += atraccion.getNombre() + ", ";
		}
		listadoDeAtraccionesPagas += "]";
		return super.toString()
				+ "\nAtracciones Pagas: " + listadoDeAtraccionesPagas;
	}
}
