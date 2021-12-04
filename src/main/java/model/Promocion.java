package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class Promocion implements Sugeribles {

	private int idPromocion;
	private String nombre;
	private String descripcion;
	private String imagen;
	private List<Atraccion> atracciones;
	private TipoDeAtraccion tipoDeAtraccion;

	public Promocion(
		int idPromocion,
		String nombre,
		String descripcion,
		String imagen,
		List<Atraccion> atracciones,
		TipoDeAtraccion tipoDeAtraccion
	) {
		this.idPromocion = idPromocion;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.imagen = imagen;
		this.atracciones = atracciones;
		this.tipoDeAtraccion = tipoDeAtraccion;
	}

	public Promocion() {
		this(0, "", "", "", new ArrayList<Atraccion>(), null);
	}

	public int getIdPromocion() {
		return idPromocion;
	}

	public void setIdPromocion(int idPromocion) {
		this.idPromocion = idPromocion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public List<Atraccion> getAtracciones() {
		return atracciones;
	}

	public void setAtracciones(List<Atraccion> atracciones) {
		this.atracciones = atracciones;
	}

	public TipoDeAtraccion getTipoDeAtraccion() {
		return tipoDeAtraccion;
	}

	public void setTipoDeAtraccion(TipoDeAtraccion tipoDeAtraccion) {
		this.tipoDeAtraccion = tipoDeAtraccion;
	}

	@Override
	public int getCosto() {
		int costoTotal = 0;
		for (Atraccion atraccion : atracciones) {
			costoTotal += atraccion.getCosto();
		}
		return costoTotal;
	}

	@Override
	public double getTiempo() {
		double tiempoTotal = 0;
		for (Atraccion atraccion : atracciones) {
			tiempoTotal += atraccion.getTiempo();
		}
		return tiempoTotal;
	}

	@Override
	public boolean tieneCupoCompleto() {
		boolean cupoCompleto = false;
		Iterator<Atraccion> atraccion = atracciones.listIterator();
		while(atraccion.hasNext()) {
			if (atraccion.next().tieneCupoCompleto()) {
				cupoCompleto = true;
			}
		}
		return cupoCompleto;
	}

	@Override
	public void agregarVisitante() {
		if (!this.tieneCupoCompleto()) {
			for (Atraccion atraccion : atracciones) {
				atraccion.agregarVisitante();
			}
		}
	}
}
