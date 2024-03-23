package com.rungroup.web.service;

import com.rungroup.web.dto.EventDto;

public interface EventService {
    void createEvent(Long clubId, EventDto eventDto);
}
