package ru.ladies.objects.ladiesentryfree.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ladies.objects.ladiesentryfree.model.dto.dashboardRelated.DashboardDTO;
import ru.ladies.objects.ladiesentryfree.repository.EventRepository;
import ru.ladies.objects.ladiesentryfree.repository.ObjectRepository;
import ru.ladies.objects.ladiesentryfree.repository.SolutionRepository;

@Service
@RequiredArgsConstructor
public class DashboardService {

    private final ObjectRepository objectRepository;
    private final EventRepository eventRepository;
    private final SolutionRepository solutionRepository;

    public DashboardDTO getDashboard() {
        DashboardDTO dto = new DashboardDTO();
        return null; //TODO жду сервиса для групп
    }



}
