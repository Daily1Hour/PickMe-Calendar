package com.pickme.calendar.service.mapper;

import com.pickme.calendar.dto.GetInterviewListDTO;
import com.pickme.calendar.dto.InterviewScheduleDTO;
import com.pickme.calendar.dto.get.GetCalendarDTO;
import com.pickme.calendar.dto.get.GetInterviewDetailDTO;
import com.pickme.calendar.dto.post.PostInterviewDetailDTO;
import com.pickme.calendar.entity.Calendar;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring") // Spring Bean으로 등록
public interface CalendarMapper {

    // InterviewScheduleDto 객체를 Calendar 엔티티로 변환합니다.
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "userInfo", ignore = true)
    void toCalendarEntity(InterviewScheduleDTO interviewScheduleDto, @MappingTarget Calendar calendar);

    // Calendar 엔티티를 InterviewScheduleDto 객체로 변환합니다.
    InterviewScheduleDTO toInterviewScheduleDto(Calendar calendar);

    // Calendar 엔티티 리스트를 GetInterviewListDto 리스트로 변환합니다.
    List<GetInterviewListDTO> toGetInterviewListDto(List<Calendar> calendarList);


    Calendar.InterviewDetails postInterviewDetailDtoToInterviewDetails (PostInterviewDetailDTO postInterviewDetailDto, @MappingTarget Calendar.InterviewDetails interviewDetails);

    @Mapping(target = "interviewDetails", ignore = true)
    void calendarToGetCalendarDTO (Calendar calendar, @MappingTarget GetCalendarDTO getCalendarDTO);

    List<GetInterviewDetailDTO> interviewDetailsToGetInterviewDetailsDTO (List<Calendar.InterviewDetails> interviewDetails);
}
