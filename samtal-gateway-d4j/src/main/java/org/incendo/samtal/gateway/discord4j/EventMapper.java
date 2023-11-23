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
package org.incendo.samtal.gateway.discord4j;

import discord4j.common.jackson.Possible;
import discord4j.gateway.json.GatewayPayload;
import discord4j.gateway.json.Heartbeat;
import discord4j.gateway.json.Identify;
import discord4j.gateway.json.IdentifyProperties;
import discord4j.gateway.json.RequestGuildMembers;
import discord4j.gateway.json.Resume;
import discord4j.gateway.json.StatusUpdate;
import discord4j.gateway.json.VoiceStateUpdate;
import java.util.Locale;
import java.util.Objects;
import org.apiguardian.api.API;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.incendo.samtal.discord.Snowflake;
import org.incendo.samtal.gateway.event.GatewayEvent;
import org.incendo.samtal.gateway.event.send.AbstractHeartbeatEvent;
import org.incendo.samtal.gateway.event.send.AbstractIdentifyEvent;
import org.incendo.samtal.gateway.event.send.AbstractRequestGuildMembersEvent;
import org.incendo.samtal.gateway.event.send.AbstractResumeEvent;
import org.incendo.samtal.gateway.event.send.AbstractUpdatePresenceEvent;
import org.incendo.samtal.gateway.event.send.AbstractUpdateVoiceStateEvent;
import org.incendo.samtal.gateway.models.AbstractUpdatePresence;

@API(status = API.Status.INTERNAL, since = "1.0.0")
public final class EventMapper {

    /**
     * Maps the given samtal event to a corresponding Discord4J event.
     *
     * @param <E> the event type
     * @param event the event
     * @return the corresponding event
     */
    public <E extends GatewayEvent> @NonNull GatewayPayload<?> map(final @NonNull E event) {
        if (event instanceof AbstractIdentifyEvent identifyEvent) {
            return this.map(identifyEvent);
        } else if (event instanceof AbstractResumeEvent resumeEvent) {
            return this.map(resumeEvent);
        } else if (event instanceof AbstractRequestGuildMembersEvent requestGuildMembersEvent) {
            return this.map(requestGuildMembersEvent);
        } else if (event instanceof AbstractHeartbeatEvent heartbeatEvent) {
            return this.map(heartbeatEvent);
        } else if (event instanceof AbstractUpdateVoiceStateEvent updateVoiceStateEvent) {
            return this.map(updateVoiceStateEvent);
        } else if (event instanceof AbstractUpdatePresenceEvent updatePresenceEvent) {
            return this.map(updatePresenceEvent);
        }
        throw new IllegalArgumentException("Don't know how to map event of type " + event.type());
    }

    private @NonNull GatewayPayload<Identify> map(final @NonNull AbstractIdentifyEvent event) {
        return GatewayPayload.identify(
                new Identify(
                        event.token(),
                        new IdentifyProperties(
                                event.properties().os(),
                                event.properties().browser(),
                                event.properties().device()
                        ),
                        event.compress(),
                        event.largeThreshold(),
                        Possible.absent(),
                        this.map(event.presence())
                )
        );
    }

    private @NonNull GatewayPayload<Resume> map(final @NonNull AbstractResumeEvent event) {
        return GatewayPayload.resume(
                new Resume(
                        event.token(),
                        event.sessionId(),
                        event.seq()
                )
        );
    }

    private @NonNull GatewayPayload<RequestGuildMembers> map(final @NonNull AbstractRequestGuildMembersEvent event) {
        return GatewayPayload.requestGuildMembers(
                new RequestGuildMembers(
                        event.guildId().asLong(),
                        Objects.requireNonNull(event.query(), "query"),
                        Objects.requireNonNull(event.limit(), "limit")
                )
        );
    }

    private @NonNull GatewayPayload<Heartbeat> map(final @NonNull AbstractHeartbeatEvent event) {
        return GatewayPayload.heartbeat(
                new Heartbeat(
                        Objects.requireNonNull(event.sequence(), "sequence")
                )
        );
    }

    private @NonNull GatewayPayload<VoiceStateUpdate> map(final @NonNull AbstractUpdateVoiceStateEvent event) {
        return GatewayPayload.voiceStateUpdate(
                new VoiceStateUpdate(
                        event.guildId().asLong(),
                        this.asLong(event.channelId()),
                        event.selfMute(),
                        event.selfDeaf()
                )
        );
    }

    private @NonNull GatewayPayload<StatusUpdate> map(final @NonNull AbstractUpdatePresenceEvent event) {
        return GatewayPayload.statusUpdate(
                new StatusUpdate(
                        event.since(),
                        null /* game */,
                        event.status().name().toLowerCase(Locale.ROOT),
                        event.afk()
                )
        );
    }

    private @NonNull Possible<StatusUpdate> map(final @Nullable AbstractUpdatePresence presence) {
        if (presence == null) {
            return Possible.absent();
        }
        return Possible.of(new StatusUpdate(
                presence.since(),
                null /* game */,
                presence.status().name().toLowerCase(Locale.ROOT),
                presence.afk()
        ));
    }

    private @Nullable Long asLong(final @Nullable Snowflake snowflake) {
        if (snowflake == null) {
            return null;
        }
        return snowflake.asLong();
    }
}
