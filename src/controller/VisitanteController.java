package controller;

import entities.Aluno;
import entities.Cidadao;
import entities.Professor;
import entities.Visitante;
import javafx.scene.control.Alert;

import java.util.LinkedList;
import java.util.List;

public class VisitanteController {

    List<Visitante> visitantesCadastrados = new LinkedList<>();

    //SUBSTITUIR POR DAO DEPOIS
    public void cadastrarVisitante(Aluno visitante){
        if (visitante!=null){
            visitantesCadastrados.add(visitante);
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("Cadastro realizado com sucesso!");
        }
    }public void cadastrarVisitante(Professor visitante){
        if (visitante!=null){
            visitantesCadastrados.add(visitante);
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("Cadastro realizado com sucesso!");
        }
    } public void cadastrarVisitante(Cidadao visitante){
        if (visitante!=null){
            visitantesCadastrados.add(visitante);
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("Cadastro realizado com sucesso!");
        }
    }

    //SUBSTITUIR POR DAO DEPOIS
    public Visitante loginVisitante(String loginOuCpf, String senha){
        for (Visitante visitante: visitantesCadastrados){
            if((visitante.getLogin().equals(loginOuCpf) || visitante.getCpf().equals(loginOuCpf)
                    && visitante.getSenha().equals(senha))){
                return visitante;
            }
        }
        return null;
    }





}
