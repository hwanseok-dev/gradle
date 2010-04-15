/*
 * Copyright 2010 the original author or authors.
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
package org.gradle.api.internal.project;

import org.gradle.api.internal.ClassPathRegistry;
import org.gradle.api.internal.DefaultClassPathRegistry;
import org.gradle.cache.AutoCloseCacheFactory;
import org.gradle.cache.CacheFactory;
import org.gradle.initialization.*;
import org.gradle.logging.DefaultLoggingManagerFactory;
import org.gradle.logging.LoggingManagerFactory;
import org.gradle.util.JUnit4GroovyMockery;
import org.jmock.integration.junit4.JMock;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

@RunWith(JMock.class)
public class GlobalServicesRegistryTest {
    private final JUnit4GroovyMockery context = new JUnit4GroovyMockery();
    private final GlobalServicesRegistry registry = new GlobalServicesRegistry(context.mock(LoggingConfigurer.class));

    @Test
    public void providesCommandLineArgsConverter() {
        assertThat(registry.get(CommandLine2StartParameterConverter.class), instanceOf(
                DefaultCommandLine2StartParameterConverter.class));
    }

    @Test
    public void providesACacheFactory() {
        assertThat(registry.get(CacheFactory.class), instanceOf(AutoCloseCacheFactory.class));
    }

    @Test
    public void providesAClassPathRegistry() {
        assertThat(registry.get(ClassPathRegistry.class), instanceOf(DefaultClassPathRegistry.class));
    }

    @Test
    public void providesAClassLoaderFactory() {
        assertThat(registry.get(ClassLoaderFactory.class), instanceOf(DefaultClassLoaderFactory.class));
    }

    @Test
    public void providesALoggingManagerFactory() {
        assertThat(registry.get(LoggingManagerFactory.class), instanceOf(DefaultLoggingManagerFactory.class));
    }
}
