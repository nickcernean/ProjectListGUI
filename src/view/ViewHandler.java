package view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import model.Project;
import model.ProjectListModel;
import model.Task;

public class ViewHandler
{
  private Scene currentScene;
  private Stage primaryStage;
  private ProjectListModel model;
  private ProjectListViewController projectListViewController;
  private AddProjectViewControler addPojectViewController;
  private ProjectDetailsViewController taskDetailsViewController;
  private AddProjectViewControler addProjectViewController;

  public ViewHandler(ProjectListModel model)
  {
    this.model = model;
    currentScene = new Scene(new Region());
  }

  public void start(Stage primaryStage)
  {
    this.primaryStage = primaryStage;
    openView("projectlist");
  }

  public void openView(String id)
  {
    Region root = null;
    switch (id)
    {
      case "projectlist":
        root = loadProjectListView("ProjectListView.fxml");
        break;
      case "addProject":
        root = loadAddProjectView("AddProjectView.fxml");
        break;
    }
    currentScene.setRoot(root);
    String title = "";

    if (root.getUserData() != null)
    {
      title += root.getUserData();
    }
    primaryStage.setTitle(title);
    primaryStage.setScene(currentScene);
    primaryStage.setWidth(root.getPrefWidth());
    primaryStage.setHeight(root.getPrefHeight());
    primaryStage.show();
  }

  public void openView(String id, Project project)
  {
    Region root = null;
    switch (id)
    {
      case "ProjectDetails":
        root = loadProjectDetailsView("ProjectDetailsView.fxml", project);
        break;
    }
    currentScene.setRoot(root);
    String title = "";
    if (root.getUserData() != null)
    {
      title += root.getUserData();
    }
    primaryStage.setTitle(title);
    primaryStage.setScene(currentScene);
    primaryStage.setWidth(root.getPrefWidth());
    primaryStage.setHeight(root.getPrefHeight());
    primaryStage.show();
  }

  public void closeView()
  {
    primaryStage.close();
  }

  private Region loadProjectListView(String fxmlFile)
  {
    if (projectListViewController == null)
    {
      try
      {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxmlFile));
        Region root = loader.load();
        projectListViewController = loader.getController();
        projectListViewController.init(this, model, root);
      }
      catch (Exception e)
      {
        e.printStackTrace();
      }
    }
    else
    {
      projectListViewController.reset();
    }
    return projectListViewController.getRoot();
  }

  private Region loadProjectDetailsView(String fxmlFile, Project project)
  {
    try
    {
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(getClass().getResource(fxmlFile));
      Region root = loader.load();
      taskDetailsViewController = loader.getController();
      taskDetailsViewController.init(this, model, root, project);
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    return taskDetailsViewController.getRoot();
  }

  private Region loadAddProjectView(String fxmlFile)
  {
    if (addProjectViewController == null)
    {
      try
      {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxmlFile));
        Region root = loader.load();
        addProjectViewController = loader.getController();
        addProjectViewController.init(this, model, root);
      }
      catch (Exception e)
      {
        e.printStackTrace();
      }
    }
    else
    {
      addProjectViewController.reset();
    }
    return addProjectViewController.getRoot();
  }

}
