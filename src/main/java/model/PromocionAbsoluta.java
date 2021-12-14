package model;

import java.util.ArrayList;
import java.util.List;

public class PromocionAbsoluta extends Promocion {

	private int costoTotal;

	public PromocionAbsoluta(
		int idPromocion,
		String nombre,
		String descripcion,
		String imagen,
		List<Atraccion> atracciones,
		TipoDeAtraccion tipoDeAtraccion,
		int costoTotal
	) {
		super(idPromocion, nombre, descripcion, imagen, atracciones, tipoDeAtraccion);
		this.costoTotal = costoTotal;
	}

	public PromocionAbsoluta() {
		this(0, "", "", "", new ArrayList<Atraccion>(), null, 0);
	}

	public int getCostoTotal() {
		return costoTotal;
	}

	public void setCostoTotal(int costoTotal) {
		this.costoTotal = costoTotal;
	}

	@Override
	public void validar() {
		super.validar();

		if (costoTotal < 1) {
			super.getErrores().put("costoTotal", "El costo total tiene que ser mayor a cero");
		}
	}

	@Override
	public int getCosto() {
		return costoTotal;
	}
}
