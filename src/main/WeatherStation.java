package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Separator;
import javafx.stage.Stage;

public class WeatherStation extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(WeatherStation.class.getResource("/main/Template.fxml"));
        Parent layout = fxmlLoader.load();

        Scene scene = new Scene(layout);
        scene.getStylesheets().add("main/Style.css");

        ScrollPane scrollPane = new ScrollPane();
        scrollPane.getStyleClass().add("scroll-pane");

        Separator separator = new Separator();
        separator.getStyleClass().add("separator");

        primaryStage.setScene(scene);
        primaryStage.setTitle("Weather_Forecast");
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}