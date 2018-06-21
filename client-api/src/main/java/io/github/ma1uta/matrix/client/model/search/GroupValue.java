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
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * Group value.
 */
@ApiModel(description = "Group value.")
public class GroupValue {

    /**
     * Token that can be used to get the next batch of results in the group, by passing as the next_batch parameter to the next call.
     * If this field is absent, there are no more results in this group.
     */
    @ApiModelProperty(name = "next_batch", value = "Token that can be used to get the next batch of results in the group, by passing "
        + "as the next_batch parameter to the next call. If this field is absent, there are no more results in this group.")
    @JsonProperty("next_batch")
    private String nextBatch;

    /**
     * Key that can be used to order different groups.
     */
    @ApiModelProperty("Key that can be used to order different groups.")
    private Long order;

    /**
     * Which results are in this group.
     */
    @ApiModelProperty("Which results are in this group.")
    private List<String> results;

    public String getNextBatch() {
        return nextBatch;
    }

    public void setNextBatch(String nextBatch) {
        this.nextBatch = nextBatch;
    }

    public Long getOrder() {
        return order;
    }

    public void setOrder(Long order) {
        this.order = order;
    }

    public List<String> getResults() {
        return results;
    }

    public void setResults(List<String> results) {
        this.results = results;
    }
}
