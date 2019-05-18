package ui;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXSpinner;

import core.Logger;
import function.DataFunction;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginPane 
{
    @FXML
    private TextField txtfield_id;

    @FXML
    private PasswordField txtfield_pw;

    @FXML
    private JFXButton btn_login;
    
    @FXML
    private JFXSpinner spinner;

    @FXML
    void d32525(ActionEvent event) {

    }

    
    public void initialize()
    {
    	this.btn_login.setOnMouseClicked(e -> onLoginClicked());
    }
    
    private void onLoginClicked()
    {
    	this.spinner.setVisible(true);
    	String id = txtfield_id.getText();
    	String pw = txtfield_pw.getText();
    	Logger logger = new Logger(id, pw);
    	Thread th = new Thread(logger);
    	
    	th.start();
    	try {
			th.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	this.spinner.setVisible(false);
    }
}
