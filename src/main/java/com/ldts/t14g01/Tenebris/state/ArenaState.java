package com.ldts.t14g01.Tenebris.state;

import com.ldts.t14g01.Tenebris.controller.Controller;
import com.ldts.t14g01.Tenebris.controller.arena.ArenaController;
import com.ldts.t14g01.Tenebris.gui.GUI;
import com.ldts.t14g01.Tenebris.model.arena.Arena;
import com.ldts.t14g01.Tenebris.sound.GlobalSoundManager;
import com.ldts.t14g01.Tenebris.sound.SoundManager;
import com.ldts.t14g01.Tenebris.view.View;
import com.ldts.t14g01.Tenebris.view.arena.ArenaView;

public class ArenaState extends State<Arena> {
    public ArenaState(Arena model) {
        super(model);
        GlobalSoundManager.getInstance().stopMusic(SoundManager.Music.menuBackground);
    }

    @Override
    protected View<Arena> getView() {
        return new ArenaView(this.getModel());
    }

    @Override
    protected Controller<Arena> getController() {
        return new ArenaController(this.getModel());
    }

    @Override
    public GUI.Type getGUIType() {
        return GUI.Type.ARENA;
    }
}
