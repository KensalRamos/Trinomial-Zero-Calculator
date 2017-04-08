package Calculator;

import static Calculator.Main.changeTheme;
import static Calculator.Main.closeProgram;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;

public class CalculatorMenu {
    
    public static MenuBar menuBar()    {
        Menu fileMenu = new Menu("_File");
        
        //File Menu Items
        MenuItem restart = new MenuItem("_Restart Program");
        restart.setOnAction(e -> {
            try {
                restartApplication();
            } catch (IOException ex) {
                Logger.getLogger(CalculatorMenu.class.getName()).log(Level.SEVERE, null, ex);
            } catch (URISyntaxException ex) {
                Logger.getLogger(CalculatorMenu.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        MenuItem exit = new MenuItem("_Exit");
        exit.setOnAction(e -> closeProgram());
        
        fileMenu.getItems().addAll(restart, new SeparatorMenuItem(), exit);
        
        
        Menu editMenu = new Menu("_Edit");
        
        //Edit Menu Items
        MenuItem changeTheme = new MenuItem("_Change Theme");
        changeTheme.setOnAction(e -> changeTheme());
        editMenu.getItems().addAll(changeTheme);
        
        
        Menu helpMenu = new Menu("_Help");
        
        //Help Menu Items
        MenuItem about = new MenuItem("_About");
        MenuItem helpContents = new MenuItem("_Help Contents");
        helpMenu.getItems().addAll(helpContents, new SeparatorMenuItem(), about);
        
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(fileMenu, editMenu, helpMenu);
        return menuBar;
    }
    
    public static void restartApplication() throws IOException, URISyntaxException
    {
        final String javaBin = System.getProperty("java.home") + File.separator + "bin" + File.separator + "java";
        final File currentJar = new File(Main.class.getProtectionDomain().getCodeSource().getLocation().toURI());

        /* is it a jar file? */
        if(!currentJar.getName().endsWith(".jar"))
          return;

        /* Build command: java -jar application.jar */
        final ArrayList<String> command = new ArrayList<>();
        command.add(javaBin);
        command.add("-jar");
        command.add(currentJar.getPath());

        final ProcessBuilder builder = new ProcessBuilder(command);
        builder.start();
        System.exit(0);
    }
   
}
