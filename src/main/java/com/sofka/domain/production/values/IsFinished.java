package com.sofka.domain.production.values;

import co.com.sofka.domain.generic.ValueObject;
import com.sofka.domain.song.values.IsRecorded;

import java.util.Objects;

public class IsFinished implements ValueObject<Boolean> {
    private final Boolean value;

    public IsFinished(boolean value) {
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
        IsFinished that = (IsFinished) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
