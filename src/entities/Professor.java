package entities;

public class Professor extends Visitante {

    private boolean ativo;
    private String instEnsino;


    @Override
    public double calcularValorIngresso(Ingresso ingresso) {
        if(this.getVisita().getIngresso() != null){
            this.setValorTotal(calcularDesconto());
        } else {
        }
            return 0.0;
    }

    private double calcularDesconto() {
        double valor = this.getVisita().getIngresso().getValor() * 0.8;
        return valor;
    }



    public Professor(String instEnsino){
        this.instEnsino = instEnsino;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public String getInstEnsino() {
        return instEnsino;
    }

    public void setInstEnsino(String instEnsino) {
        this.instEnsino = instEnsino;
    }

}
