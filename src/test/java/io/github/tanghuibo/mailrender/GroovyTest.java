package io.github.tanghuibo.mailrender;

import groovy.lang.Binding;
import groovy.lang.GroovyShell;
import groovy.lang.Script;
import org.apache.commons.lang3.time.StopWatch;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.function.Function;

public class GroovyTest {
    static ThreadLocal<Integer> iLocal = new ThreadLocal<>();
    @Test
    public void test() throws IOException {
        String script = StaticTest.resourceAsString("/script/a.groovy");
        Binding bind = new Binding();
        bind.setProperty("a", 1);
        bind.setProperty("b", (Function<Integer, Integer>) a -> a + 1);
        GroovyShell groovyShell = new GroovyShell(bind);
        Script parse = groovyShell.parse(script);

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        for (int i = 0; i < 100000; i++) {
            iLocal.set(i);
            Assertions.assertEquals((Integer) parse.run(), i + 13);

        }
        stopWatch.stop();
        System.out.println(stopWatch.formatTime());
    }

    public static Integer getI() {
        return iLocal.get();
    }
}
