package de.hbarr.aoc2020.day03;

import de.hbarr.aoc2020.Challenge;

import java.awt.geom.Point2D;
import java.util.List;

public class Challenge01 implements Challenge {

    /**
     * You start on the open square (.) in the top-left corner
     * and need to reach the bottom (below the bottom-most row on your map).
     *
     * The toboggan can only follow a few specific slopes (you opted for a cheaper model that prefers rational numbers);
     * start by counting all the trees you would encounter for the slope right 3, down 1:
     *
     * From your starting position at the top-left, check the position that is right 3 and down 1.
     * Then, check the position that is right 3 and down 1 from there, and so on until you go past the bottom of the map.
     */

    @Override
    public String run(List<String> data) {
        Position pos = new Position(0,0,data.get(0).length());
        int trees = 0;
        for (int i = pos.getY(); i < data.size()-1;i++){
            if(data.get(pos.incY()).charAt(pos.incX(3))=='#'){
                trees++;
            }
        }
        return String.valueOf(trees);
    }

    private class Position{
        int modX;
        int x;
        int y;

        Position(int x, int y, int modX){
            this.x=x;
            this.y=y;
            this.modX=modX;
        }

        int getX(){
            return x%modX;
        }

        int getY(){
            return y;
        }

        int incX(){
            x++;
            return getX();
        }

        int incX(int by){
            x+=by;
            return getX();
        }


        int incY(){
            y++;
            return getY();
        }

    }
}
