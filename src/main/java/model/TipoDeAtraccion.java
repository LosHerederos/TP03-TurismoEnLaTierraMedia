package model;

public class TipoDeAtraccion {

	private int idTipoDeAtraccion;
	private String nombre;
	
	public TipoDeAtraccion(int idTipoDeAtraccion, String nombre) {
		this.idTipoDeAtraccion = idTipoDeAtraccion;
		this.nombre = nombre;
	}
	
	public TipoDeAtraccion(String nombre) {
		this(0, nombre);
	}

	public int getIdTipoDeAtraccion() {
		return idTipoDeAtraccion;
	}

	public void setIdTipoDeAtraccion(int idTipoDeAtraccion) {
		this.idTipoDeAtraccion = idTipoDeAtraccion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
