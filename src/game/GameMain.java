package game;

import java.util.Optional;

import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import scene.SceneManager;
import ui.UIGame;
import javafx.scene.control.Alert.AlertType;

public class GameMain {
	
	private static GameState state;
	private static GameLogic logic;
	public static GameCamera camera;
	private static UIGame gameUI;
	
	public static void newGame(int diff,int wolf) {
		state = new GameState(diff,wolf);
		gameUI = new UIGame(state);
		camera = new GameCamera(gameUI);
		logic = new GameLogic(gameUI, state, camera);
		logic.startGame();
		SceneManager.gotoScene(gameUI);
		logic.startGame();
	}
	
	public static void stopGame() {
		// TODO fill code
		logic.stopGame();
		Platform.runLater(GameMain::gameOver);
		
	}
	
	public static void gameOver() {
		// TODO fill code
		Alert alert = new Alert(AlertType.NONE, 
                "Game Over! Score: "+ Integer.toString(GameState.score) , 
                ButtonType.OK);

		alert.show();
	}

}
