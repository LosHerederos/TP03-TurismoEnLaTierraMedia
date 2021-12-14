package model;

import java.util.ArrayList;
import java.util.List;

public class PromocionPorcentual extends Promocion {

	private double porcentaje;

	public PromocionPorcentual(
		int idPromocion,
		String nombre,
		String descripcion,
		String imagen,
		List<Atraccion> atracciones,
		TipoDeAtraccion tipoDeAtraccion,
		double porcentaje
	) {
		super(idPromocion, nombre, descripcion, imagen, atracciones, tipoDeAtraccion);
		this.porcentaje = porcentaje;
	}

	public PromocionPorcentual() {
		this(0, "", "", "", new ArrayList<Atraccion>(), null, 0.0);
	}

	public double getPorcentaje() {
		return porcentaje;
	}

	public void setPorcentaje(double porcentaje) {
		this.porcentaje = porcentaje;
	}

	public void validar() {
		super.validar();

		if (porcentaje < 0.1) {
			super.getErrores().put("porcentaje", "El porcentaje tiene que ser mayor a 0");
		}
	}

	@Override
	public int getCosto() {
		double costoTotal = super.getCosto() - (super.getCosto() * this.porcentaje);
		return (int) costoTotal;
	}
}
