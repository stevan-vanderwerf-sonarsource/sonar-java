/*
 * Copyright (C) 2012-2024 SonarSource SA - mailto:info AT sonarsource DOT com
 * This code is released under [MIT No Attribution](https://opensource.org/licenses/MIT-0) license.
 */
package org.sonar.samples.java;

import org.sonar.api.Plugin;
import org.sonar.api.config.PropertyDefinition;
import org.sonar.api.resources.Qualifiers;

/**
 * Entry point of your plugin containing your custom rules
 */
public class MyJavaRulesPlugin implements Plugin {

  public static final String TEXT_STRINGS_KEY = "sonar.javacustom.text.strings";

  @Override
  public void define(Context context) {
    // server extensions -> objects are instantiated during server startup
    context.addExtensions(
        PropertyDefinition.builder(TEXT_STRINGS_KEY)
          .name("Text strings")
          .description("Comma-separated list of text strings for files to analyze.")
          .defaultValue(TEXT_STRINGS_KEY)
          .multiValues(true)
          .category("CustomPlugin")
          .onQualifiers(Qualifiers.PROJECT)
          .build(),
    MyJavaRulesDefinition.class);

    // batch extensions -> objects are instantiated during code analysis
    context.addExtension(MyJavaFileCheckRegistrar.class);

  }

}
