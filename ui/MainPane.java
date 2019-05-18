package ui;

import java.io.IOException;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import main.Current;

public class MainPane 
{
    @FXML
    private JFXButton btn_grade;

    @FXML
    private JFXButton btn_schedule;

    @FXML
    private JFXButton btn_exam;

    @FXML
    private JFXButton btn_switchAc;

    @FXML
    private Label label_id;
    
    public void initialize()
    {
    	if(!Current.isLoggedin)
    	{
    		this.btn_exam.disarm();
    		this.btn_grade.disarm();
    		this.btn_schedule.disarm();
    		this.label_id.setText("Î´µÇÂ¼");
    	}
    	else
    	{
    		this.label_id.setText(Current.data.getUser_token()[0]);
    	}
    	this.btn_switchAc.setStyle("-fx-background-image: url('/picture/setting.png')");
    	this.btn_grade.setStyle("-fx-background-image: url('/picture/score.png')");
    	if(!Current.isLoggedin)
    		
    	this.btn_schedule.setStyle("-fx-background-image: url('/picture/timetable.png')");
    	if(!Current.isLoggedin)
    		
    	this.btn_exam.setStyle("-fx-background-image: url('/picture/test.png')");
    	if(!Current.isLoggedin)
    		
    	this.btn_switchAc.setOnMouseClicked(e -> this.onSwitchClicked());
    }
    
    private void onGradeClicked()
    {
    	
    }
    private void onScheduleClicked()
    {
    	
    }
    private void onExamClicked()
    {
    	
    }
    private void onSwitchClicked()
    {
    	Stage stage = new Stage();
    	FXMLLoader fxml_loader = new FXMLLoader(this.getClass().getResource("/fxml/login.fxml"));
    	Pane mainPane = null;
		try {
			mainPane = fxml_loader.load();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	LoginPane controller = fxml_loader.getController();
    	controller.initialize();
    	stage.setScene(new Scene(mainPane, mainPane.getPrefWidth(), mainPane.getPrefHeight()));
    	stage.setTitle("µÇÂ¼");
    	stage.show();
    }
}
