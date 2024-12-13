package com.ldts.t14g01.Tenebris.controller.menu;

import com.ldts.t14g01.Tenebris.controller.Controller;
import com.ldts.t14g01.Tenebris.gui.Action;
import com.ldts.t14g01.Tenebris.model.arena.Arena;
import com.ldts.t14g01.Tenebris.model.menu.MainMenu;
import com.ldts.t14g01.Tenebris.model.menu.Menu;
import com.ldts.t14g01.Tenebris.savedata.SaveData;
import com.ldts.t14g01.Tenebris.savedata.SaveDataProvider;
import com.ldts.t14g01.Tenebris.state.ArenaState;
import com.ldts.t14g01.Tenebris.state.MenuState;
import com.ldts.t14g01.Tenebris.state.StateChanger;
import com.ldts.t14g01.Tenebris.utils.Difficulty;

import java.io.IOException;

public class LoadGameMenuController extends Controller<Menu> {
    public LoadGameMenuController(Menu model) {
        super(model);
    }

    @Override
    public void tick(Action action, StateChanger stateChanger, SaveDataProvider saveDataProvider) throws IOException {
        switch (action) {
            case LOOK_UP -> this.getModel().moveDown();
            case LOOK_DOWN -> this.getModel().moveUp();
            case EXEC -> this.executeOption(stateChanger, saveDataProvider, this.getModel().getSelectedOption() );
            case ESC -> stateChanger.setState(new MenuState(new MainMenu(saveDataProvider)));
            case QUIT -> stateChanger.setState(null);
            case null, default -> {
            }
        }
    }

    void executeOption(StateChanger stateChanger, SaveDataProvider saveDataProvider,int selected) throws IOException {
        // Load selected Save
        saveDataProvider.setSaveData(SaveData.getSaves().get(selected));
        stateChanger.setState(new ArenaState(new Arena()));
    }
}
