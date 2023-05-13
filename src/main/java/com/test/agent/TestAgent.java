package com.test.agent;

import java.lang.instrument.Instrumentation;

public class TestAgent {
    public static void premain(String agentOps, final Instrumentation instrumentation) throws Throwable {
        long preTime = System.currentTimeMillis();
        System.out.println("pre start time : " + preTime);
        AgentInitiallizer.init(agentOps, instrumentation);
        long endTime = System.currentTimeMillis();
        long costTime = endTime - preTime;
        System.out.println("pre end: " + endTime + " cost time :" + costTime);
    }
}
