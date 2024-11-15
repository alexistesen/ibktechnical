package com.ibk.ibktechnical.model.headers;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ibk.ibktechnical.annotations.UsersHttpHeaders;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@UsersHttpHeaders
public class UsersHeaders {

  @JsonProperty("consumerId")
  @Schema(
      description = "Id del consumidor",
      requiredMode = Schema.RequiredMode.REQUIRED,
      name = "consumerId",
      example = "APP",
      type = "string"
  )
  private String consumerId;

  @JsonProperty("traceparent")
  @Schema(
      description = "Trace Context",
      requiredMode = Schema.RequiredMode.REQUIRED,
      name = "traceparent",
      example = "W3C",
      type = "string"
  )
  private String traceparent;

  @JsonProperty("deviceType")
  @Schema(
      description = "Tipo de dispositivo",
      requiredMode = Schema.RequiredMode.REQUIRED,
      name = "deviceType",
      example = "AND",
      type = "string"
  )
  private String deviceType;

  @JsonProperty("deviceId")
  @Schema(
      description = "Identificador del dispositivo",
      requiredMode = Schema.RequiredMode.REQUIRED,
      name = "deviceId",
      example = "123-123",
      type = "string"
  )
  private String deviceId;


}
