package ui;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.fxml.FXML;

public class GradePane 
{

	@FXML
	private ScrollPane scrollpane;
	
    @FXML
    private GridPane gridpane;
    
    public void initialize(String[][] list)
	{
		for(int a=0;a<list.length;a++)
		{
			FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/single_grade.fxml"));
			String[] temp = list[a];
			String up = temp[0];
			StringBuffer str = new StringBuffer("");
			str.append("绩点：");
			str.append(temp[1]+" ");
			str.append("成绩：");
			str.append(temp[2]+" ");
			str.append("学分：");
			str.append(temp[3]);
			String down = str.toString();
			VBox mainPane = null;
			try {
				mainPane = loader.load();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			SimpleGradePane controller = loader.getController();
			System.out.println(up+" "+down);
			controller.initialize(up, down);
			gridpane.add(mainPane, 0, a);
		}
		gridpane.setPrefSize(400, list.length*110);
		this.scrollpane.setPrefSize(400, 600);
	}
}