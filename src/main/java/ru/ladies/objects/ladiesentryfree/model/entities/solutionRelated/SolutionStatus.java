package ru.ladies.objects.ladiesentryfree.model.entities.solutionRelated;

public enum SolutionStatus {
    PLANNED("Planned"),
    IN_PROGRESS("In Progress"),
    COMPLETED("Completed"),
    EXPIRED("Expired");

    private String name;

    SolutionStatus(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
