/*
 * Copyright 2017 the original author or authors.
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
plugins {
    id("gradlebuild.distribution.api-java")
    id("gradlebuild.jmh")
}

dependencies {
    api(project(":buildCacheBase"))
    api(project(":snapshots"))

    implementation(project(":baseServices"))
    implementation(project(":coreApi"))
    implementation(project(":files"))
    implementation(project(":native"))
    implementation(project(":persistentCache"))
    implementation(project(":resources"))
    implementation(project(":logging"))

    implementation(libs.slf4jApi)
    implementation(libs.guava)
    implementation(libs.commonsIo)
    implementation(libs.inject)

    jmhImplementation(platform(project(":distributionsDependencies")))
    jmhImplementation(libs.ant)
    jmhImplementation(libs.commonsCompress)
    jmhImplementation("io.airlift:aircompressor:0.8")
    jmhImplementation("org.iq80.snappy:snappy:0.4")
    jmhImplementation("org.kamranzafar:jtar:2.3")

    testImplementation(project(":modelCore"))
    testImplementation(project(":fileCollections"))
    testImplementation(testFixtures(project(":core")))
    testImplementation(testFixtures(project(":baseServices")))

    integTestDistributionRuntimeOnly(project(":distributionsCore"))
}
