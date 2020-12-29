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
        area.setText(textMessage.getText());
        //area.setId("left-area");
        area.getStyleClass().add("left-area");
//        area.setStyle("-fx-control-inner-background: pink;" +
//                "-fx-font-size: 13");


        //area.setStyle("-fx-background-radius: 15");
        //area.setStyle("-fx-border-radius: 15");
        //area.setPrefColumnCount(15);
        area.setPrefHeight(30.0 * textMessage.getText().length()/25);
        area.setPrefWidth(240);

        FileInputStream input = null;
        try {
            input = new FileInputStream("src/img/admin-user-icon-48.png");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Image image = new Image(input);
        ImageView imageView = new ImageView(image);
        //imageView.getStyleClass().add("left-image");
        //imageView.setStyle("-fx-padding: 15px;" + "-fx-border-insets: 15px;" + "-fx-background-insets: 15px;");
        flowChat.getChildren().add(imageView);

        flowChat.getChildren().add(area);

        //flowChat.layout();
        scrollMes.setVvalue(1.0d);



    }

}
