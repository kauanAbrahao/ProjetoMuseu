package entities;

public class Aluno extends Visitante {

    private String ra;
    private String instEnsino;

    public Aluno(String ra, String instEnsino){
        this.ra = ra;
        this.instEnsino = instEnsino;
    }


    @Override
    public double calcularValorIngresso(Ingresso ingresso) {
        if(this.getVisita().getIngresso() != null){
            this.setValorTotal(calcularDesconto());
        } else {

        }
        return 0.0;
    }

    private double calcularDesconto() {
        double valor = this.getVisita().getIngresso().getValor() * 0.5;
        return valor;
    }

    public String getRa() {
        return ra;
    }

    public void setRa(String ra) {
        this.ra = ra;
    }

    public String getInstEnsino() {
        return instEnsino;
    }

    public void setInstEnsino(String instEnsino) {
        this.instEnsino = instEnsino;
    }

}
