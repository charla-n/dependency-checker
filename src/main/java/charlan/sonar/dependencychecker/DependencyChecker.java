package charlan.sonar.dependencychecker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.sonar.api.Properties;
import org.sonar.api.Property;
import org.sonar.api.PropertyType;
import org.sonar.api.SonarPlugin;
import org.sonar.api.config.PropertyDefinition;
import org.sonar.api.config.PropertyFieldDefinition;
import org.sonar.api.resources.Qualifiers;

import charlan.sonar.dependencychecker.batch.ExampleSensor;
import charlan.sonar.dependencychecker.batch.RandomDecorator;
import charlan.sonar.dependencychecker.ui.ExampleRubyWidget;

public final class DependencyChecker extends SonarPlugin {
	
	public static final String DEPENDENCY_CHECKER_LIST = "dependencychecker";
	public static final String GROUP_ID = "groupid";
	public static final String ARTIFACT_ID = "artifactid";
	public static final String VERSION = "version";
	public static final String FORBIDDEN = "forbidden";

	@Override
	public List<?> getExtensions() {
		
		List<PropertyFieldDefinition> fields = new ArrayList<PropertyFieldDefinition>();
		fields.add(PropertyFieldDefinition.build(GROUP_ID).
  		  			description("Specify the dependency groupid").name("GroupId").type(PropertyType.STRING).build());
		fields.add(PropertyFieldDefinition.build(ARTIFACT_ID).
		  		  description("Specify the dependency artifactid").name("ArtifactId").type(PropertyType.STRING).build());
		fields.add(PropertyFieldDefinition.build(VERSION).
		  		  description("Specify the dependency version. 3 possible inputs (Empty, Fixed version, Maven Range version)").
		  		  name("Version").type(PropertyType.STRING).build());
		fields.add(PropertyFieldDefinition.build(FORBIDDEN).
		  		  description("Specify if the dependency is forbidden").name("Forbidden").type(PropertyType.BOOLEAN).build());
  		  
		
		return Arrays.asList(
      PropertyDefinition.builder(DEPENDENCY_CHECKER_LIST).name("Dependency Checker").type(PropertyType.PROPERTY_SET).
      fields(fields).onlyOnQualifiers(Qualifiers.PROJECT).build(),
      ExampleMetrics.class, ExampleSensor.class, RandomDecorator.class, ExampleRubyWidget.class);
  }
}
