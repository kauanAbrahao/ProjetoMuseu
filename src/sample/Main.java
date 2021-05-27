package sample;

import controller.IngressoController;
import controller.VisitanteController;
import entities.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.time.LocalDate;

public class Main extends Application {


    //Primeira tela
    TextField textCpf = new TextField();
    TextField textSenha = new TextField();
    Label sistema = new Label("Sistema Zoomuseum");
    Button btnCadastrar = new Button("Cadastrar");
    Button btnAcessar = new Button("Acessar");

    VisitanteController visitanteController = new VisitanteController();
    IngressoController ingressoController = new IngressoController();
    Visitante visitanteDoSistema = new Cidadao();

    //Segunda Tela




    @Override
    public void start(Stage primaryStage) throws Exception {
        GridPane gridPane = new GridPane();
        Scene scene = new Scene(gridPane, 400, 400);

        gridPane.add(sistema, 1, 1);
        gridPane.add(textCpf, 2, 2);
        gridPane.add(btnAcessar, 2, 2);
        gridPane.add(textSenha, 3, 3);
        gridPane.add(btnCadastrar, 4, 4);

        //Isso é a primeira tela
        btnAcessar.setOnAction((e)-> {
            try {
                this.entityToBoundaryLoginNoSistema
                        (visitanteController.loginVisitante(textCpf.getText(), textSenha.getText()));
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });

        btnCadastrar.setOnAction((e)-> visitanteController.cadastrarVisitante(boundaryToEntityRegistroNoSistema()));

        primaryStage.setScene(scene);
        primaryStage.show();

        //GUILHERME, FAÇA AQUI A TELA!!!!!!


        //Essa é a segunda tela
        //apertei o botão: btnCadastra.setOnAction((e)-> visitanteController.cadastraVisitante(boundaryToEntityLoginNoSistema());
        boundaryToEntityRegistroNoSistema();

        //Terceira tela (compra de ingresso)
        //Pegar data de uma label na tela
        LocalDate MUDAR_ESSA_VARIAVEL_PARA_A_LABEL_DEPOIS = LocalDate.now();
        boundaryToEntityCompraIngresso(ingressoController.comprarIngresso
                (this.visitanteDoSistema, MUDAR_ESSA_VARIAVEL_PARA_A_LABEL_DEPOIS));
    }

    public void startIngresso(Stage primaryStage) throws Exception{
        //Tela de Ingresso
    }

//    ----------------------------------------------------------------------------------------------------------


    private void boundaryToEntityCompraIngresso(Visitante comprarIngresso) {
        //MONTAR A TELA E MOSTRAR AS INFORMAÇÕES DA COMPRA DE INGRESSO (VALOR, DATA DE VISITA ETC).
    }


    private void entityToBoundaryLoginNoSistema(Visitante visitante) throws Exception {
        if (visitante != null){
            //mostra na telinha que o login foi sucesso e vai para a próxima tela
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("Bem vindo, " + visitante.getNome() + " !");
            alert.show();
            this.visitanteDoSistema = visitante;
            //CHAMAR A TELA QUE SERÁ A DE COMPRA DE INGRESSO ETC
            this.startIngresso(new Stage());

        } else {
            //msotra na telinha que deu ruim e fica na mesma tela.
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Usuário ou senha inválidos");
            alert.show();
        }
    }

    private Cidadao boundaryToEntityRegistroNoSistema() {

        try{
            Cidadao visitante = new Cidadao();
            //Os parâmetros para os sets são os label.getText() da tela
        visitante.setCpf("123");
        visitante.setEmail("email");
        visitante.setDatanasc(LocalDate.now());
        visitante.setNome("Nome");
        visitante.setRg("321");
        visitante.setTelefone("12345");
        //Login e senha
        visitante.setLogin("admin");
        visitante.setSenha("admin");
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
