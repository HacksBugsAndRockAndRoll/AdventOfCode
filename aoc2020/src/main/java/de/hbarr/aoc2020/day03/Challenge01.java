package de.hbarr.aoc2020.day03;

import de.hbarr.aoc2020.Challenge;

import java.util.List;

public class Challenge01 implements Challenge {
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
