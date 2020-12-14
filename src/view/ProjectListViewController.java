package view;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Region;
import model.Date;
import model.Project;
import model.ProjectListModel;
import model.Status;

import java.util.Optional;

public class ProjectListViewController
{
  @FXML private TableView<ProjectViewModel> projectListTable;
  @FXML private TableColumn<ProjectViewModel, String> nameColumn;
  @FXML private TableColumn<ProjectViewModel, String> projectIDColumn;
  @FXML private TableColumn<ProjectViewModel, String> descriptionColumn;
  @FXML private TableColumn<ProjectViewModel, Date> deadlineColumn;
  @FXML private TableColumn<ProjectViewModel, Number> estimatedHoursColumn;
  @FXML private TableColumn<ProjectViewModel, Status> statusColumn;
  @FXML private TableColumn<ProjectViewModel, Number> hoursSpentColumn;

  @FXML private Label errorLabel;

  private Region root;
  private ProjectListModel model;
  private ViewHandler viewHandler;
  private ProjectListViewModel viewModel;

  public ProjectListViewController()
  {
    // Called by FXMLLoader
  }

  public void init(ViewHandler viewHandler, ProjectListModel model, Region root)
  {
    this.model = model;
    this.viewHandler = viewHandler;
    this.root = root;
    this.viewModel = new ProjectListViewModel(model);

    nameColumn
        .setCellValueFactory(cellData -> cellData.getValue().getNameProperty());
    projectIDColumn.setCellValueFactory(
        cellData -> cellData.getValue().getProjectIDProperty());
    descriptionColumn.setCellValueFactory(
        cellData -> cellData.getValue().getDescriptionProperty());
    deadlineColumn.setCellValueFactory(
        cellData -> cellData.getValue().getDeadlineProperty());
    estimatedHoursColumn.setCellValueFactory(
        cellData -> cellData.getValue().getEstimatedHoursProperty());
    statusColumn.setCellValueFactory(
        cellData -> cellData.getValue().getStatusProperty());
    hoursSpentColumn.setCellValueFactory(
        cellData -> cellData.getValue().getHoursSpentProperty());

    projectListTable.setItems(viewModel.getList());
  }

  public void reset()
  {
    errorLabel.setText("");

    viewModel.update();
  }

  public Region getRoot()
  {
    return root;
  }

  @FXML private void addProjectButtonPressed()
  {
    viewHandler.openView("addProject");
  }

  @FXML private void removeProjectButtonPressed()
  {
    errorLabel.setText("");
    try
    {
      ProjectViewModel selectedItem = projectListTable.getSelectionModel()
          .getSelectedItem();
      if (selectedItem == null)
      {
        throw new IllegalArgumentException("No item selected");
      }
      boolean remove = confirmation();
      if (remove)
      {
        Project project = new Project(selectedItem.getNameProperty().get(),
            selectedItem.getProjectIDProperty().get(),
            selectedItem.getDescriptionProperty().get(),
            selectedItem.getDeadlineProperty().get(),
            selectedItem.getEstimatedHoursProperty().get(),
            selectedItem.getStatusProperty().get());
        model.removeProject(project.getProjectID());
        viewModel.remove(project);
        projectListTable.getSelectionModel().clearSelection();
      }
    }
    catch (Exception e)
    {
      errorLabel.setText("Item not found: " + e.getMessage());
    }
  }

  @FXML private void showProjectDetailsButtonPressed()
  {
    viewHandler.openView("details");
  }

  private boolean confirmation()
  {
    int index = projectListTable.getSelectionModel().getSelectedIndex();
    ProjectViewModel selectedItem = projectListTable.getItems().get(index);
    if (index < 0 || index >= projectListTable.getItems().size())
    {
      return false;
    }
    Alert alert = new Alert(AlertType.CONFIRMATION);
    alert.setTitle("Confirmation");
    alert.setHeaderText(
        "Removing project  " + selectedItem.getNameProperty().get() + ":"
            + selectedItem.getProjectIDProperty().get() + ":" + selectedItem
            .getDescriptionProperty().get() + ":" + selectedItem
            .getDeadlineProperty().get() + ":" + selectedItem
            .getEstimatedHoursProperty().get() + ":" + selectedItem
            .getStatusProperty().get());

    Optional<ButtonType> result = alert.showAndWait();
    return ((result.isPresent()) && (result.get() == ButtonType.OK));
  }

  @FXML private void showTaskDetailsButtonPressed()
  {
    try
    {
      ProjectViewModel selectedItem = projectListTable.getSelectionModel()
          .getSelectedItem();
      if (selectedItem == null)
      {
        throw new IllegalArgumentException("No item selected");
      }
      boolean open = confirmationOpen();
      if (open)
      {
        Project project = new Project(selectedItem.getNameProperty().get(),
            selectedItem.getProjectIDProperty().get(),
            selectedItem.getDescriptionProperty().get(),
            selectedItem.getDeadlineProperty().get(),
            selectedItem.getEstimatedHoursProperty().get(),
            selectedItem.getStatusProperty().get());
        viewHandler.openView("projectDetails", project);
        projectListTable.getSelectionModel().clearSelection();
      }
    }

    catch (IllegalArgumentException e)
    {
      errorLabel.setText(e.getMessage());
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }

  private boolean confirmationOpen()
  {
    int index = projectListTable.getSelectionModel().getSelectedIndex();
    ProjectViewModel selectedItem = projectListTable.getItems().get(index);
    if (index < 0 || index >= projectListTable.getItems().size())
    {
      return false;
    }
    Alert alert = new Alert(AlertType.CONFIRMATION);
    alert.setTitle("Confirmation");
    alert.setHeaderText(
        "Opening project: { ProjectID: " + selectedItem.getProjectIDProperty().get()
            + ", Project Name: " + selectedItem.getNameProperty().get()
            + ", Project Description: " + selectedItem.getDescriptionProperty()
            .get() + ", Deadline: " + selectedItem.getDeadlineProperty().get()
            + ", Estimated Hours To Finish: " + selectedItem
            .getEstimatedHoursProperty().get() + "Task Status: " + selectedItem
            .getStatusProperty().get() + "}");
    Optional<ButtonType> result = alert.showAndWait();
    return ((result.isPresent()) && (result.get() == ButtonType.OK));
  }

  @FXML private void backButtonPressed()
  {
    viewHandler.openView("projects");
  }
}















