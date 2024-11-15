package com.ibk.ibktechnical.model.api;

import lombok.Data;

@Data
public class AnalyticsData {
  private String analyticsTraceSource;
  private String applicationId;
  private String channelOperationNumber;
  private String currentDate;
  private String customerId;
  private String region;
  private int statusCode;
  private String timestamp;
  private String traceId;
  private String inbound;
  private String outbound;
  private String transactionCode;
}
