package com.guava.test.jerry;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.guava.test.jerry.model.AppVer;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.*;

/**
 * Created by hesheng on 14-12-4.
 */
public class TestObjectOrder extends TestCase {

    /**
     * AppVer对象降序排序，排序的规则是1.2.1
     * [5.5.1, 1.5.1, 1.3.6, 1.2.1, 1.2.1]
     */
    @Test
    public void testObjectByOrder() {
        AppVer appVer1 = AppVer.of("1.2.1");
        AppVer appVer5 = AppVer.of("5.5.1");
        AppVer appVer2 = AppVer.of("1.2.7");
        AppVer appVer3 = AppVer.of("1.3.6");
        AppVer appVer4 = AppVer.of("1.5.1");


        List<AppVer> appVerList = new ArrayList<AppVer>();
        appVerList.add(appVer1);
        appVerList.add(appVer2);
        appVerList.add(appVer3);
        appVerList.add(appVer4);
        appVerList.add(appVer5);
        Collections.sort(appVerList);

        System.out.println(Arrays.toString(appVerList.toArray()));
        System.out.println(Lists.reverse(appVerList));
    }

    /**
     * 按照key的顺序降序排序
     */
    @Test
    public void testMapOrderByKey() {
        SortedMap<String, AppVer> sortedMap = Maps.newTreeMap(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return AppVer.of(o1).compareTo(AppVer.of(o2));
            }
        });

        AppVer appVer1 = AppVer.of("1.2.1");
        AppVer appVer5 = AppVer.of("5.5.1");
        AppVer appVer2 = AppVer.of("1.2.7");
        AppVer appVer3 = AppVer.of("1.3.6");
        AppVer appVer4 = AppVer.of("1.5.1");

        sortedMap.put("1.2.1", appVer1);
        sortedMap.put("5.5.1", appVer5);
        sortedMap.put("1.2.7", appVer2);
        sortedMap.put("1.3.6", appVer3);
        sortedMap.put("1.5.1", appVer4);

        for (Map.Entry entry : sortedMap.entrySet()) {
            System.out.println("key=" + entry.getKey() + " value=" + entry.getValue());
        }


    }
}
