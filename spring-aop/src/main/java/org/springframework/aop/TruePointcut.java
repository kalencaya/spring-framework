/*
 * Copyright 2002-2018 the original author or authors.
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

package org.springframework.aop;

import java.io.Serializable;

/**
 * Canonical Pointcut instance that always matches.
 *
 * @author Rod Johnson
 */
@SuppressWarnings("serial")
final class TruePointcut implements Pointcut, Serializable {

	public static final TruePointcut INSTANCE = new TruePointcut();

	/**
	 * 使用单例模式
	 * Enforce Singleton pattern.
	 */
	private TruePointcut() {
	}

	@Override
	public ClassFilter getClassFilter() {
		return ClassFilter.TRUE;
	}

	@Override
	public MethodMatcher getMethodMatcher() {
		return MethodMatcher.TRUE;
	}

	/**
	 * 为了支持序列化。在反序列化的时候取代具体的实例，保护单例模式。
	 * 序列化和反序列化会破坏单例模式，添加一个readResolve()方法可以避免这种情况
	 *
	 * Required to support serialization. Replaces with canonical
	 * instance on deserialization, protecting Singleton pattern.
	 * Alternative to overriding {@code equals()}.
	 */
	private Object readResolve() {
		return INSTANCE;
	}

	@Override
	public String toString() {
		return "Pointcut.TRUE";
	}

}
