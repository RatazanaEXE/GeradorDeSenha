import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.security.SecureRandom;

public class GeradorDeSenha extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    final static String caracteres =
            "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%&*()-_=+[]{}<>?";

    public String gerarSenha(int comprimento) {

        SecureRandom aleatorio = new SecureRandom();
        StringBuilder senha = new StringBuilder(comprimento);

        for (int i = 0; i < comprimento; i++) {
            int indice = aleatorio.nextInt(caracteres.length());
            senha.append(caracteres.charAt(indice));
        }

        return senha.toString();
    }

    @Override
    public void start(Stage palco) {

        Label etiquetaSenha = new Label("Digite o comprimento da senha");

        TextField campoComprimento = new TextField();
        campoComprimento.setPromptText("Digite o comprimento");

        Button gerarSenha = new Button("Gerar senha");

        gerarSenha.setOnAction(e -> {

            int comprimento = Integer.parseInt(campoComprimento.getText());

            String senha = gerarSenha(comprimento);

            etiquetaSenha.setText(senha);
        });

        VBox layout = new VBox(10, etiquetaSenha, campoComprimento, gerarSenha);

        Scene cena = new Scene(layout, 300, 200);

        palco.setTitle("Gerador de Senha");
        palco.setScene(cena);
        palco.show();
    }
}