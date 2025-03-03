import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.KeyCode;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.stage.Stage;
import java.util.Random;
import javafx.animation.ScaleTransition;
import javafx.util.Duration;

/**
 * A class representing Jordle, a fun word game meant to mimic the online game Wordle.
 * @author Matthew Kistner.
 * GT ID 903677868.
 * @version 1.
 */
public class Jordle extends Application {
    public int boxNum;
    public int r;
    public Rectangle[][] rectArr = new Rectangle[6][5];
    public Label[][] chars = new Label[6][5];
    public String guess;
    public Text result = new Text("Type a Word!\n");
    public String answer;
    public CheckBox darkmode = new CheckBox("Dark Mode");
    public BorderPane bp = new BorderPane();

    @Override
    public void start(Stage primaryStage) {
        //Setting Title
        primaryStage.setTitle("Jordle");

        //Establishing "Main Pane" to hold Header and Buttons
        Text space = new Text("\n");
        space.setFont(Font.font("Georgia", 20));
        Text header = new Text("Jordle");
        header.setFont(Font.font("Georgia", FontWeight.BOLD, 70));
        header.setFill(Color.PINK);
        result.setFont(Font.font("Georgia", 30));
        result.setFill(Color.PINK);

        Button inst = new Button("Instructions");
        inst.setOnAction(new EventHandler<ActionEvent>() {
            //Anonymous Inner Class
            public void handle(ActionEvent clicked) {
                Alert instructions = new Alert(Alert.AlertType.INFORMATION,
                    "Guess a 5 Letter Word about Java/Programming!\n"
                    + "Type it in to the corresponding boxes and press enter.\n"
                    + "A grey box means the letter is not in the word,"
                    + " yellow means it is in the word but not that spot,"
                    + " and green means the letter is in the word at that spot.");
                instructions.showAndWait();
            }
        });

        Button reset = new Button("Restart");
        //Lamda Expression
        reset.setOnMousePressed((MouseEvent m) -> {
            newGame();
        });

        darkmode.setOnAction(handler);

        HBox buttons = new HBox(inst, reset, darkmode);
        buttons.setAlignment(Pos.CENTER);
        buttons.setSpacing(10);
        VBox top = new VBox(space, header, result, buttons);
        bp.setTop(top);
        top.setAlignment(Pos.CENTER);

        //A grid to hold the Guessing Blocks
        GridPane gp = new GridPane();
        bp.setCenter(gp);
        gp.setHgap(10);
        gp.setVgap(10);
        gp.setAlignment(Pos.CENTER);

        //Creates the Rectangles and Makes the Blocks
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 5; j++) {
                StackPane sp = new StackPane();
                rectArr[i][j] = new Rectangle(65, 65, Color.TRANSPARENT);
                rectArr[i][j].setStroke(Color.PINK);
                rectArr[i][j].setStrokeWidth(8);
                chars[i][j] = new Label();
                chars[i][j].setFont(Font.font("Georgia", 30));
                sp.getChildren().addAll(rectArr[i][j], chars[i][j]);
                gp.addRow(i, sp);
            }
        }

        generateWord();
        //Sets the Scene
        Scene scene = new Scene(bp, 600, 1200);

        //Lambda Class
        scene.setOnKeyPressed(event -> {
            if (event.getCode().isLetterKey() && (boxNum < 5) && (r < 6)) {
                chars[r][boxNum].setText(event.getText().toUpperCase());
                guess += event.getText();
                boxNum++;
            } else if (event.getCode().equals(KeyCode.ENTER) && boxNum < 5 && boxNum >= 0 && r <= 6) {
                Alert violation = new Alert(Alert.AlertType.INFORMATION, "You must type a 5 letter word!\nTry again!");
                violation.showAndWait();
            } else if (event.getCode().equals(KeyCode.ENTER) && boxNum == 5 && r <= 6) {
                enter(answer);
            } else if (event.getCode().equals(KeyCode.BACK_SPACE) && boxNum >= 1 && boxNum <= 5 && r <= 6) {
                backspace();
            }
        });

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * A method that deletes the typed text, allowing
     * the square to be typed in again.
     */
    public void backspace() {
        --boxNum;
        chars[r][boxNum].setText("");
        guess = guess.substring(0, boxNum);
    }

    /**
     * A method that evaluates the typed word and either allows more typing, if the guess is wrong,
     * or stops allowing typing, if the guess is right.
     * @param a String respresenting the correct answer.
     */
    public void enter(String a) {
        if (!evaluateWord(guess, a)) {
            boxNum = 0;
            guess = "";
            r++;
        } else {
            boxNum = 6;
        }
    }

    /**
     * A method that starts a new game and resets the boxes.
     */
    public void newGame() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 5; j++) {
                rectArr[i][j].setFill(Color.TRANSPARENT);
                chars[i][j].setText("");
            }
        }
        boxNum = 0;
        r = 0;
        guess = "";
        generateWord();
        result.setText("Type a Word!\n");
    }

    /**
     * A method that generates a new answer for a puzzle.
     */
    public void generateWord() {
        Random rand = new Random();
        answer = Words.list.get(rand.nextInt(Words.list.size()));
    }

    EventHandler<ActionEvent> handler = e -> {
        if (darkmode.isSelected()) {
            bp.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 5; j++) {
                    chars[i][j].setTextFill(Color.PINK);
                }
            }
        } else {
            bp.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 5; j++) {
                    chars[i][j].setTextFill(Color.BLACK);
                }
            }
        }
    };

    /**
     * A method that evaluates the guess and changes the colors of the boxes based on letters.
     * @param word String representing the guess.
     * @param correct String representing the answer.
     * @return boolean indicating if the guess is correct.
     */
    public boolean evaluateWord(String word, String correct) {
        word = word.toLowerCase();
        if (word.contains("null")) {
            word = word.substring(4);
        }
        for (int i = 0; i < 5; i++) {
            Character c = word.charAt(i);
            if (answer.charAt(i) == word.charAt(i)) {
                rectArr[r][i].setFill(Color.GREEN);
            } else if (correct.contains(c.toString())) {
                rectArr[r][i].setFill(Color.YELLOW);
            } else {
                rectArr[r][i].setFill(Color.GRAY);
            }
        }
        if (word.equals(correct)) {
            winningAnimation();
            result.setText("You Win!\n");
            return true;
        } else if (r == 5) {
            result.setText("The word was " + answer.toUpperCase() + ".\n");
            return false;
        }
        return false;
    }

    /**
     * A method that enlarges the squares on the row of the correctly guessed word.
     */
    public void winningAnimation() {
        for (int c = 0; c < 5; c++) {
            ScaleTransition enlarge = new ScaleTransition(Duration.seconds(1), rectArr[r][c]);
            enlarge.setByX(0.1f);
            enlarge.setByY(0.1f);
            enlarge.setCycleCount(2);
            enlarge.setAutoReverse(true);
            enlarge.play();
        }
    }

    /**
     * A main method.
     * @param args standard parameter.
     */
    public static void main(String[] args) {
        launch(args);
    }
}