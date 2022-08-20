package com.sofka.domain.song.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class IsRecorded implements ValueObject<Boolean> {
    private final Boolean value;

    public IsRecorded(boolean value) {
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public Boolean value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IsRecorded that = (IsRecorded) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
