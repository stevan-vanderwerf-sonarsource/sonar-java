/*
 * SonarQube Java
 * Copyright (C) 2012-2024 SonarSource SA
 * mailto:info AT sonarsource DOT com
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
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */
package org.sonar.java.model.pattern;

import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;
import org.eclipse.jdt.core.dom.ITypeBinding;
import org.sonar.plugins.java.api.tree.Tree;
import org.sonar.plugins.java.api.tree.TreeVisitor;
import org.sonar.plugins.java.api.tree.TypePatternTree;
import org.sonar.plugins.java.api.tree.VariableTree;

/**
 * JDK 17 Preview feature (JEP-406), finalized in JDK 21 (JEP-441).
 */
public class TypePatternTreeImpl extends AbstractPatternTree implements TypePatternTree {

  private final VariableTree patternVariable;

  public TypePatternTreeImpl(VariableTree patternVariable, @Nullable ITypeBinding typeBinding) {
    super(Tree.Kind.TYPE_PATTERN, typeBinding);
    this.patternVariable = patternVariable;
  }

  @Override
  public void accept(TreeVisitor visitor) {
    visitor.visitTypePattern(this);
  }

  @Override
  public VariableTree patternVariable() {
    return patternVariable;
  }

  @Override
  protected List<Tree> children() {
    return Collections.singletonList(patternVariable);
  }

}
