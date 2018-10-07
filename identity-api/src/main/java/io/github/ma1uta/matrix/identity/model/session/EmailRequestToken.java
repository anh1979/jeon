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

package io.github.ma1uta.matrix.identity.model.session;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.json.bind.annotation.JsonbProperty;

/**
 * JSON body request of the creating an email association.
 */
@Schema(
    description = "JSON body request of the creating an email association."
)
public class EmailRequestToken {

    /**
     * Required. A unique string generated by the client, and used to identify the validation attempt. It must be a string
     * consisting of the characters [0-9a-zA-Z.=_-]. Its length must not exceed 255 characters and it must not be empty.
     */
    @Schema(
        name = "client_secret",
        description = "A unique string generated by the client, and used to identify the validation attempt. It must be a string"
            + " consisting of the characters [0-9a-zA-Z.=_-]. Its length must not exceed 255 characters and it must not be empty.",
        required = true
    )
    @JsonbProperty("client_secret")
    private String clientSecret;

    /**
     * Required. The email address to validate.
     */
    @Schema(
        description = "The email address to validate.",
        required = true
    )
    private String email;

    /**
     * Required. The server will only send an email if the send_attempt is a number greater than the most recent one which
     * it has seen, scoped to that email + client_secret pair. This is to avoid repeatedly sending the same email in the case
     * of request retries between the POSTing user and the identity server. The client should increment this value if they desire
     * a new email (e.g. a reminder) to be sent.
     */
    @Schema(
        name = "send_attempt",
        description = "The server will only send an email if the send_attempt is a number greater than the most recent one which"
            + " it has seen, scoped to that email + client_secret pair. This is to avoid repeatedly sending the same email in the case"
            + " of request retries between the POSTing user and the identity server.The client should increment this value if they desire"
            + " a new email(e.g.a reminder) to be sent.",
        required = true
    )
    @JsonbProperty("send_attempt")
    private Long sendAttempt;

    /**
     * Optional. When the validation is completed, the identity server will redirect the user to this URL.
     */
    @Schema(
        name = "next_link",
        description = "When the validation is completed, the identity server will redirect the user to this URL."
    )
    @JsonbProperty("next_link")
    private String nextLink;

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getSendAttempt() {
        return sendAttempt;
    }

    public void setSendAttempt(Long sendAttempt) {
        this.sendAttempt = sendAttempt;
    }

    public String getNextLink() {
        return nextLink;
    }

    public void setNextLink(String nextLink) {
        this.nextLink = nextLink;
    }
}
