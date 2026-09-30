package com.emanuel.provapm;

public class Salao {
    
    private int numero;
    private int capacidadeMax;
    private String localizacao;
    private String tipoSalao;
    private Organizador organizador;

    public Salao(int numero, int capacidadeMax, String localizacao, String tipoSalao) {
        this.numero = numero;
        this.capacidadeMax = capacidadeMax;
        this.localizacao = localizacao;
        this.tipoSalao = tipoSalao;
        this.organizador = null;
    }

    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }
    public int getCapacidadeMax() {
        return capacidadeMax;
    }
    public void setCapacidadeMax(int capacidadeMax) {
        this.capacidadeMax = capacidadeMax;
    }
    public String getLocalizacao() {
        return localizacao;
    }
    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }
    public String getTipoSalao() {
        return tipoSalao;
    }
    public void setTipoSalao(String tipoSalao) {
        this.tipoSalao = tipoSalao;
    }
    public Organizador getOrganizador() {
        return organizador;
    }
    public void setOrganizador(Organizador organizador) {
        this.organizador = organizador;
    }
    
    @Override
    public String toString(){
        
        if(organizador != null){
            return this.getNumero() + " >> LOCALIZAÇÃO: " + this.getLocalizacao() + " | TIPO: "  + this.getTipoSalao() 
                + " | CAPACIDADE MÁX: " + this.getCapacidadeMax() + " | ORGANIZADOR: " 
                + this.getOrganizador().getNome();
        }
        
        return this.getNumero() + " >> LOCALIZAÇÃO: " + this.getLocalizacao() + " | TIPO: "  + this.getTipoSalao() 
                + " | CAPACIDADE MÁX: " + this.getCapacidadeMax() + " | ORGANIZADOR: " 
                + "Nenhum";
        
        
    }
    
}
