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
package org.incendo.samtal.discord;

import org.apiguardian.api.API;

/**
 * <a href="https://discord.com/developers/docs/resources/application#application-object-application-flags">Application flags</a>.
 *
 * @since 1.0.0
 */
@API(status = API.Status.STABLE, since = "1.0.0")
public enum ApplicationFlag {
    /**
     * Indicates if an app uses the Auto Moderation API
     */
    APPLICATION_AUTO_MODERATION_RULE_CREATE_BADGE(1 << 6),
    /**
     * Intent required for bots in 100 or more servers to receive presence_update events.
     */
    GATEWAY_PRESENCE(1 << 12),
    /**
     * Intent required for bots in under 100 servers to receive presence_update events.
     */
    GATEWAY_PRESENCE_LIMITED(1 << 13),
    /**
     * Intent required for bots in 100 or more servers to receive member-related events like guild_member_add.
     */
    GATEWAY_GUILD_MEMBERS(1 << 14),
    /**
     * Intent required for bots in under 100 servers to receive member-related events like guild_member_add.
     */
    GATEWAY_GUILD_MEMBERS_LIMITED(1 << 15),
    /**
     * Indicates unusual growth of an app that prevents verification.
     */
    VERIFICATION_PENDING_GUILD_LIMIT(1 << 16),
    /**
     * Indicates if an app is embedded within the Discord client.
     */
    EMBEDDED(1 << 17),
    /**
     * Intent required for bots in 100 or more servers to receive message content.
     */
    GATEWAY_MESSAGE_CONTENT(1 << 18),
    /**
     * Intent required for bots in under 100 servers to receive message content.
     */
    GATEWAY_MESSAGE_CONTENT_LIMITED(1 << 19),
    /**
     * Intent required for bots in under 100 servers to receive message content.
     */
    APPLICATION_COMMAND_BADGE(1 << 23);

    private final int value;

    ApplicationFlag(final int value) {
        this.value = value;
    }

    /**
     * Returns the integer value representing this flag.
     *
     * @return the flag value
     */
    public int value() {
        return this.value;
    }
}
