package com.guava.test.jerry;

import com.guava.test.jerry.model.GuavaObjectModel;
import org.junit.Test;

/**
 * Created by hesheng on 14-12-5.
 */
public class TestObjectCommonMethod {
    @Test
    public void test() {
        GuavaObjectModel model = new GuavaObjectModel("he", "wen", "senior manager", GuavaObjectModel.Gender.FEMALE);
        System.out.println(model);
    }
}


