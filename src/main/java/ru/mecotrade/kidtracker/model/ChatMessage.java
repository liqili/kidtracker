/*
 * Copyright 2020 Sergey Shadchin (sergei.shadchin@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ru.mecotrade.kidtracker.model;

import lombok.Builder;
import lombok.Data;
import ru.mecotrade.kidtracker.dao.model.Media;
import ru.mecotrade.kidtracker.dao.model.Message;

import java.nio.charset.StandardCharsets;
import java.util.Date;

@Data
@Builder
public class ChatMessage {

    private String deviceId;

    private Date timestamp;

    private Media.Type type;

    private Message.Source source;

    private Long mediaId;

    private String text;

    public static ChatMessage of(Media media) {
        return ChatMessage.builder()
                .deviceId(media.getMessage().getDeviceId())
                .timestamp(media.getMessage().getTimestamp())
                .type(media.getType())
                .source(media.getMessage().getSource())
                .mediaId(media.getId())
                .text(media.getType() == Media.Type.TEXT ? new String(media.getContent(), StandardCharsets.UTF_8) : null)
                .build();
    }
}
