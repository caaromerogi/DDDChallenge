package com.sofka.domain.production.values;

import co.com.sofka.domain.generic.ValueObject;
import com.sofka.domain.song.values.PercussionInstrument;

import java.util.Objects;

public class Sign implements ValueObject<String> {

    private final String value;

    public Sign(String value){
        this.value = Objects.requireNonNull(value);
        if(this.value.isBlank()){
            throw new IllegalArgumentException("The VO sign can't be blank");
        }
    }

    @Override
    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sign that = (Sign) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
