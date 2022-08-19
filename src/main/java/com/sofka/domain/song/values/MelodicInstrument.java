package com.sofka.domain.song.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class MelodicInstrument implements ValueObject<String> {

    private final String value;

    public MelodicInstrument(String value) {
        this.value = Objects.requireNonNull(value);
        if(this.value.isBlank()){
            throw new IllegalArgumentException("The VO melodic instrument can't be blank");
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
        MelodicInstrument that = (MelodicInstrument) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
