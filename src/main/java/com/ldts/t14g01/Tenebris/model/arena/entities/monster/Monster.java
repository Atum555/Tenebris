package com.ldts.t14g01.Tenebris.model.arena.entities.monster;

import com.ldts.t14g01.Tenebris.controller.arena.monster.MonsterController;
import com.ldts.t14g01.Tenebris.model.arena.GameElement;
import com.ldts.t14g01.Tenebris.model.arena._commands.Command;
import com.ldts.t14g01.Tenebris.model.arena._commands.DeleteMonster;
import com.ldts.t14g01.Tenebris.model.arena.entities.Entity;
import com.ldts.t14g01.Tenebris.model.arena.interfaces.DamagesPlayer;
import com.ldts.t14g01.Tenebris.utils.HitBox;
import com.ldts.t14g01.Tenebris.utils.Vector2D;

import java.util.List;

public abstract class Monster extends Entity implements DamagesPlayer {
    protected MonsterController controller;
    private final int visionRange;
    private final int damage;

    public Monster(Vector2D position, HitBox hitBoX, int hp, int velocity, int damage, int visionRange) {
        super(position, hitBoX, hp, velocity);
        this.controller = null;
        this.visionRange = visionRange;
        this.damage = damage;
    }

    public MonsterController getController() {
        return this.controller;
    }

    public int getVisionRange() {
        return this.visionRange;
    }

    @Override
    public int getPlayerDamage() {
        return this.damage;
    }

    @Override
    public List<Command> interact(GameElement other) {
        // Execute Entity interactions
        List<Command> commands = super.interact(other);

        if (!this.isAlive()) commands.add(new DeleteMonster(this));

        return commands;
    }
}
