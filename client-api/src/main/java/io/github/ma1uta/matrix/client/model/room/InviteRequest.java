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

package io.github.ma1uta.matrix.client.model.room;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.json.bind.annotation.JsonbProperty;

/**
 * Invite request.
 */
@Schema(
    description = "Invite request."
)
public class InviteRequest {

    /**
     * Required. The fully qualified user ID of the invitee.
     */
    @Schema(
        description = "The fully qualified user ID of the invitee."
    )
    @JsonbProperty("user_id")
    private String userId;

    /**
     * Required. The hostname+port of the identity server which should be used for third party identifier lookups.
     */
    @Schema(
        description = "The hostname+port of the identity server which should be used for third "
            + "party identifier lookups."
    )
    @JsonbProperty("id_server")
    private String idServer;

    /**
     * Required. The kind of address being passed in the address field, for example email.
     */
    @Schema(
        description = "The kind of address being passed in the address field, for example email."
    )
    private String medium;

    /**
     * Required. The invitee's third party identifier.
     */
    @Schema(
        description = "The invitee's third party identifier."
    )
    private String address;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getIdServer() {
        return idServer;
    }

    public void setIdServer(String idServer) {
        this.idServer = idServer;
    }

    public String getMedium() {
        return medium;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
