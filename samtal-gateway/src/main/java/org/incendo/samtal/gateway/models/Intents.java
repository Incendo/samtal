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
package org.incendo.samtal.gateway.models;

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
 * Container of {@link Intent intents}.
 *
 * @since 1.0.0
 */
@JsonSerialize(using = Intents.IntentsSerializer.class)
@JsonDeserialize(using = Intents.IntentsDeserializer.class)
@API(status = API.Status.STABLE, since = "1.0.0")
public final class Intents {

    private final Set<Intent> intents;

    /**
     * Returns a new intents instance using the {@code encodedintents}.
     *
     * @param encodedintents the bit intents
     */
    public Intents(final int encodedintents) {
        final Set<Intent> intents = EnumSet.noneOf(Intent.class);
        for (final Intent flag : Intent.values()) {
            if ((encodedintents & flag.value()) != 0) {
                intents.add(flag);
            }
        }
        this.intents = Collections.unmodifiableSet(intents);
    }

    /**
     * Returns the intents.
     *
     * @return unmodifiable view of the intents
     */
    public @NonNull Set<@NonNull Intent> intents() {
        return this.intents;
    }

    /**
     * Returns the intents encoded into an integer.
     *
     * @return the bit intents
     */
    public int encodeintents() {
        int encodedintents = 0;
        for (final Intent flag : this.intents()) {
            encodedintents |= flag.value();
        }
        return encodedintents;
    }

    @Override
    public boolean equals(final Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        final Intents that = (Intents) object;
        return Objects.equals(this.intents, that.intents);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.intents);
    }

    @Override
    public String toString() {
        return "Intents{intents=" + this.intents  + '}';
    }


    public static final class IntentsSerializer extends JsonSerializer<Intents> {

        @Override
        public void serialize(
                final @NonNull Intents value,
                final @NonNull JsonGenerator generator,
                final @NonNull SerializerProvider serializers
        ) throws IOException {
            generator.writeNumber(value.encodeintents());
        }
    }


    public static final class IntentsDeserializer extends JsonDeserializer<Intents> {

        @Override
        public Intents deserialize(
                final @NonNull JsonParser parser,
                final @NonNull DeserializationContext context
        ) throws IOException {
            return new Intents(parser.readValueAs(Integer.class));
        }
    }
}
