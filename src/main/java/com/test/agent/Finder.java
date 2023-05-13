package com.test.agent;

import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.matcher.ElementMatcher;

import java.util.Map;

import static net.bytebuddy.matcher.ElementMatchers.isInterface;
import static net.bytebuddy.matcher.ElementMatchers.not;

public class Finder {

    //private static final Map<String, >

    public ElementMatcher<? super TypeDescription> buildMatch(){
        /*ElementMatcher.Junction judge = (ElementMatcher.Junction.Conjunction)(target) ->{
            return true;
        };*/
        ElementMatcher.Junction judge = new ElementMatcher.Junction.Conjunction<>();
        judge.and(not(isInterface()));
        return judge;
    }
}
