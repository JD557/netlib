/*
* Copyright 2020, Ludovic Henry
*
* Permission is hereby granted, free of charge, to any person obtaining a copy
* of this software and associated documentation files (the "Software"), to deal
* in the Software without restriction, including without limitation the rights
* to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
* copies of the Software, and to permit persons to whom the Software is
* furnished to do so, subject to the following conditions:
*
* The above copyright notice and this permission notice shall be included in
* all copies or substantial portions of the Software.
*
* THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
* IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
* FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
* AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
* LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
* OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
* SOFTWARE.
*/

import dev.ludovic.blas.BLAS;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.api.Assertions.*;

public class SsprTest extends BLASTest {

    @ParameterizedTest
    @MethodSource("BLASImplementations")
    void testSanity(BLAS blas) {
        int n = 4;
        float alpha = 0.1f;
        float[] x = new float[] {
            1.0f, 2.0f, 2.1f, 4.0f };
        float[] a = new float[] {
            1.0f,
            2.0f, 2.0f,
            3.0f, 3.0f, 3.0f,
            4.0f, 4.0f, 4.0f, 4.0f };
        float[] expected = new float[] {
             1.1f,
             2.2f,  2.4f,
            3.21f, 3.42f, 3.441f,
             4.4f,  4.8f,  4.84f, 5.6f };

        float[] a1 = a.clone();
        blas.sspr("U", n, alpha, x, 1, a1);
        assertArrayEquals(expected, a1, sepsilon);
    }
}
