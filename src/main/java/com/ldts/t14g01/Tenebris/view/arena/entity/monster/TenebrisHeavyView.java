package com.ldts.t14g01.Tenebris.view.arena.entity.monster;

import com.ldts.t14g01.Tenebris.gui.GUI;
import com.ldts.t14g01.Tenebris.model.arena.entity.monster.TenebrisHeavy;
import com.ldts.t14g01.Tenebris.view.arena.entity.EntityView;

public class TenebrisHeavyView extends EntityView<TenebrisHeavy> {
    public TenebrisHeavyView(TenebrisHeavy model) {
        super(model);
    }

    @Override
    public void draw() {
        this.updateState();
        this.tickState();
        GUI.getGUI().drawMonster(
                this.model.getPosition(),
                GUI.Monster.TENEBRIS_HEAVY,
                this.state
        );
    }
}
