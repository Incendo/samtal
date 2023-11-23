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

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import static com.google.common.truth.Truth.assertThat;

class UserTest {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void testDeserialization() throws JsonProcessingException {
        // Arrange
        final String json = """
                {
                  "id": "80351110224678912",
                  "username": "Nelly",
                  "discriminator": "1337",
                  "avatar": "8342729096ea3675442027381ff50dfe",
                  "verified": true,
                  "email": "nelly@discord.com",
                  "flags": 64,
                  "banner": "06c16474723fe537c283b8efa61a30c8",
                  "accent_color": 16711680,
                  "premium_type": 1,
                  "public_flags": 64
                }
        """;

        // Act
        final User user = this.objectMapper.readValue(json, User.class);

        // Assert
        assertThat(user).isEqualTo(
                User.builder()
                        .id(Snowflake.of("80351110224678912"))
                        .username("Nelly")
                        .discriminator("1337")
                        .avatar("8342729096ea3675442027381ff50dfe")
                        .verified(true)
                        .email("nelly@discord.com")
                        .flags(new UserFlags(64))
                        .banner("06c16474723fe537c283b8efa61a30c8")
                        .accentColor(16711680)
                        .premiumType(1)
                        .publicFlags(new UserFlags(64))
                        .build()
        );
    }
}
