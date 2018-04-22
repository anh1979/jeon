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

import io.github.ma1uta.matrix.client.model.Event;
import io.github.ma1uta.matrix.client.model.Page;
import io.github.ma1uta.matrix.client.model.StateEvent;
import io.github.ma1uta.matrix.client.model.event.JoinedMembersResponse;
import io.github.ma1uta.matrix.client.model.event.MembersResponse;
import io.github.ma1uta.matrix.client.model.event.RedactRequest;
import io.github.ma1uta.matrix.client.model.event.SendEventResponse;

import java.util.List;
import java.util.Map;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/_matrix/client/r0/rooms/")
public interface EventApi {

    @GET
    @Path("/{roomId}/state/{eventType}/{stateKey}")
    Map<String, Object> eventsForRoomWithTypeAndState(@PathParam("roomId") String roomId, @PathParam("eventType") String eventType,
                                                      @PathParam("stateKey") String stateKey);

    @GET
    @Path("/{roomId}/state/{eventType}")
    Map<String, Object> eventsForRoomWithType(@PathParam("roomId") String roomId, @PathParam("eventType") String eventType);

    @GET
    @Path("/{roomId}/state")
    List<StateEvent> eventsForRoom(@PathParam("roomId") String roomId);

    @GET
    @Path("/{roomId}/members")
    MembersResponse members(@PathParam("roomId") String roomId);

    @GET
    @Path("/{roomId}/joined_members")
    JoinedMembersResponse joinedMembers(@PathParam("roomId") String roomId);

    @GET
    @Path("/{roomId}/messages")
    Page<Event> messages(@PathParam("roomId") String roomId);

    @PUT
    @Path("/{roomId}/state/{eventType}/{stateKey}")
    SendEventResponse sendEventWithTypeAndState(@PathParam("roomId") String roomId, @PathParam("eventType") String eventType,
                                                @PathParam("stateKey") String stateKey, Map<String, Object> event);

    @PUT
    @Path("/{roomId}/state/{eventType}")
    SendEventResponse sendEventWithType(@PathParam("roomId") String roomId, @PathParam("eventType") String eventType,
                                        Map<String, Object> event);

    @PUT
    @Path("/{roomId}/send/{eventType}/{txnId}")
    SendEventResponse sendEvent(@PathParam("roomId") String roomId, @PathParam("eventType") String eventType,
                                @PathParam("txnId") String txnId, Map<String, Object> event);

    @PUT
    @Path("/{roomId}/redact/{eventType}/{txnId}")
    SendEventResponse redact(@PathParam("roomId") String roomId, @PathParam("eventType") String eventType,
                             @PathParam("txnId") String txnId, RedactRequest event);

}
