/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxmvc;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Rafael Pimenta
 */
public class Main extends Application {
    
    @Override
    public void start(Stage stage) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("view/FXMLVBoxMain.fxml")); //Carrega o arquivo fxml
        
        Scene scene = new Scene(root); //estancia a cena
        
        stage.setScene(scene);//seta a cena
        stage.setTitle("Sistema JAVAFX");//titulo
        stage.setResizable(false);//não permitir maximização
        stage.show();//exibir a tela
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
