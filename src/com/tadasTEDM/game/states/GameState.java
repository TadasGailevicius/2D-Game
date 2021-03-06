package com.tadasTEDM.game.states;

import com.tadasTEDM.game.utils.KeyHandler;
import com.tadasTEDM.game.utils.MouseHandler;

import java.awt.Graphics2D;

public abstract class GameState {

    private GameStateManager gsm;

    public GameState(GameStateManager gsm){
        this.gsm = gsm;

    }

    public abstract void update();
    public abstract void input(MouseHandler mouse, KeyHandler key);
    public abstract void render(Graphics2D g);
}
