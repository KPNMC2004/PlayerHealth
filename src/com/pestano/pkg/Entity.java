package com.pestano.pkg;

import com.pestano.pkg.health.Health;
import com.pestano.pkg.health.PlayerHealth;

public abstract class Entity {

    String name = "Joe";
    Weapon  weapon = null;

    public abstract void attack();

}
