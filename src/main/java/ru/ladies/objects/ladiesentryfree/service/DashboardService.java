package ru.ladies.objects.ladiesentryfree.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ladies.objects.ladiesentryfree.model.dto.dashboardRelated.DashboardDTO;
import ru.ladies.objects.ladiesentryfree.model.entities.userRelated.User;
import ru.ladies.objects.ladiesentryfree.repository.*;
import ru.ladies.objects.ladiesentryfree.utils.exception.UserNotFoundException;

@Service
@RequiredArgsConstructor
public class DashboardService {

    private final ObjectRepository objectRepository;
    private final EventRepository eventRepository;
    private final SolutionRepository solutionRepository;
    private final GroupRepository groupRepository;
    private final UserRepository userRepository;

    public DashboardDTO getDashboard(Integer userId) {
        User user = userRepository.findById(userId.longValue())
                .orElseThrow(() -> new UserNotFoundException("нет пользователя с id =  " + userId));
        DashboardDTO dto = new DashboardDTO();
        return null; //TODO жду сервиса для групп
    }


}
