package com.example.practice;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(@NotNull Stage stage) throws IOException {

        String path = "C:\\Users\\User\\Downloads\\Video\\Charlie Puth - -How Long- [Official Video].mp4";
        System.out.println("Trying song to play.");

        //Instantiating Media class
        Media media = new Media(new File(path).toURI().toString());

        //Instantiating MediaPlayer class
        MediaPlayer mediaPlayer = new MediaPlayer(media);

        //by setting this property to true, the audio will be played
        mediaPlayer.setAutoPlay(true);


        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("test-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 650, 400);
        stage.setTitle("Currency Converter");

        stage.setScene(scene);
        stage.show();

    }
    public static void main(String[] args) {

        launch();
    }







}