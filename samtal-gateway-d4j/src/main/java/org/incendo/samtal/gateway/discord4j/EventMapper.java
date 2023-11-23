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
import discord4j.gateway.json.Identify;
import discord4j.gateway.json.IdentifyProperties;
import discord4j.gateway.json.StatusUpdate;
import java.util.Locale;
import org.apiguardian.api.API;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.incendo.samtal.gateway.event.GatewayEvent;
import org.incendo.samtal.gateway.event.send.AbstractIdentifyEvent;
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
}
