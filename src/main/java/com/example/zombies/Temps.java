package com.example.zombies;

import java.util.Timer;
import java.util.TimerTask;

public class Temps {
    private Timer timer = new Timer();
    private int segons = 0;

    //Clase interna que funciona com a contador
    class Contador extends TimerTask {
        public void run() {
            segons++;
        }
    }
    //Creem un timer, que inicia els segons a 0 i comença a contar
    public void Contar()
    {
        this.segons = 0;
        timer = new Timer();
        timer.schedule(new Contador(), 0, 1000);
    }
    //Metode que retorna els segons que van pasant
    public int getSegons()
    {
        return this.segons;
    }
}
