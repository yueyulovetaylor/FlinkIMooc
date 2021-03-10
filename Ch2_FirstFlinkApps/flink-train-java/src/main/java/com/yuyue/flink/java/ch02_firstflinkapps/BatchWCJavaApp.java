package com.yuyue.flink.java.ch02_firstflinkapps;

import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.java.operators.DataSource;
import org.apache.flink.util.Collector;
import org.apache.flink.api.java.tuple.Tuple2;

/**
 * Use Java API to develop Flink Batch Process
 */
public class BatchWCJavaApp {
    public static void main(String[] args) throws Exception {

        String input = "file:///Users/yyu196/Codes/FlinkIMooc/Ch2_FirstFlinkApps/input/inputText";
        // Step 1: Get the execution environment
        final ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();

        // Step 2: Read file
        DataSource<String> text = env.readTextFile(input);

        // Step 3: Data Transformation and Step 4: Group the output
        text.flatMap(new FlatMapFunction<String, Tuple2<String, Integer>>() {
            @Override
            public void flatMap(
                    String value, Collector<Tuple2<String, Integer>> collector) throws Exception {
                String[] tokens = value.toLowerCase().split("\t");
                for (String token: tokens) {
                    if (token.length() > 0) {
                        collector.collect(new Tuple2<String, Integer>(token, 1));
                    }
                }
            }
        }).groupBy(0).sum(1).print();
    }
}
