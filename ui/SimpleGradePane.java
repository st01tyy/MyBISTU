package ui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class SimpleGradePane 
{
	@FXML
	private VBox vbox;
    @FXML
    private Label label_down;

    @FXML
    private Label label_up;
    
    public void initialize(String strUp, String strDown)
    {
    	this.label_up.setText(strUp);
    	this.label_down.setText(strDown);
    	this.vbox.setStyle("-fx-background-image: url('/picture/1.jpg')");
    	this.vbox.setPrefSize(400, 100);
    }
}
