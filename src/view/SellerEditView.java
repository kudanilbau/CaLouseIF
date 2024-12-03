package view;

import java.io.File;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class SellerEditView {
	private VBox mainVBox;
	private TextField namaItem, categoryItem, ukuranItem, hargaItem;
	private Button uploadButton, submitButton;
	private FileChooser pilihFile;

	public SellerEditView() {
		initComponent();
		addComponent();
		styleComponent();
		initActionComponent();
	}

	public void initComponent() {
		mainVBox = new VBox(15);
		namaItem = new TextField();
		categoryItem = new TextField();
		ukuranItem = new TextField();
		hargaItem = new TextField();

		namaItem.setPromptText("Masukkan nama item");
		categoryItem.setPromptText("Masukkan kategori item");
		ukuranItem.setPromptText("Masukkan ukuran item");
		hargaItem.setPromptText("Masukkan harga item");

		uploadButton = new Button("Upload Image");
		submitButton = new Button("Submit");

		pilihFile = new FileChooser();
	}

	public void addComponent() {
		mainVBox.getChildren().addAll(namaItem, categoryItem, ukuranItem, hargaItem, uploadButton, submitButton);
	}

	public void styleComponent() {
		mainVBox.setPadding(new Insets(10));
	}

	public void initActionComponent() {
		uploadButton.setOnAction(e -> {
			Stage primaryStage = (Stage) ((Node) e.getSource()).getScene().getWindow();
			pilihFile.setTitle("Pilih gambar yang ingin di Upload");

			pilihFile.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Image files", "*.jpg"),
					new FileChooser.ExtensionFilter("Image files", "*.png"));
			File fileTerpilih = pilihFile.showOpenDialog(primaryStage);
			if (fileTerpilih != null) {
				String filepath = fileTerpilih.getAbsolutePath();
				System.out.println("File Path : " + filepath);
			} else {
				System.err.println("No File Selected");
			}
		});

		submitButton.setOnAction(e -> {

		});
	}

	public Node asNode() {
		return mainVBox;
	}
}
