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

package io.github.ma1uta.matrix.server.api;

import io.github.ma1uta.matrix.server.model.version.VersionResponse;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

/**
 * Version of the server federation endpoints.
 */
@Path("/_matrix/federaion/v1")
@Produces(MediaType.APPLICATION_JSON)
public interface VersionApi {

    /**
     * Get the implementation name and version of this homeserver.
     *
     * @param servletRequest  servlet request.
     * @param servletResponse servlet response.
     * @return <p>Status code 200: The implementation name and version of this homeserver.</p>
     */
    @GET
    @Path("/version")
    VersionResponse version(@Context HttpServletRequest servletRequest, @Context HttpServletResponse servletResponse);
}
