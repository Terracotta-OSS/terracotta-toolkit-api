/*
 * Copyright Terracotta, Inc.
 * Copyright IBM Corp. 2024, 2025
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
package org.terracotta.toolkit.search.expression;

/**
 * A clause is a constraining boolean statement for use in search queries.
 */
public interface Clause {
  /**
   * Produce a clause that is the boolean "and" of this and the other given clause
   * 
   * @param other
   * @return and clause
   */
  Clause and(Clause other);

  /**
   * Produce a clause that is the boolean "or" of this and the other given clause
   * 
   * @param other
   * @return or clause
   */
  Clause or(Clause other);

  /**
   * Produce a clause that is the boolean "not" of this
   * 
   * @return not clause
   */
  Clause not();

}
