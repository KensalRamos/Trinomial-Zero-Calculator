package Calculator;

import static Calculator.CalculatorMenu.menuBar;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


/**
 *
 * @author Kensal Ramos
 */
public class Main extends Application    {

    
    static Stage window;
    static Scene scene;
    //Binomial Calculator
    TextField inputA, inputB, inputC;
    static Button solveButton, backButton, exitButton, backButton2, exitButton2;
    Label inputLabel;
    static BorderPane root;
    static VBox vBox;
    
    
    static Button calcButton;
    
    public static void main(String[] args)  {
        //Launches the program/primary stage
        launch(args);
        
    }
    
    // The main entry point for all JavaFX applications.
    @Override
    public void start(Stage primaryStage)   {
        window = primaryStage;
        window.resizableProperty().setValue(Boolean.FALSE);
        
        String binomial_Formula = "   X " + '\u00B2' +  "+ X + C \n" + "Solve Binomial" ;        
        
        //Adds Binomial Button 
        Button binomial_Button = new Button();
        binomial_Button.setText(binomial_Formula);
        
        
        //Adds the exit button, when clicked it terminates the program
        Button exitButton = new Button();
        exitButton.setText("        Exit        ");
        exitButton.setTranslateY(-10);
        exitButton.setId("exit-hover");
        exitButton.setOnAction(e -> closeProgram());
        
        //Creates a stack pane that can be changed in size by the user
        root = new BorderPane();
        root.setPrefSize(700,700);
        BorderPane.setAlignment(exitButton, Pos.BOTTOM_CENTER);
        BorderPane.setAlignment(binomial_Button, Pos.CENTER);
        
        scene = new Scene(root, 300, 250);
        
            //Calc Button
            calcButton = new Button("Calculator WIP");
            calcButton.setTranslateY(20);
            calcButton.setOnAction(e ->  launchCalcScene());
            
            backButton2 = new Button("Back");
            exitButton2 = new Button("Exit");
            exitButton2.setId("exit-hover");
            exitButton2.setOnAction(e -> closeProgram());
            backButton2.setOnAction(e -> {
                window.setTitle("Multi-Function Calculator");
                window.setScene(scene);
            });
             
            
            //Binomial button action
            binomial_Button.setOnAction(e -> setBinomialScene());
            
            VBox vBox = new VBox(30);
            vBox.setPadding(new Insets(20, 20, 20, 20));
            
            calcButton.setMaxWidth(Double.MAX_VALUE);
            binomial_Button.setMaxWidth(Double.MAX_VALUE);
            exitButton.setMaxWidth(Double.MAX_VALUE);
            vBox.getChildren().addAll(calcButton, binomial_Button, exitButton);
            
            //Stack Pane
            BorderPane.setAlignment(vBox, Pos.TOP_CENTER);
            root.setCenter(vBox);
            root.setTop(menuBar());
            
            //Window (primary stage)
            window.setTitle("Multi-Function calculator");
            
            //Style Sheets
            scene.getStylesheets().add("Calculator/CalculatorCSS.css");
            root.getStylesheets().add("Calculator/CalculatorCSS.css");
            
            window.setOnCloseRequest(e -> {
                e.consume();
                closeProgram();
            });
            
            window.setScene(scene);
            window.show();
    }    
    
    public static void closeProgram()   {
        Boolean answer = ConfirmBox.display("Exit Prompt", "Are you sure you want to exit?");
        if(answer)
            System.exit(0);
    }
    
    //Boolean testing if A is a number
    private static boolean isDoubleA(TextField inputA) {
        try {
            double a = Double.parseDouble(inputA.getText());
            return true;
        }
        catch(NumberFormatException e)  {
            AlertBox.display("Error", "Please insert a number");
            return false;
        }
    }
    
    //Boolean testing if B is a number
    private static boolean isDoubleB(TextField inputB) {
        try {
            double b = Double.parseDouble(inputB.getText());
            return true;
        }
        catch(NumberFormatException e)  {
            AlertBox.display("Error", "Please insert a number");
            return false;
        }
       
    }
    
    //Boolean testing if C is a number
    private static boolean isDoubleC(TextField inputC) {
        try {
            double c = Double.parseDouble(inputC.getText());
            return true;
        }
        catch(NumberFormatException e)  {
            AlertBox.display("Error", "Please insert a number");
            return false;
        }
    }
    
    
    //Method solves for zeros
    public static void quadraticFormula() {
        if (isDoubleA(BinomialScene.inputA) )    {
                    if(isDoubleB(BinomialScene.inputB))   {
                        if(isDoubleC(BinomialScene.inputC))   {
                    double a = Double.parseDouble(BinomialScene.inputA.getText());
                    double b = Double.parseDouble(BinomialScene.inputB.getText());
                    double c = Double.parseDouble(BinomialScene.inputC.getText());
                    
                    double answer1 = (-b + Math.sqrt(Math.pow(b, 2) - (4 * a * c))) / (2 * a);
                    double answer2 = (-b - Math.sqrt(Math.pow(b, 2) - (4 * a * c))) / (2 * a);
                    
                    String answer1_3dec = String.format("%.3f", answer1);
                    String answer2_3dec = String.format("%.3f", answer2);
                    
                     if (Double.isNaN(answer1) || Double.isNaN(answer2)) {                        
                         BinomialScene.inputLabel.setText("Binomial has no zeros.");
                        }  else    {
                         if (answer1 == answer2){
                             BinomialScene.inputLabel.setText("Binomial has 1 zero: " + answer1_3dec);
                         }else  {
                            BinomialScene.inputLabel.setText("Binomial has 2 zeros: " + answer1_3dec+ " and " + answer2_3dec);
                         }
                     }
                }
               }
              }
    }
    
    public void launchCalcScene()   {
        CalculatorScene.display();
    }
    
    public void setBinomialScene()  {
        BinomialScene.display();
    }
    
    public static void changeTheme()    {
        ChangeTheme.display();
    }
}
