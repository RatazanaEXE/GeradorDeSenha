import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.security.SecureRandom;


public class GeradorDeSenha extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    public String gerarSenha() {

        SecureRandom aleatorio = new SecureRandom();

        String senha ="";
        for (int i = 0; i < 8; i++) {
            senha += aleatorio.nextInt(10);
        }
        return senha;
    }
    @Override
    public void start(Stage palco) {

        Label etiquetaSenha = new Label("Clique para gerar");
        Button gerarSenha = new Button("Gerar senha");

        gerarSenha.setOnAction(e -> {
            String senha = String.valueOf(gerarSenha());
            etiquetaSenha.setText(senha);
        });

        VBox layout = new VBox(etiquetaSenha, gerarSenha);

        Scene cena = new Scene(layout, 300, 200);

        palco.setTitle("Gerador de Senha");
        palco.setScene(cena);
        palco.show();
    }
}