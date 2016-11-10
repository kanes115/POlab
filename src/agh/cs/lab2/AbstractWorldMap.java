package agh.cs.lab2;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Kanes on 10.11.2016.
 */
public abstract class AbstractWorldMap implements IWorldMap{
    protected List<Car> cars = new LinkedList<>();
    protected MapVisualizer mapV = new MapVisualizer();


    public boolean add(Car car){
        cars.add(car);
        return true;
    }

    public void run(MoveDirection[] directions){
        int turn = 0;
        for(int i = 0; i < directions.length; i++){
            cars.get(turn).move(directions[i]);
            turn += 1;
            turn = turn % cars.size();
            System.out.println(toString());
        }
    }

    public Object objectAt(Position position){
        for(Car car : cars){
            if(car.getPosition().equals(position)) return car;
        }
        return null;
    }

    public boolean isOccupied(Position position){
        for(int i = 0; i< cars.size(); i++){
            if(cars.get(i).getPosition().equals(position)) return true;
        }
        return false;
    }

    public String toString(){
        return mapV.dump(this, getLowerLeft(), getUpperRight());
    }

    public abstract Position getLowerLeft();

    public abstract Position getUpperRight();
}
