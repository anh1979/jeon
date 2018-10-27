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

package io.github.ma1uta.matrix.client.model.search;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.json.bind.annotation.JsonbProperty;

/**
 * JSON body response for search api.
 */
@Schema(
    description = "JSON body response for search api."
)
public class SearchResponse {

    /**
     * Required. Describes which categories to search in and their criteria.
     */
    @Schema(
        description = "Describes which categories to search in and their criteria."
    )
    @JsonbProperty("search_categories")
    private ResponseCategories searchCategories;

    @JsonProperty("search_categories")
    public ResponseCategories getSearchCategories() {
        return searchCategories;
    }

    public void setSearchCategories(ResponseCategories searchCategories) {
        this.searchCategories = searchCategories;
    }
}
