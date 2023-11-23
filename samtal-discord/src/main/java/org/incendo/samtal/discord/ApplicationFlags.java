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

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.io.IOException;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;
import org.apiguardian.api.API;
import org.checkerframework.checker.nullness.qual.NonNull;

/**
 * Container of {@link ApplicationFlag application flags}.
 *
 * @since 1.0.0
 */
@JsonSerialize(using = ApplicationFlags.ApplicationFlagsSerializer.class)
@JsonDeserialize(using = ApplicationFlags.ApplicationFlagsDeserializer.class)
@API(status = API.Status.STABLE, since = "1.0.0")
public final class ApplicationFlags {

    private final Set<ApplicationFlag> flags;

    /**
     * Returns a new application flags instance using the {@code encodedFlags}.
     *
     * @param encodedFlags the bit flags
     */
    public ApplicationFlags(final int encodedFlags) {
        final Set<ApplicationFlag> flags = EnumSet.noneOf(ApplicationFlag.class);
        for (final ApplicationFlag flag : ApplicationFlag.values()) {
            if ((encodedFlags & flag.value()) != 0) {
                flags.add(flag);
            }
        }
        this.flags = Collections.unmodifiableSet(flags);
    }

    /**
     * Returns the flags.
     *
     * @return unmodifiable view of the flags
     */
    public @NonNull Set<@NonNull ApplicationFlag> flags() {
        return this.flags;
    }

    /**
     * Returns the flags encoded into an integer.
     *
     * @return the bit flags
     */
    public int encodeFlags() {
        int encodedFlags = 0;
        for (final ApplicationFlag flag : this.flags()) {
            encodedFlags |= flag.value();
        }
        return encodedFlags;
    }

    @Override
    public boolean equals(final Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        final ApplicationFlags that = (ApplicationFlags) object;
        return Objects.equals(this.flags, that.flags);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.flags);
    }

    @Override
    public String toString() {
        return "ApplicationFlags{flags=" + this.flags  + '}';
    }


    public static final class ApplicationFlagsSerializer extends JsonSerializer<ApplicationFlags> {

        @Override
        public void serialize(
                final @NonNull ApplicationFlags value,
                final @NonNull JsonGenerator generator,
                final @NonNull SerializerProvider serializers
        ) throws IOException {
            generator.writeNumber(value.encodeFlags());
        }
    }


    public static final class ApplicationFlagsDeserializer extends JsonDeserializer<ApplicationFlags> {

        @Override
        public ApplicationFlags deserialize(
                final @NonNull JsonParser parser,
                final @NonNull DeserializationContext context
        ) throws IOException {
            return new ApplicationFlags(parser.readValueAs(Integer.class));
        }
    }
}
