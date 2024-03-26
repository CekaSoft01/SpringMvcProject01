package com.rungroup.web.service;

import com.rungroup.web.dto.EventDto;

import java.util.List;

public interface EventService {
    void createEvent(Long clubId, EventDto eventDto);

    List<EventDto> findAllEvents();

    EventDto findByEventId(Long eventsId);

    void updateClub(EventDto eventDto);

    void deleteEvent(Long eventId);
}
