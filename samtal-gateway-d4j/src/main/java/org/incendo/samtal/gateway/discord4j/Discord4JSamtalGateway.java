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

import discord4j.gateway.GatewayClient;
import java.util.concurrent.CompletableFuture;
import org.apiguardian.api.API;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.incendo.samtal.gateway.SamtalGateway;
import org.incendo.samtal.gateway.event.GatewayEvent;

/**
 * {@link SamtalGateway} implementation that delegates to a {@link GatewayClient}.
 *
 * @since 1.0.0
 */
@API(status = API.Status.STABLE, since = "1.0.0")
public final class Discord4JSamtalGateway implements SamtalGateway {

    private final EventMapper eventMapper = new EventMapper();
    private final GatewayClient gatewayClient;

    /**
     * Creates a new {@link Discord4JSamtalGateway} that uses the given {@code gatewayClient}.
     *
     * @param gatewayClient the client to use
     */
    public Discord4JSamtalGateway(final @NonNull GatewayClient gatewayClient) {
        this.gatewayClient = gatewayClient;
    }

    @Override
    public @NonNull <E extends GatewayEvent> CompletableFuture<Void> send(@NonNull final E event) {
        return this.gatewayClient.send(publisher -> publisher.onNext(this.eventMapper.map(event))).toFuture();
    }
}
