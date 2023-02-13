package com.findby.common.swagger.post;

import com.findby.common.CommonResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.*;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Operation(summary = "Create Peaceletter", description = "피스레터 생성 API")
@ApiResponses({
        @ApiResponse(responseCode = "201", description = "피스레터 생성이 완료되었습니다."),
        @ApiResponse(responseCode = "400", description = "요청인자를 확인하세요.", content = @Content(schema = @Schema(implementation = CommonResponse.class))),
        @ApiResponse(responseCode = "500", description = "서버에서 알 수 없는 에러가 발생하였습니다.", content = @Content(schema = @Schema(implementation = CommonResponse.class))),
})
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface CreatePost {
}
