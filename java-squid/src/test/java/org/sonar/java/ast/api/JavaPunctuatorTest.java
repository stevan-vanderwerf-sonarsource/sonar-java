/*
 * SonarQube Java
 * Copyright (C) 2012 SonarSource
 * dev@sonar.codehaus.org
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02
 */
package org.sonar.java.ast.api;

import com.sonar.sslr.api.AstNode;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Mockito.mock;

public class JavaPunctuatorTest {

  @Test
  public void test() {
    assertThat(JavaPunctuator.values()).hasSize(50);

    AstNode astNode = mock(AstNode.class);
    for (JavaPunctuator punctuator : JavaPunctuator.values()) {
      assertThat(punctuator.getName()).isEqualTo(punctuator.name());
      assertThat(punctuator.getValue()).isNotNull();
      assertThat(punctuator.hasToBeSkippedFromAst(astNode)).isFalse();
    }
  }

}
