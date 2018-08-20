/*
 * Copyright 2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
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

package org.gradle.buildinit.plugins.internal;

public interface ScriptBlockBuilder {
    /**
     * Adds a plugin to be applied
     *
     * @param comment A description of why the plugin is required
     */
    ScriptBlockBuilder plugin(String comment, String pluginId);

    /**
     * Adds a top level property assignment statement.
     */
    ScriptBlockBuilder propertyAssignment(String comment, String propertyName, Object propertyValue);

    /**
     * Adds a property assignment statement to the configuration of all tasks with the given type.
     */
    ScriptBlockBuilder taskPropertyAssignment(String comment, String taskType, String propertyName, Object propertyValue);
}
