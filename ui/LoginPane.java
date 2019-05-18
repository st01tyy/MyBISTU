package ui;

import com.jfoenix.controls.JFXButton;
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
    
    public void initialize()
    {
    	this.btn_login.setOnMouseClicked(e -> onLoginClicked());
    }
    
    private void onLoginClicked()
    {
    	
    }
}
