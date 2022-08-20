package com.sofka.domain.production;

import co.com.sofka.domain.generic.Entity;
import com.sofka.domain.generics.Name;
import com.sofka.domain.production.values.*;

import java.util.Objects;

public class Producer extends Entity<ProducerId> {
    private Name name;
    private Sign sign;


    public Producer(ProducerId entityId, Name name, Sign sign) {
        super(entityId);
        this.name = name;
        this.sign = sign;
    }

    public void updateName(Name name){
        this.name = Objects.requireNonNull(name);
    }

    public void changeSign(Sign sign){
        this.sign = Objects.requireNonNull(sign);
    }

    public Name name() {
        return name;
    }

    public Sign sign() {
        return sign;
    }
}
