package com.guava.test.jerry;

import com.google.common.base.Splitter;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.Map;
import java.util.regex.Pattern;

/**
 * Created by hesheng on 14-12-4.
 */
public class TestSpliter extends TestCase{
    /**
     * 将字符串转换成Map "11:12390,12:12356;13:12323,14:90876";
     *
     * key=11 value=12390
       key=12 value=12356
       key=13 value=12323
       key=14 value=90876
     *
     */
    @Test
    public void testSpliterToMap() {
        String pvids = "11:12390,12:12356;13:12323,14:90876";
        Map<String, String> split = Splitter.on(Pattern.compile("[,;]")).withKeyValueSeparator(":")
                .split(pvids);

        for (Map.Entry entry : split.entrySet()) {
            System.out.println("key=" + entry.getKey() + " value=" + entry.getValue());
        }
    }


}
