/*
 * Copyright 2017, OpenSkywalking Organization All rights reserved.
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
 *
 * Project repository: https://github.com/OpenSkywalking/skywalking
 */

package org.skywalking.apm.plugin.spring.mvc;

import java.lang.reflect.Method;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * The <code>RequestMappingMethodInterceptor</code> only use the first mapping value.
 * it will inteceptor with <code>@RequestMapping</code>
 *
 * @author clevertension
 */
public class RequestMappingMethodInterceptor extends AbstractMethodInteceptor {
    @Override
    public String getRequestURL(Method method) {
        String requestURL = "";
        RequestMapping methodRequestMapping = method.getAnnotation(RequestMapping.class);
        if (methodRequestMapping.value().length > 0) {
            requestURL = methodRequestMapping.value()[0];
        } else if (methodRequestMapping.path().length > 0) {
            requestURL = methodRequestMapping.path()[0];
        }
        return requestURL;
    }
}
