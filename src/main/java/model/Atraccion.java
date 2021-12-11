package model;

import java.util.Objects;

public class Atraccion implements Sugeribles {

	private int idAtraccion;
	private boolean eliminado;
	private String nombre;
	private String descripcion;
	private String imagen;
	private int costoVisita;
	private double tiempoParaRealizarla;
	private int cupoPersonas;
	private int visitantes = 0;
	private TipoDeAtraccion tipoDeAtraccion;

	public Atraccion(
		int idAtraccion,
		String nombre,
		String descripcion,
		String imagen,
		int costoVisita,
		double tiempoParaRealizarla,
		int cupoPersonas,
		int visitantes,
		TipoDeAtraccion tipoDeAtraccion
	) {
		this.idAtraccion = idAtraccion;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.imagen = imagen;
		this.costoVisita = costoVisita;
		this.tiempoParaRealizarla = tiempoParaRealizarla;
		this.cupoPersonas = cupoPersonas;
		this.visitantes = visitantes;
		this.tipoDeAtraccion = tipoDeAtraccion;
	}

	public Atraccion() {
		this(0, "", "", "", 0, 0.0, 0, 0, null);
	}

	public int getIdAtraccion() {
		return idAtraccion;
	}

	public void setIdAtraccion(int idAtraccion) {
		this.idAtraccion = idAtraccion;
	}

	public boolean estaEliminado() {
		return this.eliminado;
	}

	public void setEliminado(boolean eliminado) {
		this.eliminado = eliminado;
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

	public int getCostoVisita() {
		return costoVisita;
	}

	public void setCostoVisita(int costoVisita) {
		this.costoVisita = costoVisita;
	}

	public double getTiempoParaRealizarla() {
		return tiempoParaRealizarla;
	}

	public void setTiempoParaRealizarla(double tiempoParaRealizarla) {
		this.tiempoParaRealizarla = tiempoParaRealizarla;
	}

	public int getCupoPersonas() {
		return cupoPersonas;
	}

	public void setCupoPersonas(int cupoPersonas) {
		this.cupoPersonas = cupoPersonas;
	}

	public int getVisitantes() {
		return visitantes;
	}

	public void setVisitantes(int visitantes) {
		this.visitantes = visitantes;
	}

	public TipoDeAtraccion getTipoDeAtraccion() {
		return tipoDeAtraccion;
	}

	public void setTipoDeAtraccion(TipoDeAtraccion tipoDeAtraccion) {
		this.tipoDeAtraccion = tipoDeAtraccion;
	}

	@Override
	public int getCosto() {
		return this.costoVisita;
	}

	@Override
	public double getTiempo() {
		return this.tiempoParaRealizarla;
	}

	@Override
	public boolean tieneCupoCompleto() {
		return this.cupoPersonas == this.visitantes;
	}

	@Override
	public void agregarVisitante() {
		this.visitantes += 1;
	}

	@Override
	public int hashCode() {
		return Objects.hash(costoVisita, cupoPersonas, nombre, tiempoParaRealizarla, tipoDeAtraccion, visitantes);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Atraccion other = (Atraccion) obj;
		return costoVisita == other.costoVisita && cupoPersonas == other.cupoPersonas
				&& Objects.equals(nombre, other.nombre)
				&& Double.doubleToLongBits(tiempoParaRealizarla) == Double.doubleToLongBits(other.tiempoParaRealizarla)
				&& tipoDeAtraccion == other.tipoDeAtraccion && visitantes == other.visitantes;
	}

	@Override
	public String toString() {
		return "Nombre: " + this.getNombre() + ", "
				+ "Tipo: " + this.getTipoDeAtraccion() + ", "
				+ "Costo: " + this.getCosto() + ", "
				+ "Tiempo: " + this.tiempoParaRealizarla + ".";
	}
}
