package entities;

import java.time.LocalDate;

public class Ingresso {
    private LocalDate dataEmissao;
    private LocalDate dataVencimento;
    private Double valor = 30.0;

    public Ingresso(){
        this.dataEmissao = LocalDate.now();
        this.dataVencimento = LocalDate.now().plusDays(7);
    }


    public LocalDate getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(LocalDate dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public Double getValor() {
        return valor;
    }
}
