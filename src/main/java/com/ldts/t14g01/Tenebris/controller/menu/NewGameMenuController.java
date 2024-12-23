package com.ldts.t14g01.Tenebris.controller.menu;

import com.ldts.t14g01.Tenebris.controller.Controller;
import com.ldts.t14g01.Tenebris.gui.Action;
import com.ldts.t14g01.Tenebris.gui.GUI;
import com.ldts.t14g01.Tenebris.model.arena.ArenaBuilder;
import com.ldts.t14g01.Tenebris.model.menu.MainMenu;
import com.ldts.t14g01.Tenebris.model.menu.Menu;
import com.ldts.t14g01.Tenebris.savedata.SaveData;
import com.ldts.t14g01.Tenebris.savedata.SaveDataManager;
import com.ldts.t14g01.Tenebris.savedata.SaveDataProvider;
import com.ldts.t14g01.Tenebris.sound.SoundManager;
import com.ldts.t14g01.Tenebris.state.ArenaState;
import com.ldts.t14g01.Tenebris.state.MenuState;
import com.ldts.t14g01.Tenebris.state.StateChanger;
import com.ldts.t14g01.Tenebris.utils.Difficulty;

import java.io.IOException;

public class NewGameMenuController extends Controller<Menu> {
    public NewGameMenuController(Menu model) {
        super(model);
    }

    void executeOption(StateChanger stateChanger, SaveDataProvider saveDataProvider) throws IOException {
        SoundManager.getInstance().playSFX(SoundManager.SFX.MENU_SELECT);

        // Create new Save Data
        Difficulty newSaveDifficulty = Difficulty.valueOf(this.getModel().getOptions().get(this.getModel().getSelectedOption()));
        SaveData newSaveData = SaveDataManager.getInstance().createNewSave(newSaveDifficulty);
        saveDataProvider.setSaveData(newSaveData);

        // Change into Arena
        stateChanger.setState(new ArenaState(ArenaBuilder.build(newSaveData)));
    }

    void quit(StateChanger stateChanger) throws IOException {
        stateChanger.setState(null);
    }

    @Override
    public void tick(StateChanger stateChanger, SaveDataProvider saveDataProvider) throws IOException, InterruptedException {
        Action action = GUI.getGUI().getAction();

        switch (action) {
            case LOOK_UP -> this.getModel().moveUp();
            case LOOK_DOWN -> this.getModel().moveDown();
            case EXEC -> this.executeOption(stateChanger, saveDataProvider);
            case ESC -> {
                SoundManager.getInstance().playSFX(SoundManager.SFX.MENU_GO_BACK);
                stateChanger.setState(new MenuState(new MainMenu(saveDataProvider)));
            }
            case QUIT -> this.quit(stateChanger);
            case null, default -> {
            }
        }
    }
}
