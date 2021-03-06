/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.murillo.fluentq;

public interface EphemeralListQ<T> extends CommonListQ<T, ListQ<T>, EphemeralListQ<T>>, java.io.Serializable {

    @Override
    default boolean isDurable() {
        return false;
    }

    @Override
    default boolean isEphemeral() {
        return true;
    }

    ListQ<T> hold();
    
}
