/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package com.kitfox.svg.animation.parser;

import com.kitfox.svg.animation.parser.AnimTimeParser;
import com.kitfox.svg.animation.parser.SimpleNode;

public class ASTSum
extends SimpleNode {
    public ASTSum(int id) {
        super(id);
    }

    public ASTSum(AnimTimeParser p, int id) {
        super(p, id);
    }
}
