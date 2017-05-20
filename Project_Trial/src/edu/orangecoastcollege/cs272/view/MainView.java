package edu.orangecoastcollege.cs272.view;

import java.io.File;
import java.time.Duration;

import com.sun.media.jfxmedia.MediaPlayer;

import javafx.application.Application;
import javafx.scene.media.Media;
import javafx.stage.Stage;

/**
 * 
 * @author last edited by Khang Nguyen
 *
 */

public class MainView extends Application
{
//    static final String COMBAT_FOREST_PATH = "mp3/MUSIC.mp3";
//    static final String INTRO_FOREST_PATH = "mp3/MUSIC2.mp3"
    @Override
    public void start(Stage primaryStage) throws Exception
    {
        ViewNavigator.setStage(primaryStage);
        ViewNavigator.loadScene("Title Screen", ViewNavigator.TITLE_SCENE);

        /*
        Media song = new Media(new File(MainView.COMBAT_FOREST_PATH).toURI().toString());
        MediaPlayer player = new MediaPlayer(song);
        player.setVolume(50);
        player.setAutoPlay(true);
        player.setOnEndOfMedia(new Runnable)
        {
            public void run() {
                player.seek(Duration.ZERO);
            }
        }
        */
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
