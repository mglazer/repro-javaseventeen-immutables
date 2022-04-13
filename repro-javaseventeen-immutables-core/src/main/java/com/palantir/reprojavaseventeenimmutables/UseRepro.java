/*
 * (c) Copyright 2022 Palantir Technologies Inc. All rights reserved.
 */

package com.palantir.reprojavaseventeenimmutables;

import org.immutables.value.Value;

@Value.Immutable
public interface UseRepro {
    ReproIssue issue();
}
