package ui;

import com.jfoenix.controls.JFXButton;

import core.Logger;
import function.InterfaceFunction;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import main.Current;

public class LoginPane 
{
	private Stage stage;
	
    @FXML
    private TextField txtfield_id;

    @FXML
    private PasswordField txtfield_pw;

    @FXML
    private JFXButton btn_login;
    
    @FXML
    private Label label_fail;

    
    public void initialize(Stage stage)
    {
    	this.stage = stage;
    	this.btn_login.setOnMouseClicked(e -> onLoginClicked());
    }
    private void onLoginClicked()
    {
    	String id = txtfield_id.getText();
    	String pw = txtfield_pw.getText();
    	Logger logger = new Logger(id, pw);
    	logger.run();
    	if(logger.isResult())
    	{
    		Current.data = logger.getData();
    		Current.isLoggedin = true;
    		InterfaceFunction.refresh(Current.mainStage);
    		String[][][] arr = Current.data.getTimetable();
    		for(int a=0;a<arr.length;a++)
    		{
    			for(int b=0;b<arr[a].length;b++)
    			{
    				for(int c=0;c<arr[a][b].length;c++)
    				{
    					System.out.println(arr[a][b][c]);
    				}
    			}
    		}
    		stage.close();
    	}
    	else
    		this.label_fail.setVisible(true);
    }
}
