/*
 * Copyright 2012 The Netty Project
 *
 * The Netty Project licenses this file to you under the Apache License,
 * version 2.0 0(the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at:
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */
package io.netty.buffer.pool;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

import java.nio.ByteOrder;

/**
 * {@link AbstractFixedByteBufPool} implementation which pools {@link ByteBuf}'s thate are
 * stored off-heap (direct {@link ByteBuf}'s)
 *
 */
public class FixedDirectByteBufPool extends AbstractFixedByteBufPool {

    /**
     * See {@link AbstractFixedByteBufPool#AbstractFixedByteBufPool(int, int, ByteOrder)}
     */
    public FixedDirectByteBufPool(int bufferCapacity, int bufferCount, ByteOrder order) {
        super(bufferCapacity, bufferCount, order);
    }

    @Override
    protected ByteBuf createByteBuf(int minCapacity) {
        return Unpooled.directBuffer(minCapacity);
    }

}