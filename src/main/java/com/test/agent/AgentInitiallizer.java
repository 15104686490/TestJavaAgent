package com.test.agent;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.Instrumentation;

public class AgentInitiallizer {

    static void init(String ops, Instrumentation instrumentation){
        addTestTransformer(instrumentation);
    }
    public static void addTestTransformer(Instrumentation instrumentation) {
        ClassFileTransformer testTransformer = new TestTransformer();
        instrumentation.addTransformer(testTransformer, true);
        System.out.println("add test transformer done");
    }
}
