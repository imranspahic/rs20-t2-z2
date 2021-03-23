package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class Controller {
    public TextField textField;

    @FXML
    public  void initialize() {
        textField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String stari, String novi) {
                System.out.println(textField.getText());

                if(!novi.matches("\\d*"))  {
                    textField.setText(stari);
                }
            }
        });
    }

}
