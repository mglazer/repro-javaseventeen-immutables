package com.palantir.reprojavaseventeenimmutables;

import org.immutables.value.Value;

@Value.Style(
        typeAbstract = "*Wrapper",
        typeImmutable = "*",
        visibility = Value.Style.ImplementationVisibility.PUBLIC,
        defaults = @Value.Immutable(builder = false, copy = false))
public @interface Wrapped {}
