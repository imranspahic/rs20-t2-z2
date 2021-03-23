package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {
    public TextField textField;
    public Label labela;

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

    public void savucaj(ActionEvent actionEvent) {
        int broj = Integer.parseInt(textField.getText());
        String tekst = "";
        for (int i = 1; i < broj; i++) {
            int suma = sumaCifara(i);
            if(i%suma == 0) tekst+= " " + i;
        }
        if(!tekst.isEmpty()) {
            String labelaTekst = "Brojevi su djeljivi sa svojim ciframa između 1 i n su: ";
            labela.setText(labelaTekst + tekst);
        }
    }

    private int sumaCifara(int broj) {
        int sumaCifara=0;
        do {
            sumaCifara+= broj%10;
            broj/=10;
        } while(broj!=0);
        return sumaCifara;
    }
}
