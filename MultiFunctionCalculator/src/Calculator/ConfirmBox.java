package Calculator;

import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

/**
 *
 * @author Kensal Ramos
 */
public class ConfirmBox {
    
    static boolean answer;
    
    public static boolean display(String title, String message)   {
        Stage confirmBoxWindow = new Stage();
        confirmBoxWindow.resizableProperty().setValue(Boolean.FALSE);
        confirmBoxWindow .initModality(Modality.APPLICATION_MODAL);
        confirmBoxWindow .setTitle(title);
        confirmBoxWindow .setWidth(200);
        confirmBoxWindow.setHeight(200);
        confirmBoxWindow.setX(Calculator.Main.window.getX() + Calculator.Main.window.getWidth() / 2 - confirmBoxWindow.getWidth() / 2);
        confirmBoxWindow.setY(Calculator.Main.window.getY() + Calculator.Main.window.getHeight() / 2 - confirmBoxWindow.getHeight() / 2);
        
        Label label = new Label();
        label.setText(message);

        //Create two buttons
        Button yesButton = new Button("Yes");
        Button noButton = new Button ("No");
        
        yesButton.setOnAction(e ->  {
            answer = true;
            confirmBoxWindow .close();
        });
        noButton.setOnAction(e ->   {
            answer = false;
            confirmBoxWindow .close();
        });
        
        VBox layout = new VBox(10);
        layout.getChildren().addAll(label, yesButton, noButton);
        layout.setAlignment(Pos.CENTER);
        Scene scene = new Scene(layout);
        scene.getStylesheets().add("Calculator/CalculatorCSS.css");
        confirmBoxWindow .setScene(scene);
        //Waits until window is closed to return boolean value
        confirmBoxWindow .showAndWait();
        
        return answer;
    }
    
}






