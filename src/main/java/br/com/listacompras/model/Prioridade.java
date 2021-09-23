package br.com.listacompras.model;

public enum Prioridade {
	
    BAIXA, MEDIA, ALTA;

    public static Prioridade procurarPrioridade (String descricao) {
        for (Prioridade prioridade : values()) {
            if(prioridade.name().equalsIgnoreCase(descricao)) {
                return prioridade;
            }
        }
        return null;
    }

}
