package Calculator;

import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;
import javafx.scene.input.KeyCode;

/**
 *
 * @author Kensal Ramos
 */
public class AlertBox {
    
    public static void display(String title, String message)   {
        Stage alertBoxWindow = new Stage();
        alertBoxWindow.resizableProperty().setValue(Boolean.FALSE);
        
        //Blocks user interaction with other windows until this one is taken care of
        alertBoxWindow.initModality(Modality.APPLICATION_MODAL);
        alertBoxWindow.setTitle(title);
        alertBoxWindow.setWidth(200);
        alertBoxWindow.setHeight(200);
        alertBoxWindow.setX(Calculator.Main.window.getX() + Calculator.Main.window.getWidth() / 2 - alertBoxWindow.getWidth() / 2);
        alertBoxWindow.setY(Calculator.Main.window.getY() + Calculator.Main.window.getHeight() / 2 - alertBoxWindow.getHeight() / 2);
        
        Label label = new Label();
        label.setText(message);
        Button closeButton = new Button("Close Window");
        closeButton.setOnAction(e -> alertBoxWindow.close());
        closeButton.setOnKeyPressed(event ->  {
            if(event.getCode() == KeyCode.ENTER){
                alertBoxWindow.close();
            }
        });
        
        VBox layout = new VBox(10);
        layout.getChildren().addAll(label, closeButton);
        layout.setAlignment(Pos.CENTER);
        
        
        Scene scene = new Scene(layout);
        scene.getStylesheets().add("Calculator/CalculatorCSS.css");
        alertBoxWindow.setScene(scene);
        //Display window and before returning to other windows needs to be closed
        alertBoxWindow.showAndWait();
    }
    
}











