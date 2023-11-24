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

import discord4j.gateway.GatewayObserver;
import discord4j.gateway.IdentifyOptions;
import org.apiguardian.api.API;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.netty.ConnectionObserver;

@API(status = API.Status.INTERNAL, since = "1.0.0")
final class SamtalGatewayObserver implements GatewayObserver {

    private static final Logger LOGGER = LoggerFactory.getLogger(SamtalGatewayObserver.class);

    @Override
    public void onStateChange(
            final ConnectionObserver.@NonNull State newState,
            final @NonNull IdentifyOptions identifyOptions
    ) {
        LOGGER.info("Connection state changed to {} - Identify options: {}", newState, identifyOptions);
    }
}
