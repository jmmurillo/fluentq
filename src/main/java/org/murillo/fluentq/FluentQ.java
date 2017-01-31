package org.murillo.fluentq;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import org.murillo.fluentq.utils.func.*;

public interface FluentQ<A, Z> {

    default <R> R extend(Function<A, R> func) {
        return func.apply(this.insideIdentity());
    }

    default <B, R> R extend(BiFunction<A, B, R> func, B param) {
        return func.apply(this.insideIdentity(), param);
    }

    default <B, C, R> R extend(
            Func3<A, B, C, R> func,
            B b, C c) {
        return func.apply(this.insideIdentity(), b, c);
    }

    default <B, C, D, R> R extend(
            Func4<A, B, C, D, R> func,
            B b, C c, D d) {
        return func.apply(this.insideIdentity(), b, c, d);
    }

    default <B, C, D, E, R> R extend(
            Func5<A, B, C, D, E, R> func,
            B b, C c, D d, E e) {
        return func.apply(this.insideIdentity(), b, c, d, e);
    }

    default <B, C, D, E, F, R> R extend(
            Func6<A, B, C, D, E, F, R> func,
            B b, C c, D d, E e, F f) {
        return func.apply(this.insideIdentity(), b, c, d, e, f);
    }

    default <B, C, D, E, F, G, R> R extend(
            Func7<A, B, C, D, E, F, G, R> func,
            B b, C c, D d, E e, F f, G g) {
        return func.apply(this.insideIdentity(), b, c, d, e, f, g);
    }

    default <B, C, D, E, F, G, H, R> R extend(
            Func8<A, B, C, D, E, F, G, H, R> func,
            B b, C c, D d, E e, F f, G g, H h) {
        return func.apply(this.insideIdentity(), b, c, d, e, f, g, h);
    }

    default <B, C, D, E, F, G, H, I, R> R extend(
            Func9<A, B, C, D, E, F, G, H, I, R> func,
            B b, C c, D d, E e, F f, G g, H h, I i) {
        return func.apply(this.insideIdentity(), b, c, d, e, f, g, h, i);
    }

    default <B, C, D, E, F, G, H, I, J, R> R extend(
            Func10<A, B, C, D, E, F, G, H, I, J, R> func,
            B b, C c, D d, E e, F f, G g, H h, I i, J j) {
        return func.apply(this.insideIdentity(), b, c, d, e, f, g, h, i, j);
    }

    default <B, C, D, E, F, G, H, I, J, K, R> R extend(
            Func11<A, B, C, D, E, F, G, H, I, J, K, R> func,
            B b, C c, D d, E e, F f, G g, H h, I i, J j, K k) {
        return func.apply(this.insideIdentity(), b, c, d, e, f, g, h, i, j, k);
    }

    default <B, C, D, E, F, G, H, I, J, K, L, R> R extend(
            Func12<A, B, C, D, E, F, G, H, I, J, K, L, R> func,
            B b, C c, D d, E e, F f, G g, H h, I i, J j, K k, L l) {
        return func.apply(this.insideIdentity(), b, c, d, e, f, g, h, i, j, k, l);
    }

    default <B, C, D, E, F, G, H, I, J, K, L, M, R> R extend(
            Func13<A, B, C, D, E, F, G, H, I, J, K, L, M, R> func,
            B b, C c, D d, E e, F f, G g, H h, I i, J j, K k, L l, M m) {
        return func.apply(this.insideIdentity(), b, c, d, e, f, g, h, i, j, k, l, m);
    }

    default <B, C, D, E, F, G, H, I, J, K, L, M, N, R> R extend(
            Func14<A, B, C, D, E, F, G, H, I, J, K, L, M, N, R> func,
            B b, C c, D d, E e, F f, G g, H h, I i, J j, K k, L l, M m, N n) {
        return func.apply(this.insideIdentity(), b, c, d, e, f, g, h, i, j, k, l, m, n);
    }

    default <B, C, D, E, F, G, H, I, J, K, L, M, N, O, R> R extend(
            Func15<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, R> func,
            B b, C c, D d, E e, F f, G g, H h, I i, J j, K k, L l, M m, N n, O o) {
        return func.apply(this.insideIdentity(), b, c, d, e, f, g, h, i, j, k, l, m, n, o);
    }

    default <B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, R> R extend(
            Func16<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, R> func,
            B b, C c, D d, E e, F f, G g, H h, I i, J j, K k, L l, M m, N n, O o, P p) {
        return func.apply(this.insideIdentity(), b, c, d, e, f, g, h, i, j, k, l, m, n, o, p);
    }

    default Z aside(Consumer<A> action) {
        action.accept(this.insideIdentity());
        return this.outsideIdentity();
    }

    default <B> Z aside(BiConsumer<A, B> action, B param) {
        action.accept(this.insideIdentity(), param);
        return this.outsideIdentity();
    }

    default <B, C> Z aside(
            Action3<A, B, C> action,
            B b, C c) {
        action.accept(this.insideIdentity(), b, c);
        return this.outsideIdentity();
    }

    default <B, C, D> Z aside(
            Action4<A, B, C, D> action,
            B b, C c, D d) {
        action.accept(this.insideIdentity(), b, c, d);
        return this.outsideIdentity();
    }

    default <B, C, D, E> Z aside(
            Action5<A, B, C, D, E> action,
            B b, C c, D d, E e) {
        action.accept(this.insideIdentity(), b, c, d, e);
        return this.outsideIdentity();
    }

    default <B, C, D, E, F> Z aside(
            Action6<A, B, C, D, E, F> action,
            B b, C c, D d, E e, F f) {
        action.accept(this.insideIdentity(), b, c, d, e, f);
        return this.outsideIdentity();
    }

    default <B, C, D, E, F, G> Z aside(
            Action7<A, B, C, D, E, F, G> action,
            B b, C c, D d, E e, F f, G g) {
        action.accept(this.insideIdentity(), b, c, d, e, f, g);
        return this.outsideIdentity();
    }

    default <B, C, D, E, F, G, H> Z aside(
            Action8<A, B, C, D, E, F, G, H> action,
            B b, C c, D d, E e, F f, G g, H h) {
        action.accept(this.insideIdentity(), b, c, d, e, f, g, h);
        return this.outsideIdentity();
    }

    default <B, C, D, E, F, G, H, I> Z aside(
            Action9<A, B, C, D, E, F, G, H, I> action,
            B b, C c, D d, E e, F f, G g, H h, I i) {
        action.accept(this.insideIdentity(), b, c, d, e, f, g, h, i);
        return this.outsideIdentity();
    }

    default <B, C, D, E, F, G, H, I, J> Z aside(
            Action10<A, B, C, D, E, F, G, H, I, J> action,
            B b, C c, D d, E e, F f, G g, H h, I i, J j) {
        action.accept(this.insideIdentity(), b, c, d, e, f, g, h, i, j);
        return this.outsideIdentity();
    }

    default <B, C, D, E, F, G, H, I, J, K> Z aside(
            Action11<A, B, C, D, E, F, G, H, I, J, K> action,
            B b, C c, D d, E e, F f, G g, H h, I i, J j, K k) {
        action.accept(this.insideIdentity(), b, c, d, e, f, g, h, i, j, k);
        return this.outsideIdentity();
    }

    default <B, C, D, E, F, G, H, I, J, K, L> Z aside(
            Action12<A, B, C, D, E, F, G, H, I, J, K, L> action,
            B b, C c, D d, E e, F f, G g, H h, I i, J j, K k, L l) {
        action.accept(this.insideIdentity(), b, c, d, e, f, g, h, i, j, k, l);
        return this.outsideIdentity();
    }

    default <B, C, D, E, F, G, H, I, J, K, L, M> Z aside(
            Action13<A, B, C, D, E, F, G, H, I, J, K, L, M> action,
            B b, C c, D d, E e, F f, G g, H h, I i, J j, K k, L l, M m) {
        action.accept(this.insideIdentity(), b, c, d, e, f, g, h, i, j, k, l, m);
        return this.outsideIdentity();
    }

    default <B, C, D, E, F, G, H, I, J, K, L, M, N> Z aside(
            Action14<A, B, C, D, E, F, G, H, I, J, K, L, M, N> action,
            B b, C c, D d, E e, F f, G g, H h, I i, J j, K k, L l, M m, N n) {
        action.accept(this.insideIdentity(), b, c, d, e, f, g, h, i, j, k, l, m, n);
        return this.outsideIdentity();
    }

    default <B, C, D, E, F, G, H, I, J, K, L, M, N, O> Z aside(
            Action15<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O> action,
            B b, C c, D d, E e, F f, G g, H h, I i, J j, K k, L l, M m, N n, O o) {
        action.accept(this.insideIdentity(), b, c, d, e, f, g, h, i, j, k, l, m, n, o);
        return this.outsideIdentity();
    }

    default <B, C, D, E, F, G, H, I, J, K, L, M, N, O, P> Z aside(
            Action16<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P> action,
            B b, C c, D d, E e, F f, G g, H h, I i, J j, K k, L l, M m, N n, O o, P p) {
        action.accept(this.insideIdentity(), b, c, d, e, f, g, h, i, j, k, l, m, n, o, p);
        return this.outsideIdentity();
    }

    default A insideIdentity() {
        return ((A) this);
    }
    
    default Z outsideIdentity() {
        return ((Z) this);
    }   
    
}
