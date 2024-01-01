package xyz.bulick.addition.config;

import io.opentelemetry.exporter.otlp.logs.OtlpGrpcLogRecordExporter;
import io.opentelemetry.exporter.otlp.metrics.OtlpGrpcMetricExporter;
import io.opentelemetry.exporter.otlp.trace.OtlpGrpcSpanExporter;
import io.opentelemetry.sdk.logs.export.LogRecordExporter;
import io.opentelemetry.sdk.metrics.export.MetricExporter;
import io.opentelemetry.sdk.trace.export.SpanExporter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OtlpConfig {

    @Bean
    public SpanExporter otlpHttpSpanExporter(@Value("${tracing.url}") String url) {
        return OtlpGrpcSpanExporter.builder().setEndpoint(url).build();
    }

    public LogRecordExporter logRecordExporter(@Value("${tracing.url}") String url) {
        return OtlpGrpcLogRecordExporter.builder().setEndpoint(url).build();
    }

//    @Bean
    public MetricExporter otlpGrpcMetricExporter(@Value("${tracing.url}") String url) {
        return OtlpGrpcMetricExporter.builder().setEndpoint(url).build();
    }
}
