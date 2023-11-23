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

import org.apiguardian.api.API;
import org.incendo.samtal.gateway.event.GatewayEventType;

/**
 * Defines the <a href="https://discord.com/developers/docs/topics/gateway-events#send-events">send event types</a>.
 *
 * @since 1.0.0
 */
@API(status = API.Status.STABLE, since = "1.0.0")
public final class SendEventTypes {

    public static final GatewayEventType HEARTBEAT = GatewayEventType.eventType(1);
    public static final GatewayEventType IDENTIFY = GatewayEventType.eventType(2);
    public static final GatewayEventType UPDATE_PRESENCE = GatewayEventType.eventType(3);
    public static final GatewayEventType UPDATE_VOICE_STATE = GatewayEventType.eventType(4);
    public static final GatewayEventType RESUME = GatewayEventType.eventType(6);
    public static final GatewayEventType REQUEST_GUILD_MEMBERS = GatewayEventType.eventType(8);

    private SendEventTypes() {
    }
}
