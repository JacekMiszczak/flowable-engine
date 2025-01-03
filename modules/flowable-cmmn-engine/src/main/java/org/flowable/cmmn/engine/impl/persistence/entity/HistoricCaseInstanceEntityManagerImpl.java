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

package org.flowable.cmmn.engine.impl.persistence.entity;

import java.util.Collection;
import java.util.List;

import org.flowable.cmmn.api.history.HistoricCaseInstance;
import org.flowable.cmmn.api.history.HistoricCaseInstanceQuery;
import org.flowable.cmmn.api.runtime.CaseInstance;
import org.flowable.cmmn.engine.CmmnEngineConfiguration;
import org.flowable.cmmn.engine.impl.history.HistoricCaseInstanceQueryImpl;
import org.flowable.cmmn.engine.impl.persistence.entity.data.HistoricCaseInstanceDataManager;
import org.flowable.common.engine.impl.persistence.entity.AbstractEngineEntityManager;

/**
 * @author Joram Barrez
 */
public class HistoricCaseInstanceEntityManagerImpl
    extends AbstractEngineEntityManager<CmmnEngineConfiguration, HistoricCaseInstanceEntity, HistoricCaseInstanceDataManager>
    implements HistoricCaseInstanceEntityManager {

    public HistoricCaseInstanceEntityManagerImpl(CmmnEngineConfiguration cmmnEngineConfiguration, HistoricCaseInstanceDataManager historicCaseInstanceDataManager) {
        super(cmmnEngineConfiguration, historicCaseInstanceDataManager);
    }
    
    @Override
    public HistoricCaseInstanceEntity create(CaseInstance caseInstance) {
        return dataManager.create(caseInstance);
    }

    @Override
    public HistoricCaseInstanceQuery createHistoricCaseInstanceQuery() {
        return new HistoricCaseInstanceQueryImpl(engineConfiguration.getCommandExecutor(), engineConfiguration);
    }
    
    @Override
    public List<HistoricCaseInstanceEntity> findHistoricCaseInstancesByCaseDefinitionId(String caseDefinitionId) {
        return dataManager.findHistoricCaseInstancesByCaseDefinitionId(caseDefinitionId);
    }

    @Override
    public List<String> findHistoricCaseInstanceIdsByParentIds(Collection<String> caseInstanceIds) {
        return dataManager.findHistoricCaseInstanceIdsByParentIds(caseInstanceIds);
    }

    @Override
    public List<HistoricCaseInstance> findByCriteria(HistoricCaseInstanceQuery query) {
        return dataManager.findByCriteria((HistoricCaseInstanceQueryImpl) query);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<HistoricCaseInstance> findWithVariablesByQueryCriteria(HistoricCaseInstanceQuery query) {
        return dataManager.findWithVariablesByQueryCriteria((HistoricCaseInstanceQueryImpl) query);
    }
    
    @Override
    public List<HistoricCaseInstance> findIdsByCriteria(HistoricCaseInstanceQuery query) {
        return dataManager.findIdsByCriteria((HistoricCaseInstanceQueryImpl) query);
    }

    @Override
    public long countByCriteria(HistoricCaseInstanceQuery query) {
        return dataManager.countByCriteria((HistoricCaseInstanceQueryImpl) query);
    }
    
    @Override
    public void deleteHistoricCaseInstances(HistoricCaseInstanceQueryImpl historicCaseInstanceQuery) {
        dataManager.deleteHistoricCaseInstances(historicCaseInstanceQuery);
    }

    @Override
    public void bulkDeleteHistoricCaseInstances(Collection<String> caseInstanceIds) {
        dataManager.bulkDeleteHistoricCaseInstances(caseInstanceIds);
    }
}
