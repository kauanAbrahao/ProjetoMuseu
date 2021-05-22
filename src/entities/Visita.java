package entities;

import java.time.LocalDate;

public class Visita {
    private LocalDate dataref;
    private Ingresso ingresso;
    Guia guia;
    Visitante visitante;

    public void obtemIngresso(){
        this.setIngresso(new Ingresso());
        this.setGuia(new Guia());
    }


    public LocalDate getDataref() {
        return dataref;
    }

    public void setDataref(LocalDate dataref) {
        this.dataref = dataref;
    }

    public Visitante getVisitante() {
        return visitante;
    }

    public void setVisitante(Visitante visitante) {
        this.visitante = visitante;
    }

    public Ingresso getIngresso() {
        return ingresso;
    }

    public void setIngresso(Ingresso ingresso) {
        this.ingresso = ingresso;
    }

    public Guia getGuia() {
        return guia;
    }

    public void setGuia(Guia guia) {
        this.guia = guia;
    }
}
