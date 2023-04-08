package ru.ladies.objects.ladiesentryfree.model.entities.solutionRelated;

public enum SolutionStatus {
    NEW("New"),
    EXPIRED("Expired");

    private String name;

    SolutionStatus(String name) {
        this.name = name;
    }
}
