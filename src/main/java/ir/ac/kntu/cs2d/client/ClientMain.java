package ir.ac.kntu.cs2d.client;

import ir.ac.kntu.cs2d.graphics.MapGraphic;
import ir.ac.kntu.cs2d.graphics.Observer;
import ir.ac.kntu.cs2d.logic.play.logic.Game;
import ir.ac.kntu.cs2d.logic.play.logic.Soldier;
import ir.ac.kntu.cs2d.server.ServerMain;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.ParallelCamera;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Timer;

public class ClientMain extends Application implements Observer<Game> {

    static Soldier clientSoldier;
    static Game game;
    static Socket socket = null;

    private MapGraphic map ;
    //    private List<Player> players;
    private Group root;
    private Scene scene;
//    private Circle soldier;
    private List<Circle> soldiers;
    private Line soldierAim;
    private Circle bullet;
    private Circle aim;
    private ParallelCamera camera;
    private VBox dataBar;
    private Text cash;
    private Text gunInHand;
    private Alert inGameSoldiers;

    private static void controlData() {
        try {
            socket = new Socket("127.0.0.1",50128);
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("problem creating client.");
        }
        System.out.println("client is connected.");

//        Thread sendingThread = new Thread(()->{
            Object sendingMessage ;
//            while (true){
        try {
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            game = (Game) ois.readObject();
            System.out.println("game received");

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
//        try {
//            sendingMessage = clientSoldier;
//            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
//            sendingMessage += new Scanner(System.in).nextLine();
//            oos.writeObject(sendingMessage);
//            oos.flush();
//            System.out.println("client soldier sent.");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//            }
//        });
//        Thread receivingThread = new Thread(()->{
//            while (true){

//            }
//        });
//        sendingThread.start();
//        receivingThread.start();
    }

    @Override
    public void init() throws Exception {
        map = new MapGraphic();
        clientSoldier = new Soldier("ali", ir.ac.kntu.cs2d.logic.weapons.Group.TERRORIST);
        camera = new ParallelCamera();
        soldierAim = new Line(5,5,10,10);
        soldierAim.setFill(Color.CHOCOLATE);
        aim = new Circle(400,400,12);
        aim.setFill(Color.TRANSPARENT);
        aim.setStroke(Color.RED);
        aim.setStrokeWidth(2);
        dataBar = new VBox();
        dataBar.setSpacing(50);
        dataBar.setAlignment(Pos.CENTER);
        dataBar.setPrefSize(100,800);
        dataBar.setLayoutX(800);
        dataBar.setLayoutY(0);

        cash = new Text("$");
        cash.setTextAlignment(TextAlignment.CENTER);
        gunInHand = new Text();
        gunInHand.setTextAlignment(TextAlignment.CENTER);
        dataBar.getChildren().addAll(cash,gunInHand);

        soldiers = new ArrayList<>();
    }

    @Override
    public void start(Stage stage) throws Exception {
        Thread controlData = new Thread(ClientMain::controlData);
        controlData.start();
        Thread.sleep(1000);
        game.addObserver(this);
        game.addSoldier(clientSoldier);
        for (Soldier soldier1 : game.getSoldiers()){
            soldiers.add(new Circle(soldier1.getX(),soldier1.getY(),8));
        }

        inGameSoldiers = new Alert(Alert.AlertType.INFORMATION);
        inGameSoldiers.setHeaderText("soldiers");

        root = new Group();
        map.addObstaclesTo(root);
        scene = new Scene(root, 900, 800);
        stage.setScene(scene);
        stage.setResizable(false);

        scene.addEventFilter(KeyEvent.KEY_PRESSED, e -> {
            switch (e.getCode()) {
                case W:
                    game.getSoldiers().get(0).goUp();
                    break;
                case S:
                    game.getSoldiers().get(0).goDown();
                    break;
                case D:
                    game.getSoldiers().get(0).goRight();
                    break;
                case A:
                    game.getSoldiers().get(0).goLeft();
                    break;
                case DIGIT1:
                    game.getSoldiers().get(0).setInHandWeapon(1);
                    break;
                case DIGIT2:
                    game.getSoldiers().get(0).setInHandWeapon(2);
                    break;
                case TAB:
                    inGameSoldiers.show();
                    break;
                default:
                    System.err.println("Wrong Key!");
            }
            scene.setOnMouseMoved((MouseEvent)->{
                game.getAim().setX(MouseEvent.getX());
                game.getAim().setY(MouseEvent.getY());
            });
            scene.setOnMouseClicked((MouseEvent)->{
                System.out.println("fire!");
                if (clientSoldier.getInHandWeapon()==1 && clientSoldier.getMainGun()!=null){
                    clientSoldier.getMainGun().fire();
                }else {
                    clientSoldier.getPistol().fire();
                }
            });
            e.consume();
        });
        stage.getIcons().addAll(new Image(getClass().getResource(
                "/images/logo.png").toString()));
        Timer timer = new Timer();
        timer.schedule(game, 100, 16);
        root.getChildren().addAll(soldiers);
        root.getChildren().addAll(dataBar, soldierAim, aim);
        stage.setTitle("Counter Strike 2d");
        stage.show();
    }

    @Override
    public void update(Game observable) {
        Platform.runLater(()->{
            soldiers.get(game.getSoldiers().indexOf(clientSoldier)).setCenterY(game.getSoldiers().get(0).getY());
            soldiers.get(game.getSoldiers().indexOf(clientSoldier)).setCenterX(game.getSoldiers().get(0).getX());
            aim.setCenterY(game.getAim().getY());
            aim.setCenterX(game.getAim().getX());
            soldierAim.setStartX(game.getSoldiers().get(0).getX());
            soldierAim.setStartY(game.getSoldiers().get(0).getY());
            soldierAim.setEndX(game.getAim().getX());
            soldierAim.setEndY(game.getAim().getY());
            camera.setTranslateX(game.getCamera().getTranslateX());
            camera.setTranslateY(game.getCamera().getTranslateY());
            cash.setText(game.getSoldiers().get(0).getCash().getAmount()+"$");
            if (game.getSoldiers().get(0).getInHandWeapon()==1){
                gunInHand.setText(game.getSoldiers().get(0).getMainGun().getName());
            }else {
                gunInHand.setText(game.getSoldiers().get(0).getPistol().getName());
            }
            inGameSoldiers.setContentText(game.getInGameSoldiers());
            updateSoldiers(soldiers,game.getSoldiers(),root);
        });
    }

    private void updateSoldiers(List<Circle> soldiers, List<Soldier> soldiers1 , Group root) {
        for (int i = 0; i < soldiers1.size() ; i++) {
            soldiers.get(i).setCenterX(soldiers1.get(i).getX());
            soldiers.get(i).setCenterY(soldiers1.get(i).getY());
        }

    }
}
