import javafx.animation.*;
import javafx.application.Application;
import javafx.geometry.*;
import javafx.geometry.Insets;
import javafx.scene.GroupBuilder;
import javafx.scene.Scene;
import javafx.scene.SceneBuilder;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.*;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.layout.HBox;
import javafx.util.Duration;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;
import static javafx.scene.text.TextBuilder.*;

/**
 * Copyright by Dariush Daneshvar
 *
 * Credits:
 * Dariush Daneshvar
 *
 */

public class Main extends Application {

    Stage window;
    Scene menu,scene1,scene2,scene3,scene4,about;

    public static void main(String[] args) {
        launch(args);

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("QuikSilver");
        window.setResizable(false);
        window.setHeight(300);
        window.setWidth(600);

        //menu
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(12);

        HBox hbButtons = new HBox();
        hbButtons.setSpacing(10.0);

        Button b1 = new Button("Enter Departure Velocity");
        Button b2 = new Button("Exit Departure Velocity");
        Button b3 = new Button("Hohmann Transfer Velocity");
        Button b4 = new Button("Hohmann Transfer Time");
        Button b5 = new Button("About");

        //title
        Label title = new Label("Welcome, enter mode");

        hbButtons.getChildren().addAll(b1, b2, b3);
        grid.add(title,0, 1);
        grid.add(b4,0,5);
        grid.add(b5,2,5);
        grid.add(hbButtons, 0, 3, 3, 1);
        grid.setAlignment(Pos.CENTER);
        menu = new Scene(grid,300,300);

        //Scene 1
        b1.setOnAction(e -> window.setScene(scene1));
        GridPane grid2 = new GridPane();
        grid2.setHgap(0);
        grid2.setVgap(5);
        grid.setPadding(new Insets(10,10,10,10));
        scene1 = new Scene(grid2,300,300);

        //Logo
        final ImageView selectedImage = new ImageView();
        Image image1 = new Image(Main.class.getResourceAsStream("logo.jpg"));

        selectedImage.setImage(image1);
        selectedImage.setFitWidth(100);
        selectedImage.setPreserveRatio(true);
        selectedImage.setSmooth(true);
        selectedImage.setCache(true);

        grid.getChildren().addAll(selectedImage);

        //title
        Label t1 = new Label("Calculating Departure Periapse Velocity");
        t1.setTextFill(Color.web("#0076a3"));
        t1.setStyle("-fx-font: 16 arial;");
        GridPane.setConstraints(t1,0,0);

        //Input mole val
        Label inputMole = new Label("Enter energy in 1 mole");
        inputMole.setStyle("-fx-font: 12 arial;");
        //inputMole.setTextFill(Color.web("#66ffff"));
        GridPane.setConstraints(inputMole,0,5);
        TextField mole = new TextField ();
        GridPane.setConstraints(mole,0,6);

        //Input Earth grav radius
        Label inputRadius = new Label("Enter gravitational field of earth radius");
        inputRadius.setStyle("-fx-font: 12 arial;");
        //inputRadius.setTextFill(Color.web("#FF0000"));
        GridPane.setConstraints(inputRadius,0,8);
        TextField radius = new TextField ();
        GridPane.setConstraints(radius,0,9);

        //empty label for output
        Label result = new Label("");
        GridPane.setConstraints(result,0,12);

        //Enter
        Button enter = new Button("Enter");
        GridPane.setConstraints(enter,0,11);
        enter.setOnAction(event -> {
            try {
                double m = Double.parseDouble(mole.getText());
                double r = Double.parseDouble(radius.getText());
                double calc1 = m/r;
                double calc2 = Math.sqrt(calc1);
                result.setText("Velocity needed " + Double.toString(calc2));
            } catch (NumberFormatException e) {
                result.setText("Enter a decimal or an integer");
            }
        });

        //Back to menu
        Button backM = new Button("Menu");
        GridPane.setConstraints(backM,0,13);
        backM.setOnAction(e-> window.setScene(menu));
        grid2.getChildren().addAll(inputMole, inputRadius, mole, radius, enter, result,backM,t1);

        //Scene 2

        b2.setOnAction(e-> window.setScene(scene2));
        GridPane grid3 = new GridPane();
        grid3.setHgap(0);
        grid3.setVgap(5);
        grid3.setPadding(new Insets(10,10,10,10));
        scene2 = new Scene(grid3,300,300);

        //Title
        Label t2 = new Label("Calculating Velocity to exit Departure Prolapse");
        t2.setTextFill(Color.web("#0076a3"));
        t2.setStyle("-fx-font: 16 arial;");
        GridPane.setConstraints(t2,0,0);

        //Input
        Label sGP = new Label("Gravitational Parameter");
        sGP.setStyle("-fx-font: 12 arial;");
        //sGP.setTextFill(Color.web("#FF0000"));
        GridPane.setConstraints(sGP,0,1);
        TextField grav = new TextField ();
        GridPane.setConstraints(grav,0,2);

        //Standard gravitational Parameter
        Label inputRadius2 = new Label("Enter gravitational field of earth radius");
        inputRadius2.setStyle("-fx-font: 12 arial;");
        //inputRadius2.setTextFill(Color.web("#FF0000"));
        GridPane.setConstraints(inputRadius2,0,3);
        TextField radius2 = new TextField ();
        GridPane.setConstraints(radius2,0,4);

        Label acc = new Label("Acceleration");
        acc.setStyle("-fx-font: 12 arial;");
        //acc.setTextFill(Color.web("#FF0000"));
        GridPane.setConstraints(acc,0,5);
        TextField accl = new TextField ();
        GridPane.setConstraints(accl,0,6);

        //empty label for output
        Label result2 = new Label("");
        GridPane.setConstraints(result2,0,8);

        //Enter
        Button enter2 = new Button("Enter");
        GridPane.setConstraints(enter2,0,7);
        enter2.setOnAction(event -> {
            try {
                double a = Double.parseDouble(accl.getText());
                double r = Double.parseDouble(radius2.getText());
                double g = Double.parseDouble(grav.getText());
                double calc1 = ((2*g)/r);
                double calc2 =  calc1-((g)/a);
                double calc3 = Math.sqrt(calc2);
                result2.setText("Velocity needed " + Double.toString(calc3));
            } catch (NumberFormatException e) {
                result2.setText("Enter a decimal or an integer");
            }
        });

        //Back to menu
        Button backM2 = new Button("Menu");
        GridPane.setConstraints(backM2,0,10);

        backM2.setOnAction(e-> window.setScene(menu));

        grid3.getChildren().addAll(grav, inputRadius2, radius2, acc,accl, enter2, result2,backM2,t2,sGP);

        //Scene 3

        b3.setOnAction(e-> window.setScene(scene3));

        GridPane grid4 = new GridPane();
        grid4.setHgap(0);
        grid4.setVgap(5);
        grid4.setPadding(new Insets(10,10,10,10));
        scene3 = new Scene(grid4,300,300);

        //Title
        Label t3 = new Label("Hohmann Transfer Velocity");
        t3.setTextFill(Color.web("#0076a3"));
        t3.setStyle("-fx-font: 16 arial;");
        GridPane.setConstraints(t3,0,0);

        //Input
        Label acc3 = new Label("Acceleration");
        acc3.setStyle("-fx-font: 12 arial;");
        //acc3.setTextFill(Color.web("#FF0000"));
        GridPane.setConstraints(acc3,0,1);
        TextField acce = new TextField ();
        GridPane.setConstraints(acce,0,2);

        //Standard gravitational Parameter
        Label inputRadius3 = new Label("Standard Gravitational Parameter");
        inputRadius3.setStyle("-fx-font: 12 arial;");
        //inputRadius3.setTextFill(Color.web("#FF0000"));
        GridPane.setConstraints(inputRadius3,0,3);
        TextField radius3 = new TextField ();
        GridPane.setConstraints(radius3,0,4);

        //empty label for output
        Label result3 = new Label("");
        GridPane.setConstraints(result3,0,8);

        //Enter
        Button enter3 = new Button("Enter");
        GridPane.setConstraints(enter3,0,7);
        enter3.setOnAction(event -> {
            try {
                double a = Double.parseDouble(acce.getText());
                double r = Double.parseDouble(radius3.getText());
                double calc1 = a*a*a;
                double calc2 =  calc1-r;
                double calc3 = Math.sqrt(calc2);
                double calc4 = Math.PI*calc3;
                result3.setText("Hohmann Transfer rate: " + Double.toString(calc4));
            } catch (NumberFormatException e) {
                result3.setText("Enter a decimal or an integer");
            }
        });

        //Back to menu
        Button backM3 = new Button("Menu");
        GridPane.setConstraints(backM3,0,10);
        backM3.setOnAction(e-> window.setScene(menu));
        grid4.getChildren().addAll(t3,acc3,acce,inputRadius3,radius3,result3,enter3,backM3);

        //Scene 4

        b4.setOnAction(e -> window.setScene(scene4));

        GridPane grid5 = new GridPane();
        grid5.setHgap(0);
        grid5.setVgap(5);
        grid5.setPadding(new Insets(10,10,10,10));
        scene4 = new Scene(grid5,300,300);

        //Title
        Label t4 = new Label("Hohmann Transfer Time");
        t4.setTextFill(Color.web("#0076a3"));
        t4.setStyle("-fx-font: 16 arial;");
        GridPane.setConstraints(t4,0,0);

        //Input
        Label acc4 = new Label("Acceleration");
        acc4.setStyle("-fx-font: 12 arial;");
        //acc4.setTextFill(Color.web("#FF0000"));
        GridPane.setConstraints(acc4,0,1);
        TextField acce2 = new TextField ();
        GridPane.setConstraints(acce2,0,2);

        //Standard gravitational Parameter
        Label inputRadius4 = new Label("Standard Gravitational Parameter");
        inputRadius4.setStyle("-fx-font: 12 arial;");
        //inputRadius4.setTextFill(Color.web("#FF0000"));
        GridPane.setConstraints(inputRadius4,0,3);
        TextField radius4 = new TextField ();
        GridPane.setConstraints(radius4,0,4);

        //empty label for output
        Label result4 = new Label("");
        GridPane.setConstraints(result4,0,8);

        //Enter
        Button enter4 = new Button("Enter");
        GridPane.setConstraints(enter4,0,7);
        enter4.setOnAction(event -> {
            try {
                double a = Double.parseDouble(acce2.getText());
                double r = Double.parseDouble(radius4.getText());
                double calc1 = a*a*a;
                double calc2 =  calc1/r;
                double calc3 = Math.sqrt(calc2);
                double calc4 = Math.PI*calc3;
                result4.setText("Hohmann Transfer time: " + Double.toString(calc4) + " hours");
            } catch (NumberFormatException e) {
                result4.setText("Enter a decimal or an integer");
            }
        });

        //Back to menu
        Button backM4 = new Button("Menu");
        GridPane.setConstraints(backM4,0,10);
        backM4.setOnAction(e-> window.setScene(menu));
        grid5.getChildren().addAll(t4,acc4,acce2,inputRadius4,radius4,result4,enter4,backM4);

        //About page with animation

        String message =
                "\nCode Team: \n" +
                        "Dariush Daneshvar \n"  +
                        "Jakub Koziol \n" +
                        "Cece Stewart \n\n" +
                        "©Quiksilver 2016-3000 \n" +
                        "All rights reserved\n" +
                        "\nClick anywhere to return to menu";


        // Reference to the Text
        Text textRef = create()
                .layoutY(100)
                .textOrigin(VPos.TOP)
                .textAlignment(TextAlignment.JUSTIFY)
                .wrappingWidth(400)
                .text(message)
                .fill(Color.web("#33ccff"))
                .font(Font.font("SansSerif", FontWeight.BOLD, 24))
                .build();

        // Provides the animated scrolling behavior for the text
        TranslateTransition transTransition = TranslateTransitionBuilder.create()
                .duration(new Duration(11000))
                .node(textRef)
                .toY(-230)
                .interpolator(Interpolator.LINEAR)
                .cycleCount(Timeline.INDEFINITE)
                .build();
        about = SceneBuilder.create()
                .width(700)
                .height(300)
                .root(
                        GroupBuilder.create()
                                .children(
                                        ScrollPaneBuilder.create()
                                                .layoutX(80)
                                                .layoutY(50)
                                                .prefWidth(440)
                                                .prefHeight(150)
                                                .hbarPolicy(ScrollPane.ScrollBarPolicy.NEVER)
                                                .vbarPolicy(ScrollPane.ScrollBarPolicy.NEVER)
                                                .pannable(true)
                                                .content(textRef)
                                                .build()
                                )
                                .build()
                )
                .build();
        // change here to your path
        String musicFile = "src/music_credits.mp3";

        Media sound = new Media(new File(musicFile).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);


        b5.setOnAction(e->{
            window.setScene(about);
            transTransition.play();
            mediaPlayer.play();
        });


        about.setOnMousePressed(event -> {
            window.setScene(menu);
            mediaPlayer.stop();
            transTransition.pause();
        });




        //Program theme
        menu.getStylesheets().add("theme");
        scene1.getStylesheets().add("theme");
        scene2.getStylesheets().add("theme");
        scene3.getStylesheets().add("theme");
        scene4.getStylesheets().add("theme");

        //Show window
        window.setScene(menu);
        window.show();
    }
}

