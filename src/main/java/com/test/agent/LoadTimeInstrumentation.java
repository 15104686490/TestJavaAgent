package com.test.agent;

import net.bytebuddy.agent.builder.AgentBuilder;
import net.bytebuddy.agent.builder.ResettableClassFileTransformer;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.implementation.MethodDelegation;
import net.bytebuddy.implementation.bind.annotation.Morph;
import net.bytebuddy.utility.JavaModule;


import java.lang.instrument.Instrumentation;

public class LoadTimeInstrumentation {
    public static ResettableClassFileTransformer instrument(String ops, Instrumentation instrumentation) {
        Finder finder = new Finder();
        ResettableClassFileTransformer resettableClassFileTransformer =
                new AgentBuilder.Default().type(finder.buildMatch()).transform(new AgentBuilder.Transformer() {
                    @Override
                    public DynamicType.Builder<?> transform(DynamicType.Builder<?> builder, TypeDescription typeDescription,
                                                            ClassLoader classLoader, JavaModule javaModule) {
                        //查找 finder中
                        return null;
                    }
                }).with(new LoadListener()).installOn(instrumentation);
        //Class.forName();
        MethodDelegation.withDefaultConfiguration();
        return null;

    }
}
