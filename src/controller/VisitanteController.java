package controller;

import entities.Aluno;
import entities.Cidadao;
import entities.Professor;
import entities.Visitante;

import java.util.LinkedList;
import java.util.List;

public class VisitanteController {

    List<Visitante> visitantesCadastrados = new LinkedList<>();

    //SUBSTITUIR POR DAO DEPOIS
    public void cadastrarVisitante(Aluno visitante){
        if (visitante!=null){
            visitantesCadastrados.add(visitante);
        }
    }public void cadastrarVisitante(Professor visitante){
        if (visitante!=null){
            visitantesCadastrados.add(visitante);
        }
    } public void cadastrarVisitante(Cidadao visitante){
        if (visitante!=null){
            visitantesCadastrados.add(visitante);
        }
    }

    //SUBSTITUIR POR DAO DEPOIS
    public Visitante loginVisitante(Visitante visitanteLogin){
        for (Visitante visitante: visitantesCadastrados){
            if((visitante.getLogin().equals(visitanteLogin.getLogin()) || visitante.getCpf().equals(visitanteLogin.getLogin())
                    && visitante.getSenha().equals(visitanteLogin.getSenha()))){
                return visitante;
            }
        }
        return null;
    }





}
