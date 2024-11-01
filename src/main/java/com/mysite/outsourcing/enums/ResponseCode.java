package com.mysite.outsourcing.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * API 응답 시 사용되는 상태 코드와 메시지를 정의하는 enum
 *
 * @see <a href="https://ko.wikipedia.org/wiki/HTTP_%EC%83%81%ED%83%9C_%EC%BD%94%EB%93%9C">HTTP 상태 코드</a>
 * @since 2024-10-03
 */
@Getter
@AllArgsConstructor
public enum ResponseCode {
    // 200
    SUCCESS_LOGIN(HttpStatus.OK, "로그인 성공"),
    SUCCESS_LOGOUT(HttpStatus.OK, "로그 아웃 성공"),
    SUCCESS_SEARCH_USER(HttpStatus.OK, "유저 조회 성공"),
    SUCCESS_SEARCH_SCHEDULE(HttpStatus.OK, "일정 조회 성공"),
    SUCCESS_SEARCH_COMMENT(HttpStatus.OK, "댓글 조회 성공"),
    SUCCESS_UPDATE_USER(HttpStatus.OK, "유저 수정 성공"),
    SUCCESS_UPDATE_SCHEDULE(HttpStatus.OK, "일정 수정 성공"),
    SUCCESS_UPDATE_COMMENT(HttpStatus.OK, "댓글 수정 성공"),

    // 201
    SUCCESS_CREATE_USER(HttpStatus.CREATED, "회원 가입 성공"),
    SUCCESS_CREATE_SCHEDULE(HttpStatus.CREATED, "일정 등록 성공"),
    SUCCESS_CREATE_COMMENT(HttpStatus.CREATED, "댓글 등록 성공"),

    // 204
    SUCCESS_DELETE_USER(HttpStatus.NO_CONTENT, "유저 삭제 성공"),
    SUCCESS_DELETE_SCHEDULE(HttpStatus.NO_CONTENT, "일정 삭제 성공"),
    SUCCESS_DELETE_COMMENT(HttpStatus.NO_CONTENT, "댓글 삭제 성공"),

    // 400
    INVALID_TOKEN(HttpStatus.BAD_REQUEST, "잘못된 JWT 토큰 입니다."),
    INVALID_JSON(HttpStatus.BAD_REQUEST, "잘못된 JSON형식 전송"),
    BAD_INPUT(HttpStatus.BAD_REQUEST, "잘못된 값 입력"),
    UNSIGNED_TOKEN(HttpStatus.BAD_REQUEST, "유효하지 않는 JWT 서명 입니다."),
    FAIL_ENCODING_TOKEN(HttpStatus.BAD_REQUEST, "잘못된 인코딩을 사용하였습니다."),

    // 401
    TIMEOUT_TOKEN(HttpStatus.UNAUTHORIZED, "만료된 JWT token 입니다."),
    UNSUPPORTED_TOKEN(HttpStatus.UNAUTHORIZED, "지원되지 않는 JWT 토큰 입니다."),
    NOT_MATCH_PASSWORD(HttpStatus.UNAUTHORIZED, "비밀번호가 틀렸습니다."),

    // 403
    INVALID_PERMISSION(HttpStatus.FORBIDDEN, "권한이 없습니다"),

    // 404
    NOT_FOUND_TOKEN(HttpStatus.NOT_FOUND, "JWT 토큰이 없습니다."),
    NOT_FOUND_USER(HttpStatus.NOT_FOUND, "유저를 찾을 수 없습니다."),
    NOT_FOUND_SCHEDULE(HttpStatus.NOT_FOUND, "이미 삭제된 일정입니다."),
    NOT_FOUND_COMMENT(HttpStatus.NOT_FOUND, "이미 삭제된 댓글입니다."),

    // 409
    DUPLICATED_EMAIL(HttpStatus.CONFLICT, "이메일이 중복됩니다"),

    // 500
    UNKNOWN_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "알 수 없는 오류");

    private final HttpStatus httpStatus;
    private final String message;
}