package view;

import controller.RegisterController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;

public class RegisterView extends HBox{
	private VBox imageVBox, contentVBox, formVBox;
	private HBox dividerHBox, loginAccountHBox, roleHBox;
	private Label titleLabel, subTitleLabel, usernameLabel, passwordLabel, phoneNumberLabel, addressLabel, roleLabel,
			orLabel, createAccountLabel, errorMessageLabel;
	private TextField usernameTextField, phoneNumberTextField, addressTextField;
	private PasswordField passwordPasswordField;
	private Button registerButton;
	private Hyperlink loginHyperLink;
	private Line line1, line2;
	private ToggleGroup roleToggleGroup;
	private RadioButton buyerRadioButton, sellerRadioButton;

	private RegisterController controller;

	public RegisterView(RegisterController controller) {
		super();
		this.controller = controller;
		initComponent();
		addComponent();
		styleComponent();
		initActionComponent();
	}

	private void initActionComponent() {
		registerButton.setOnMouseClicked(e -> {
			if (e.getButton() == MouseButton.PRIMARY) {
				try {
					String role = "";
					try {
						role = ((RadioButton) roleToggleGroup.getSelectedToggle()).getText().toLowerCase();
					} catch (NullPointerException ex) {
					}
					;
					controller.handleRegister(usernameTextField.getText(), passwordPasswordField.getText(),
							phoneNumberTextField.getText(), addressTextField.getText(), role);
					errorMessageLabel.setText("");
					errorMessageLabel.setVisible(false);
				} catch (Exception ex) {
					errorMessageLabel.setText(ex.getMessage());
					errorMessageLabel.setVisible(true);

				}
			}
		});
		registerButton.setOnMouseEntered(e -> {
			registerButton.setCursor(Cursor.HAND);
		});
		registerButton.setOnMouseExited(e -> {
			registerButton.setCursor(Cursor.DEFAULT);
		});

		loginHyperLink.setOnAction(e -> {
			controller.handleLoginHyperLink(e);
		});
	}

	private void styleComponent() {
		this.setPrefWidth(1280);
		this.setPrefHeight(720);
		imageVBox.setStyle("" + "-fx-background-image: url('"
				+ getClass().getResource("/resources/images/register-image.jpg").toExternalForm() + "');"
				+ "-fx-background-size: cover;" + "-fx-background-position: center center;"
				+ "-fx-background-repeat: no-repeat;");
		imageVBox.setPrefWidth(768);
		HBox.setHgrow(imageVBox, Priority.ALWAYS);
		HBox.setHgrow(contentVBox, Priority.ALWAYS);
		contentVBox.setPadding(new Insets(20, 40, 20, 40));
		contentVBox.setAlignment(Pos.CENTER);

		titleLabel.setFont(Font.font("Bodoni MT", 64));
		VBox.setMargin(titleLabel, new Insets(0, 0, 20, 0));
		subTitleLabel.setFont(Font.font(24));
		VBox.setMargin(subTitleLabel, new Insets(0, 0, 20, 0));

		formVBox.setAlignment(Pos.CENTER_LEFT);
		VBox.setVgrow(formVBox, Priority.ALWAYS);

		usernameLabel.setFont(Font.font(14));
		usernameTextField.setFont(Font.font(14));
		usernameTextField.setStyle("-fx-background-color: -fx-text-box-border, -fx-background ;"
				+ "	-fx-background-insets: 0, 0 0 1 0 ;" + "	-fx-background-radius: 0;");
		VBox.setMargin(usernameTextField, new Insets(0, 0, 20, 0));

		passwordLabel.setFont(Font.font(14));
		passwordPasswordField.setFont(Font.font(14));
		passwordPasswordField.setStyle("-fx-background-color: -fx-text-box-border, -fx-background ;"
				+ "	-fx-background-insets: 0, 0 0 1 0 ;" + "	-fx-background-radius: 0 ;");
		VBox.setMargin(passwordPasswordField, new Insets(0, 0, 20, 0));

		addressLabel.setFont(Font.font(14));
		addressTextField.setFont(Font.font(14));
		addressTextField.setStyle("-fx-background-color: -fx-text-box-border, -fx-background ;"
				+ "	-fx-background-insets: 0, 0 0 1 0 ;" + "	-fx-background-radius: 0;");
		VBox.setMargin(addressTextField, new Insets(0, 0, 20, 0));

		phoneNumberLabel.setFont(Font.font(14));
		phoneNumberTextField.setFont(Font.font(14));
		phoneNumberTextField.setStyle("-fx-background-color: -fx-text-box-border, -fx-background ;"
				+ "	-fx-background-insets: 0, 0 0 1 0 ;" + "	-fx-background-radius: 0;");
		VBox.setMargin(phoneNumberTextField, new Insets(0, 0, 20, 0));

		roleLabel.setFont(Font.font(14));
		VBox.setMargin(roleLabel, new Insets(0, 0, 5, 0));

		buyerRadioButton.setFont(Font.font(14));
		HBox.setMargin(buyerRadioButton, new Insets(0, 20, 0, 0));
		sellerRadioButton.setFont(Font.font(14));
		HBox.setMargin(roleHBox, new Insets(0, 0, 20, 0));

		errorMessageLabel.setFont(Font.font(10));
		errorMessageLabel.setTextFill(Color.RED);
		errorMessageLabel.setVisible(false);

		VBox.setMargin(registerButton, new Insets(20, 0, 0, 0));
		registerButton.setFont(Font.font(14));
		registerButton.setStyle("-fx-background-color: blue; -fx-text-fill: white; -fx-background-radius: 10px;");
		registerButton.setPadding(new Insets(15, 0, 15, 0));
		registerButton.setMaxWidth(Double.MAX_VALUE);
		VBox.setVgrow(registerButton, Priority.ALWAYS);

		dividerHBox.setPadding(new Insets(10));
		dividerHBox.setAlignment(Pos.CENTER);
		line1.setEndX(170);
		line2.setEndX(170);

		orLabel.setFont(Font.font(12));
		orLabel.setPadding(new Insets(0, 5, 0, 5));
		orLabel.setMinWidth(Region.USE_PREF_SIZE);
		orLabel.setMinHeight(Region.USE_PREF_SIZE);
		HBox.setMargin(orLabel, new Insets(0, 5, 0, 5));

		loginAccountHBox.setAlignment(Pos.CENTER);
		loginAccountHBox.setPadding(new Insets(0, 10, 0, 10));
		createAccountLabel.setFont(Font.font(12));
		loginHyperLink.setFont(Font.font(12));
	}

	private void addComponent() {
		loginAccountHBox.getChildren().addAll(createAccountLabel, loginHyperLink);
		dividerHBox.getChildren().addAll(line1, orLabel, line2);
		buyerRadioButton.setToggleGroup(roleToggleGroup);
		sellerRadioButton.setToggleGroup(roleToggleGroup);
		roleHBox.getChildren().addAll(buyerRadioButton, sellerRadioButton);
		formVBox.getChildren().addAll(usernameLabel, usernameTextField, passwordLabel, passwordPasswordField,
				phoneNumberLabel, phoneNumberTextField, addressLabel, addressTextField, roleLabel, roleHBox);
		contentVBox.getChildren().addAll(titleLabel, subTitleLabel, formVBox, errorMessageLabel, registerButton,
				dividerHBox, loginAccountHBox);
		this.getChildren().addAll(imageVBox, contentVBox);
	}

	private void initComponent() {
		imageVBox = new VBox();
		contentVBox = new VBox();
		formVBox = new VBox();

		dividerHBox = new HBox();
		loginAccountHBox = new HBox();
		roleHBox = new HBox();

		titleLabel = new Label("CaLouseIF");
		subTitleLabel = new Label("Welcome to CaLouseIF");
		usernameLabel = new Label("Username");
		passwordLabel = new Label("Password");
		phoneNumberLabel = new Label("Phone Number");
		addressLabel = new Label("Address");
		roleLabel = new Label("Role");
		orLabel = new Label("or");
		createAccountLabel = new Label("Already have an account?");
		errorMessageLabel = new Label();

		usernameTextField = new TextField();
		phoneNumberTextField = new TextField("+62");
		addressTextField = new TextField();

		passwordPasswordField = new PasswordField();

		registerButton = new Button("Register");

		loginHyperLink = new Hyperlink("Login");

		line1 = new Line();
		line2 = new Line();

		roleToggleGroup = new ToggleGroup();
		buyerRadioButton = new RadioButton("Buyer");
		sellerRadioButton = new RadioButton("Seller");

	}
}
