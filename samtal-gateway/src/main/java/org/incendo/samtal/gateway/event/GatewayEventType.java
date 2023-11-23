//
// MIT License
//
// Copyright (c) 2023 Incendo
//
// Permission is hereby granted, free of charge, to any person obtaining a copy
// of this software and associated documentation files (the "Software"), to deal
// in the Software without restriction, including without limitation the rights
// to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
// copies of the Software, and to permit persons to whom the Software is
// furnished to do so, subject to the following conditions:
//
// The above copyright notice and this permission notice shall be included in all
// copies or substantial portions of the Software.
//
// THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
// IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
// FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
// AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
// LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
// OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
// SOFTWARE.
//
package org.incendo.samtal.gateway.event;

import org.apiguardian.api.API;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

/**
 * Defines the type of event.
 *
 * @param opCode the event opcode
 * @param eventName the name of the event
 * @since 1.0.0
 */
@API(status = API.Status.STABLE, since = "1.0.0")
public record GatewayEventType(
        int opCode,
        @Nullable String eventName
) {

    /**
     * Creates a new event type.
     *
     * @param eventName the name of the event
     * @return the created type
     */
    public static @NonNull GatewayEventType eventType(
            final @NonNull String eventName
    ) {
        return new GatewayEventType(0, eventName);
    }

    /**
     * Creates a new event type.
     *
     * @param opCode the opcode
     * @return the created type
     */
    public static @NonNull GatewayEventType eventType(
            final int opCode
    ) {
        return new GatewayEventType(opCode, null /* eventName */);
    }
}
