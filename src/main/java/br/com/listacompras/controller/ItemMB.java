package br.com.listacompras.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.listacompras.model.Item;
import br.com.listacompras.service.ItemService;
import br.com.listacompras.util.Message;
import br.com.listacompras.util.NegocioException;

@Named
@ViewScoped
public class ItemMB implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	private Item item;

	@Inject
	private ItemService itemService;

	private List<Item> itens;

	@PostConstruct
	public void carregar() {
		itens = itemService.findAllItem();
	}

	public void add() {

		try {
			itemService.save(item);
			item = new Item();
			carregar();

			Message.info("Salvo com sucesso");

		} catch (NegocioException e) {
			Message.erro(e.getMessage());
		}

	}

	public void delete() {
		try {
			itemService.delete(item);
			carregar();

			Message.info(item.getNome() + " foi removido");
		} catch (NegocioException e) {
			Message.erro(e.getMessage());
		}
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public List<Item> getItens() {
		return itens;
	}

}
