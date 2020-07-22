package ir.ac.kntu.cs2d.server;

import ir.ac.kntu.cs2d.graphics.Map;
import ir.ac.kntu.cs2d.graphics.Observer;
import ir.ac.kntu.cs2d.logic.play.logic.Game;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.ParallelCamera;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Timer;


public class ServerMain extends Application implements Observer<Game> {

    static ServerSocket server = null;
    static Socket socket = null;
    private Map map ;
//    private List<Player> players;
    private Game game;
    private Group root;
    private Scene scene;
    private Circle soldier;
    private Line soldierAim;
    private Circle bullet;
    private Circle aim;
    private ParallelCamera camera;
    private HBox dataBar;
    private Text cash;
    private Text gunInHand;

    public static void controlData() {
        int i = 0 ;
        while (true){
            try {
                server = new ServerSocket(50128+i);
                System.out.println("server accepting client.");
                socket = server.accept();
            } catch (IOException e) {
                e.printStackTrace();
                System.err.println("problem creating server.");
            }
            if (socket!=null){
                i++;
                Thread receivingThread = new Thread(()->{
                    while (true){
                        try {
                            String arrivedMessage="";
                            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                            arrivedMessage += (String) ois.readObject();
                            System.out.println(arrivedMessage);
                        } catch (IOException | ClassNotFoundException e) {
                            e.printStackTrace();
                        }
                    }
                });
                receivingThread.start();
            }
        }
    }
    public ServerMain() {

    }

    @Override
    public void init() throws Exception {
        map = new Map();
        game = new Game();

        game.addObserver(this);
        camera = new ParallelCamera();
        soldier = new Circle(5,5,8);
        soldierAim = new Line(5,5,10,10);
        aim = new Circle(400,400,12);
        aim.setFill(Color.TRANSPARENT);
        aim.setStroke(Color.RED);
        aim.setStrokeWidth(2);
        dataBar = new HBox();
        dataBar.setSpacing(20);
        dataBar.setAlignment(Pos.CENTER);
        dataBar.setPrefSize(600,100);
        dataBar.setLayoutX(0);
        dataBar.setLayoutY(0);

        cash = new Text("$");
        cash.setTextAlignment(TextAlignment.CENTER);
        gunInHand = new Text();
        gunInHand.setTextAlignment(TextAlignment.CENTER);
        dataBar.getChildren().addAll(cash,gunInHand);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Thread controlData = new Thread(ServerMain::controlData);
        controlData.start();

        root = new Group();
        scene = new Scene(root, 600, 700);
        stage.setScene(scene);

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
                default:
                    System.err.println("Wrong Key!");
            }
            scene.setOnMouseMoved((MouseEvent)->{
                game.getAim().setX1(MouseEvent.getX());
                game.getAim().setY1(MouseEvent.getY());
            });
            e.consume();
        });
        stage.getIcons().addAll(new Image(getClass().getResource(
                "/images/logo.png").toString()));
        Timer timer = new Timer();
        timer.schedule(game, 100, 16);
        root.getChildren().addAll(dataBar,soldier, soldierAim, aim);
        stage.setTitle("Counter Strike 2d");
        stage.show();

    }

    @Override
    public void update(Game observable) {
        Platform.runLater(()->{
            soldier.setCenterY(game.getSoldiers().get(0).getY());
            soldier.setCenterX(game.getSoldiers().get(0).getX());
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
        });
    }
}
