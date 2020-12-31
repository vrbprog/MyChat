package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Controller {

    final int LENGTH = 57;

    @FXML
    private Button buttonSend;

    @FXML
    private TextField textMessage;

    @FXML
    private FlowPane flowChat;

    @FXML
    private ScrollPane scrollMes;

    @FXML
    void addMessage(ActionEvent event) {


        TextArea area = new TextArea();
        area.setEditable(false);

//        area.setBorder(new Border(new BorderStroke(Color.BLACK,
//                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        //Setting number of pages
        area.setText(makeMes(textMessage.getText()));
        //area.setId("left-area");
        area.getStyleClass().add("left-area");
//        area.setStyle("-fx-control-inner-background: pink;" +
//                "-fx-font-size: 13");


        //area.setStyle("-fx-background-radius: 15");
        //area.setStyle("-fx-border-radius: 15");
        //area.setPrefColumnCount(15);
        area.setPrefHeight(22.0 * (1.0*textMessage.getText().length()/LENGTH + 5));
        area.setPrefWidth(358);

        FileInputStream input = null;
        try {
            input = new FileInputStream("src/img/blank-icon-48.png");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Image image = new Image(input);
        ImageView imageView = new ImageView(image);
        //imageView.getStyleClass().add("left-image");
        //imageView.setStyle("-fx-padding: 15px;" + "-fx-border-insets: 15px;" + "-fx-background-insets: 15px;");
        flowChat.getChildren().add(imageView);

        try {
            input = new FileInputStream("src/img/male-user-icon-48.png");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Image image2 = new Image(input);
        ImageView imageView2 = new ImageView(image2);
        flowChat.getChildren().add(imageView2);

        flowChat.getChildren().add(area);

        //flowChat.layout();
        scrollMes.setVvalue(1.0d);
    }

    public String makeMes(String line){
        StringBuilder builder = new StringBuilder(line);
        String time = "\t\t\t\t\t\t\t\t30-12-2020 11:45\n\r\n\r";
        String user = "\n\r\t\t\t\t\t\t\t\t\t\tAlex";
        int n = LENGTH-3;
        int num = 0;
        int numCur = 0;
        int delta = 0;
        int len = line.length();
        while((len - numCur) >= LENGTH) {
            do{
                numCur = num;
                num = builder.indexOf(" ", num + 1);
            }while (num < n - delta && num > numCur);
            delta = n - numCur;
            builder.insert(numCur, System.lineSeparator());
            n += LENGTH-5;
            len += 2;
        }
        return time + "      " + builder.toString() + user;
    }
}
