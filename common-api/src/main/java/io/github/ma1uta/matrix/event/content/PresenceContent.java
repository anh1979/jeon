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

import io.github.ma1uta.matrix.support.DeserializerUtil;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Map;
import javax.json.bind.annotation.JsonbProperty;

/**
 * Informs the client of a user's presence state change.
 */
@Schema(
    description = "Informs the client of a user's presence state change."
)
public class PresenceContent implements EventContent {

    /**
     * The current avatar URL for this user, if any.
     */
    @Schema(
        name = "avatar_url",
        description = "The current avatar URL for this user, if any."
    )
    @JsonbProperty("avatar_url")
    private String avatarUrl;

    /**
     * The current display name for this user, if any.
     */
    @Schema(
        name = "displayname",
        description = "The current display name for this user, if any."
    )
    @JsonbProperty("displayname")
    private String displayName;

    /**
     * The last time since this used performed some action, in milliseconds.
     */
    @Schema(
        name = "last_active_ago",
        description = "The last time since this used performed some action, in milliseconds."
    )
    @JsonbProperty("last_active_ago")
    private Long lastActiveAgo;

    /**
     * Required. The presence state for this user. One of: ["online", "offline", "unavailable"].
     */
    @Schema(
        description = "The presence state for this user.",
        required = true,
        allowableValues = "online, offline, unavailable"
    )
    private String presence;

    /**
     * Whether the user is currently active.
     */
    @Schema(
        name = "currently_active",
        description = "Whether the user is currently active."
    )
    @JsonbProperty("currently_active")
    private Boolean currentlyActive;

    public PresenceContent() {
    }

    public PresenceContent(Map props) {
        this.avatarUrl = DeserializerUtil.toString(props, "avatar_url");
        this.displayName = DeserializerUtil.toString(props, "displayname");
        this.lastActiveAgo = DeserializerUtil.toLong(props, "last_active_ago");
        this.presence = DeserializerUtil.toString(props, "presence");
        this.currentlyActive = DeserializerUtil.toBoolean(props, "currently_active");
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public Long getLastActiveAgo() {
        return lastActiveAgo;
    }

    public void setLastActiveAgo(Long lastActiveAgo) {
        this.lastActiveAgo = lastActiveAgo;
    }

    public String getPresence() {
        return presence;
    }

    public void setPresence(String presence) {
        this.presence = presence;
    }

    public Boolean getCurrentlyActive() {
        return currentlyActive;
    }

    public void setCurrentlyActive(Boolean currentlyActive) {
        this.currentlyActive = currentlyActive;
    }
}
