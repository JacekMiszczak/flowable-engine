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
package org.flowable.common.spring.async;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;

import org.flowable.common.engine.api.async.AsyncTaskExecutor;

/**
 * @author Filip Hrisafov
 */
public class SpringAsyncTaskExecutor implements AsyncTaskExecutor {

    protected final org.springframework.core.task.AsyncTaskExecutor asyncTaskExecutor;

    public SpringAsyncTaskExecutor(org.springframework.core.task.AsyncTaskExecutor asyncTaskExecutor) {
        this.asyncTaskExecutor = asyncTaskExecutor;
    }

    @Override
    public void execute(Runnable task) {
        asyncTaskExecutor.execute(task);
    }

    @Override
    public Future<?> submit(Runnable task) {
        return asyncTaskExecutor.submit(task);
    }

    @Override
    public <T> Future<T> submit(Callable<T> task) {
        return asyncTaskExecutor.submit(task);
    }

    public org.springframework.core.task.AsyncTaskExecutor getAsyncTaskExecutor() {
        return asyncTaskExecutor;
    }
}