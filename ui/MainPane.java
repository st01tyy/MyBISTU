package ui;

import java.io.IOException;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
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
    	this.btn_schedule.setStyle("-fx-background-image: url('/picture/timetable.png')");
    	this.btn_exam.setStyle("-fx-background-image: url('/picture/test.png')");
    	this.btn_switchAc.setOnMouseClicked(e -> this.onSwitchClicked());
    	this.btn_grade.setOnMouseClicked(e -> this.onGradeClicked());
    }
    
    private void onGradeClicked()
    {
    	Stage stage = new Stage();
    	FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/grade.fxml"));
    	ScrollPane pane = null;
		try {
			pane = loader.load();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	GradePane controller = loader.getController();
    	controller.initialize(Current.data.getGrade());
    	//GradePane pane = new GradePane(Current.data.getGrade());
    	stage.setScene(new Scene(pane, pane.getPrefWidth(), pane.getPrefHeight()));
    	stage.setTitle("³É¼¨");
    	stage.show();
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
    	controller.initialize(stage);
    	stage.setScene(new Scene(mainPane, mainPane.getPrefWidth(), mainPane.getPrefHeight()));
    	stage.setTitle("µÇÂ¼");
    	stage.show();
    	
    }
}
