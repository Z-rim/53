import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PoetryCalculator extends Application {

    // Define the UI elements
    private TextField priceField = new TextField();
    private TextField sizeField = new TextField();
    private TextField rateField = new TextField();
    private Label valueLabel = new Label();
    private Label rentLabel = new Label();

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Set up the UI layout
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(10));
        gridPane.setAlignment(Pos.CENTER);

        gridPane.add(new Label("Property price:"), 0, 0);
        gridPane.add(priceField, 1, 0);

        gridPane.add(new Label("Property size (in sq.ft.):"), 0, 1);
        gridPane.add(sizeField, 1, 1);

        gridPane.add(new Label("Rate per sq.ft.:"), 0, 2);
        gridPane.add(rateField, 1, 2);

        HBox hbox1 = new HBox();
        hbox1.setSpacing(10);
        hbox1.setAlignment(Pos.CENTER);
        hbox1.getChildren().add(new Label("Estimated Property Value: "));
        hbox1.getChildren().add(valueLabel);

        HBox hbox2 = new HBox();
        hbox2.setSpacing(10);
        hbox2.setAlignment(Pos.CENTER);
        hbox2.getChildren().add(new Label("Estimated Rent Price: "));
        hbox2.getChildren().add(rentLabel);

        VBox vbox = new VBox();
        vbox.setSpacing(10);
        vbox.setAlignment(Pos.CENTER);
        vbox.getChildren().addAll(gridPane, hbox1, hbox2);

        // Set up event handlers for text fields
        priceField.setOnAction(e -> calculateValues());
        sizeField.setOnAction(e -> calculateValues());
        rateField.setOnAction(e -> calculateValues());

        // Set up the calculate button
        Button calculateButton = new Button("Calculate");
        calculateButton.setOnAction(e -> calculateValues());

        HBox hbox3 = new HBox();
        hbox3.setSpacing(10);
        hbox3.setAlignment(Pos.CENTER);
        hbox3.getChildren().add(calculateButton);

        vbox.getChildren().add(hbox3);

        // Set up the scene
        Scene scene = new Scene(vbox, 400, 250);

        // Set up the stage
        primaryStage.setTitle("Property Value and Rent Price Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void calculateValues() {
        // Get the values from the text fields
        double price = Double.parseDouble(priceField.getText());
        double size = Double.parseDouble(sizeField.getText());
        double rate = Double.parseDouble(rateField.getText());

        // Calculate the property value and rent price
        double value = size * rate;
        double rent = value * 0.01; // Assume rent is 1% of property value per month

        // Update the UI with the estimated values
        valueLabel.setText(String.format("$%.2f", value));
        rentLabel.setText(String.format("$%.2f", rent));
    }

    public static void main(String[] args) {
        launch(args);
    }
}
