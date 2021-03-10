package com.yuyue.flink.java.ch02_firstflinkapps;

import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.windowing.time.Time;
import org.apache.flink.util.Collector;

/**
 * Use Java API to develop Flink Streaming Process
 *
 * The stream comes from a socket
 */
public class StreamingWCJavaApp {
    public static void main(String[] args) throws Exception {
        // Step 1: Get the execution environment
        final StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

        // Step 2: Read data from socket
        DataStreamSource<String> text = env.socketTextStream("localhost", 9999);

        // Step 3: Data Transformation and Step 4: Group the output
        text.flatMap(new FlatMapFunction<String, Tuple2<String, Integer>>() {
            @Override
            public void flatMap(
                    String value, Collector<Tuple2<String, Integer>> collector) throws Exception {
                String[] tokens = value.toLowerCase().split(",");
                for (String token: tokens) {
                    if (token.length() > 0) {
                        collector.collect(new Tuple2<String, Integer>(token, 1));
                    }
                }
            }
        }).keyBy(0).timeWindow(Time.seconds(5)).sum(1).print();

        env.execute();
    }
}
