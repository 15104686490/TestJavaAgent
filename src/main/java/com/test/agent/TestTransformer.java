package com.test.agent;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;

public class TestTransformer implements ClassFileTransformer {

    @Override
    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
        long transTime = System.currentTimeMillis();
        if(className.equals("com/time/test/test/ByteTest")){
            System.out.println(loader.toString());
        }
        return new byte[0];
    }
}
