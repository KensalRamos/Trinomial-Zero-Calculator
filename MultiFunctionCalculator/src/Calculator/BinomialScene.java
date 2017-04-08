package Calculator;

import static Calculator.Main.window;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

/**
 *
 * @author Kensal Ramos
 */
public class BinomialScene {
    
    static TextField inputA, inputB, inputC;
    static Label inputLabel;
    
    public static void display()    {
        window.setTitle("Binomial Calculator");
        //Binomial scene
            //Middle Menu (Textfields)
            HBox midMenu = new HBox();
            midMenu.setSpacing(15);
            
            //Bottom Menu (Solve and Back buttons)
            HBox botMenu = new HBox();
            botMenu.setSpacing(125);
            
            //Input Values Label
            inputLabel = new Label("Insert a,b,c values appropiately: ");
            
            //A,B,C value input
            inputA = new TextField();
            inputB = new TextField();
            inputC = new TextField();
            
            //Solve and back buttons
            Button solveButton = new Button("Solve");
            Button backButton = new Button("Back");
            Button exitButton = new Button("Exit");
            exitButton.setId("exit-hover");
            exitButton.setOnAction(e -> Main.closeProgram());
            
            //Children
            midMenu.getChildren().addAll(inputA, inputB, inputC);

            
            
            //Border pane configuration
            BorderPane borderPane = new BorderPane();
              //Input Label
            borderPane.setTop(inputLabel); 
            BorderPane.setAlignment(inputLabel, Pos.CENTER);
            BorderPane.setMargin(inputLabel, new Insets(10, 10, 25, 10));
                //Mid Menu
            borderPane.setCenter(midMenu);
            BorderPane.setAlignment(midMenu, Pos.CENTER);
            BorderPane.setMargin(midMenu, new Insets(0, 10, 0, 10));
                //Bot Menu
            borderPane.setBottom(botMenu);
            BorderPane.setAlignment(botMenu, Pos.CENTER);
            BorderPane.setMargin(botMenu, new Insets (0, 0, 20, 10));
          
            //Binomial Scene
            Scene binomialScene = new Scene(borderPane, 400, 150);
            binomialScene.getStylesheets().add("Calculator/CalculatorCSS.css");
           
            botMenu.getChildren().addAll(backButton, solveButton, exitButton);
            
                        //Back button action
            backButton.setOnAction(e -> {
                inputA.clear(); inputB.clear(); inputC.clear();
                inputLabel.setText("Insert a, b, c values appropiately: ");
                window.setTitle("Multi-Function Calculator");
                window.setScene(Main.scene);
            });
            //Enter Key Action A
            inputA.setOnKeyPressed(event ->  {
                if(event.getCode() == KeyCode.ENTER){   Main.quadraticFormula(); }});
            //Enter key action B
            inputB.setOnKeyPressed(event ->  {
                if(event.getCode() == KeyCode.ENTER){   Main.quadraticFormula(); }});
            //Enter action event C 
            inputC.setOnKeyPressed(event ->  {
                if(event.getCode() == KeyCode.ENTER)    {   Main.quadraticFormula(); }});
            
            solveButton.setOnAction(e -> Main.quadraticFormula());
            window.setScene(binomialScene);
    }
}
