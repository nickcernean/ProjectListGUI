package view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import model.Project;
import model.ProjectList;
import model.ProjectListModel;

public class ProjectDetailsViewController
{
  @FXML private TextField projectID;
  @FXML private TextField name;
  @FXML private TextField description;
  @FXML private TextField numberOfTeamMembers;
  @FXML private TextField spentHours;
  @FXML private TextField estimatedHours;
  @FXML private TextField deadline;
  @FXML private Label errorLabel;

  private Region root;
  private ProjectListModel model;
  private ViewHandler viewHandler;
  private Project project;

  public ProjectDetailsViewController()
  {
    // Called by FXMLLoader
  }

  public void init(ViewHandler viewHandler, ProjectListModel model, Region root, Project project)
  {
    this.model = model;
    this.viewHandler = viewHandler;
    this.root = root;
    this.project=project;
    reset();
  }

  public void reset()
  {
    this.projectID.setText("");
    this.name.setText("");
    this.description.setText("");
    this.numberOfTeamMembers.setText("");
    this.estimatedHours.setText("");
    this.deadline.setText("");
    try
    {
      this.projectID.setText(model.getprojectID(project));
      this.projectID.setEditable(false);
      this.name.setText(model.getProjectName(project));
      this.name.setEditable(false);
      this.projectID.setEditable(false);
      this.description.setText(model.getProjectDescription(project));
      this.description.setEditable(false);
      this.numberOfTeamMembers.setText(0+"");
      this.numberOfTeamMembers.setEditable(false);
      this.spentHours.setText(model.getTeamMembersOfAProject(model.getprojectID(project))+"");
      this.spentHours.setEditable(false);
//      this.estimatedHours.setText(model+"");
//      this.estimatedHours.setEditable(false);
//      this.deadline.setText(model.getDeadlineOfTheTask(task)+"");
//      this.deadline.setEditable(false);
//      this.errorLabel.setText("");
    }
    catch (Exception e)
    {
      this.errorLabel.setText(e.getMessage());
    }
  }

  public Region getRoot()
  {
    return root;
  }

  @FXML private void backButtonPressed()
  {
    viewHandler.openView("projectList");
  }
  @FXML private void addTimeSpentButtonPressed(){viewHandler.openView("addHoursSpent",project);}


}