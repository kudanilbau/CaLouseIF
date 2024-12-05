package view;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class SellerEditView extends VBox{
	private TextField idItem, namaItem, categoryItem, ukuranItem, hargaItem;
	private Button submitButton;

	public SellerEditView() {
		super();
		initComponent();
		addComponent();
		styleComponent();
		initActionComponent();
	}

	public void initComponent() {
		
		idItem = new TextField();
		namaItem = new TextField();
		categoryItem = new TextField();
		ukuranItem = new TextField();
		hargaItem = new TextField();

		idItem.setPromptText("Id item");
		namaItem.setPromptText("Masukkan nama item");
		categoryItem.setPromptText("Masukkan kategori item");
		ukuranItem.setPromptText("Masukkan ukuran item");
		hargaItem.setPromptText("Masukkan harga item");

		submitButton = new Button("Submit");
	}

	public void addComponent() {
		this.getChildren().addAll(idItem, namaItem, categoryItem, ukuranItem, hargaItem, submitButton);
	}

	public void styleComponent() {
		this.setSpacing(15);
		this.setPadding(new Insets(10));
		idItem.setDisable(true);
	}

	public void initActionComponent() {
		submitButton.setOnAction(e -> {

		});
	}

	public Node asNode() {
		return this;
	}
}
