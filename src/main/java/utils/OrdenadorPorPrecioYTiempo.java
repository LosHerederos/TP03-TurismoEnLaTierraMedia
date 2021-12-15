package utils;

import java.util.Comparator;

import model.Sugeribles;

public class OrdenadorPorPrecioYTiempo implements Comparator<Sugeribles> {

	@Override
	public int compare(Sugeribles sugerencia, Sugeribles otraSugerencia) {
		if (Integer.compare(sugerencia.getCosto(), otraSugerencia.getCosto()) == 0) {
			return Double.compare(sugerencia.getTiempo(), otraSugerencia.getTiempo()) * -1;
		}
		return Integer.compare(sugerencia.getCosto(), otraSugerencia.getCosto()) * -1;
	}
}
