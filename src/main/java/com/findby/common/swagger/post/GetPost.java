package com.findby.common.swagger.post;

import com.findby.common.CommonResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Operation(summary = "Get Peaceletter", description = "단일 피스레터 조회 API")
@ApiResponses({
        @ApiResponse(responseCode = "200", description = "피스레테 조회 성공"),
        @ApiResponse(responseCode = "400", description = "잘못된 요청인자로 요청하여 실패", content = @Content(schema = @Schema(implementation = CommonResponse.class))),
        @ApiResponse(responseCode = "500", description = "서버에서 알 수 없는 에러가 발생하였습니다.", content = @Content(schema = @Schema(implementation = CommonResponse.class))),
})
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface GetPost {
}