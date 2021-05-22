package entities;

public class Professor extends Visitante {

    private boolean ativo;
    private String instEnsino;

    @Override
    public void comprarIngresso() {
        if(this.getVisita().getIngresso() != null){
            //jogar na tela que ele já tem um ingresso!
        } else {
            visita = new Visita();
            visita.obtemIngresso();
        }
    }

    @Override
    public void calcularValorIngresso() {
        if(this.getVisita().getIngresso() != null){
            this.setValorTotal(calcularDesconto());
        } else {
            return;
        }
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
