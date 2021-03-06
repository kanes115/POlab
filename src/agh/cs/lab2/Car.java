package agh.cs.lab2;

import java.util.LinkedList;
import java.util.List;

import static agh.cs.lab2.MapDirection.North;

/**
 * Created by Kanes on 28.10.2016.
 */
public class Car {
    private MapDirection orientation = North;
    private Position position = new Position(2, 2);
    private IWorldMap map;


    public Car(IWorldMap map){
        this.map = map;
    }

    public Car(IWorldMap map, Position startPos){
        this.map = map;
        position = startPos;
    }

    public Car(IWorldMap map, int x, int y){
        this.map = map;
        position = new Position(x, y);
    }


    public String toString(){
        switch(orientation) {
            case North:
                return "N";
            case South:
                return "S";
            case West:
                return "W";
            case East:
                return "E";
            default:
                return null;
        }
    }


    private Position updatePos(Position pos){
        return new Position(position).add(pos);
    }


    private Position checkAndMove(int ornt){
        Position pos = new Position(0 ,0);

        if(orientation == MapDirection.North) {
            pos = updatePos(new Position(0, -1).multiplyBy(ornt));
        }
        if(orientation == MapDirection.South){
            pos = updatePos(new Position(0, 1).multiplyBy(ornt));
        }
        if(orientation == MapDirection.East) {
            pos = updatePos(new Position(1, 0).multiplyBy(ornt));
        }
        if(orientation == MapDirection.West){
            pos = updatePos(new Position(-1, 0).multiplyBy(ornt));
        }


        if(!map.canMoveTo(pos)) return position;
        return pos;
    }


    public void move(MoveDirection direction){

        if(direction == MoveDirection.Right || direction == MoveDirection.Left) {
            orientation = orientation.next(orientation);
            return;
        }
        if(direction == MoveDirection.Backward){
            position = checkAndMove(-1);
        }else {
            position = checkAndMove(1);
        }

    }

    public Position getPosition(){
        return position;
    }






    public static void main(){

        String [] tab = new String [5];
        tab[0] = "f";
        tab[1] = "f";
        tab[2] = "f";
        tab[3] = "r";
        tab[4] = "f";

        List<HayStack> haystacks = new LinkedList<>();
        haystacks.add(new HayStack(new Position(7, 7)));
        haystacks.add(new HayStack(new Position(-4, -4)));
        haystacks.add(new HayStack(new Position(3, 6)));
        haystacks.add(new HayStack(new Position(2, 0)));

        MoveDirection[] directions = new OptionsParser().parse(tab);
        IWorldMap map = new UnboundedMap(haystacks);
        map.add(new Car(map));
        map.add(new Car(map,3,4));
        map.run(directions);
        System.out.println(map.toString());
    }

}
