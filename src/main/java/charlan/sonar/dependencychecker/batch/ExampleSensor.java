package charlan.sonar.dependencychecker.batch;

import org.sonar.api.utils.log.*;

import charlan.sonar.dependencychecker.ExampleMetrics;
import charlan.sonar.dependencychecker.DependencyChecker;

import org.sonar.api.batch.Sensor;
import org.sonar.api.batch.SensorContext;
import org.sonar.api.batch.fs.FileSystem;
import org.sonar.api.batch.fs.InputFile;
import org.sonar.api.config.Settings;
import org.sonar.api.measures.Measure;
import org.sonar.api.resources.Project;

public class ExampleSensor implements Sensor {

  private static final Logger LOG = Loggers.get(ExampleSensor.class);

  private Settings settings;
  private FileSystem fs;

  /**
   * Use of IoC to get Settings and FileSystem
   */
  public ExampleSensor(Settings settings, FileSystem fs) {
    this.settings = settings;
    this.fs = fs;
  }

  @Override
  public boolean shouldExecuteOnProject(Project project) {
    // This sensor is executed only when there are Java files
    return fs.hasFiles(fs.predicates().hasLanguage("java"));
  }

  @Override
  public void analyse(Project project, SensorContext sensorContext) {
    // This sensor create a measure for metric MESSAGE on each Java file
//    String value = settings.getString(DependencyChecker.MY_PROPERTY);
//    LOG.info(DependencyChecker.MY_PROPERTY + "=" + value);
//    for (InputFile inputFile : fs.inputFiles(fs.predicates().hasLanguage("java"))) {
//      sensorContext.saveMeasure(inputFile, new Measure<String>(ExampleMetrics.MESSAGE, value));
//    }
  }

  @Override
  public String toString() {
    return getClass().getSimpleName();
  }

}
