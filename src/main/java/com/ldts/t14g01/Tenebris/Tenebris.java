package com.ldts.t14g01.Tenebris;

import com.googlecode.lanterna.screen.Screen;
import com.ldts.t14g01.Tenebris.screen.ScreenGetter;
import com.ldts.t14g01.Tenebris.screen.ScreenManager;
import com.ldts.t14g01.Tenebris.screen.ScreenRelaunchHandler;

import java.io.IOException;

public class Tenebris implements ScreenRelaunchHandler, ScreenGetter {
    private Screen screen;
    private final State state;

    public static void main(String[] args) throws IOException, InterruptedException {
        Tenebris tenebris = new Tenebris();
        tenebris.run();
    }

    Tenebris() throws IOException {
        // Init game state
        this.state = State.initState();
        ScreenManager.setScreenRelaunchHandler(this);
    }

    public void run() throws IOException, InterruptedException {
        if (this.state.isInMenu()) {
            this.screen = ScreenManager.newScreen(ScreenManager.MAIN_MENU);
            this.state.runMenu(this);
        }
    }

    // Receives new screen when it is relaunched
    public void screenRelaunchHandler(Screen screen) {
        this.screen = screen;
    }

    public Screen getScreen() {
        return this.screen;
    }
}
