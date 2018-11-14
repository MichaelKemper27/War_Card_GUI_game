/*
 Michael Kemper
ID: 0506582
November 7th, 2017
This is Lab 9
Shows how to use Polymorphism.
 */
package lab9;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.stage.Stage;
import javafx.scene.image.*;
import java.util.Random;
import javafx.geometry.Pos;
import javafx.scene.input.MouseEvent;

public class Lab9 extends Application {
    
    int rightVal = 0, leftVal = 0;
    Suit rightSuit, leftSuit;
    boolean rightsTurn = true;
    Deck d = new Deck();
    @Override
    public void start(Stage primaryStage) {
        Random ran = new Random();
        Font fnt1 = Font.font("Arial", FontWeight.BOLD, 16.0);
        Font fnt2 = Font.font("Arial", FontWeight.NORMAL, 12.0);
        Label lblScore = new Label("Score:");
        Label lblLeft = new Label("Left:");
        TextField tfLeft = new TextField();
        tfLeft.setPrefWidth(50);
        tfLeft.setDisable(true);
        tfLeft.setText("0");
        Label lblRight = new Label("Right:");
        TextField tfRight = new TextField();
        tfRight.setPrefWidth(50);
        tfRight.setDisable(true);
        tfRight.setText("0");
        Label lblCardLeft = new Label();
        Label lblCardDeck = new Label();
        Label lblCardRight = new Label();
        resetCardImages(lblCardLeft,lblCardRight,lblCardDeck);
        Button btnReset = new Button("Reset");
        lblScore.setFont(fnt1);
        lblScore.setTextFill(Color.RED);
        lblLeft.setFont(fnt2);
        lblRight.setFont(fnt2);  
            
        lblCardDeck.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
            public void handle(MouseEvent event) {
                PlayingCard c = (PlayingCard) d.deal();
                if (rightsTurn == true) 
                {
                    rightVal = c.getValue();
                    rightSuit = c.getSuit();
                    lblCardRight.setGraphic(c);
                }
                else 
                {
                    leftVal = c.getValue();
                    leftSuit = c.getSuit();
                    lblCardLeft.setGraphic(c);
                    //System.out.println("left is: " + leftVal + " " + leftSuit + ", right val is: " + rightVal + " " + rightSuit);
                    if (rightVal > leftVal)
                    {
                        Score.setRightScore(rightVal);
                        tfRight.setText(String.valueOf(Score.getRightScore()));
                    }
                    else if (leftVal > rightVal)
                    {
                        Score.setLeftScore(leftVal);
                        tfLeft.setText(String.valueOf(Score.getLeftScore()));
                    }
                }
                rightsTurn = !rightsTurn;
            }
        });  
        
        btnReset.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Score.resetScore();
                rightsTurn = true;
                tfRight.setText(String.valueOf(Score.getRightScore()));
                tfLeft.setText(String.valueOf(Score.getLeftScore()));
                resetCardImages(lblCardLeft,lblCardRight,lblCardDeck);
            }
        });
        
        BorderPane root = new BorderPane();
        GridPane topPane  = new GridPane();
        topPane.setHgap(20);
        topPane.setVgap(10);
        topPane.add(lblScore, 0, 0);
        topPane.add(lblLeft, 0, 1);
        topPane.add(tfLeft, 1, 1);
        topPane.add(lblRight, 2, 1);
        topPane.add(tfRight, 3, 1);
        GridPane cardPane  = new GridPane();
        cardPane.setHgap(20);
        topPane.setVgap(10);
        cardPane.add(lblCardLeft, 0, 0);
        cardPane.add(lblCardDeck, 1, 0);
        cardPane.add(lblCardRight, 2, 0);
        cardPane.setAlignment(Pos.CENTER);
        root.setTop(topPane);
        root.setCenter(cardPane);
        root.setBottom(btnReset);
        
        Scene scene = new Scene(root, 400, 250);
        primaryStage.setTitle("Assignment 9 - Simple Game of War");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public void resetCardImages(Label lblCardLeft, Label lblCardRight, Label lblCardDeck) 
    {   
        /*PlayingCard c1 = new PlayingCard();
        PlayingCard c2 = new PlayingCard();
        PlayingCard c3 = new PlayingCard();*/

        TarotCard c1 = new TarotCard("file:img\\maj_05.jpg");
        TarotCard c2 = new TarotCard("file:img\\maj_08.jpg");
        TarotCard c3 = new TarotCard("file:img\\maj_18.jpg");
        
        lblCardLeft.setGraphic(c1);
        lblCardRight.setGraphic(c2);
        lblCardDeck.setGraphic(c3);
        
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
