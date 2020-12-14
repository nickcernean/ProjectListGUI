package model;

public interface ProjectListModel
{
  public void addProject(Project project);
  public void removeProject(String projectID);
  public Project getProjectByID(String projectID);
  public Project[] getAllProjects();
  public Project getProjectByName(String name);
  public Status getProjectStatus(String projectID);
  public void editDeadlineOfAProject(String projectID, Date newDeadline);
  public void editUserStoryOfTheProject(String projectID, String newDescription);
  public Project[] getAllActiveProjects();
  public RequirementList getRequirementsOfAProject(String projectID);
  public RequirementList getRequirementsByImportance(String projectID);
  public Team getTeamMembersOfAProject(String projectID);
  public Project getProjectByIndex(int index);
  public int getNumberOfProjects();
 public String getprojectID(Project project);
  public String getProjectName(Project project);
  public String getProjectDescription(Project project);

}
