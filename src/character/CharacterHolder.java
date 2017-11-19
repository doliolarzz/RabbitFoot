package character;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import map.Block;
import utility.Pair;
import utility.RandomGenerator;

public class CharacterHolder {
	public static ObservableList<Animal> aniData;
	private Comparator<Animal> comparator;
	public CharacterHolder()
	{
		comparator = (Animal o1, Animal o2) -> {
			if(o1.getZ() > o2.getZ())
				return 1;
			return -1;
		};
	}
	public void genAnimal(int diff)
	{
		aniData = FXCollections.<Animal>observableArrayList();
		//temp
		Rabbit r = new Rabbit(new Pair(4,3), 1.2, 1, 0);
		aniData.add(r);
		Wolf w = new Wolf(RandomGenerator.randomIndex(), 0.9, 1, 0);
		aniData.add(w);
	}
	public void add(Animal animal)
	{
		
	}
	public void remove(Animal animal)
	{
		
	}
}