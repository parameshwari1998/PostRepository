package com.project.postMicroservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BaseResponse<T> {
    private boolean status;
    private String errorMessage;
    private T data;
    public BaseResponse(T data) {
        this.data = data;
        this.status = true;
    }
    public BaseResponse(String errorMessage) {
        this.errorMessage = errorMessage;
        this.status = false;
    }
}
