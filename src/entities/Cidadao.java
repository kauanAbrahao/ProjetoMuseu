package entities;

public class Cidadao extends Visitante {



    @Override
    public double calcularValorIngresso(Ingresso ingresso) {
        return ingresso.getValor();
    }
}
