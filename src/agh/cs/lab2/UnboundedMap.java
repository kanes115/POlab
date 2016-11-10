package agh.cs.lab2;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Kanes on 10.11.2016.
 */
public class UnboundedMap extends AbstractWorldMap implements IWorldMap {
    private List<HayStack> haystacks;


    public UnboundedMap(List haystacks){
        this.haystacks = haystacks;
    }


    public boolean canMoveTo(Position position){
        for(Car car : cars){
            if(car.getPosition().equals(position)) return false;
        }
        for(HayStack haystack : haystacks){
            if(haystack.getPosition().equals(position)) return false;
        }
        return true;
    }


    public boolean isOccupied(Position position){
        return !canMoveTo(position);
    }

    public Object objectAt(Position position){
        if(super.objectAt(position) != null) return super.objectAt(position);

        for(HayStack haystack : haystacks){
            if(haystack.getPosition().equals(position)) return haystack;
        }
        return null;
    }

    public Position getLowerLeft(){
        int leftiest = Integer.MAX_VALUE;
        int lowest = Integer.MAX_VALUE;

        for(Car car : cars){
            if(car.getPosition().getX()<leftiest) leftiest = car.getPosition().getX();
            if(car.getPosition().getY()<lowest) lowest = car.getPosition().getY();
        }
        for(HayStack haystack : haystacks){
            if(haystack.getPosition().getX()<leftiest) leftiest = haystack.getPosition().getX();
            if(haystack.getPosition().getY()<lowest) lowest = haystack.getPosition().getY();
        }

        return new Position(leftiest, lowest);
    }

    public Position getUpperRight(){
        int rightest = Integer.MIN_VALUE;
        int uppest = Integer.MIN_VALUE;

        for(Car car : cars){
            if(car.getPosition().getX() > rightest) rightest = car.getPosition().getX();
            if(car.getPosition().getY() > uppest) uppest = car.getPosition().getY();
        }
        for(HayStack haystack : haystacks){
            if(haystack.getPosition().getX() > rightest) rightest = haystack.getPosition().getX();
            if(haystack.getPosition().getY() > uppest) uppest = haystack.getPosition().getY();
        }

        return new Position(rightest, uppest);
    }

}
