package model;

/**
 * Created by Макс on 10.10.2016.
 */

import matchmaker.SinglePlayerMatchMaker;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import model.GameConstants;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SingleGameSession implements GameSession {
    private List<Player> activePlayers = new ArrayList<>();
    private  List<Food> FoodList = new ArrayList<>();
    private String sessionName;
    private final List<SomeGreenThing> GreenThingList = new ArrayList<>();
    @NotNull
    private final Logger log = LogManager.getLogger(SinglePlayerMatchMaker.class);

    public SingleGameSession(Player player){

        sessionName=player.name();

        if (log.isInfoEnabled()) {
            log.info("SinglePlayerSession " + sessionName + " had created");
        }
        CreateField(GameConstants.FIELD_WIDTH, GameConstants.FIELD_HEIGTH);
        join(player);

        //System.out.println("SinglePlayerSession " + sessionName + " had created");
        Random random = new Random();


        for(int i=0;i<10;i++){
            int x = Food.radius + random.nextInt(GameConstants.FIELD_WIDTH-2*Food.radius);
            int y = Food.radius + random.nextInt(GameConstants.FIELD_HEIGTH-2*Food.radius);
            CreateFood(x,y);
        }

        for(int i=0;i<5;i++){
            int x = SomeGreenThing.radius + random.nextInt(GameConstants.FIELD_WIDTH-2*SomeGreenThing.radius);
            int y = SomeGreenThing.radius + random.nextInt(GameConstants.FIELD_HEIGTH-2*SomeGreenThing.radius);
            CreateGreenThing(x,y);
        }

    }



    public void join(Player player){
       activePlayers.add(player);
        if (log.isInfoEnabled()) {
            log.info(player.name() +" has joined to session " + sessionName);
        }
        //System.out.println(player.name() +" has joined to session " + sessionName);
        Random random = new Random();
        int x = GameConstants.START_PLAYER_RADIUS + random.nextInt(GameConstants.FIELD_WIDTH - 2*GameConstants.START_PLAYER_RADIUS);
        int y = GameConstants.START_PLAYER_RADIUS + random.nextInt(GameConstants.FIELD_HEIGTH - 2*GameConstants.START_PLAYER_RADIUS);
       CreatePlayerCircle(x,y,player);
    }

    public void CreatePlayerCircle(int x, int y, Player player){
        PlayerCircle newPlayerCircle = new PlayerCircle(x,y,player);
        if (log.isInfoEnabled()) {
            log.info(newPlayerCircle + " had created");
        }
        //System.out.println(newPlayerCircle + " had created");
    }

    public void CreateField (int Width, int Heigth){
        Field gameField= new Field(Width,Heigth);
        if (log.isInfoEnabled()) {
            log.info(gameField + " had created");
        }
        //System.out.println(gameField + " had created");
    }

    public void CreateFood(int x, int y){

        Food newFood=new Food(x,y);
        FoodList.add(newFood);
        if (log.isInfoEnabled()) {
            log.info(newFood+" had created");
        }
        //System.out.println(newFood+" had created");
    }

    @Override
    public String toString() {
        return sessionName;
    }

    @NotNull
    public List<Player> ActivePlayers() {
        return new ArrayList<>(activePlayers);
    }

    public void CreateGreenThing(int x,int y){
        SomeGreenThing newGreen = new SomeGreenThing(x,y);
        GreenThingList.add(newGreen);
        if (log.isInfoEnabled()) {
            log.info(newGreen + " had created");
        }
        //System.out.println(newGreen + " had created");
    }
}
