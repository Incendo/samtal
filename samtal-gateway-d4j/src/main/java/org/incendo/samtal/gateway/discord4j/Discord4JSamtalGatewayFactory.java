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

import com.fasterxml.jackson.databind.ObjectMapper;
import discord4j.common.ReactorResources;
import discord4j.common.SimpleBucket;
import discord4j.gateway.DefaultGatewayClient;
import discord4j.gateway.GatewayClient;
import discord4j.gateway.IdentifyOptions;
import discord4j.gateway.RateLimiterTransformer;
import discord4j.gateway.payload.JacksonPayloadReader;
import discord4j.gateway.payload.JacksonPayloadWriter;
import discord4j.gateway.payload.PayloadReader;
import discord4j.gateway.payload.PayloadWriter;
import discord4j.gateway.retry.RetryOptions;
import java.time.Duration;
import org.apiguardian.api.API;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.incendo.samtal.gateway.GatewayConfiguration;
import org.incendo.samtal.gateway.SamtalGatewayFactory;
import reactor.core.scheduler.Schedulers;

@API(status = API.Status.STABLE, since = "1.0.0")
public final class Discord4JSamtalGatewayFactory implements SamtalGatewayFactory<Discord4JSamtalGateway> {

    @Override
    public @NonNull Discord4JSamtalGateway createGateway(final @NonNull GatewayConfiguration configuration) {
        final ObjectMapper objectMapper = new ObjectMapper(); // TODO(City): Move this into a factory.
        final PayloadReader reader = new JacksonPayloadReader(objectMapper);
        final PayloadWriter writer = new JacksonPayloadWriter(objectMapper);
        final RetryOptions retryOptions = new RetryOptions(
                Duration.ofSeconds(5L),
                Duration.ofSeconds(120L),
                Integer.MAX_VALUE,
                Schedulers.elastic()
        );
        final GatewayClient client = new DefaultGatewayClient(
                ReactorResources.DEFAULT_HTTP_CLIENT.get(),
                reader,
                writer,
                retryOptions,
                configuration.token(),
                new IdentifyOptions(0, 1, null),
                new SamtalGatewayObserver(),
                new RateLimiterTransformer(new SimpleBucket(1, Duration.ofSeconds(6)))
        );
         return new Discord4JSamtalGateway(client);
    }
}
