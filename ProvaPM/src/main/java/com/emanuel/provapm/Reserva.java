package com.emanuel.provapm;

public class Reserva {
    
    private int codigo;
    private String nomeCliente;
    private String data;
    private String horario;
    private int quantConvidados;
    private String status;
    private double valorTotal;
    private Salao salao;
    
    public Reserva(){
        this.codigo = (int) Math.random()*1000;
        this.status = "SOLICITADA";
        this.salao = null;
    }
    
    @Override
    public String toString(){
        return codigo + " >> Cliente: " + this.getNomeCliente() + " | Data: " + this.getData() + " | Horário: " + this.getHorario() +
                " | Quant. Convidadados: " + this.getQuantConvidados() + " | Status: " + this.getStatus() + " | Valor: R$" + this.getValorTotal();
    }

    public Salao getSalao() {
        return salao;
    }
    public void setSalao(Salao salao) {
        this.salao = salao;
    }
    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public String getNomeCliente() {
        return nomeCliente;
    }
    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }
    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }
    public String getHorario() {
        return horario;
    }
    public void setHorario(String horario) {
        this.horario = horario;
    }
    public int getQuantConvidados() {
        return quantConvidados;
    }
    public void setQuantConvidados(int quantConvidados) {
        this.quantConvidados = quantConvidados;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public double getValorTotal() {
        return valorTotal;
    }
    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
}
