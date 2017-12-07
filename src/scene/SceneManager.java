package scene;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import ui.UIMenu;

public class SceneManager {
	
	private static Stage primaryStage;
	private static Pane mainMenu;
	private static Scene mainScene;
	private static Pane mainFrame;
	public static final int SCENE_WIDTH = 800;
	public static final int SCENE_HEIGHT = 600;
	
	public static void initialize(Stage stage) {
		mainMenu = new UIMenu();
		mainFrame = new Pane(mainMenu);
		mainFrame.setPrefWidth(SCENE_WIDTH);
		mainFrame.setPrefHeight(SCENE_HEIGHT);
		mainScene = new Scene(mainFrame);
		primaryStage = stage;
	}
	
	public static void gotoMenu() {
		primaryStage.setScene(mainScene);
		mainMenu.requestFocus();
	}

	public static void gotoScene(Group group) {
		Pane gameFrame = new Pane(group);
		gameFrame.setPrefWidth(SCENE_WIDTH);
		gameFrame.setPrefHeight(SCENE_HEIGHT);
		Scene gameScene = new Scene(gameFrame);
		primaryStage.setScene(gameScene);
		group.requestFocus();
	}
	
	public static void gotoScene(Pane gameFrame) {
		gameFrame.setPrefWidth(SCENE_WIDTH);
		gameFrame.setPrefHeight(SCENE_HEIGHT);
		Scene gameScene = new Scene(gameFrame);
		primaryStage.setScene(gameScene);
		gameFrame.requestFocus();
	}
}
