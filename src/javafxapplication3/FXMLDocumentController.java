/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication3;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import java.io.*;
import javafx.stage.FileChooser;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.Desktop;
import javafx.scene.control.TextField;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Window;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.util.Iterator;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.CheckBox;
import javafx.beans.value.ObservableValue;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent; 
import org.openqa.selenium.By;  
import org.openqa.selenium.WebDriver;   
import org.openqa.selenium.firefox.FirefoxDriver; 

/**
 *
 * @author Nilu-PC
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    @FXML
    private TextField uploadtext;
    private final Desktop desktop = Desktop.getDesktop();
    private Window stage;
    @FXML private TableView<Amazon> tableView;
    @FXML private TableColumn<Amazon, String> Status;
    @FXML private TableColumn<Amazon, String> Originurl;
    @FXML private TableColumn<Amazon, String> Desturl;
    ObservableList<Amazon> data;

    
    
    @FXML
    private void uploadButtonAction(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Excel file", "*.xlsx","*.xls");
        fileChooser.getExtensionFilters().add(extFilter);
        File file = fileChooser.showOpenDialog(stage);
        if (file != null) {
            uploadtext.setText(file.getAbsolutePath());
        }
    }
    
    @FXML
    private void processButtonAction(ActionEvent event) throws AWTException,InterruptedException ,IOException {
           WebDriver driver = new FirefoxDriver();  
           driver.get("http://spreadsheetpage.com/index.php/file/C35/P10/"); // sample url  
           driver.findElement(By.xpath(".//a[@href=contains(text(),'yearly-calendar.xls')]")).click();  
           Robot robot = new Robot();  // Robot class throws AWT Exception  
           Thread.sleep(2000); // Thread.sleep throws InterruptedException  
           robot.keyPress(KeyEvent.VK_DOWN);  // press arrow down key of keyboard to navigate and select Save radio button  
            
           Thread.sleep(2000);  // sleep has only been used to showcase each event separately   
           robot.keyPress(KeyEvent.VK_TAB); 
           Thread.sleep(2000);  
           robot.keyPress(KeyEvent.VK_TAB); 
           Thread.sleep(2000);  
           robot.keyPress(KeyEvent.VK_TAB); 
           Thread.sleep(2000);  
           robot.keyPress(KeyEvent.VK_ENTER);   
        //readXLSXFile();
        //System.out.println(uploadtext.getText());
    }
    
    public static void readXLSXFile() throws IOException
    {
                
		InputStream ExcelFileToRead;
                ExcelFileToRead = new FileInputStream("C:\\Users\\IBM_ADMIN\\Desktop\\reimbursement.xlsx");
		XSSFWorkbook  wb = new XSSFWorkbook(ExcelFileToRead);
                System.out.println(wb);
		
		XSSFWorkbook test = new XSSFWorkbook(); 
		
		XSSFSheet sheet = wb.getSheetAt(0);
		XSSFRow row; 
		XSSFCell cell;

		Iterator rows = sheet.rowIterator();
                ObservableList<ObservableList> csvData = FXCollections.observableArrayList(); 
		while (rows.hasNext())
		{
                     ObservableList<String> amzrow = FXCollections.observableArrayList();
			row=(XSSFRow) rows.next();
			Iterator cells = row.cellIterator();
			while (cells.hasNext())
			{
				cell=(XSSFCell) cells.next();
                                
				if (cell.getCellType() == XSSFCell.CELL_TYPE_STRING)
				{
                                    amzrow.add(cell.getStringCellValue()); 
					//System.out.print(cell.getStringCellValue()+" ");
				}
				else if(cell.getCellType() == XSSFCell.CELL_TYPE_NUMERIC)
				{
                                        //amzrow.add(cell.getNumericCellValue()); 
					//System.out.print(cell.getNumericCellValue()+" ");
				}
				else
				{
					//U Can Handel Boolean, Formula, Errors
				}
			}
			csvData.add(amzrow);
		}
                //tableview.getItems().add(csvData);
	
	}
    
    
    

         
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Status.setCellValueFactory(
            new PropertyValueFactory<>("status")
        );
        Originurl.setCellValueFactory(
            new PropertyValueFactory<>("oriurl")
        );
        Desturl.setCellValueFactory(
            new PropertyValueFactory<>("desturl")
        );
    }    
    
}
