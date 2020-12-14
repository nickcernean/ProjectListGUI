package model;

public class ProjectListModelManager implements ProjectListModel
{
  private ProjectList projectList;

  public ProjectListModelManager()
  {
    this.projectList = new ProjectList();
  }

  @Override public void addProject(Project project)
  {
    projectList.addProject(project);
  }

  @Override public void removeProject(String projectID)
  {
   projectList.removeProject(projectID);
  }

  @Override public Project getProjectByID(String projectID)
  {
    return projectList.getProjectByID(projectID);
  }

  @Override public Project[] getAllProjects()
  {
    return projectList.getAllProjects();
  }

  @Override public Project getProjectByName(String name)
  {
    return projectList.getProjectByName(name);
  }

  @Override public Status getProjectStatus(String projectID)
  {
    return projectList.getProjectStatus(projectID);
  }

  public void editDeadlineOfAProject(String projectID, Date newDeadline)
  {
    projectList.editDeadlineOfAProject(projectID, newDeadline);
  }

  public void editUserStoryOfTheProject(String projectID, String newDescription)
  {
   projectList.editUserStoryOfTheProject(projectID, newDescription);
  }

  public Project[] getAllActiveProjects()
  {
    return projectList.getAllActiveProjects();
  }

  public RequirementList getRequirementsOfAProject(String projectID)
  {
    return projectList.getRequirementsOfAProject(projectID);
  }

  public RequirementList getRequirementsByImportance(String projectID)
  {
    return projectList.getRequirementsByImportance(projectID);
  }

  public Team getTeamMembersOfAProject(String projectID)
  {
    return projectList.getTeamMembersOfAProject(projectID);
  }

  @Override public Project getProjectByIndex(int index)
  {
    return projectList.getProjectByIndex(index);
  }

  @Override public int getNumberOfProjects()
  {
    return projectList.getNumberOfProjects();
  }

  @Override public String getprojectID(Project project)
  {
    return projectList.getprojectID(project);
  }

  @Override public String getProjectName(Project project)
  {
    return projectList.getProjectName(project);
  }

  @Override public String getProjectDescription(Project project)
  {
    return projectList.getProjectDescription(project);
  }
}

