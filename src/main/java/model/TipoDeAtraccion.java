package model;

public enum TipoDeAtraccion {

	AVENTURA("Atracción de aventura"),
	PAISAJE("Atracción de paisaje"),
	DEGUSTACION("Atracción de degustación");

	private final String descripcion;

	private TipoDeAtraccion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return this.descripcion;
	}
}
