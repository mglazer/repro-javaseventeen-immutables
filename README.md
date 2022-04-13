repro-javaseventeen-immutables
============

Reproduces an issue with Java 17 and immutables. The easiest way to validate this is changing:

```groovy
javaVersions {
    libraryTarget = 17
    runtime = 17
}
```

To:

```groovy
javaVersions {
    libraryTarget = 11
    runtime = 17
}
```

And seeing that it successfully builds with:

```shell
./gradlew compileJava
```

Switching back to a library target of 17 will fail.

The error is:

```shell
> Task :repro-javaseventeen-immutables-core:compileJava FAILED
Round 1:
	input files: {com.palantir.reprojavaseventeenimmutables.UseRepro, com.palantir.reprojavaseventeenimmutables.Wrapper, com.palantir.reprojavaseventeenimmutables.Wrapped, com.palantir.reprojavaseventeenimmutables.ReproIssueWrapper}
	annotations: [org.immutables.value.Value.Immutable, com.fasterxml.jackson.annotation.JsonValue, org.immutables.value.Value.Parameter, java.lang.Override, org.immutables.value.Value.Style, com.palantir.reprojavaseventeenimmutables.Wrapped]
	last round: false
Processor org.gradle.api.internal.tasks.compile.processing.TimeTrackingProcessor matches [/org.immutables.value.Value.Immutable] and returns false.
Processor org.gradle.api.internal.tasks.compile.processing.SupportedOptionsCollectingProcessor matches [/com.palantir.reprojavaseventeenimmutables.Wrapped, /com.fasterxml.jackson.annotation.JsonValue, java.base/java.lang.Override, /org.immutables.value.Value.Immutable, /org.immutables.value.Value.Parameter, /org.immutables.value.Value.Style] and returns false.
warning: Was unable to read source file for com.palantir.reprojavaseventeenimmutables.UseRepro[com.sun.tools.javac.code.Symbol$ClassSymbol.class]: java.io.FileNotFoundException: com/palantir/reprojavaseventeenimmutables/UseRepro.java
Round 2:
	input files: {com.palantir.reprojavaseventeenimmutables.ImmutableUseRepro, com.palantir.reprojavaseventeenimmutables.ReproIssue}
	annotations: [org.immutables.value.Generated, java.lang.SuppressWarnings, javax.annotation.ParametersAreNonnullByDefault, javax.annotation.processing.Generated, javax.annotation.concurrent.Immutable, javax.annotation.CheckReturnValue, javax.annotation.concurrent.NotThreadSafe, javax.annotation.Nullable, com.google.errorprone.annotations.CanIgnoreReturnValue, java.lang.Override]
	last round: false
warning: Was unable to read source file for com.palantir.reprojavaseventeenimmutables.UseRepro[com.sun.tools.javac.code.Symbol$ClassSymbol.class]: java.io.FileNotFoundException: com/palantir/reprojavaseventeenimmutables/UseRepro.java

Processor org.gradle.api.internal.tasks.compile.processing.TimeTrackingProcessor matches [] and returns false.
Processor org.gradle.api.internal.tasks.compile.processing.SupportedOptionsCollectingProcessor matches [/javax.annotation.concurrent.NotThreadSafe, /javax.annotation.Nullable, /com.google.errorprone.annotations.CanIgnoreReturnValue, /javax.annotation.CheckReturnValue, java.compiler/javax.annotation.processing.Generated, /javax.annotation.concurrent.Immutable, /org.immutables.value.Generated, java.base/java.lang.SuppressWarnings, java.base/java.lang.Override, /javax.annotation.ParametersAreNonnullByDefault] and returns false.
Round 3:
	input files: {}
	annotations: []
	last round: true
error: warnings found and -Werror specified
1 error
1 warning
error: warnings found and -Werror specified
```

