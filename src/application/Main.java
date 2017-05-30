package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main extends Application {
    private static Stage stage;
    private static Map users =  new HashMap();


    public static Map getUsers(){
        return users;
    }

    public static Stage getStage(){
        return stage;
    }
    @Override
    public void start(Stage primaryStage) throws Exception{
        stage = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("../fxml/main.fxml"));
        stage.setTitle("Hello World");
        stage.setScene(new Scene(root, 342, 160));
        stage.setResizable(false);
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
