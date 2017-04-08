package Calculator;

import static Calculator.Main.window;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;

public class CalculatorScene {
    
    //Calculator
    
    public static void display()    {
        window.setTitle("Calculator WIP");
        
        
        
        //Top Input
        TextField calcInput = new TextField();
        calcInput.setPromptText("Please insert an expression");

        //Bottom Calculator Menu
        HBox calcBotMenu = new HBox();
        calcBotMenu.setSpacing(250);
        calcBotMenu.getChildren().addAll(Calculator.Main.backButton2, Calculator.Main.exitButton2);
        
        //Middle Menu Buttons
        Button button1 = new Button("1");
        GridPane.setConstraints(button1, 0, 0); 
        button1.setStyle("-fx-font: 15 Kameron;");
        
        Button button2 = new Button("2");
        GridPane.setConstraints(button2, 1, 0); 
        button2.setStyle("-fx-font: 15 Kameron;");
        
        Button button3 = new Button("3");
        GridPane.setConstraints(button3, 2, 0); 
        button3.setStyle("-fx-font: 15 Kameron;");
        
        Button button4 = new Button("4");
        GridPane.setConstraints(button4, 0, 1); 
        button4.setStyle("-fx-font: 15 Kameron;");
        
        Button button5 = new Button("5");
        GridPane.setConstraints(button5, 1, 1);
        button5.setStyle("-fx-font: 15 Kameron;");
        
        Button button6 = new Button("6");
        GridPane.setConstraints(button6, 2, 1); 
        button6.setStyle("-fx-font: 15 Kameron;");
        
        Button button7 = new Button("7");
        GridPane.setConstraints(button7, 0, 2); 
        button7.setStyle("-fx-font: 15 Kameron;");
        
        Button button8 = new Button("8");
        GridPane.setConstraints(button8, 1, 2); 
        button8.setStyle("-fx-font: 15 Kameron;");
        
        Button button9 = new Button("9");
        GridPane.setConstraints(button9, 2, 2); 
        button9.setStyle("-fx-font: 15 Kameron;");
        
        Button button0 = new Button("0");
        GridPane.setConstraints(button0, 1, 3); 
        button0.setStyle("-fx-font: 15 Kameron;");

        //Middle Calculator Menu
        GridPane calcGrid = new GridPane();
        calcGrid.setTranslateX(100);
        calcGrid.setTranslateY(30);
        calcGrid.setPadding(new Insets(10, 10, 10, 10));
        calcGrid.setVgap(3);
        calcGrid.setHgap(5);
        calcGrid.getChildren().addAll(
                button0, button1, button2, button3, button4, button5, button6, button7, button8, button9
        );
        
        //Calculator Scene
        BorderPane calcPane = new BorderPane();
        //Top
        calcPane.setTop(calcInput); 
        BorderPane.setAlignment(calcInput, Pos.CENTER);
        BorderPane.setMargin(calcInput, new Insets(15, 20, 15, 20));
        //Middle
        BorderPane.setAlignment(calcGrid, Pos.CENTER);
        calcPane.setCenter(calcGrid);
        //Bottom
        calcPane.setBottom(calcBotMenu);
        BorderPane.setAlignment(calcBotMenu, Pos.CENTER);
        BorderPane.setMargin(calcBotMenu, new Insets(10, 10, 10, 10));

        Scene calcScene = new Scene(calcPane, 350, 300);
        calcScene.getStylesheets().add("Calculator/CalculatorCSS.css");

        window.setScene(calcScene);
    }
}
