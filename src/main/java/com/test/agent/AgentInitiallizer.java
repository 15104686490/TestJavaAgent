package com.test.agent;

import net.bytebuddy.agent.builder.AgentBuilder;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.implementation.MethodDelegation;
import net.bytebuddy.utility.JavaModule;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.Instrumentation;
import java.security.ProtectionDomain;

import static net.bytebuddy.matcher.ElementMatchers.named;

public class AgentInitiallizer {

    static void init(String ops, Instrumentation instrumentation){
        addTestTransformer(instrumentation);


        new AgentBuilder.Default()
                .type(new AgentBuilder.RawMatcher() {
                    public boolean matches(TypeDescription typeDescription, ClassLoader classLoader,
                                           JavaModule module, Class<?> classBeingRedefined,
                                           ProtectionDomain protectionDomain) {
                        // 拦截指定的目标类
                        return typeDescription.getName().equals("com.time.test.test.VMTest");
                    }
                })
                .transform(new AgentBuilder.Transformer() {
                    public DynamicType.Builder<?> transform(DynamicType.Builder<?> builder, TypeDescription typeDescription, ClassLoader classLoader, JavaModule module) {
                        return builder.method(named("testMethod"))
                                .intercept(MethodDelegation.to(MyInterceptor.class));
                    }
                })
                .installOn(instrumentation);
        System.out.println("finish");
    }
    public static void addTestTransformer(Instrumentation instrumentation) {
        ClassFileTransformer testTransformer = new TestTransformer();
        instrumentation.addTransformer(testTransformer, true);
        System.out.println("add test transformer done");
    }
}
