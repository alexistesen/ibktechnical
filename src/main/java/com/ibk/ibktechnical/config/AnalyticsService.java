package com.ibk.ibktechnical.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ibk.ibktechnical.model.api.AnalyticsData;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class AnalyticsService {

  private final KafkaTemplate<String, String> kafkaProducer;
  private final ObjectMapper objectMapper;

  @Value("${app.analytics.region}")
  private String region;

  @Value("${app.analytics.transaction-code}")
  private String transactionCode;

  public AnalyticsService(KafkaTemplate<String, String> kafkaProducer, ObjectMapper objectMapper) {
    this.kafkaProducer = kafkaProducer;
    this.objectMapper = objectMapper;
  }

  public void sendAnalytics(String consumerId, String traceparent, String inbound, String outbound, String customerId, int statusCode) {
    try {
      var analyticsData = new AnalyticsData();
      analyticsData.setAnalyticsTraceSource("application-" + consumerId);
      analyticsData.setApplicationId(consumerId);
      analyticsData.setChannelOperationNumber(String.valueOf(System.currentTimeMillis()));
      analyticsData.setCurrentDate(Instant.now().atZone(ZoneId.of("UTC-5")).format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
      analyticsData.setCustomerId(customerId);
      analyticsData.setRegion(region);
      analyticsData.setStatusCode(statusCode);
      analyticsData.setTimestamp(Instant.now().toString());
      analyticsData.setTraceId(traceparent);
      analyticsData.setInbound(inbound);
      analyticsData.setOutbound(outbound);
      analyticsData.setTransactionCode(transactionCode);

      String message = objectMapper.writeValueAsString(analyticsData);
      kafkaProducer.send("usersanalytics", message);

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}
