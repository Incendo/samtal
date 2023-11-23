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
import org.checkerframework.checker.nullness.qual.MonotonicNonNull;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.immutables.value.Value;
import org.incendo.samtal.discord.Snowflake;
import org.incendo.samtal.gateway.ImmutableStyle;
import org.incendo.samtal.gateway.event.GatewayEvent;
import org.incendo.samtal.gateway.event.GatewayEventType;

/**
 * <a href="https://discord.com/developers/docs/topics/gateway-events#request-guild-members">
 *     Request Guild Members</a>.
 * <p>
 * Used to request all members for a guild or a list of guilds.
 *
 * @since 1.0.0
 */
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
@ImmutableStyle
@Value.Immutable
@API(status = API.Status.STABLE, since = "1.0.0")
public interface AbstractRequestGuildMembersEvent extends GatewayEvent {

    /**
     * Returns the ID of the guild to get members for.
     *
     * @return the guild id
     */
    @NonNull Snowflake guildId();

    /**
     * Returns the string that the username starts with, or an empty
     * string to return all members.
     *
     * @return the query string, or {@code null}
     */
    @Nullable String query();

    /**
     * Returns the maximum number of members to send matching the {@link #query()}.
     * <p>
     * A limit of {@code 0} can be used with an empty string {@link #query()} to return all members.
     * <p>
     * The {@code GUILD_MEMBERS} intent is required to fetch all members.
     *
     * @return the limit
     */
    @MonotonicNonNull Integer limit();

    /**
     * Returns whether to return the presences of all players. This requires the {@code GUILD_PRESENCES} intent.
     *
     * @return whether to include the presences
     */
    @Value.Default
    default boolean presences() {
        return false;
    }

    /**
     * Returns the users to fetch.
     *
     * @return the users to fetch, or {@code null}
     */
    @Nullable List<@NonNull Snowflake> userIds();

    /**
     * Returns the nonce used to identify the response. Can only be up to 32 bytes.
     *
     * @return the nonce, or {@code null}
     */
    @Nullable String nonce();

    @Override
    default @NonNull GatewayEventType type() {
        return SendEventTypes.REQUEST_GUILD_MEMBERS;
    }
}
