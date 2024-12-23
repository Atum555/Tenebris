package com.ldts.t14g01.Tenebris.model.arena.projectiles;

import com.ldts.t14g01.Tenebris.model.arena.GameElement;
import com.ldts.t14g01.Tenebris.model.arena._commands.Command;
import com.ldts.t14g01.Tenebris.model.arena._commands.CreateEffect;
import com.ldts.t14g01.Tenebris.model.arena._commands.ShakeCamera;
import com.ldts.t14g01.Tenebris.model.arena.effects.Explosion;
import com.ldts.t14g01.Tenebris.model.arena.interfaces.AbsorbsProjectiles;
import com.ldts.t14g01.Tenebris.sound.SoundManager;
import com.ldts.t14g01.Tenebris.utils.HitBox;
import com.ldts.t14g01.Tenebris.utils.Vector2D;
import com.ldts.t14g01.Tenebris.view.arena.projectiles.ExplosiveBulletView;

import java.util.List;

public class ExplosiveBullet extends Projectile {
    private static final HitBox HIT_BOX = new HitBox(new Vector2D(-4, -4), new Vector2D(6, 6));
    private static final int VELOCITY = 4;
    private static final int EXPLOSION_DAMAGE = 15;

    public ExplosiveBullet(Vector2D position, Vector2D.Direction direction) {
        super(position, HIT_BOX, direction, VELOCITY, 0);
        this.view = new ExplosiveBulletView(this);
    }

    @Override
    public List<Command> interact(GameElement other) {
        List<Command> commands = super.interact(other);

        if (other instanceof AbsorbsProjectiles) {
            commands.add(new CreateEffect(new Explosion(this.position, EXPLOSION_DAMAGE)));
            commands.add(new ShakeCamera());
            SoundManager.getInstance().playSFX(SoundManager.SFX.EXPLOSION);
        }

        return commands;
    }
}
