package com.guava.test.jerry;

import com.google.common.base.Function;
import com.google.common.collect.*;
import com.guava.test.jerry.model.AppVer;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.*;

/**
 * Created by hesheng on 14-12-4.
 */
public class TestMapUtil extends TestCase {


    @Test
    public void testMapDifferent() {
        AppVer appVer1 = AppVer.of("1.2.1");
        AppVer appVer5 = AppVer.of("5.5.1");
        AppVer appVer2 = AppVer.of("1.2.7");
        AppVer appVer3 = AppVer.of("1.3.6");
        AppVer appVer4 = AppVer.of("1.5.1");

        Map<String, AppVer> map1 = Maps.newHashMapWithExpectedSize(3);
        map1.put("map1_key1", appVer1);
        map1.put("map1_key2", appVer2);
        map1.put("commonKey", appVer5);

        Map<String, AppVer> map2 = Maps.newHashMapWithExpectedSize(4);
        map2.put("map2_key1", appVer1);
        map2.put("map2_key2",appVer3);
        map2.put("map2_key3",appVer4);
        map2.put("commonKey", appVer5);

        MapDifference<String, AppVer> different = Maps.difference(map1, map2);
        System.out.println("key与value相同的map集合:" + different.entriesInCommon());

        System.out.println("Map1比较Map2集合不一样的entry的集合:" + different.entriesOnlyOnLeft());
        System.out.println("Map2比较Map1集合不一样的entry的集合:" + different.entriesOnlyOnRight());
    }

    /**
     * 有一组对象，它们有共同的特定属性，我们希望按照这个属性的值查询对象，但属性值不一定是独一无二的。
     * {4=[zero, four, five, nine], 3=[one, two, six], 5=[three, seven, eight]}
     *
     */
    @Test
    public void testMergeSet() {
        ImmutableSet digits = ImmutableSet.of("zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine");
        Function<String, Integer> lengthFunction = new Function<String, Integer>() {
            public Integer apply(String string) {
                return string.length();
            }
        };

        ImmutableListMultimap<Integer, String> digitsByLength= Multimaps.index(digits, lengthFunction);
        System.out.println(digitsByLength);


    }


}
