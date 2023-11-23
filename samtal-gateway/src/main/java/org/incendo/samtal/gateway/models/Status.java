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
import java.util.Locale;
import org.apiguardian.api.API;
import org.checkerframework.checker.nullness.qual.NonNull;

/**
 * Represents the user status.
 *
 * @since 1.0.0
 */
@JsonSerialize(using = Status.StatusSerializer.class)
@JsonDeserialize(using = Status.StatusDeserializer.class)
@API(status = API.Status.STABLE, since = "1.0.0")
public enum Status {
    ONLINE,
    DND,
    IDLE,
    INVISIBLE,
    OFFLINE;


    public static final class StatusSerializer extends JsonSerializer<Status> {

        @Override
        public void serialize(
                final @NonNull Status value,
                final @NonNull JsonGenerator generator,
                final @NonNull SerializerProvider serializers
        ) throws IOException {
            generator.writeString(value.name().toLowerCase(Locale.ROOT));
        }
    }

    public static final class StatusDeserializer extends JsonDeserializer<Status> {

        @Override
        public Status deserialize(
                final @NonNull JsonParser parser,
                final DeserializationContext context
        ) throws IOException {
            return Status.valueOf(parser.readValueAs(String.class).toUpperCase(Locale.ROOT));
        }
    }
}
