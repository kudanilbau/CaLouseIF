package main.views;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import main.controllers.LoginController;

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
	
	public LoginView(LoginController controller) {
		this.controller = controller;
		initComponent();
	}
	
	public Parent asParent() {
		return mainHBox;
	}
	
	public void initComponent() {
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
		
		createAccountHBox.getChildren().addAll(createAccountLabel, createAccountHyperLink);
		dividerHBox.getChildren().addAll(line1, orLabel, line2);
		formVBox.getChildren().addAll(usernameLabel, usernameTextField, passwordLabel, passwordPasswordField, loginButton);
		contentVBox.getChildren().addAll(titleLabel, subTitleLabel, formVBox, dividerHBox, createAccountHBox);
		mainHBox.getChildren().addAll(imageVBox, contentVBox);
		
		imageVBox.setStyle(""
				+ "-fx-background-image: url('"+getClass().getResource("/resources/images/login-image.jpg").toExternalForm()+"');"
				+ "-fx-background-size: cover;"
				+ "-fx-background-position: center center;"
				+ "-fx-background-repeat: no-repeat;");
		imageVBox.setPrefWidth(960);
		
		HBox.setHgrow(contentVBox, Priority.ALWAYS);
		contentVBox.setPadding(new Insets(20, 40, 20 , 40));
		contentVBox.setAlignment(Pos.CENTER);
		
		titleLabel.setFont(Font.font("Bodoni MT", 64));		
		VBox.setMargin(titleLabel, new Insets(0, 0, 20, 0));
		subTitleLabel.setFont(Font.font(24));
		VBox.setMargin(subTitleLabel, new Insets(0, 0, 20, 0));		
		
		usernameLabel.setFont(Font.font(18));
		usernameTextField.setFont(Font.font(18));
		usernameTextField.setStyle("-fx-background-color: -fx-text-box-border, -fx-background ;"
				+ "	-fx-background-insets: 0, 0 0 1 0 ;"
				+ "	-fx-background-radius: 0 ;");
		VBox.setMargin(usernameTextField, new Insets(0, 0, 20, 0));
		
		passwordLabel.setFont(Font.font(18));
		passwordPasswordField.setFont(Font.font(18));
		passwordPasswordField.setStyle("-fx-background-color: -fx-text-box-border, -fx-background ;"
				+ "	-fx-background-insets: 0, 0 0 1 0 ;"
				+ "	-fx-background-radius: 0 ;");
		VBox.setMargin(passwordPasswordField, new Insets(0, 0, 20, 0));
		
		loginButton.setFont(Font.font(18));
		loginButton.setStyle("-fx-background-color: blue; -fx-text-fill: white; -fx-background-radius: 10px;");
		loginButton.setPadding(new Insets(15, 0, 15, 0));
		
		createAccountLabel.setFont(Font.font(18));
		createAccountHyperLink.setFont(Font.font(18));
		
		orLabel.setFont(Font.font(18));
		
		
		
		
	}
}
