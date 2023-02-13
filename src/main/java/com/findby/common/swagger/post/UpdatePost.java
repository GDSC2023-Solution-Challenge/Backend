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


@Operation(summary = "Update Peaceletter", description = "피스레터 업데이트 API")
@ApiResponses({
        @ApiResponse(responseCode = "200", description = "피스레터 수정이 완료되었습니다."),
        @ApiResponse(responseCode = "400", description = "요청인자를 확인하세요.\t\n해당 피스레터가 존재하지 않습니다.", content = @Content(schema = @Schema(implementation = CommonResponse.class))),
        @ApiResponse(responseCode = "403", description = "해당 피스레터를 수정할 수 있는 권한이 존재하지 않습니다.", content = @Content(schema = @Schema(implementation = CommonResponse.class))),
        @ApiResponse(responseCode = "500", description = "서버에서 알 수 없는 에러가 발생하였습니다.", content = @Content(schema = @Schema(implementation = CommonResponse.class))),
})
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface UpdatePost {
}
