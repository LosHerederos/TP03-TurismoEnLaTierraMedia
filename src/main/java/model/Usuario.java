package model;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Usuario {

	private int idUsuario;
	private boolean eliminado;
	private boolean esAdmin;
	private String nombre;
	private int presupuesto;
	private double tiempoDisponible;
	private TipoDeAtraccion tipoFavorito;
	private Itinerario itinerario = new Itinerario();
	private HashMap<String, String> errores;

	public Usuario(
		int idUsuario,
		boolean esAdmin,
		String nombre,
		int presupuesto,
		double tiempoDisponible,
		TipoDeAtraccion tipoFavorito,
		Itinerario itinerario
	) {
		this.idUsuario = idUsuario;
		this.esAdmin = esAdmin;
		this.nombre = nombre;
		this.presupuesto = presupuesto;
		this.tiempoDisponible = tiempoDisponible;
		this.tipoFavorito = tipoFavorito;
		this.itinerario = itinerario;
	}

	public Usuario() {
		this(0, false, "", 0, 0.0, null, new Itinerario());
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public boolean estaEliminado() {
		return this.eliminado;
	}
	
	public void setEliminado(boolean eliminado) {
		this.eliminado = eliminado;
	}

	public boolean esAdmin() {
		return esAdmin;
	}

	public void setEsAdmin(boolean esAdmin) {
		this.esAdmin = esAdmin;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPresupuesto() {
		return presupuesto;
	}

	public void setPresupuesto(int presupuesto) {
		this.presupuesto = presupuesto;
	}

	public double getTiempoDisponible() {
		return tiempoDisponible;
	}

	public void setTiempoDisponible(double tiempoDisponible) {
		this.tiempoDisponible = tiempoDisponible;
	}

	public TipoDeAtraccion getTipoFavorito() {
		return tipoFavorito;
	}

	public void setTipoFavorito(TipoDeAtraccion tipoFavorito) {
		this.tipoFavorito = tipoFavorito;
	}

	public Itinerario getItinerario() {
		return itinerario;
	}

	public void setItinerario(Itinerario itinerario) {
		this.itinerario = itinerario;
	}

	public Map<String, String> getErrores() {
		return errores;
	}

	public boolean estaEnElItinerario(Sugeribles sugerencia) {
		return this.itinerario.tiene(sugerencia);
	}

	public boolean poseeRecursosSuficientes(int precio, double tiempo) {
		return this.presupuesto >= precio && this.tiempoDisponible >= tiempo;
	}

	public void aceptarSugerencia(Sugeribles sugerencia) {
		this.itinerario.agregarSugerencia(sugerencia);
		this.presupuesto -= sugerencia.getCosto();
		this.tiempoDisponible -= sugerencia.getTiempo();
	}

	public boolean esNulo() {
		return false;
	}
	
	public boolean esValido() {
		validar();
		return errores.isEmpty();
	}
	
	public void validar() {
		errores = new HashMap<String, String>();
		
		if (presupuesto < 0) {
			errores.put("presupuesto", "No debe ser negativo");
		}
		if (tiempoDisponible < 0) {
			errores.put("tiempoDisponible", "No debe ser negativo");
		}
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(idUsuario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return idUsuario == other.idUsuario;
	}

	@Override
	public String toString() {
		return "Nombre: " + this.nombre + ", Tipo de favorito: " + this.tipoFavorito + "\n"
				+ this.itinerario;
	}
}
