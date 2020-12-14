package view;

import javafx.beans.property.*;
import model.Date;
import model.Project;
import model.Status;

public class ProjectViewModel
{
  private StringProperty nameProperty;
  private StringProperty projectIDProperty;
  private StringProperty descriptionProperty;
  private ObjectProperty<Date> deadlineProperty;
  private DoubleProperty estimatedHoursProperty;
  private DoubleProperty hoursSpentProperty;
  private ObjectProperty<Status> statusProperty;

  public ProjectViewModel(Project project)
  {
    nameProperty = new SimpleStringProperty(project.getName());
    projectIDProperty = new SimpleStringProperty(project.getProjectID());
    descriptionProperty = new SimpleStringProperty(project.getDescription());
    deadlineProperty = new SimpleObjectProperty<>(project.getDeadline());
    estimatedHoursProperty = new SimpleDoubleProperty(project.getEstimatedHours());
    statusProperty=new SimpleObjectProperty<>(project.getProjectStatus());
    hoursSpentProperty = new SimpleDoubleProperty(project.getHoursSpentOnProject());
  }

  public StringProperty getNameProperty()
  {
    return nameProperty;
  }

  public StringProperty getProjectIDProperty()
  {
    return projectIDProperty;
  }

  public StringProperty getDescriptionProperty()
  {
    return descriptionProperty;
  }

  public ObjectProperty<Date> getDeadlineProperty()
  {
    return deadlineProperty;
  }

  public DoubleProperty getEstimatedHoursProperty()
  {
    return estimatedHoursProperty;
  }

  public DoubleProperty getHoursSpentProperty()
  {
    return hoursSpentProperty;
  }
  public ObjectProperty<Status> getStatusProperty()
  {
    return statusProperty;
  }
}

