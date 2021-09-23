package br.com.listacompras.model;

public enum Categoria {
	
    ELETRONICOS,
    ALIMENTACAO,
    VESTUARIO;

    public static Categoria procurarCategoria(String descricao) {
        for (Categoria categoria : values()) {
            if (categoria.name().equalsIgnoreCase(descricao)) {
                return categoria;
            }
        }
        return null;
    }

}
