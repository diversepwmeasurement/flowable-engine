/* Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.flowable.entitylink.service.impl.persistence.entity;

import java.util.Collection;
import java.util.List;

import org.flowable.common.engine.impl.persistence.entity.EntityManager;
import org.flowable.entitylink.api.InternalEntityLinkQuery;
import org.flowable.entitylink.api.history.HistoricEntityLink;

/**
 * @author Tijs Rademakers
 */
public interface HistoricEntityLinkEntityManager extends EntityManager<HistoricEntityLinkEntity> {

    List<HistoricEntityLink> findHistoricEntityLinksWithSameRootScopeForScopeIdAndScopeType(String scopeId, String scopeType, String linkType);
    
    List<HistoricEntityLink> findHistoricEntityLinksWithSameRootScopeForScopeIdsAndScopeType(Collection<String> scopeIds, String scopeType, String linkType);

    InternalEntityLinkQuery<HistoricEntityLinkEntity> createInternalHistoricEntityLinkQuery();

    void deleteHistoricEntityLinksByScopeIdAndScopeType(String scopeId, String scopeType);
    
    void deleteHistoricEntityLinksByScopeDefinitionIdAndScopeType(String scopeDefinitionId, String scopeType);
    
    void bulkDeleteHistoricEntityLinksForScopeTypeAndScopeIds(String scopeType, Collection<String> scopeIds);

    void deleteHistoricEntityLinksForNonExistingProcessInstances();
    
    void deleteHistoricEntityLinksForNonExistingCaseInstances();
}