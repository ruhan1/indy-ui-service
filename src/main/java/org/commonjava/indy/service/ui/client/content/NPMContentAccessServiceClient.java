/**
 * Copyright (C) 2023 Red Hat, Inc. (https://github.com/Commonjava/indy-ui-service)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.commonjava.indy.service.ui.client.content;

import org.commonjava.indy.service.ui.client.Constants;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.HEAD;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;

@Path( "/api/content/npm/{type: (hosted|group|remote)}/{name}" )
@RegisterRestClient( configKey = "service-api" )
public interface NPMContentAccessServiceClient
{

    @PUT
    @Path( "/{packageName}" )
    Response doCreate( final @PathParam( "type" ) String type, final @PathParam( "name" ) String name,
                       final @PathParam( "packageName" ) String packageName, final @Context UriInfo uriInfo,
                       final @Context HttpServletRequest request );

    @PUT
    @Path( "/{packageName}/{versionTarball}" )
    Response doCreate( final @PathParam( "type" ) String type, final @PathParam( "name" ) String name,
                       final @PathParam( "packageName" ) String packageName,
                       final @PathParam( "versionTarball" ) String versionTarball, final @Context UriInfo uriInfo,
                       final @Context HttpServletRequest request );

    @DELETE
    @Path( "/{path}" )
    Response doDelete( final @PathParam( "type" ) String type, final @PathParam( "name" ) String name,
                       final @PathParam( "path" ) String path,
                       final @QueryParam( Constants.CHECK_CACHE_ONLY ) Boolean cacheOnly );

    @HEAD
    @Path( "/{packageName}" )
    Response doHead( final @PathParam( "type" ) String type, final @PathParam( "name" ) String name,
                     final @PathParam( "packageName" ) String packageName,
                     @QueryParam( Constants.CHECK_CACHE_ONLY ) final Boolean cacheOnly, @Context final UriInfo uriInfo,
                     @Context final HttpServletRequest request );

    @HEAD
    @Path( "/{packageName}/{versionTarball: (.*)}" )
    Response doHead( final @PathParam( "type" ) String type, final @PathParam( "name" ) String name,
                     final @PathParam( "packageName" ) String packageName,
                     final @PathParam( "versionTarball" ) String versionTarball,
                     @QueryParam( Constants.CHECK_CACHE_ONLY ) final Boolean cacheOnly, @Context final UriInfo uriInfo,
                     @Context final HttpServletRequest request );

    @GET
    @Path( "/{packageName}" )
    Response doGet( final @PathParam( "type" ) String type, final @PathParam( "name" ) String name,
                    final @PathParam( "packageName" ) String packageName, @Context final UriInfo uriInfo,
                    @Context final HttpServletRequest request );

    @GET
    @Path( "/{packageName}/{versionTarball: (.*)}" )
    Response doGet( final @PathParam( "type" ) String type, final @PathParam( "name" ) String name,
                    final @PathParam( "packageName" ) String packageName,
                    final @PathParam( "versionTarball" ) String versionTarball, @Context final UriInfo uriInfo,
                    @Context final HttpServletRequest request );

    @GET
    @Path( "/" )
    Response doGet( final @PathParam( "type" ) String type, final @PathParam( "name" ) String name,
                    @Context final UriInfo uriInfo, @Context final HttpServletRequest request );

}
