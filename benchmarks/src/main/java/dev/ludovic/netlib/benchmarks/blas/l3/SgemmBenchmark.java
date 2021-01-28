/*
 * Copyright (c) Ludovic Henry. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation. Ludovic Henry designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Ludovic Henry in the LICENSE file that accompanied this code.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact hi@ludovic.dev or visit ludovic.dev if you need additional
 * information or have any questions.
 */

package dev.ludovic.netlib.benchmarks.blas.l3;

import dev.ludovic.netlib.benchmarks.blas.BLASBenchmark;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

@State(Scope.Thread)
public class SgemmBenchmark extends BLASBenchmark {

    @Param({"N", "T"})
    public String transa;
    @Param({"N", "T"})
    public String transb;

    @Param({"10", "1000"})
    public int m;
    @Param({"10", "1000"})
    public int n;
    @Param({"10", "1000"})
    public int k;

    public float alpha;
    public float[] a;
    public int lda;
    public float[] b;
    public int ldb;
    public float beta;
    public float[] c, cclone;
    public int ldc;

    @Setup(Level.Trial)
    public void setup() {
        alpha = randomFloat();
        a = randomFloatArray(k * m);
        b = randomFloatArray(k * n);
        beta = randomFloat();
        c = randomFloatArray(m * n);
    }

    @Setup(Level.Invocation)
    public void setupIteration() {
        cclone = c.clone();
    }

    @Benchmark
    public void blas(Blackhole bh) {
        blas.sgemm(transa, transb, m, n, k, alpha, a, transa.equals("N") ? m : k, b, transb.equals("N") ? k : n, beta, cclone, m);
        bh.consume(cclone);
    }
}
