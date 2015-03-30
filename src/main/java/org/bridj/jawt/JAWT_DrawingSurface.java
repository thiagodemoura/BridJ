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
package org.bridj.jawt;

import org.bridj.Callback;
import org.bridj.Pointer;
import org.bridj.StructObject;
import org.bridj.ann.Convention;
import org.bridj.ann.Field;
import org.bridj.ann.Library;

/**
 * <i>native declaration : jawt.h</i><br>
 * This file was autogenerated by <a
 * href="http://jnaerator.googlecode.com/">JNAerator</a>,<br>
 * a tool written by <a href="http://ochafik.com/">Olivier Chafik</a> that <a
 * href="http://code.google.com/p/jnaerator/wiki/CreditsAndLicense">uses a few
 * opensource projects.</a>.<br>
 * For help, please visit <a
 * href="http://nativelibs4java.googlecode.com/">NativeLibs4Java</a> or <a
 * href="http://bridj.googlecode.com/">BridJ</a> .
 */
@Library("jawt")
@Convention(Convention.Style.StdCall)
public class JAWT_DrawingSurface extends StructObject {

    /**
     * Cached reference to the Java environment of the calling thread.<br>
     * If Lock(), Unlock(), GetDrawingSurfaceInfo() or<br>
     * FreeDrawingSurfaceInfo() are called from a different thread,<br>
     * this data member should be set before calling those functions.<br>
     * C type : JNIEnv*
     */
    @Field(0)
    public Pointer env() {
        return this.io.getPointerField(this, 0);
    }

    /**
     * Cached reference to the target object<br>
     * C type : void*
     */
    @Field(1)
    public Pointer target() {
        return this.io.getPointerField(this, 1);
    }

    @Field(2)
    public Pointer<Lock_callback> Lock() {
        return this.io.getPointerField(this, 2);
    }

    @Field(3)
    public Pointer<GetDrawingSurfaceInfo_callback> GetDrawingSurfaceInfo() {
        return this.io.getPointerField(this, 3);
    }

    @Field(4)
    public Pointer<FreeDrawingSurfaceInfo_callback> FreeDrawingSurfaceInfo() {
        return this.io.getPointerField(this, 4);
    }

    @Field(5)
    public Pointer<Unlock_callback> Unlock() {
        return this.io.getPointerField(this, 5);
    }

    /// Conversion Error : Lock_callback (Unsupported type)
    /// Conversion Error : GetDrawingSurfaceInfo_callback (Unsupported type)
    /// Conversion Error : FreeDrawingSurfaceInfo_callback (Unsupported type)
    /// Conversion Error : Unlock_callback (Unsupported type)
    /// <i>native declaration : jawt.h:187</i>
    public static abstract class Lock_callback extends Callback {

        public abstract int invoke(Pointer<JAWT_DrawingSurface> ds);
    };
    /// <i>native declaration : jawt.h:198</i>

    public static abstract class GetDrawingSurfaceInfo_callback extends Callback {

        public abstract Pointer<org.bridj.jawt.JAWT_DrawingSurfaceInfo> invoke(Pointer<JAWT_DrawingSurface> ds);
    };
    /// <i>native declaration : jawt.h:203</i>

    public static abstract class FreeDrawingSurfaceInfo_callback extends Callback {

        public abstract void invoke(Pointer<org.bridj.jawt.JAWT_DrawingSurfaceInfo> dsi);
    };
    /// <i>native declaration : jawt.h:208</i>

    public static abstract class Unlock_callback extends Callback {

        public abstract void invoke(Pointer<JAWT_DrawingSurface> ds);
    };
}
