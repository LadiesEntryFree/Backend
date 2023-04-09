package ru.ladies.objects.ladiesentryfree.model.entities.userRelated;

public enum TypeOfWork {
    ANALYZE("Анализ работ"),
    BUILD("Строительство"),
    FIX("Ремонт"),
    ESTIMATION("Оценка работ"),
    DESTROY("Демонтаж"),
    INSPECTION("Инспекция");

    private String name;

    TypeOfWork(String name) {
        this.name = name;
    }
}
