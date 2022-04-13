package com.palantir.reprojavaseventeenimmutables;

import com.fasterxml.jackson.annotation.JsonValue;
import org.immutables.value.Value;

public abstract class Wrapper<T> {
    @JsonValue
    @Value.Parameter
    abstract T value();

    @Override
    public final String toString() {
        return value().toString();
    }
}
