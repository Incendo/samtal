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

import org.checkerframework.checker.nullness.qual.NonNull;
import org.incendo.samtal.gateway.ConnectionOptions;
import org.incendo.samtal.gateway.GatewayConfiguration;
import org.incendo.samtal.gateway.SamtalGateway;
import org.incendo.samtal.gateway.SamtalGatewayFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class Test {

    private static final Logger LOGGER = LoggerFactory.getLogger(Test.class);

    private Test() {
    }

    /**
     * Starts the application.
     *
     * @param args the args
     */
    public static void main(final @NonNull String @NonNull[] args) {
        final GatewayConfiguration configuration = GatewayConfiguration.builder()
                .token(System.getenv("DISCORD_TOKEN"))
                .build();
        final SamtalGatewayFactory<Discord4JSamtalGateway> factory = new Discord4JSamtalGatewayFactory();
        final SamtalGateway gateway = factory.createGateway(configuration);
        gateway.connect(ConnectionOptions.builder().gatewayUrl("https://google.com").build()).join();
        LOGGER.info("Created :)");
    }
}
