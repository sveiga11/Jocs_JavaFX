package com.example.zombies;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Iterator;

public class MainApp extends Application {

    Temps temps = new Temps();

    IntValue punts = new IntValue(0);
    IntValue vides = new IntValue(6);

    int nivell = 1;

    ArrayList<Sprite> LlistaZombies1 = new ArrayList<Sprite>();
    ArrayList<Sprite> LlistaZombies2 = new ArrayList<Sprite>();
    ArrayList<Sprite> LlistaZombies3 = new ArrayList<Sprite>();
    ArrayList<Sprite> AugmentadorsVides = new ArrayList<Sprite>();

    Sprite zombie1, zombie2, zombie3, augmentadorVides;

    Image space = new Image("file:img/background.png");

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws InterruptedException {

        Image image = new Image("file:img/zombie1.png");
        stage.getIcons().add(image);
        stage.setTitle("Zombies");

        Group root = new Group();
        Scene theScene = new Scene(root);
        stage.setScene(theScene);

        Canvas canvas = new Canvas(940, 540);
        root.getChildren().add(canvas);

        ArrayList<String> input = new ArrayList<String>();

        temps.Contar();

        theScene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent keyEvent) {
                String code = keyEvent.getCode().toString();
                if (!input.contains(code))
                    input.add(code);
            }
        });

        theScene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent keyEvent) {
                String code = keyEvent.getCode().toString();
                input.remove(code);
            }
        });

        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();

        Font theFont = Font.font("Calibri", FontWeight.BOLD, 24);
        graphicsContext.setFont(theFont);
        graphicsContext.setFill(Color.ORANGE);
        graphicsContext.setStroke(Color.ORANGERED);
        graphicsContext.setLineWidth(1);

        Sprite civil = new Sprite();
        civil.setImage("file:img/civil.png");
        civil.setPosition(400, 360);

        LongValue lastNanoTime = new LongValue(System.nanoTime());

        new AnimationTimer() {
            public void handle(long currentNanoTime){

                // Causalitats del joc
                if (vides.value > 0) {
                    double elapsedTime = (currentNanoTime - lastNanoTime.value) / 1000000000.0;
                    lastNanoTime.value = currentNanoTime;

                    if (temps.getSegons() < 10) {
                        nivell = 1;
                        punts.value = 0;
                        if (currentNanoTime % 7000 == 0) {
                            zombie1 = new Sprite();
                            zombie1.setImage("file:img/zombie1.png");
                            double px = 900 * Math.random() + 50;
                            double py = 0;
                            zombie1.setPosition(px, py);
                            LlistaZombies1.add(zombie1);
                        }
                    } else if (temps.getSegons() > 10 && temps.getSegons() < 20){
                        nivell = 2;
                        punts.value = 10;
                        if (currentNanoTime % 6000 == 0) {
                            zombie1 = new Sprite();
                            zombie1.setImage("file:img/zombie1.png");
                            double px = 900 * Math.random() + 50;
                            double py = 0;
                            zombie1.setPosition(px, py);
                            LlistaZombies1.add(zombie1);
                        }
                        if (currentNanoTime % 15000 == 0) {
                            augmentadorVides = new Sprite();
                            augmentadorVides.setImage("file:img/aumentadorVidas.png");
                            double px = 900 * Math.random() + 50;
                            double py = 0;
                            augmentadorVides.setPosition(px, py);
                            AugmentadorsVides.add(augmentadorVides);
                        }
                    } else if (temps.getSegons() > 20 && temps.getSegons() < 30) {
                        nivell = 3;
                        punts.value = 20;
                        if (currentNanoTime % 6000 == 0) {
                            zombie1 = new Sprite();
                            zombie1.setImage("file:img/zombie1.png");
                            double px = 900 * Math.random() + 50;
                            double py = 0;
                            zombie1.setPosition(px, py);
                            LlistaZombies1.add(zombie1);
                        }
                        if (currentNanoTime % 8000 == 0) {
                            zombie2 = new Sprite();
                            zombie2.setImage("file:img/zombie2.png");
                            double px = 900 * Math.random() + 50;
                            double py = 0;
                            zombie2.setPosition(px, py);
                            LlistaZombies2.add(zombie2);
                        }
                        if (currentNanoTime % 15000 == 0) {
                            augmentadorVides = new Sprite();
                            augmentadorVides.setImage("file:img/aumentadorVidas.png");
                            double px = 900 * Math.random() + 50;
                            double py = 0;
                            augmentadorVides.setPosition(px, py);
                            AugmentadorsVides.add(augmentadorVides);
                        }
                    } else if (temps.getSegons() > 30 && temps.getSegons() < 40) {
                        nivell = 4;
                        punts.value = 30;
                        if (currentNanoTime % 6000 == 0) {
                            zombie1 = new Sprite();
                            zombie1.setImage("file:img/zombie1.png");
                            double px = 900 * Math.random() + 50;
                            double py = 0;
                            zombie1.setPosition(px, py);
                            LlistaZombies1.add(zombie1);
                        }
                        if (currentNanoTime % 7000 == 0) {
                            zombie2 = new Sprite();
                            zombie2.setImage("file:img/zombie2.png");
                            double px = 900 * Math.random() + 50;
                            double py = 0;
                            zombie2.setPosition(px, py);
                            LlistaZombies2.add(zombie2);
                        }
                        if (currentNanoTime % 15000 == 0) {
                            augmentadorVides = new Sprite();
                            augmentadorVides.setImage("file:img/aumentadorVidas.png");
                            double px = 900 * Math.random() + 50;
                            double py = 0;
                            augmentadorVides.setPosition(px, py);
                            AugmentadorsVides.add(augmentadorVides);
                        }
                    } else if (temps.getSegons() > 40 && temps.getSegons() < 50) {
                        nivell = 5;
                        punts.value = 40;
                        if (currentNanoTime % 6000 == 0) {
                            zombie1 = new Sprite();
                            zombie1.setImage("file:img/zombie1.png");
                            double px = 900 * Math.random() + 50;
                            double py = 0;
                            zombie1.setPosition(px, py);
                            LlistaZombies1.add(zombie1);
                        }if (currentNanoTime % 7000 == 0) {
                            zombie2 = new Sprite();
                            zombie2.setImage("file:img/zombie2.png");
                            double px = 900 * Math.random() + 50;
                            double py = 0;
                            zombie2.setPosition(px, py);
                            LlistaZombies2.add(zombie2);
                        }
                        if (currentNanoTime % 9000 == 0) {
                            zombie3 = new Sprite();
                            zombie3.setImage("file:img/zombie3.png");
                            double px = 900 * Math.random() + 50;
                            double py = 0;
                            zombie3.setPosition(px, py);
                            LlistaZombies3.add(zombie3);
                        }
                        if (currentNanoTime % 15000 == 0) {
                            augmentadorVides = new Sprite();
                            augmentadorVides.setImage("file:img/aumentadorVidas.png");
                            double px = 900 * Math.random() + 50;
                            double py = 0;
                            augmentadorVides.setPosition(px, py);
                            AugmentadorsVides.add(augmentadorVides);
                        }
                    } else if (temps.getSegons() > 50 && temps.getSegons() < 60) {
                        nivell = 6;
                        punts.value = 50;
                        if (currentNanoTime % 6000 == 0) {
                            zombie1 = new Sprite();
                            zombie1.setImage("file:img/zombie1.png");
                            double px = 900 * Math.random() + 50;
                            double py = 0;
                            zombie1.setPosition(px, py);
                            LlistaZombies1.add(zombie1);
                        }
                        if (currentNanoTime % 7000 == 0) {
                            zombie2 = new Sprite();
                            zombie2.setImage("file:img/zombie2.png");
                            double px = 900 * Math.random() + 50;
                            double py = 0;
                            zombie2.setPosition(px, py);
                            LlistaZombies2.add(zombie2);
                        }
                        if (currentNanoTime % 8000 == 0) {
                            zombie3 = new Sprite();
                            zombie3.setImage("file:img/zombie3.png");
                            double px = 900 * Math.random() + 50;
                            double py = 0;
                            zombie3.setPosition(px, py);
                            LlistaZombies3.add(zombie3);
                        }
                        if (currentNanoTime % 15000 == 0) {
                            augmentadorVides = new Sprite();
                            augmentadorVides.setImage("file:img/aumentadorVidas.png");
                            double px = 900 * Math.random() + 50;
                            double py = 0;
                            augmentadorVides.setPosition(px, py);
                            AugmentadorsVides.add(augmentadorVides);
                        }
                    }

                    /*Funcionament del joc*/

                    //Velocitat dels zombies
                    for (Sprite sprite : LlistaZombies1) {
                        int vx = 0;
                        int vy = (int) (Math.random() * 50 + 1);
                        sprite.setVelocity(vx, vy);
                        sprite.update(elapsedTime);
                    }
                    for (Sprite sprite : LlistaZombies2) {
                        int vx = 0;
                        int vy = (int) (Math.random() * 70 + 1);
                        sprite.setVelocity(vx, vy);
                        sprite.update(elapsedTime);
                    }
                    for (Sprite sprite : LlistaZombies3) {
                        int vx = 0;
                        int vy = (int) (Math.random() * 90 + 1);
                        sprite.setVelocity(vx, vy);
                        sprite.update(elapsedTime);
                    }

                    // Velocitat del augmentador de vides
                    for (Sprite sprite : AugmentadorsVides) {
                        int vx = 0;
                        int vy = (int) (Math.random() * 200 + 1);
                        sprite.setVelocity(vx, vy);
                        sprite.update(elapsedTime);
                    }

                    //Moviment del personatge
                    civil.setVelocity(0, 0);
                    if (input.contains("LEFT"))
                        civil.addVelocity(-200, 0);

                    if (input.contains("RIGHT"))
                        civil.addVelocity(200, 0);

                    if (input.contains("UP"))
                        civil.addVelocity(0, -200);

                    if (input.contains("DOWN"))
                        civil.addVelocity(0, 200);


                    //Augmentar velocitat de moviment del personatge
                    if (input.contains("SHIFT") && nivell >= 3){
                        civil.update(elapsedTime * 2);
                    }

                    civil.update(elapsedTime);

                    // Augmentar punts
                    if ((temps.getSegons() > temps.getSegons() + 10)){
                        punts.value++;
                    }

                    // Quan els sprites choquen entre si
                    Iterator<Sprite> zombie1Interator = LlistaZombies1.iterator();
                    while (zombie1Interator.hasNext()) {
                        Sprite zombie1 = zombie1Interator.next();
                        if (civil.intersects(zombie1)) {
                            zombie1Interator.remove();
                            vides.value--;
                        }
                    }
                    Iterator<Sprite> zombie2Interator = LlistaZombies2.iterator();
                    while (zombie2Interator.hasNext()) {
                        Sprite zombie2 = zombie2Interator.next();
                        if (civil.intersects(zombie2)) {
                            zombie2Interator.remove();
                            //punts.value--;
                            vides.value = vides.value - 3;
                        }
                    }
                    Iterator<Sprite> zombie3Interator = LlistaZombies3.iterator();
                    while (zombie3Interator.hasNext()) {
                        Sprite zombie3 = zombie3Interator.next();
                        if (civil.intersects(zombie3)) {
                            zombie3Interator.remove();
                            //punts.value = 0;
                            vides.value = 0;
                        }
                    }
                    Iterator<Sprite> augmentarVidesInterator = AugmentadorsVides.iterator();
                    while (augmentarVidesInterator.hasNext()) {
                        Sprite augmentadorVides = augmentarVidesInterator.next();
                        if (civil.intersects(augmentadorVides)) {
                            augmentarVidesInterator.remove();
                            //punts.value = 0;
                            vides.value = 6;
                        }
                    }

                    //Render
                    graphicsContext.clearRect(0, 0, 1000, 600);
                    graphicsContext.drawImage( space, 0, 0 );
                    civil.render(graphicsContext);

                    for (Sprite zombie1 : LlistaZombies1)
                        zombie1.render(graphicsContext);

                    for (Sprite zombie2 : LlistaZombies2)
                        zombie2.render(graphicsContext);

                    for (Sprite zombie3 : LlistaZombies3)
                        zombie3.render(graphicsContext);

                    for (Sprite augmentadorVides : AugmentadorsVides)
                        augmentadorVides.render(graphicsContext);

                    String textTemps = "Temps: " + (temps.getSegons());
                    graphicsContext.fillText(textTemps, 420, 36);
                    graphicsContext.strokeText(textTemps, 420, 36);

                    String textVides = "Vides: " + vides.value;
                    graphicsContext.fillText(textVides, 30, 36);
                    graphicsContext.strokeText(textVides, 30, 36);

                    String textPunts = "Punts: " + punts.value;
                    graphicsContext.fillText(textPunts, 30, 72);
                    graphicsContext.strokeText(textPunts, 30, 72);

                    String textNivell = "Nivell " + nivell;
                    graphicsContext.fillText(textNivell, 850, 36);
                    graphicsContext.strokeText(textNivell, 850, 36);



                } else {
                    // Quan perds la partida
                    String gameover = "HAS MUERTO!!\nFIN DEL JUEGO";

                    graphicsContext.setFill(Color.ORANGE);
                    graphicsContext.setStroke(Color.ORANGERED);

                    Font theFont = Font.font("Calibri", FontWeight.BOLD, 75);

                    graphicsContext.setFont(theFont);
                    graphicsContext.fillText(gameover, 240, 250);
                    graphicsContext.strokeText(gameover, 240, 250);
                }
            }

        }.start();
        stage.show();
    }
}