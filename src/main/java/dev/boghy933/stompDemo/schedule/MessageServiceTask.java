package dev.boghy933.stompDemo.schedule;

import dev.boghy933.stompDemo.model.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.*;

@Component
public class MessageServiceTask {

    private final Logger log = LoggerFactory.getLogger(this.getClass());
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    private static List<String> cities = new ArrayList<>(
            Arrays.asList("Rome", "London")
    );


    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @Scheduled(fixedRate = 5000)
    public void sendNotification() {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        for(String city : cities) {
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("Europe/"+city));

            log.info("The time for {} is {}", city, simpleDateFormat.format(calendar.getTime()));
            Message response = new Message("Hello, time is " + simpleDateFormat.format(calendar.getTime()));
            this.simpMessagingTemplate.convertAndSend("/topic/"+city, response);
        }
    }
}
