package org.murillo.fluentq;

import java.util.function.BiFunction;
import java.util.function.Function;
import org.murillo.fluentq.utils.func.*;

public interface FluentQ<A> {

    default <R> R flow(Function<A, R> func) {
        return func.apply(this.flowIdentity());
    }

    default <B, R> R flow(BiFunction<A, B, R> func, B param) {
        return func.apply(this.flowIdentity(), param);
    }

    default <B, C, R> R flow(
            Func3<A, B, C, R> func,
            B b, C c) {
        return func.apply(this.flowIdentity(), b, c);
    }

    default <B, C, D, R> R flow(
            Func4<A, B, C, D, R> func,
            B b, C c, D d) {
        return func.apply(this.flowIdentity(), b, c, d);
    }

    default <B, C, D, E, R> R flow(
            Func5<A, B, C, D, E, R> func,
            B b, C c, D d, E e) {
        return func.apply(this.flowIdentity(), b, c, d, e);
    }

    default <B, C, D, E, F, R> R flow(
            Func6<A, B, C, D, E, F, R> func,
            B b, C c, D d, E e, F f) {
        return func.apply(this.flowIdentity(), b, c, d, e, f);
    }

    default <B, C, D, E, F, G, R> R flow(
            Func7<A, B, C, D, E, F, G, R> func,
            B b, C c, D d, E e, F f, G g) {
        return func.apply(this.flowIdentity(), b, c, d, e, f, g);
    }

    default <B, C, D, E, F, G, H, R> R flow(
            Func8<A, B, C, D, E, F, G, H, R> func,
            B b, C c, D d, E e, F f, G g, H h) {
        return func.apply(this.flowIdentity(), b, c, d, e, f, g, h);
    }

    default <B, C, D, E, F, G, H, I, R> R flow(
            Func9<A, B, C, D, E, F, G, H, I, R> func,
            B b, C c, D d, E e, F f, G g, H h, I i) {
        return func.apply(this.flowIdentity(), b, c, d, e, f, g, h, i);
    }

    default <B, C, D, E, F, G, H, I, J, R> R flow(
            Func10<A, B, C, D, E, F, G, H, I, J, R> func,
            B b, C c, D d, E e, F f, G g, H h, I i, J j) {
        return func.apply(this.flowIdentity(), b, c, d, e, f, g, h, i, j);
    }

    default <B, C, D, E, F, G, H, I, J, K, R> R flow(
            Func11<A, B, C, D, E, F, G, H, I, J, K, R> func,
            B b, C c, D d, E e, F f, G g, H h, I i, J j, K k) {
        return func.apply(this.flowIdentity(), b, c, d, e, f, g, h, i, j, k);
    }

    default <B, C, D, E, F, G, H, I, J, K, L, R> R flow(
            Func12<A, B, C, D, E, F, G, H, I, J, K, L,R> func,
            B b, C c, D d, E e, F f, G g, H h, I i, J j, K k, L l) {
        return func.apply(this.flowIdentity(), b, c, d, e, f, g, h, i, j, k, l);
    }

        default <B, C, D, E, F, G, H, I, J, K, L, M, R> R flow(
            Func13<A, B, C, D, E, F, G, H, I, J, K, L, M, R> func,
            B b, C c, D d, E e, F f, G g, H h, I i, J j, K k, L l, M m) {
        return func.apply(this.flowIdentity(), b, c, d, e, f, g, h, i, j, k, l, m);
    }
    
    default <B, C, D, E, F, G, H, I, J, K, L, M, N, R> R flow(
            Func14<A, B, C, D, E, F, G, H, I, J, K, L, M, N, R> func,
            B b, C c, D d, E e, F f, G g, H h, I i, J j, K k, L l, M m, N n) {
        return func.apply(this.flowIdentity(), b, c, d, e, f, g, h, i, j, k, l, m, n);
    }

    default <B, C, D, E, F, G, H, I, J, K, L, M, N, O, R> R flow(
            Func15<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, R> func,
            B b, C c, D d, E e, F f, G g, H h, I i, J j, K k, L l, M m, N n, O o) {
        return func.apply(this.flowIdentity(), b, c, d, e, f, g, h, i, j, k, l, m, n, o);
    }

    default <B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, R> R flow(
            Func16<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, R> func,
            B b, C c, D d, E e, F f, G g, H h, I i, J j, K k, L l, M m, N n, O o, P p) {
        return func.apply(this.flowIdentity(), b, c, d, e, f, g, h, i, j, k, l, m, n, o, p);
    }

    default A flowIdentity() {
        return ((A) this);
    }
}
