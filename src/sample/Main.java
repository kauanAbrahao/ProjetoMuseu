package sample;

import controller.IngressoController;
import controller.VisitanteController;
import entities.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.time.LocalDate;

public class Main extends Application {

    //fazer label, botão etc

    VisitanteController visitanteController = new VisitanteController();
    IngressoController ingressoController = new IngressoController();
    Visitante visitanteDoSistema = new Cidadao();


    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Tela de acesso");
        primaryStage.setScene(new Scene(root, 500, 500));
        primaryStage.show();

        //GUILHERME, FAÇA AQUI A TELA!!!!!!

        //Isso é a primeira tela
        //apertei o botão: btnLogin.setOnAction((e)->entityToBoundaryLoginNoSistema
        // (visitanteController.loginVisitante(labelLoginOuCpf, loginSenha);

        //Essa é a segunda tela
        //apertei o botão: btnCadastra.setOnAction((e)-> visitanteController.cadastraVisitante(boundaryToEntityLoginNoSistema());
        boundaryToEntityRegistroNoSistema();

        //Terceira tela (compra de ingresso)
        //Pegar data de uma label na tela
        LocalDate MUDAR_ESSA_VARIAVEL_PARA_A_LABEL_DEPOIS = LocalDate.now();
        boundaryToEntityCompraIngresso(ingressoController.comprarIngresso
                (this.visitanteDoSistema, MUDAR_ESSA_VARIAVEL_PARA_A_LABEL_DEPOIS));


    }

    private void boundaryToEntityCompraIngresso(Visitante comprarIngresso) {
        //MONTAR A TELA E MOSTRAR AS INFORMAÇÕES DA COMPRA DE INGRESSO (VALOR, DATA DE VISITA ETC).
    }


    private void entityToBoundaryLoginNoSistema(Visitante visitante){
        if (visitante != null){
            //mostra na telinha que o login foi sucesso e vai para a próxima tela
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("Bem vindo, " + visitante.getNome() + " !");
            alert.show();
            this.visitanteDoSistema = visitante;
        } else {
            //msotra na telinha que deu ruim e fica na mesma tela.
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Usuário ou senha inválidos");
            alert.show();
        }
    }

    private Visitante boundaryToEntityRegistroNoSistema() {
        try{
            Cidadao visitante = new Cidadao();
            //Os parâmetros para os sets são os label.getText() da tela
//        visitante.setCpf();
//        visitante.setEmail();
//        visitante.setDatanasc();
//        visitante.setNome();
//        visitante.setRg();
//        visitante.setTelefone();
//        //Login e senha
//        visitante.setLogin();
//        visitante.setSenha();
            return visitante;
        } catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Erro! Por favor, verifique as informações inseridas");
            alert.show();
            return null;
        }
    }


    public static void main(String[] args) {
        launch(args);
    }

}
