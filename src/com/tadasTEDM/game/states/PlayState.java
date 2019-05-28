package com.tadasTEDM.game.states;

import com.tadasTEDM.game.GamePanel;
import com.tadasTEDM.game.entity.Enemy;
import com.tadasTEDM.game.entity.Enemy2;
import com.tadasTEDM.game.entity.Player;
import com.tadasTEDM.game.graphics.Font;
import com.tadasTEDM.game.graphics.Sprite;
import com.tadasTEDM.game.tiles.TileManager;
import com.tadasTEDM.game.utils.KeyHandler;
import com.tadasTEDM.game.utils.MouseHandler;
import com.tadasTEDM.game.utils.Vector2f;
import java.awt.Graphics2D;

public class PlayState extends GameState {

    private Font font;
    private Player player;
    private Enemy enemy;
    private Enemy2 enemy2;
    private TileManager tm;

    public static Vector2f map;

    public PlayState(GameStateManager gsm) {
        super(gsm);
        map = new Vector2f();
        Vector2f.setWorldVar(map.x, map.y);

        tm = new TileManager("tile/tilemap.xml");
        font = new Font("font/font.png", 10, 10);

        enemy = new Enemy(new Sprite("entity/enemy1.png", 32, 32), new Vector2f(0 + (GamePanel.width / 2) - 32 + 150, 0 + (GamePanel.height / 2) - 32 + 150), 48);
        //enemy2 = new Enemy2(new Sprite("entity/enemy2.png", 32, 32), new Vector2f(0 + (GamePanel.width / 2) - 32 + 180, 0 + (GamePanel.height / 2) - 32 + 180), 48);
        player = new Player(new Sprite("entity/linkFormatted.png"), new Vector2f(0 + (GamePanel.width / 2) - 32, 0 + (GamePanel.height / 2) - 32), 64);
        //player = new Player(new Sprite("entity/professor_walk_cycle_no_hat.png"), new Vector2f(40 + (GamePanel.width / 2) -32 + 150, 0 + (GamePanel.height / 2) - 32 + 150), 80);
    }

    public void update() {
        Vector2f.setWorldVar(map.x, map.y);
        player.update(enemy);
        enemy.update(player);
    }

    public void input(MouseHandler mouse, KeyHandler key) {
        player.input(mouse, key);
    }

    public void render(Graphics2D g) {
        tm.render(g);
        String fps = GamePanel.oldFrameCount + " FPS";
        Sprite.drawArray(g, font, fps, new Vector2f(GamePanel.width - fps.length() * 32, 32), 32, 24);

        String tps = GamePanel.oldTickCount + " TPS";
        Sprite.drawArray(g, tps, new Vector2f(GamePanel.width - tps.length() * 32, 64), 32, 24);

        player.render(g);
        enemy.render(g);
    }
}
