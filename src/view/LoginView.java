package view;

import controller.LoginController;
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
import javafx.scene.shape.Line;
import javafx.scene.text.Font;

public class LoginView {
	private VBox imageVBox, contentVBox, formVBox;
	private HBox mainHBox, dividerHBox, createAccountHBox;
	private Label titleLabel, subTitleLabel, usernameLabel, passwordLabel, orLabel, createAccountLabel;
	private TextField usernameTextField;
	private PasswordField passwordPasswordField;
	private Button loginButton;
	private Hyperlink createAccountHyperLink;
	private Line line1, line2;

	private LoginController controller;

	public LoginView() {
		this.controller = LoginController.getInstance();
		initComponent();
		addComponent();
		styleComponent();
		initActionComponent();
	}

	private void initActionComponent() {
		loginButton.setOnMouseClicked(e -> {
			if (e.getButton() == MouseButton.PRIMARY) {
				controller.handleLogin(usernameTextField.getText(), passwordPasswordField.getText());
			}
		});
		loginButton.setOnMouseEntered(e -> {
			loginButton.setCursor(Cursor.HAND);
		});
		loginButton.setOnMouseExited(e -> {
			loginButton.setCursor(Cursor.DEFAULT);
		});

		createAccountHyperLink.setOnAction(e -> {
			controller.handleCreateAccountHyperLink(e);
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

		loginButton.setFont(Font.font(16));
		loginButton.setStyle("-fx-background-color: blue; -fx-text-fill: white; -fx-background-radius: 10px;");
		loginButton.setPadding(new Insets(15, 0, 15, 0));
		loginButton.setMaxWidth(Double.MAX_VALUE);
		VBox.setVgrow(loginButton, Priority.ALWAYS);

		dividerHBox.setPadding(new Insets(10));
		dividerHBox.setAlignment(Pos.CENTER);
		line1.setEndX(170);
		line2.setEndX(170);

		orLabel.setFont(Font.font(16));
		orLabel.setPadding(new Insets(0, 5, 0, 5));
		orLabel.setMinWidth(Region.USE_PREF_SIZE);
		orLabel.setMinHeight(Region.USE_PREF_SIZE);
		HBox.setMargin(orLabel, new Insets(0, 5, 0, 5));

		createAccountHBox.setAlignment(Pos.CENTER);
		createAccountHBox.setPadding(new Insets(10));
		createAccountLabel.setFont(Font.font(16));
		createAccountHyperLink.setFont(Font.font(16));
	}

	private void addComponent() {
		createAccountHBox.getChildren().addAll(createAccountLabel, createAccountHyperLink);
		dividerHBox.getChildren().addAll(line1, orLabel, line2);
		formVBox.getChildren().addAll(usernameLabel, usernameTextField, passwordLabel, passwordPasswordField);
		contentVBox.getChildren().addAll(titleLabel, subTitleLabel, formVBox, loginButton, dividerHBox,
				createAccountHBox);
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
		createAccountHBox = new HBox();

		titleLabel = new Label("CaLouseIF");
		subTitleLabel = new Label("Welcome to CaLouseIF");
		usernameLabel = new Label("Username");
		passwordLabel = new Label("Password");
		orLabel = new Label("or");
		createAccountLabel = new Label("New to CaLouseIF?");

		usernameTextField = new TextField();

		passwordPasswordField = new PasswordField();

		loginButton = new Button("Login");

		createAccountHyperLink = new Hyperlink("Create Account");

		line1 = new Line();
		line2 = new Line();

	}
}
