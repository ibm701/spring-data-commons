/*
 * Copyright 2016 the original author or authors.
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
package org.springframework.data.web;

import org.springframework.core.MethodParameter;
import org.springframework.data.domain.Pageable;
import org.springframework.web.context.request.NativeWebRequest;

/**
 * Argument resolver to extract a {@link Pageable} object from a {@link NativeWebRequest} for a particular
 * {@link MethodParameter}. A {@link PageableArgumentResolver} can either resolve {@link Pageable} itself or wrap
 * another {@link PageableArgumentResolver} to post-process {@link Pageable}. {@link Pageable} resolution yields either
 * in a {@link Pageable} object or {@literal null} if {@link Pageable} cannot be resolved.
 *
 * @author Mark Paluch
 * @since 1.13
 * @see org.springframework.web.method.support.HandlerMethodArgumentResolver
 */
public interface PageableArgumentResolver {

	/**
	 * Whether the given {@linkplain MethodParameter method parameter} is supported by this resolver.
	 * 
	 * @param parameter the method parameter to check
	 * @return {@code true} if this resolver supports the supplied parameter; {@code false} otherwise
	 */
	boolean supportsParameter(MethodParameter parameter);

	/**
	 * Resolve a {@link Pageable} object for a {@link MethodParameter} from a {@link NativeWebRequest}.
	 * 
	 * @param parameter must not be {@literal null}.
	 * @param webRequest must not be {@literal null}.
	 * @return the resolved {@link Pageable} or {@literal null} if {@link Pageable} could not be resolved.
	 */
	Pageable resolveArgument(MethodParameter methodParameter, NativeWebRequest webRequest);
}
