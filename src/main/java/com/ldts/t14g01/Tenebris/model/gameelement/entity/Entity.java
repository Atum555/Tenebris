package com.ldts.t14g01.Tenebris.model.gameelement.entity;

import com.ldts.t14g01.Tenebris.model.gameelement.GameElement;
import com.ldts.t14g01.Tenebris.utils.Position;

public class Entity extends GameElement {
    private int hp;
    private int maxHp;
    private double energy;
    private double maxEnergy;
    private Position moveSpeed;

    public Entity(int x, int y, int maxHp, double maxEnergy) {
        super(x, y);
        this.maxHp = maxHp;
        this.hp = maxHp;
        this.maxEnergy = maxEnergy;
        this.energy = maxEnergy;
        this.moveSpeed = new Position(0, 0);

    }

    public double getEnergy() {
        return energy;
    }

    public int getHp() {
        return hp;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public double getMaxEnergy() {
        return maxEnergy;
    }

    public Position getMoveSpeed() {
        return moveSpeed;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    public void setEnergy(double energy) {
        this.energy = energy;
    }

    public void setMaxEnergy(double maxEnergy) {
        this.maxEnergy = maxEnergy;
    }

    public void setMoveSpeed(Position moveSpeed) {
        this.moveSpeed = moveSpeed;
    }

    public boolean isAlive() {
        return hp > 0;
    }

    public Position updatePosition() {
        return new Position(
                this.getPosition().x() + moveSpeed.x(),
                this.getPosition().y() + moveSpeed.y());
    }
}