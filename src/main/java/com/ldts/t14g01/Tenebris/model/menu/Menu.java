package com.ldts.t14g01.Tenebris.model.menu;

import com.ldts.t14g01.Tenebris.controller.Controller;
import com.ldts.t14g01.Tenebris.sound.SoundManager;
import com.ldts.t14g01.Tenebris.view.View;

import java.util.ArrayList;
import java.util.List;

public abstract class Menu {
    protected List<String> options;
    protected int selectedOption;

    protected Menu() {
        this.options = new ArrayList<>();
        selectedOption = 0;
    }

    public void moveUp() {
        if (this.options.isEmpty()) return;
        this.selectedOption += this.options.size() - 1;
        this.selectedOption %= this.options.size();
        SoundManager.getInstance().playSFX(SoundManager.SFX.MENU_SWITCH);
    }

    public void moveDown() {
        if (this.options.isEmpty()) return;
        this.selectedOption++;
        this.selectedOption %= this.options.size();
        SoundManager.getInstance().playSFX(SoundManager.SFX.MENU_SWITCH);
    }

    public int getSelectedOption() {
        return selectedOption;
    }

    public void setSelectedOption(int selectedOption) {
        this.selectedOption = selectedOption % this.options.size();
    }

    public List<String> getOptions() {
        return options;
    }

    public abstract View<Menu> getView();

    public abstract Controller<Menu> getController();
}
