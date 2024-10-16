package com.houndcoder.global.exception;

import com.houndcoder.global.dto.Response;
import com.houndcoder.global.dto.ResponseDto;
import com.houndcoder.members.exception.MemberNotFoundException;
import com.houndcoder.members.exception.ProfileNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Response<ResponseDto>> handleGeneralException(Exception ex) {
        log.error("예상치 못한 서버 오류 발생: {}", ex.getMessage(), ex);
        return new ResponseEntity<>(
                Response.error("에러 메시지: " + ex.getMessage()),
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }

    // MemberNotFoundException 처리
    @ExceptionHandler(MemberNotFoundException.class)
    public ResponseEntity<Response<ResponseDto>> handleMemberNotFoundException(MemberNotFoundException ex) {
        log.error("MemberNotFoundException: {}", ex.getMessage());
        return new ResponseEntity<>(
                Response.error(ex.getMessage()),
                HttpStatus.NOT_FOUND
        );
    }

    // ProfileNotFoundException 처리
    @ExceptionHandler(ProfileNotFoundException.class)
    public ResponseEntity<Response<ResponseDto>> handleProfileNotFoundException(MemberNotFoundException ex) {
        log.error("ProfileNotFoundException: {}", ex.getMessage());
        return new ResponseEntity<>(
                Response.error(ex.getMessage()),
                HttpStatus.NOT_FOUND
        );
    }
}
