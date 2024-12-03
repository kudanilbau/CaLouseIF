package view;

import controller.RegisterController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;

public class RegisterView {
	private VBox imageVBox, contentVBox, formVBox;
	private HBox mainHBox, dividerHBox, loginAccountHBox;
	private Label titleLabel, subTitleLabel, usernameLabel, passwordLabel, phoneNumberLabel, addressLabel, orLabel,
			createAccountLabel, errorMessageLabel;
	private TextField usernameTextField, phoneNumberTextField, addressTextField;
	private PasswordField passwordPasswordField;
	private Button registerButton;
	private Hyperlink loginHyperLink;
	private Line line1, line2;

	private RegisterController controller;

	public RegisterView(RegisterController controller) {
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
					controller.handleRegister(usernameTextField.getText(), passwordPasswordField.getText(),
							phoneNumberTextField.getText(), addressTextField.getText());
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
		mainHBox.setPrefWidth(1280);
		mainHBox.setPrefHeight(720);
		imageVBox.setStyle("" + "-fx-background-image: url('"
				+ getClass().getResource("/resources/images/login-image.jpg").toExternalForm() + "');"
				+ "-fx-background-size: cover;" + "-fx-background-position: center center;"
				+ "-fx-background-repeat: no-repeat;");
		imageVBox.setPrefWidth(853.33);
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

		usernameLabel.setFont(Font.font(16));
		usernameTextField.setFont(Font.font(16));
		usernameTextField.setStyle("-fx-background-color: -fx-text-box-border, -fx-background ;"
				+ "	-fx-background-insets: 0, 0 0 1 0 ;" + "	-fx-background-radius: 0;");
		VBox.setMargin(usernameTextField, new Insets(0, 0, 20, 0));

		passwordLabel.setFont(Font.font(16));
		passwordPasswordField.setFont(Font.font(16));
		passwordPasswordField.setStyle("-fx-background-color: -fx-text-box-border, -fx-background ;"
				+ "	-fx-background-insets: 0, 0 0 1 0 ;" + "	-fx-background-radius: 0 ;");
		VBox.setMargin(passwordPasswordField, new Insets(0, 0, 20, 0));

		addressLabel.setFont(Font.font(16));
		addressTextField.setFont(Font.font(16));
		addressTextField.setStyle("-fx-background-color: -fx-text-box-border, -fx-background ;"
				+ "	-fx-background-insets: 0, 0 0 1 0 ;" + "	-fx-background-radius: 0;");
		VBox.setMargin(addressTextField, new Insets(0, 0, 20, 0));

		phoneNumberLabel.setFont(Font.font(16));
		phoneNumberTextField.setFont(Font.font(16));
		phoneNumberTextField.setStyle("-fx-background-color: -fx-text-box-border, -fx-background ;"
				+ "	-fx-background-insets: 0, 0 0 1 0 ;" + "	-fx-background-radius: 0;");
		VBox.setMargin(phoneNumberTextField, new Insets(0, 0, 20, 0));

		errorMessageLabel.setFont(Font.font(16));
		errorMessageLabel.setTextFill(Color.RED);
		errorMessageLabel.setVisible(false);
		VBox.setMargin(errorMessageLabel, new Insets(0, 0, 20, 0));

		registerButton.setFont(Font.font(16));
		registerButton.setStyle("-fx-background-color: blue; -fx-text-fill: white; -fx-background-radius: 10px;");
		registerButton.setPadding(new Insets(15, 0, 15, 0));
		registerButton.setMaxWidth(Double.MAX_VALUE);
		VBox.setVgrow(registerButton, Priority.ALWAYS);

		dividerHBox.setPadding(new Insets(10));
		dividerHBox.setAlignment(Pos.CENTER);
		line1.setEndX(170);
		line2.setEndX(170);

		orLabel.setFont(Font.font(16));
		orLabel.setPadding(new Insets(0, 5, 0, 5));
		orLabel.setMinWidth(Region.USE_PREF_SIZE);
		orLabel.setMinHeight(Region.USE_PREF_SIZE);
		HBox.setMargin(orLabel, new Insets(0, 5, 0, 5));

		loginAccountHBox.setAlignment(Pos.CENTER);
		loginAccountHBox.setPadding(new Insets(10));
		createAccountLabel.setFont(Font.font(16));
		loginHyperLink.setFont(Font.font(16));
	}

	private void addComponent() {
		loginAccountHBox.getChildren().addAll(createAccountLabel, loginHyperLink);
		dividerHBox.getChildren().addAll(line1, orLabel, line2);
		formVBox.getChildren().addAll(usernameLabel, usernameTextField, passwordLabel, passwordPasswordField,
				phoneNumberLabel, phoneNumberTextField, addressLabel, addressTextField);
		contentVBox.getChildren().addAll(titleLabel, subTitleLabel, formVBox, errorMessageLabel, registerButton, dividerHBox,
				loginAccountHBox);
		mainHBox.getChildren().addAll(imageVBox, contentVBox);
	}

	public Node asNode() {
		return mainHBox;
	}

	private void initComponent() {
		imageVBox = new VBox();
		contentVBox = new VBox();
		formVBox = new VBox();

		mainHBox = new HBox();
		dividerHBox = new HBox();
		loginAccountHBox = new HBox();

		titleLabel = new Label("CaLouseIF");
		subTitleLabel = new Label("Welcome to CaLouseIF");
		usernameLabel = new Label("Username");
		passwordLabel = new Label("Password");
		phoneNumberLabel = new Label("Phone Number");
		addressLabel = new Label("Address");
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

	}
}
