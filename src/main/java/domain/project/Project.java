package domain.project;

import domain.tradesman.Location;
import domain.task.Task;
import java.util.List;
import java.util.Objects;

public class Project {

    private final List<String> jobs;
    private final List<String> skills;
    private final Location location;
    private final Double dailyTax;
    private final Integer duration;
    private final List<Task> tasks;

    public Project(List<String> jobs, List<String> skills, Location location, Double dailyTax, Integer duration,
                   List<Task> tasks) {
        this.jobs = Objects.requireNonNull(jobs);
        this.skills = Objects.requireNonNull(skills);
        this.location = Objects.requireNonNull(location);
        this.dailyTax = Objects.requireNonNull(dailyTax);
        this.duration = Objects.requireNonNull(duration);
        this.tasks = Objects.requireNonNull(tasks);
    }

    public static Project of(List<String> jobs, List<String> skills, Location location, Double dailyTax,
                             Integer duration, List<Task> tasks){
        return new Project(jobs, skills, location, dailyTax, duration, tasks);
    }



    @Override
    public String toString() {
        return "Project{" +
                "jobs=" + jobs +
                ", skills=" + skills +
                ", location=" + location +
                ", dailyTax=" + dailyTax +
                ", duration=" + duration +
                ", tasks=" + tasks +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return Objects.equals(jobs, project.jobs) && Objects.equals(skills, project.skills)
                && Objects.equals(location, project.location) && Objects.equals(dailyTax, project.dailyTax)
                && Objects.equals(duration, project.duration)
                && Objects.equals(tasks, project.tasks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(jobs, skills, location, dailyTax, duration, tasks);
    }

    public List<String> getJobs() {
        return jobs;
    }

    public List<String> getSkills() {
        return skills;
    }

    public Location getLocation() {
        return location;
    }

    public Double getDailyTax() {
        return dailyTax;
    }

    public Integer getDuration() {
        return duration;
    }

    public List<Task> getTasks() {
        return tasks;
    }
}