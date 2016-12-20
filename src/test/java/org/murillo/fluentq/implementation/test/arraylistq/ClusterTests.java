package org.murillo.fluentq.implementation.test.arraylistq;

import java.util.HashMap;
import java.util.Map;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.murillo.fluentq.impl.ArrayListQ;
import org.murillo.fluentq.ListQ;

public class ClusterTests {

    ListQ<String> list;

    @Before
    public void initList() {
        list = new ArrayListQ("a", "2", "!", "3", "e", "aa", "22", "!!", "33", "ee");
    }

    @Test
    public void cluster_happypath() {
        ListQ<ListQ<String>> cluster = list.cluster((a, b) -> a.charAt(0) == b.charAt(0));
        Assert.assertEquals(ArrayListQ.ofLists(new String[][]{{"a", "aa"}, {"2", "22"}, {"!", "!!"}, {"3", "33"}, {"e", "ee"}}), cluster);
    }

    @Test
    public void clusterEvery_happypath() {
        ListQ<ListQ<String>> cluster = list.clusterEvery(3);
        Assert.assertEquals(ArrayListQ.ofLists(new String[][]{{"a", "2", "!"}, {"3", "e", "aa"}, {"22", "!!", "33"}, {"ee"}}), cluster);
    }

}
