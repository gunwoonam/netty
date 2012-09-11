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

import static org.junit.Assert.fail;

import java.nio.ByteOrder;

import org.junit.Test;

public class StrictFixedDirectByteBufPoolTest extends AbstractByteBufPoolTest {

    @Override
    protected StrictFixedDirectByteBufPool createPool(int bufferCapacity, int bufferCount, ByteOrder order) {
        return new StrictFixedDirectByteBufPool(bufferCapacity, bufferCount, order);
    }


    @Override
    @Test
    public void testPoolExhausted() {
        try {
            super.testPoolExhausted();
            fail("Should have thrown a PoolExhaustedException");
        } catch (PoolExhaustedException e) {
            // expected
        }
    }
}