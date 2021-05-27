package sample;

import controller.IngressoController;
import controller.VisitanteController;
import entities.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
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

    public void startCadastro(Stage primaryStage, Visitante visitanteCadastro) throws Exception{
        TextField textCpf = new TextField("cpf");
        TextField textEmail = new TextField("email");
        TextField textNome = new TextField("nome");
        TextField textRg = new TextField("rg");
        TextField textTelefone = new TextField();
        TextField textLogin = new TextField("login");
        TextField textSenha = new TextField("senha");

        Button btnCadastrar = new Button("Cadastrar");
        Button btnVoltar = new Button("Voltar");

        GridPane gridPane = new GridPane();
        Scene scene = new Scene(gridPane, 400, 400);


        gridPane.add(textCpf, 1, 1);
        gridPane.add(textEmail, 2, 2);
        gridPane.add(textNome, 2, 2);
        gridPane.add(textRg, 3, 3);
        gridPane.add(textLogin, 4, 4);
        gridPane.add(textSenha, 4, 5);
        gridPane.add(btnCadastrar, 6, 6);

        btnCadastrar.setOnAction((e)->setParametros(visitanteCadastro));
        btnVoltar.setOnAction((e)-> Platform.exit());

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void setParametros(Visitante visitante) {
        visitante.setCpf("123");
        visitante.setEmail("email");
        visitante.setDatanasc(LocalDate.now());
        visitante.setNome("Nome");
        visitante.setRg("321");
        visitante.setTelefone("12345");
        //Login e senha
        visitante.setLogin("admin");
        visitante.setSenha("admin");
        return;
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
            this.startCadastro(new Stage(), visitante);
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
