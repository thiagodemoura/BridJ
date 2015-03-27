/*
 * BridJ - Dynamic and blazing-fast native interop for Java.
 * http://bridj.googlecode.com/
 *
 * Copyright (c) 2010-2015, Olivier Chafik (http://ochafik.com/)
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * 
 *     * Redistributions of source code must retain the above copyright
 *       notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above copyright
 *       notice, this list of conditions and the following disclaimer in the
 *       documentation and/or other materials provided with the distribution.
 *     * Neither the name of Olivier Chafik nor the
 *       names of its contributors may be used to endorse or promote products
 *       derived from this software without specific prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY OLIVIER CHAFIK AND CONTRIBUTORS ``AS IS'' AND ANY
 * EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE REGENTS AND CONTRIBUTORS BE LIABLE FOR ANY
 * DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package org.bridj;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;


/**
 *
 * @author ochafik
 */
public class DynamicCallbackTest {

    public DynamicCallbackTest() {
    }


    @Test
    public void testAddDynamicFunction() throws IOException {
        NativeLibrary lib = BridJ.getNativeLibrary("test");
        DynamicFunction i = lib.getSymbolPointer("testAddDyncall").asDynamicFunction(null, int.class, int.class, int.class);
        int res = (Integer)i.apply(1, 2);
        assertEquals(3, res);
    }
    
    @Test
    public void testDynamicFunctionCallback() throws FileNotFoundException {
        Pointer dc = Pointer.allocateDynamicCallback(
            new DynamicCallback<Integer>() {

                public Integer apply(Object... args) {
                    int a = (Integer)args[0];
                    int b = (Integer)args[1];
                    return a + b;
                }
                
            }, null, int.class, int.class, int.class
        );
        DynamicFunction<Integer> df = dc.asUntyped().asDynamicFunction(null, int.class, int.class, int.class);
        int ret = df.apply(1, 2);
        assertEquals(3, ret);
    }
}
