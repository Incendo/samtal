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
package org.incendo.samtal.gateway.event.send;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import java.util.List;
import org.apiguardian.api.API;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.immutables.value.Value;
import org.incendo.samtal.gateway.ImmutableStyle;
import org.incendo.samtal.gateway.event.GatewayEvent;
import org.incendo.samtal.gateway.event.GatewayEventType;
import org.incendo.samtal.gateway.models.AbstractConnectionProperties;
import org.incendo.samtal.gateway.models.AbstractUpdatePresence;
import org.incendo.samtal.gateway.models.Intents;

/**
 * <a href="https://discord.com/developers/docs/topics/gateway-events#identify">Identify</a>.
 * <p>
 * Used to trigger the initial handshake with the gateway.
 *
 * @since 1.0.0
 */
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
@ImmutableStyle
@Value.Immutable
@API(status = API.Status.STABLE, since = "1.0.0")
public interface AbstractIdentifyEvent extends GatewayEvent {

    /**
     * Returns the authentication token.
     *
     * @return the token
     */
    @NonNull String token();

    /**
     * Returns the connection properties.
     *
     * @return the connection properties
     */
    @NonNull AbstractConnectionProperties properties();

    /**
     * Returns whether the connection supports compression of packets.
     *
     * @return whether compression is supported
     */
    @Value.Default
    default boolean compress() {
        return false;
    }

    /**
     * Returns the total number of members where the gateway will stop sending offline members.
     *
     * @return the member threshold for offline members
     */
    @Value.Default
    default int largeThreshold() {
        return 50;
    }

    /**
     * Returns the presence update.
     *
     * @return the presence update, or {@code null}
     */
    @Nullable AbstractUpdatePresence presence();

    /**
     * Returns the sharding information.
     *
     * @return sharding information
     */
    @Nullable List<@NonNull Integer> shard();

    /**
     * Returns the intents.
     *
     * @return the intents
     */
    @NonNull Intents intents();

    @Override
    default @NonNull GatewayEventType type() {
        return SendEventTypes.IDENTIFY;
    }
}
