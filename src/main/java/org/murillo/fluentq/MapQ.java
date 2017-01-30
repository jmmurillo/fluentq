/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.murillo.fluentq;

import java.util.Map;

public interface MapQ<K, V> extends Map<K, V>{
    
    ListQ<Map.Entry<K, V>> toListQ();
    
}
