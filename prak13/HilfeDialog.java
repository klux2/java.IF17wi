import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class HilfeDialog extends Stage {

    private Button ok;
    WebView browser;
    WebEngine webEngine;

    HBox buttonBox;
    VBox vBox;

    public HilfeDialog() {
        super();
        initModality(Modality.APPLICATION_MODAL);

        browser = new WebView();
        webEngine = browser.getEngine();
        webEngine.load("https://de.wikipedia.org/wiki/Vier_gewinnt");
        ok = new Button("OK");
        ok.addEventHandler(ActionEvent.ACTION, e -> this.close());

        buttonBox = new HBox(20);
        buttonBox.setAlignment(Pos.CENTER_RIGHT);
        buttonBox.getChildren().add(ok);

        vBox = new VBox(20, browser, buttonBox);
        VBox.setVgrow(browser, Priority.ALWAYS);

        Scene scene = new Scene(vBox);
        this.setScene(scene);
    }
}