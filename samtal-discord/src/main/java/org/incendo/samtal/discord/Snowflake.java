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
import org.apiguardian.api.API;
import org.checkerframework.checker.nullness.qual.NonNull;

/**
 * Represents a Snowflake.
 *
 * @param value the string value of the Snowflake
 * @since 1.0.0
 */
@JsonSerialize(using = Snowflake.SnowflakeSerializer.class)
@JsonDeserialize(using = Snowflake.SnowflakeDeserializer.class)
@API(status = API.Status.STABLE, since = "1.0.0")
public record Snowflake(
        @NonNull String value
) {

    /**
     * Returns a snowflake with the given {@code value}.
     *
     * @param value the value
     * @return the created snowflake
     */
    public static @NonNull Snowflake of(final @NonNull String value) {
        return new Snowflake(value);
    }

    public static final class SnowflakeSerializer extends JsonSerializer<Snowflake> {

        @Override
        public void serialize(
                final @NonNull Snowflake value,
                final @NonNull JsonGenerator generator,
                final @NonNull SerializerProvider serializers
        ) throws IOException {
           generator.writeString(value.value());
        }
    }

    public static final class SnowflakeDeserializer extends JsonDeserializer<Snowflake> {

        @Override
        public Snowflake deserialize(
                final @NonNull JsonParser parser,
                final @NonNull DeserializationContext context
        ) throws IOException {
            return new Snowflake(parser.readValueAs(String.class));
        }
    }
}
