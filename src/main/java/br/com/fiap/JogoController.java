package br.com.fiap;

import java.io.IOException;
import java.util.Random;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class JogoController {
    @FXML
    private TextField tentativaTextField;
    @FXML
    private Label vidasLabel;
    @FXML
    private Button btnTentar;
    @FXML
    private Label aviso;

    Random rand = new Random();
    private int randomNum = rand.nextInt(101);
    private int vidas = 10;

    @FXML
    private void tentar() {
        int tentativa = Integer.valueOf(tentativaTextField.getText());

        if (vidas > 0) {
            if (tentativa == randomNum) {
                vidas = vidas + 1;
                aviso.setText("ACERTOU!");
            } else {
                if (tentativa > randomNum) {
                    vidas = vidas - 1;
                    aviso.setText("CHUTOU ALTO!");
                } else {
                    vidas = vidas - 1;
                    aviso.setText("CHUTOU BAIXO!");
                }
            }
        } else {
            aviso.setText("GAME OVER!");
        }

        vidasLabel.setText(String.valueOf(vidas));
    }
}
