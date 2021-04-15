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

import dev.ludovic.netlib.BLAS;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.api.Assertions.*;

public class SsymvTest extends BLASTest {

    @ParameterizedTest
    @MethodSource("BLASImplementations")
    void testSanity(String blas) {
        float[] expected, sYcopy;

        f2j.ssymv("U", M,  1.0f, ssyA, M, sX, 1,  1.0f, expected = sY.clone(), 1);
        getImpl(blas).ssymv("U", M,  1.0f, ssyA, M, sX, 1,  1.0f, sYcopy = sY.clone(), 1);
        assertArrayEquals(expected, sYcopy, sepsilon);

        f2j.ssymv("U", M,  0.5f, ssyA, M, sX, 1,  1.0f, expected = sY.clone(), 1);
        getImpl(blas).ssymv("U", M,  0.5f, ssyA, M, sX, 1,  1.0f, sYcopy = sY.clone(), 1);
        assertArrayEquals(expected, sYcopy, sepsilon);

        f2j.ssymv("U", M, -0.5f, ssyA, M, sX, 1,  1.0f, expected = sY.clone(), 1);
        getImpl(blas).ssymv("U", M, -0.5f, ssyA, M, sX, 1,  1.0f, sYcopy = sY.clone(), 1);
        assertArrayEquals(expected, sYcopy, sepsilon);

        f2j.ssymv("U", M,  0.0f, ssyA, M, sX, 1,  1.0f, expected = sY.clone(), 1);
        getImpl(blas).ssymv("U", M,  0.0f, ssyA, M, sX, 1,  1.0f, sYcopy = sY.clone(), 1);
        assertArrayEquals(expected, sYcopy, sepsilon);

        f2j.ssymv("U", M,  1.0f, ssyA, M, sX, 1,  0.5f, expected = sY.clone(), 1);
        getImpl(blas).ssymv("U", M,  1.0f, ssyA, M, sX, 1,  0.5f, sYcopy = sY.clone(), 1);
        assertArrayEquals(expected, sYcopy, sepsilon);

        f2j.ssymv("U", M,  1.0f, ssyA, M, sX, 1, -0.5f, expected = sY.clone(), 1);
        getImpl(blas).ssymv("U", M,  1.0f, ssyA, M, sX, 1, -0.5f, sYcopy = sY.clone(), 1);
        assertArrayEquals(expected, sYcopy, sepsilon);

        f2j.ssymv("U", M,  1.0f, ssyA, M, sX, 1,  0.0f, expected = sY.clone(), 1);
        getImpl(blas).ssymv("U", M,  1.0f, ssyA, M, sX, 1,  0.0f, sYcopy = sY.clone(), 1);
        assertArrayEquals(expected, sYcopy, sepsilon);

        f2j.ssymv("L", M,  1.0f, ssyA, M, sX, 1,  1.0f, expected = sY.clone(), 1);
        getImpl(blas).ssymv("L", M,  1.0f, ssyA, M, sX, 1,  1.0f, sYcopy = sY.clone(), 1);
        assertArrayEquals(expected, sYcopy, sepsilon);

        f2j.ssymv("L", M,  0.5f, ssyA, M, sX, 1,  1.0f, expected = sY.clone(), 1);
        getImpl(blas).ssymv("L", M,  0.5f, ssyA, M, sX, 1,  1.0f, sYcopy = sY.clone(), 1);
        assertArrayEquals(expected, sYcopy, sepsilon);

        f2j.ssymv("L", M, -0.5f, ssyA, M, sX, 1,  1.0f, expected = sY.clone(), 1);
        getImpl(blas).ssymv("L", M, -0.5f, ssyA, M, sX, 1,  1.0f, sYcopy = sY.clone(), 1);
        assertArrayEquals(expected, sYcopy, sepsilon);

        f2j.ssymv("L", M,  0.0f, ssyA, M, sX, 1,  1.0f, expected = sY.clone(), 1);
        getImpl(blas).ssymv("L", M,  0.0f, ssyA, M, sX, 1,  1.0f, sYcopy = sY.clone(), 1);
        assertArrayEquals(expected, sYcopy, sepsilon);

        f2j.ssymv("L", M,  1.0f, ssyA, M, sX, 1,  0.5f, expected = sY.clone(), 1);
        getImpl(blas).ssymv("L", M,  1.0f, ssyA, M, sX, 1,  0.5f, sYcopy = sY.clone(), 1);
        assertArrayEquals(expected, sYcopy, sepsilon);

        f2j.ssymv("L", M,  1.0f, ssyA, M, sX, 1, -0.5f, expected = sY.clone(), 1);
        getImpl(blas).ssymv("L", M,  1.0f, ssyA, M, sX, 1, -0.5f, sYcopy = sY.clone(), 1);
        assertArrayEquals(expected, sYcopy, sepsilon);

        f2j.ssymv("L", M,  1.0f, ssyA, M, sX, 1,  0.0f, expected = sY.clone(), 1);
        getImpl(blas).ssymv("L", M,  1.0f, ssyA, M, sX, 1,  0.0f, sYcopy = sY.clone(), 1);
        assertArrayEquals(expected, sYcopy, sepsilon);
    }
}
