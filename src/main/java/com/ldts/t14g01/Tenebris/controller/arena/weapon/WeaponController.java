package com.ldts.t14g01.Tenebris.controller.arena.weapon;

import com.ldts.t14g01.Tenebris.model.arena._commands.CommandHandler;
import com.ldts.t14g01.Tenebris.model.arena.weapons.Weapon;
import com.ldts.t14g01.Tenebris.utils.Vector2D;

public abstract class WeaponController {
    protected final Weapon model;

    public WeaponController(Weapon model) {
        this.model = model;
    }

    public void update() {
        if (!this.model.isLoaded() && !this.model.isReloading()) this.reload();
        else this.model.tickWeaponTimer();

        if (this.model.isReloading()) {
            this.model.tickWeaponTimer();
            this.model.reload();
        }
    }

    public void reload() {
        this.model.startReload();
        this.playReloadSound();
    }

    protected abstract void playReloadSound();

    public abstract void shoot(CommandHandler commandHandler, Vector2D bulletPosition, Vector2D.Direction direction);
}