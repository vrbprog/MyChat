package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class Controller {

    @FXML
    private Button buttonSend;

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
        area.setText("String.valueOf(scrollMes.getVvalue())");
        area.setStyle("-fx-control-inner-background: pink;" +
                "-fx-font-size: 16");


        //area.setStyle("-fx-background-radius: 15");
        //area.setStyle("-fx-border-radius: 15");
        //area.setPrefColumnCount(15);
        area.setPrefHeight(50);
        area.setPrefWidth(240);

        flowChat.getChildren().add(area);

        //flowChat.layout();
        scrollMes.setVvalue(1.0d);



    }

}
