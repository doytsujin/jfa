// Copyright 2000-2020 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
// This file has been modified
package de.jangassen.jfa.foundation;

import com.sun.jna.NativeLong; // NOSONAR
import com.sun.jna.Pointer; // NOSONAR

/**
 * Could be an address in memory (if pointer to a class or method) or a value (like 0 or 1)
 *
 * User: spLeaner
 */
public class ID extends NativeLong {

    public ID() {
    }

    public ID(long peer) {
        super(peer);
    }


    public ID(Pointer peer) {
        super(Pointer.nativeValue(peer));
    }

    public Pointer toPointer() {
        return new Pointer(longValue());
    }

    public static final ID NIL = new ID(0L);

    public boolean booleanValue() {
        return intValue() != 0;
    }
}