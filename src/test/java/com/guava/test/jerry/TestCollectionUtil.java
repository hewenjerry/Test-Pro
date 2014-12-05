package com.guava.test.jerry;

import com.google.common.collect.*;
import com.google.common.primitives.Ints;
import com.guava.test.jerry.model.GuavaObjectModel;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.Set;

/**
 * Created by hesheng on 14-12-4.
 */
public class TestCollectionUtil extends TestCase {

    /**
     * 相同的key分组{b=[2, 4, 6], c=[2, 5, 3], a=[4, 2, 1]}
     *
     * 并且可以按照key胡必须爆发排序
     */
    @Test
    public void testMultiListMapByGroup() {

        ListMultimap<String, Integer> multimap = ArrayListMultimap.create();
        multimap.putAll("b", Ints.asList(2, 4, 6));
        multimap.putAll("a", Ints.asList(4, 2, 1));
        multimap.putAll("e", Ints.asList(12, 5, 3));
        multimap.putAll("c", Ints.asList(2, 5, 3));

        System.out.println(TreeMultimap.create(multimap));

    }

    /**
     * 两个集合求交集并集差集
     */
    @Test
    public void testCollection() {
        Set<String> wordsWithPrimeLength = ImmutableSet.of("one", "two", "three", "six", "seven", "eight");
        Set<String> primes = ImmutableSet.of("two", "three", "five", "seven");

        Sets.SetView<String> intersection = Sets.intersection(primes,wordsWithPrimeLength);
        System.out.println(intersection.immutableCopy());//可以使用交集，但不可变拷贝的读取效率更高

        System.out.println(Sets.union(primes, wordsWithPrimeLength).immutableCopy());//并集


        System.out.println(Sets.difference(primes, wordsWithPrimeLength).immutableCopy());//只是返回wordsWithPrimeLength集合没有的元素

        System.out.println(Sets.symmetricDifference(primes, wordsWithPrimeLength).immutableCopy());//返回两个集合差集

        GuavaObjectModel guavaObjectModel1 = new GuavaObjectModel("hello1", "world1", "manager", GuavaObjectModel.Gender.FEMALE);
        GuavaObjectModel guavaObjectModel2 = new GuavaObjectModel("hello2", "world2", "manager", GuavaObjectModel.Gender.FEMALE);
        GuavaObjectModel guavaObjectModel3 = new GuavaObjectModel("hello3", "world3", "manager", GuavaObjectModel.Gender.FEMALE);
        GuavaObjectModel guavaObjectModel4 = new GuavaObjectModel("hello4", "world4", "manager", GuavaObjectModel.Gender.FEMALE);

        Set<GuavaObjectModel> setLefts = ImmutableSet.of(guavaObjectModel1, guavaObjectModel4, guavaObjectModel3);
        Set<GuavaObjectModel> setRights = ImmutableSet.of(guavaObjectModel1, guavaObjectModel2, guavaObjectModel3, guavaObjectModel4);

        System.out.println(Sets.difference(setRights, setLefts));
        System.out.println(Sets.symmetricDifference(setLefts, setRights));
    }
}
