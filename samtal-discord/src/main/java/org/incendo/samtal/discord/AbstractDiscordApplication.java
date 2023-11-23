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
import java.util.List;
import org.apiguardian.api.API;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.immutables.value.Value;

/**
 * <a href="https://discord.com/developers/docs/resources/application">Application</a>.
 *
 * @since 1.0.0
 */
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
@ImmutableStyle
@Value.Immutable
@API(status = API.Status.STABLE, since = "1.0.0")
public interface AbstractDiscordApplication {

    /**
     * Returns the ID of the application.
     *
     * @return the id
     */
    @NonNull Snowflake id();

    /**
     * Returns the name of the application.
     *
     * @return the name
     */
    @NonNull String name();

    /**
     * Returns the icon hash of the application.
     *
     * @return the icon hash, or {@code null}
     */
    @Nullable String icon();

    /**
     * Returns the description of the application.
     *
     * @return the description
     */
    @NonNull String description();

    /**
     * Returns the list of RPC origin URLs, if RPC is enabled.
     *
     * @return the list of RPC origin URLs, or {@code null}
     */
    @Nullable List<@NonNull String> rpcOrigins();

    /**
     * Returns whether the bot is public.
     * <p>
     * When {@code false}, only the app owner can add the app to guilds.
     *
     * @return whether the app is public
     */
    boolean botPublic();

    /**
     * Returns whether the bot requires completion of the OAuth2 code grant flow.
     * <p>
     * When {@code true}, the app's bot will only join upon completion of the full OAuth2 code grant flow.
     *
     * @return whether the code grant flow is required
     */
    boolean botRequireCodeGrant();

    /**
     * Returns a partial user object  for the bot that is associated with this application.
     *
     * @return the bot user, or {@code null}
     */
    @Nullable AbstractUser bot();

    /**
     * Returns the terms of service URL.
     *
     * @return the terms of service URL, or {@code null}
     */
    @Nullable String termsOfServiceUrl();

    /**
     * Returns the privacy policy URL.
     *
     * @return the privacy policy URL, or {@code null}
     */
    @Nullable String privacyPolicyUrl();

    /**
     * Returns the owner of the application.
     *
     * @return the owner
     */
    @Nullable AbstractUser owner();

    /**
     * Returns a hex encoded key for verification in interactions and the GameSDK's GetTicket.
     *
     * @return the hex encoded key
     */
    @NonNull String verifyKey();

    /**
     * Returns the team if the application belongs to a team.
     *
     * @return the team, or {@code null}
     */
    @Nullable AbstractTeam team();

    /**
     * Returns the id of the guild associated with the application.
     *
     * @return the id of the guild associated with the application, or {@code null}
     */
    @Nullable Snowflake guildId();

    /**
     * Returns the guild associated with the application.
     *
     * @return the guild associated with the application, or {@code null}
     */
    @Nullable AbstractGuild guild();

    /**
     * Returns the Game SKU of the associated game.
     *
     * @return the game SKU, or {@code null}
     */
    @Nullable Snowflake primarySkuId();

    /**
     * Returns the URL slug that links to the store page of the associated game.
     *
     * @return the URL slug, or {@code null}
     */
    @Nullable String slug();

    /**
     * Returns the application's default rich presence invite cover image hash.
     *
     * @return the cover image hash, or {@code null}
     */
    @Nullable String coverImage();

    /**
     * Returns the application's public flags.
     *
     * @return the public flags, or {@code null}
     */
    @Nullable ApplicationFlags flags();

    /**
     * Returns the approximate count of guilds the app has been added to.
     *
     * @return the approximate guild count, or {@code null}
     */
    @Nullable Integer approximateGuildCount();

    /**
     * Returns the redirect URLs for the application.
     *
     * @return the redirect URLs, or {@code null}
     */
    @Nullable List<@NonNull String> redirectUrls();

    /**
     * Returns the interactions endpoint url for the application.
     *
     * @return the applications endpoint URL, or {@code null}
     */
    @Nullable String interactionsEndpointUrl();

    /**
     * Returns the role connections verification URL for the application.
     *
     * @return the role connections verification URL, or {@code null}
     */
    @Nullable String roleConnectionsVerificationUrl();

    /**
     * Returns a list of tags describing the content and functionality of the app. Max of 5 tags.
     *
     * @return the tags, or {@code null}
     */
    @Nullable List<@NonNull String> tags();

    /**
     * Returns the settings for the application's default in-app authorization link, if enabled.
     *
     * @return the installation parameters, or {@code null}
     */
    @Nullable AbstractInstallParams installParams();

    /**
     * Returns the default custom authorization URL for the application, if enabled.
     *
     * @return the custom installation url, or {@code null}
     */
    @Nullable String customInstallUrl();
}
