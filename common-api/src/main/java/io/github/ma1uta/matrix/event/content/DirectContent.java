/*
 * Copyright sablintolya@gmail.com
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

package io.github.ma1uta.matrix.event.content;

import static java.util.stream.Collectors.toMap;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A map of which rooms are considered 'direct' rooms for specific users is kept in account_data in an event of type m.direct.
 * The content of this event is an object where the keys are the user IDs and values are lists of room ID strings of the 'direct'
 * rooms for that user ID.
 * <p>
 * Map USER_ID -&gt; ROOM_ID
 * </p>
 */
@Schema(
    description = "A map of which rooms are considered 'direct' rooms for specific users is kept in account_data in"
        + " an event of type m.direct. The content of this event is an object where the keys are the user IDs and values are lists"
        + " of room ID strings of the 'direct' rooms for that user ID."
)
public class DirectContent extends HashMap<String, List<String>> implements EventContent {

    public DirectContent() {
    }

    @SuppressWarnings("unchecked")
    public DirectContent(Map props) {
        super((Map<String, List<String>>) props.entrySet().parallelStream().collect(toMap(
            entry -> ((Map.Entry) entry).getKey(),
            entry -> ((Map.Entry) entry).getValue()
        )));
    }
}
