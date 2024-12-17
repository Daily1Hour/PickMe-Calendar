package com.pickme.calendar.dto.put;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Schema(description = "일정 수정 시 응답")
public class PutApiResponseDTO {
    @Schema(description = "success", example = "true")
    private String success;
    @Schema(description = "message", example = "면접 일정 수정 성공")
    private String message;
}
