package main.views;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import main.controllers.ItemController;

public class SellerView extends Application {
	private Button uploadbutton;
	private TextField namaItem, categoryItem,ukuranItem, hargaItem;
	private Button submit;
	private Label inameLabel, iCategoriesLabel, iSizeLabel, iPriceLabel;
	private String ItemName, ItemCategory;
	private Integer itemPrice, itemSize;
	private ItemController controller;

	
	public void uploadView(Stage primaryStage) {
		primaryStage.setTitle("Upload Item");
		VBox root = new VBox(15);
		root.setPadding(new Insets(10));
		
		TextField namaItem = new TextField();
		TextField categoryItem = new TextField();
		TextField ukuranItem = new TextField();
		TextField hargaItem = new TextField();
		namaItem.setPromptText("Masukkan nama item");
		categoryItem.setPromptText("Masukkan kategori item");
		ukuranItem.setPromptText("Masukkan ukuran item");
		hargaItem.setPromptText("Masukkan harga item");

		Button uploadButton = new Button("Upload Item");
		
		uploadButton.setOnAction(e ->{
			FileChooser pilihfile = new FileChooser();
			pilihfile.setTitle("Pilih Item yang ingin di Upload");
			pilihfile.getExtensionFilters().addAll(
						new FileChooser.ExtensionFilter("Image files", "*.jpg"),
						new FileChooser.ExtensionFilter("Image files", "*.png")
					);
			var fileTerpilih = pilihfile.showOpenDialog(primaryStage);
			if(fileTerpilih != null) {
				String filepath = fileTerpilih.getAbsolutePath();
				System.out.println("File Path : " +filepath);
			}else {
				System.out.println("No File Selected");
			}
			
		});
		
		Scene scene = new Scene(root, 400, 200);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	
		
	public void EditView(Stage primaryStage) {
		primaryStage.setTitle("Edit Item");
		VBox root = new VBox(15);
		root.setPadding(new Insets(10));
		
		TextField namaItem = new TextField();
		TextField categoryItem = new TextField();
		TextField ukuranItem = new TextField();
		TextField hargaItem = new TextField();
		namaItem.setPromptText("Masukkan nama item");
		categoryItem.setPromptText("Masukkan kategori item");
		ukuranItem.setPromptText("Masukkan ukuran item");
		hargaItem.setPromptText("Masukkan harga item");

		Button uploadButton = new Button("Edit Item");
		
		uploadButton.setOnAction(e ->{
			FileChooser pilihfile = new FileChooser();
			pilihfile.setTitle("Pilih Item yang ingin di Upload");
			pilihfile.getExtensionFilters().addAll(
						new FileChooser.ExtensionFilter("Image files", "*.jpg"),
						new FileChooser.ExtensionFilter("Image files", "*.png")
					);
			var fileTerpilih = pilihfile.showOpenDialog(primaryStage);
			if(fileTerpilih != null) {
				String filepath = fileTerpilih.getAbsolutePath();
				System.out.println("File Path : " +filepath);
			}else {
				System.out.println("No File Selected");
			}
			
		});
		
		Scene scene = new Scene(root, 400, 200);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public void ViewItem(Stage primaryStage) {
		TextField namaItem = new TextField();
		namaItem.setDisable(true);
		TextField categoryItem = new TextField();
		categoryItem.setDisable(true);
		TextField ukuranItem = new TextField();
		ukuranItem.setDisable(true);
		TextField hargaItem = new TextField();
		hargaItem.setDisable(true);
	}
	
	
	public void submitItem() {

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
