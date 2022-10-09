package net.itinajero.service.db;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import net.itinajero.model.Categoria;
import net.itinajero.model.Vacante;
import net.itinajero.repository.CategoriasRepository;
import net.itinajero.service.ICategoriasService;

@Service
@Primary
public class CategoriasServiceJpa implements ICategoriasService {

	@Autowired
	private CategoriasRepository categoriasRepo;
	
	public void guardar(Categoria categoria) {
		categoriasRepo.save(categoria);
	}

	@Override
	public List<Categoria> buscarTodas() {
		return categoriasRepo.findAll();
	}

	@Override
	public Categoria buscarPorId(Integer idCategoria) {
		Optional<Categoria> optional = categoriasRepo.findById(idCategoria);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}
	@Override
	public void eliminar(Integer idCategoria) {
		// TODO Auto-generated method stub
		categoriasRepo.deleteById(idCategoria);
		
	}

	@Override
	public List<Categoria> buscarByExample(Example<Categoria> example) {
		return categoriasRepo.findAll(example);
	}

	public Page<Categoria> buscarTodas(Pageable page) {
		return categoriasRepo.findAll(page);
	}

	

}
