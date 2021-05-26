package controller;

import entities.Ingresso;
import entities.Visita;
import entities.Visitante;

import java.time.LocalDate;

public class IngressoController {

    public Visitante comprarIngresso(Visitante visitante, LocalDate dataDeVisita){
        Ingresso ingresso = new Ingresso();
        visitante.setVisita(new Visita());
        visitante.getVisita().setIngresso(ingresso);
        visitante.getVisita().setDataref(dataDeVisita);
        double valorIngresso = visitante.calcularValorIngresso(ingresso);
        visitante.setValorTotal(valorIngresso);
        return visitante;

    }
}
