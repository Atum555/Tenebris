package com.ldts.t14g01.Tenebris.controller.menu;

import com.ldts.t14g01.Tenebris.controller.Controller;
import com.ldts.t14g01.Tenebris.gui.Action;
import com.ldts.t14g01.Tenebris.gui.GUI;
import com.ldts.t14g01.Tenebris.model.arena.ArenaBuilder;
import com.ldts.t14g01.Tenebris.model.menu.DeathMenu;
import com.ldts.t14g01.Tenebris.model.menu.MainMenu;
import com.ldts.t14g01.Tenebris.model.menu.Menu;
import com.ldts.t14g01.Tenebris.savedata.SaveDataProvider;
import com.ldts.t14g01.Tenebris.state.ArenaState;
import com.ldts.t14g01.Tenebris.state.MenuState;
import com.ldts.t14g01.Tenebris.state.StateChanger;

import java.io.IOException;

public class DeathMenuController extends Controller<Menu> {
    public DeathMenuController(Menu model) {
        super(model);
    }

    void executeOption(StateChanger stateChanger, SaveDataProvider saveDataProvider) throws IOException {
        switch (DeathMenu.DeathMenuOptions.valueOf(this.getModel().getOptions().get(this.getModel().getSelectedOption()))) {
            case Retry -> stateChanger.setState(new ArenaState(ArenaBuilder.build(saveDataProvider.getSaveData())));
            case Back_To_Main_Menu -> stateChanger.setState(new MenuState(new MainMenu(saveDataProvider)));
            default -> {
            }
        }
    }

    @Override
    public void tick(StateChanger stateChanger, SaveDataProvider saveDataProvider) throws IOException, InterruptedException {
        Action action = GUI.getGUI().getAction();

        switch (action) {
            case LOOK_LEFT -> this.getModel().moveUp();
            case LOOK_RIGHT -> this.getModel().moveDown();
            case EXEC -> this.executeOption(stateChanger, saveDataProvider);
            case ESC -> stateChanger.setState(new MenuState(new MainMenu(saveDataProvider)));
            case QUIT -> stateChanger.setState(null);
            case null, default -> {
            }
        }
    }
}