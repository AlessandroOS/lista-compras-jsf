package br.com.listacompras.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.com.listacompras.dao.DAO;
import br.com.listacompras.model.Item;
import br.com.listacompras.util.NegocioException;

public class ItemService implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private DAO<Item> dao;
	
	public void save(Item item) throws NegocioException {
		
		if(item.getNome().length() < 3) {
			throw new NegocioException("O nome do item tem que ter no minimo 3 caracteres");
		}
		
		dao.save(item);
	}
	
	public void delete(Item item) throws NegocioException {
		dao.remove(Item.class, item.getId());
	}
	
	public List<Item> findAllItem() {
		return dao.findAll("select item from Item item order by item.nome");
	}

}
