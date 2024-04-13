package ru.gb.example3_sem3_hometask.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.example3_sem3_hometask.domain.User;
import ru.gb.example3_sem3_hometask.repository.UserRepository;

@Service
public class RegistrationService {

    public DataProcessingService getDataProcessingService() {
        return dataProcessingService;
    }

    @Autowired
    private DataProcessingService dataProcessingService;

    //Поля UserService, NotificationService

    //Метод processRegistration

    @Autowired
    private UserService userService;

    @Autowired
    private NotificationService notificationService;

    @Autowired
    private UserRepository userRepository;

    public void processRegistration(String name, int age, String email){
        User newUser = userService.createUser(name, age,email);


        dataProcessingService.addUserToList(newUser);

        notificationService.sendNotification("Новый пользователь успешно создан!");
    }
}