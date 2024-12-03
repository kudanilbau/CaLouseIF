package view;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class SellerUploadView {
	private VBox mainVBox;
	private TextField namaItem, categoryItem, ukuranItem, hargaItem;
	private Button submitButton;

	public SellerUploadView() {
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

		submitButton = new Button("Submit");
	}

	public void addComponent() {
		mainVBox.getChildren().addAll(namaItem, categoryItem, ukuranItem, hargaItem, submitButton);
	}

	public void styleComponent() {
		mainVBox.setPadding(new Insets(10));
	}

	public void initActionComponent() {
		submitButton.setOnAction(e -> {

		});
	}

	public Node asNode() {
		return mainVBox;
	}
}
