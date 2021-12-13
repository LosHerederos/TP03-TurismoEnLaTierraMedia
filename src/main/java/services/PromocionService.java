package services;

import java.util.List;

import model.Promocion;
import persistence.PromocionDAO;
import persistence.commons.DAOFactory;

public class PromocionService {

	PromocionDAO promocionDAO;

	public PromocionService() {
		this.promocionDAO = DAOFactory.getPromocionDAO();
	}

	public Promocion buscar(int idPromocion) {
		return promocionDAO.findById(idPromocion);
	}

	public List<Promocion> listar() {
		return promocionDAO.findAll();
	}

	public void crear() {
		
	}

	public void modificar() {
		
	}
}
