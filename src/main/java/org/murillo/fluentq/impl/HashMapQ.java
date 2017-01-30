/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.murillo.fluentq.impl;

import java.util.HashMap;
import org.murillo.fluentq.FluentQ;
import org.murillo.fluentq.ListQ;
import org.murillo.fluentq.MapQ;

public class HashMapQ<K, V> extends HashMap<K, V> implements MapQ<K, V>, FluentQ<MapQ<K, V>, MapQ<K, V>>{

    @Override
    public ListQ<Entry<K, V>> toListQ() {
        return ArrayListQ.ofEntries(this);
    }
    
}
