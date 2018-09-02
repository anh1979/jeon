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

package io.github.ma1uta.matrix.identity.api;

import io.github.ma1uta.matrix.identity.model.invitation.InvitationRequest;
import io.github.ma1uta.matrix.identity.model.invitation.InvitationResponse;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

/**
 * An identity service can store pending invitations to a user's 3pid, which will be retrieved and can be either notified on or
 * look up when the 3pid is associated with a Matrix user ID.
 * <br>
 * At a later point, if the owner of that particular 3pid binds it with a Matrix user ID, the identity server will attempt to make
 * an HTTP POST to the Matrix user's homeserver via the /3pid/onbind endpoint. The request MUST be signed with a long-term private
 * key for the identity server.
 */
@Path("/_matrix/identity/api/v1")
public interface InvitationApi {

    /**
     * Store pending invitations to a user's 3pid.
     * <br>
     * In addition to the request parameters specified below, an arbitrary number of other parameters may also be specified.
     * These may be used in the invite message generation described below.
     * <br>
     * The service will generate a random token and an ephemeral key used for accepting the invite.
     * <br>
     * The service also generates a display_name for the inviter, which is a redacted version of address which does not leak the
     * full contents of the address.
     * <br>
     * The service records persistently all of the above information.
     * <br>
     * It also generates an email containing all of this data, sent to the address parameter, notifying them of the invitation.
     * <br>
     * Also, the generated ephemeral public key will be listed as valid on requests to /_matrix/identity/api/v1/pubkey/ephemeral/isvalid.
     * <br>
     * Currently, invites may only be issued for 3pids of the email medium.
     *
     * @param request         JSON body request.
     * @param servletRequest  Servlet request.
     * @param servletResponse Servlet response.
     * @return <p>Status code 200: The invitation was stored.</p>
     * <p>Status code 400: An error has occured. If the 3pid is already bound to a Matrix user ID, the error code
     * will be M_THREEPID_IN_USE. If the medium is unsupported, the error code will be M_UNRECOGNIZED.</p>
     */
    @POST
    @Path("/store-invite")
    @Produces(MediaType.APPLICATION_JSON)
    InvitationResponse invite(
        InvitationRequest request,

        @Context HttpServletRequest servletRequest,
        @Context HttpServletResponse servletResponse
    );
}
