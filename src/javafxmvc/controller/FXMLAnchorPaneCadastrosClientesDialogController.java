/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxmvc.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafxmvc.model.domain.Cliente;

/**
 * FXML Controller class
 *
 * @author Rafael Pimenta
 */
public class FXMLAnchorPaneCadastrosClientesDialogController implements Initializable {

    @FXML
    private Label labelClienteNome;
    @FXML
    private Label labelClienteCPF;
    @FXML
    private Label labelClienteTelefone;
    @FXML
    private TextField textFieldClienteNome;
    @FXML
    private TextField textFieldClienteCPF;
    @FXML
    private TextField textFieldClienteTelefone;
    @FXML
    private Button buttonConfirmar;
    @FXML
    private Button buttonCancelar;

    private Stage dialogStage;
    private boolean buttonConfirmarClicked = false;
    private Cliente cliente;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    public Stage getDialogStage() {
        return dialogStage;
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public boolean isButtonConfirmarClicked() {
        return buttonConfirmarClicked;
    }

    public void setButtonConfirmarClicked(boolean buttonConfirmarClicked) {
        this.buttonConfirmarClicked = buttonConfirmarClicked;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
        this.textFieldClienteNome.setText(cliente.getNome());
        this.textFieldClienteCPF.setText(cliente.getCpf());
        this.textFieldClienteTelefone.setText(cliente.getTelefone());
    }

    @FXML //Evento no botão confirmar 
    public void handleButtonConfirmar() {
        if (validarEntradaDeDados()) {

            cliente.setNome(textFieldClienteNome.getText());
            cliente.setCpf(textFieldClienteCPF.getText());
            cliente.setTelefone(textFieldClienteTelefone.getText());

            buttonConfirmarClicked = true;
            dialogStage.close(); //fecha  a tela a confirmar  
        }
    }

    @FXML //Evento no botão cancelar 
    public void handleButtonCancelar() {
        dialogStage.close();
    }

    //Validar entrada de dados para o cadastro 
    private boolean validarEntradaDeDados() {
        String errorMessage = "";
        if (textFieldClienteNome.getText() == null || textFieldClienteNome.getText().length() == 0) {
            errorMessage += "Nome Invalido! \n";
        }
        if (textFieldClienteCPF.getText() == null || textFieldClienteCPF.getText().length() == 0) {
            errorMessage += "CPF Invalido! \n";
        }
        if (textFieldClienteTelefone.getText() == null || textFieldClienteTelefone.getText().length() == 0) {
            errorMessage += "Telefone Invalido! \n";
        }

        if (errorMessage.length() == 0) {
            return true;
        } else {
            //Mostrando mensagem de erro 
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Erro no cadastro");
            alert.setHeaderText("Campos invalidos , por favor , corrija ...");
            alert.setContentText(errorMessage);
            alert.show();
            return false;
        }
    }
}
