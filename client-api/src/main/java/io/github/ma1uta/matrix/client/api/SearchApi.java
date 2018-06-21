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

package io.github.ma1uta.matrix.client.api;

import static io.github.ma1uta.matrix.client.api.SearchApi.PATH;

import io.github.ma1uta.matrix.RateLimit;
import io.github.ma1uta.matrix.Secured;
import io.github.ma1uta.matrix.client.model.search.SearchRequest;
import io.github.ma1uta.matrix.client.model.search.SearchResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;

/**
 * The search API allows clients to perform full text search across events in all rooms that the user has been in, including those
 * that they have left. Only events that the user is allowed to see will be searched, e.g. it won't include events in rooms that
 * happened after you left.
 * <p/>
 * <a href="https://matrix.org/docs/spec/client_server/r0.3.0.html#id395">Specification.</a>
 */
@Api(value = PATH, description = "The search API allows clients to perform full text search across events in all rooms that "
    + "the user has been in, including those that they have left. Only events that the user is allowed to see will be searched, "
    + "e.g. it won't include events in rooms that happened after you left.")
@Path(PATH)
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface SearchApi {

    /**
     * Search api url.
     */
    String PATH = "/_matrix/client/r0";

    /**
     * Performs a full text search across different categories.
     * <p/>
     * <b>Rate-limited</b>: Yes.
     * <p/>
     * <b>Requires auth</b>: Yes.
     *
     * @param nextBatch       The point to return events from. If given, this should be a next_batch result from a previous call
     *                        to this endpoint.
     * @param searchRequest   JSON body request.
     * @param servletRequest  servlet request.
     * @param servletResponse servlet response.
     * @param securityContext security context.
     * @return Status code 200: Results of the search.
     *     Status code 400: Part of the request was invalid.
     *     Status code 429: This request was rate-limited.
     */
    @ApiOperation(value = "Performs a full text search across different categories.", response = SearchResponse.class)
    @ApiResponses( {
        @ApiResponse(code = 200, message = "Results of the search."),
        @ApiResponse(code = 400, message = "Part of the request was invalid."),
        @ApiResponse(code = 429, message = "This request was rate-limited.")
    })
    @POST
    @RateLimit
    @Secured
    @Path("/search")
    SearchResponse search(
        @ApiParam("The point to return events from. If given, this should be a next_batch result from a previous call "
            + "to this endpoint.") @QueryParam("next_batch") String nextBatch,
        @ApiParam("JSON body request") SearchRequest searchRequest,
        @Context HttpServletRequest servletRequest, @Context HttpServletResponse servletResponse, @Context SecurityContext securityContext);
}
