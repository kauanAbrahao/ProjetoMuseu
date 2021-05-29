package sample;

import controller.IngressoController;
import controller.VisitanteController;
import entities.Cidadao;
import entities.Visitante;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.time.LocalDate;

public class Main extends Application {

    VisitanteController visitanteController = new VisitanteController();

    //Primeira tela
    TextField textCpf = new TextField();
    TextField textSenha = new TextField();
    Label sistema = new Label("Sistema Zoomuseum");
    Label CPF = new Label("CPF");
    Label Senha = new Label("Senha");
    Button btnCadastrar = new Button("Cadastrar");
    Button btnAcessar = new Button("Acessar");

    IngressoController ingressoController = new IngressoController();
    Visitante visitanteDoSistema = new Cidadao();

    //Segunda Tela
        TextField textCpfCadastro = new TextField();
        TextField textEmailCadastro = new TextField();
        TextField textNomeCadastro = new TextField();
        TextField textRgCadastro = new TextField();
        TextField textTelefoneCadastro = new TextField();
        TextField textLoginCadastro = new TextField();
        TextField textSenhaCadastro = new TextField();
        Label CPFCadastro = new Label("CPF");
        Label SenhaCadastro = new Label("Senha");
        Label RG = new Label("RG");
        Label Nome = new Label("Nome");
        Label Login = new Label("Login");
        Label EMail = new Label("E-Mail");
        Label Telefone = new Label("Telefone");
        Button btnCadastrar2 = new Button("Cadastrar");

        Button btnVoltar = new Button("Voltar");


    @Override
    public void start(Stage primaryStage) throws Exception {
        GridPane gridPane = new GridPane();
        Scene scene = new Scene(gridPane, 400, 400);

        gridPane.add(sistema, 7, 3);
        gridPane.add(CPF, 3, 6);
        gridPane.add(Senha, 8, 6);
        gridPane.add(textCpf, 3, 7);
        gridPane.add(btnAcessar, 3, 9);
        gridPane.add(textSenha, 8, 7);
        gridPane.add(btnCadastrar, 8, 9);

        //Isso é a primeira tela
        btnAcessar.setOnAction((e)-> {
            try {
                this.entityToBoundaryLoginNoSistema
                        (visitanteController.loginVisitante(textCpf.getText(), textSenha.getText()));
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });

        btnCadastrar.setOnAction((e)-> {
            try {
                this.startCadastro(new Stage());
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });

        primaryStage.setScene(scene);
        primaryStage.show();


    }

    public void startCadastro(Stage primaryStage) throws Exception{

        GridPane gridPane = new GridPane();
        Scene scene = new Scene(gridPane, 400, 400);

        gridPane.add(CPFCadastro, 1, 1);
        gridPane.add(textCpfCadastro, 1, 2);
        gridPane.add(EMail, 5, 1);
        gridPane.add(textEmailCadastro, 5, 2);
        gridPane.add(Nome, 1, 3);
        gridPane.add(textNomeCadastro, 1, 4);
        gridPane.add(RG, 5, 3);
        gridPane.add(textRgCadastro, 5, 4);
        gridPane.add(Login, 1, 5);
        gridPane.add(textLoginCadastro, 1, 6);
        gridPane.add(Senha, 5, 5);
        gridPane.add(textSenhaCadastro, 5, 6);
        gridPane.add(btnCadastrar2, 5, 18);
        gridPane.add(btnVoltar, 1, 18);

        btnCadastrar2.setOnAction((e)->visitanteController.cadastrarVisitante(boundaryToEntityRegistroNoSistema()));
        btnVoltar.setOnAction((e)-> primaryStage.close());

        primaryStage.setScene(scene);
        primaryStage.show();
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
//            this.startIngresso(new Stage());

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
            visitante.setCpf("123");
            visitante.setEmail("email");
            visitante.setDatanasc(LocalDate.now());
            visitante.setNome("Nome");
            visitante.setRg("321");
            visitante.setTelefone("12345");
            //Login e senha
            visitante.setLogin(textLoginCadastro.getText());
            visitante.setSenha(textSenhaCadastro.getText());
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