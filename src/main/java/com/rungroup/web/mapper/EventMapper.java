package com.rungroup.web.mapper;

import com.rungroup.web.dto.EventDto;
import com.rungroup.web.models.Event;

public class EventMapper {
    public static Event mapToEvent(EventDto eventDto){

        return Event.builder()
                .id(eventDto.getId())
                .startTime(eventDto.getStartTime())
                .endTime(eventDto.getEndTime())
                .type(eventDto.getType())
                .createOn(eventDto.getCreateOn())
                .updatedOn(eventDto.getUpdatedOn())
                .photoUrl(eventDto.getPhotoUrl())
                .build()
                ;
    }

    public static EventDto mapToEventDto(Event event){

        return EventDto.builder()
                .id(event.getId())
                .startTime(event.getStartTime())
                .endTime(event.getEndTime())
                .type(event.getType())
                .createOn(event.getCreateOn())
                .updatedOn(event.getUpdatedOn())
                .photoUrl(event.getPhotoUrl())
                .build()
                ;
    }
}
