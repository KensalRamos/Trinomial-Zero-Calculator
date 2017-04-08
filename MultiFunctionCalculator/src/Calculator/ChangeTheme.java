package Calculator;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ChangeTheme {
    
    public static void display()    {
        //Stage
        Stage changeThemeStage = new Stage();
        changeThemeStage.resizableProperty().setValue(Boolean.FALSE);
        changeThemeStage.setTitle("Change Theme");
        changeThemeStage.setWidth(200);
        changeThemeStage.setHeight(200);
        changeThemeStage.setX(Calculator.Main.window.getX() + Calculator.Main.window.getWidth() / 2 - changeThemeStage.getWidth() / 2);
        changeThemeStage.setY(Calculator.Main.window.getY() + Calculator.Main.window.getHeight() / 2 - changeThemeStage.getHeight() / 2);

        Label label = new Label("Please select a theme");
        
        //List view
        ListView<String> listView = new ListView<>();
        listView.getItems().addAll("Traditional", "Night", "Candy", "Transparent");
        listView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        
        //Vertical box setup
        VBox vBox = new VBox();
        vBox.setPadding(new Insets(20, 20, 20, 20));
        vBox.getChildren().addAll(listView);
        
        Scene changeThemeScene = new Scene(vBox, 300, 250);
        changeThemeStage.setScene(changeThemeScene);
        changeThemeStage.show();
    }
}
