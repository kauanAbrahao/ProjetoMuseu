package sample;

import controller.IngressoController;
import controller.VisitanteController;
import entities.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();


        //GUILHERME, FAÇA AQUI A TELA!!!!!!

        //Isso é a primeira tela
        boundaryToEntityLoginNoSistema();

        //Essa é a segunda tela
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

    private void boundaryToEntityLoginNoSistema() {
        Cidadao visitanteLogin = new Cidadao();
//        visitanteLogin.setLogin();
//        visitanteLogin.setSenha();
        entityToBoundaryLoginNoSistema(visitanteController.loginVisitante(visitanteLogin));
    }

    private void entityToBoundaryLoginNoSistema(Visitante visitante){
        if (visitante != null){
            //mostra na telinha que o login foi sucesso e vai para a próxima tela
            this.visitanteDoSistema = visitante;
        } else {
            //msotra na telinha que deu ruim e fica na mesma tela.
        }
    }

    private void boundaryToEntityRegistroNoSistema() {
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
        visitanteController.cadastrarVisitante(visitante);
    }


    public static void main(String[] args) {
        launch(args);
    }

}
