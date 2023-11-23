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
import org.apiguardian.api.API;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.immutables.value.Value;
import org.incendo.samtal.discord.Snowflake;
import org.incendo.samtal.gateway.ImmutableStyle;
import org.incendo.samtal.gateway.event.GatewayEvent;
import org.incendo.samtal.gateway.event.GatewayEventType;

/**
 * <a href="https://discord.com/developers/docs/topics/gateway-events#update-voice-state">
 *     Update Voice State</a>.
 *
 * @since 1.0.0
 */
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
@ImmutableStyle
@Value.Immutable
@API(status = API.Status.STABLE, since = "1.0.0")
public interface AbstractUpdateVoiceStateEvent extends GatewayEvent {

    /**
     * Returns the ID of the guild.
     *
     * @return the guild id
     */
    @NonNull Snowflake guildId();

    /**
     * Returns the ID of the voice channel to join, or {@code null} to disconnect.
     *
     * @return the channel id, or {@code null}
     */
    @Nullable Snowflake channelId();

    /**
     * Returns whether the client is muted.
     *
     * @return whether the client is muted
     */
    boolean selfMute();

    /**
     * Returns whether the client is deafened.
     *
     * @return whether the client is deafened
     */
    boolean selfDeaf();

    @Override
    default @NonNull GatewayEventType type() {
        return SendEventTypes.UPDATE_VOICE_STATE;
    }
}
