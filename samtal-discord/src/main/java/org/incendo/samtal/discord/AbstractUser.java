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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import org.apiguardian.api.API;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.immutables.value.Value;

/**
 * <a href="https://discord.com/developers/docs/resources/user">User</a>.
 *
 * @since 1.0.0
 */
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
@ImmutableStyle
@Value.Immutable
@API(status = API.Status.STABLE, since = "1.0.0")
public interface AbstractUser {

    /**
     * Returns the user's id.
     *
     * @return the user's id
     */
    @NonNull Snowflake id();

    /**
     * Returns the user's username.
     *
     * @return the username
     */
    @NonNull String username();

    /**
     * Returns the user's Discord-tag.
     *
     * @return the discriminator
     */
    @NonNull String discriminator();

    /**
     * Returns the user's display name, if it is set. For bots, this is the application name.
     *
     * @return the global name, or {@code null}
     */
    @Nullable String globalName();

    /**
     * Returns the user's avatar hash.
     *
     * @return the avatar hash, or {@code null}
     */
    @Nullable String avatar();

    /**
     * Returns whether the user belongs to an OAuth2 application.
     *
     * @return whether the user is a bot
     */
    @Value.Default
    default boolean bot() {
        return false;
    }

    /**
     * Returns whether the user is an Official Discord System user.
     *
     * @return whether the user is a system user
     */
    @Value.Default
    default boolean system() {
        return false;
    }

    /**
     * Returns whether the user has 2FA enabled.
     *
     * @return whether the user has 2FA enabled
     */
    @Value.Default
    default boolean mfaEnabled() {
        return false;
    }

    /**
     * Returns the user's banner hash
     *
     * @return the banner hash, or {@code null}
     */
    @Nullable String banner();

    /**
     * Returns the user's banner color encoded as an integer representation of hexadecimal color code.
     *
     * @return the user's accent color, or {@code null}
     */
    @Nullable Integer accentColor();

    /**
     * Returns the user's chosen language option.
     *
     * @return the user's locale, or {@code null}
     */
    @Nullable String locale();

    /**
     * Returns whether the email of this account has been verified.
     *
     * @return whether the account has been verified
     */
    boolean verified();

    /**
     * Returns the user's email.
     *
     * @return the email, or {@code null}
     */
    @Nullable String email();

    /**
     * Returns the flags on a user's account.
     *
     * @return the flags, or {@code null}
     */
    @Nullable UserFlags flags();

    /**
     * Returns the type of Nitro subscription on a user's account.
     *
     * @return the Nitro subscription type, or {@code null}
     */
    @Nullable Integer premiumType();

    /**
     * Returns the public flag's on a user's account.
     *
     * @return the public flags, or {@code null}
     */
    @Nullable UserFlags publicFlags();

    /**
     * Returns the user's avatar decoration hash.
     *
     * @return the avatar decoration hash, or {@code null}
     */
    @Nullable String avatarDecoration();
}
