/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication3;

import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableCell;
import javafx.stage.Stage;
import javafx.geometry.Pos;

/**
 *
 * @author Nilu-PC
 */
public class JavaFXApplication3 extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }
    
    public static class CheckBoxTableCell<S, T> extends TableCell<S, T> {

        private final CheckBox checkBox;

        private ObservableValue<T> ov;

 

        public CheckBoxTableCell() {

            this.checkBox = new CheckBox();

            this.checkBox.setAlignment(Pos.CENTER);

 

            setAlignment(Pos.CENTER);

            setGraphic(checkBox);

        } 

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
}
