package com.guava.test.jerry;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by hesheng on 14-12-4.
 */
public class TestJoin extends TestCase {
    @Test
    public void testJoin() {
        Joiner joiner = Joiner.on("; ").skipNulls();
        System.out.println(joiner.join("Harry", null, "Ron", "Hermione"));

        System.out.println(Joiner.on(":").join(Arrays.asList(1,5,6)));
    }
}
