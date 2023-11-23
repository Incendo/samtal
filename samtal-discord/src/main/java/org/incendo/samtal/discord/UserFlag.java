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
 * <a href="https://discord.com/developers/docs/resources/user#user-object-user-flags">User flags</a>.
 *
 * @since 1.0.0
 */
@API(status = API.Status.STABLE, since = "1.0.0")
public enum UserFlag {
    STAFF(1),
    PARTNER(1 << 1),
    HYPESQUAD(1 << 2),
    BUG_HUNTER_LEVEL_1(1 << 3),
    HYPESQUAD_ONLINE_HOUSE_1(1 << 6),
    HYPESQUAD_ONLINE_HOUSE_2(1 << 7),
    HYPESQUAD_ONLINE_HOUSE_3(1 << 8),
    PREMIUM_EARLY_SUPPORTER(1 << 9),
    TEAM_PSEUDO_USER(1 << 10),
    BUG_HUNTER_LEVEL_2(1 << 14),
    VERIFIED_BOT(1 << 15),
    VERIFIED_DEVELOPER(1 << 17),
    CERTIFIED_MODERATOR(1 << 18),
    BOT_HTTP_INTERACTIONS(1 << 19),
    ACTIVE_DEVELOPER(1 << 22);

    private final int value;

    UserFlag(final int value) {
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
