/**
 * Copyright (C) 2011-2022 Red Hat, Inc. (https://github.com/Commonjava/indy)
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
package org.commonjava.indy.service.models.nfc;

import org.commonjava.indy.service.models.repository.StoreKey;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SuppressWarnings( "unused" )
@Schema( description = "Listing of artifact store paths that could not be retrieved.", name = "not-found cache" )
public class NotFoundCacheDTO
{

    @Schema( required = true, description = "Set of sections each corresponding an artifact store" )
    private Set<NotFoundCacheSectionDTO> sections = new HashSet<NotFoundCacheSectionDTO>();

    public void addSection( final StoreKey key, final List<String> paths )
    {
        sections.add( new NotFoundCacheSectionDTO( key, paths ) );
    }

    public void addSection( final NotFoundCacheSectionDTO sectionDto )
    {
        sections.add( sectionDto );
    }

    public Set<NotFoundCacheSectionDTO> getSections()
    {
        return sections;
    }

    public void setSections( Set<NotFoundCacheSectionDTO> sections )
    {
        this.sections = sections;
    }
}
