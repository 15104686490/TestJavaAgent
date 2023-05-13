package com.test.agent;

import net.bytebuddy.matcher.ElementMatcher;

public abstract class JunctionImpl<V> implements ElementMatcher.Junction<V> {
    @Override
    public Junction and(ElementMatcher elementMatcher) {
        new Conjunction<>();
        return null;
    }

    @Override
    public Junction or(ElementMatcher elementMatcher) {
        return null;
    }

    @Override
    public boolean matches(Object o) {
        return false;
    }
}
