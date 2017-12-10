package ui;

import java.util.List;

import character.Animal;
import character.CharacterHolder;
import game.GameState;
import item.ItemHolder;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Rectangle;
import map.Block;
import map.MapHolder;

public class UIGame extends Group {
	
	private static final int FPS = 60;
	private static final long LOOP_TIME = 1000000000 / FPS;
	
	public static Group globalMap;
	//public static Group globalAni;
	public static Node globalRabbit;
	private GameState state;
	
	public UIGame(GameState state)
	{
		this.state = state;
		globalMap = drawMap();
		//globalAni = drawAnimal();
		globalRabbit = CharacterHolder.aniData.get(0).body;
		this.getChildren().add(globalMap);
		this.getChildren().add(globalRabbit);
		this.getChildren().add(CharacterHolder.aniGroup);
		CharacterHolder.aniGroup.translateXProperty().bind(globalMap.translateXProperty());
		CharacterHolder.aniGroup.translateYProperty().bind(globalMap.translateYProperty());
		UIBar bar = new UIBar();
		this.getChildren().add(bar);
		this.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) {
				if(event.getCode().equals(KeyCode.LEFT)) {
					CharacterHolder.aniData.get(0).turnLeft();
				}
				else if(event.getCode().equals(KeyCode.RIGHT)) {
					CharacterHolder.aniData.get(0).turnRight();
				}
				else if(event.getCode().equals(KeyCode.SPACE)) {
					ItemHolder.useItem();
				}
			}
		});
	}
	
	private Group drawMap()
	{
		Group temp = new Group();
		for(List<Block> row : MapHolder.mapData)
			for(Block b : row)
				temp.getChildren().add(b.hexagon);
		return temp;
	}
	
	private Group drawAnimal()
	{
		Group temp = new Group();
		//for(Animal a : CharacterHolder.aniData.subList(1, CharacterHolder.aniData.size())) 
		//	temp.getChildren().add(a.body);
		return temp;
	}
}