package com.yy.java;

import org.apache.spark.SparkConf;
import org.apache.spark.SparkContext;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.api.java.function.VoidFunction;
import org.apache.spark.rdd.RDD;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/**
 * Created by cc on 2019/8/1.
 */
public class zip {
    public static void main(String[] args) {
        SparkConf sparkConf = new SparkConf().setAppName("a").setMaster("local[*]");
        JavaSparkContext sc = new JavaSparkContext(sparkConf);
        JavaRDD<String> pandas = sc.parallelize(Arrays.asList("pandas,a", "i, like, pandas"));
        JavaRDD<String> stringJavaRDD = pandas.flatMap(new FlatMapFunction<String, String>() {

            @Override
            public Iterator<String> call(String s) throws Exception {
                ArrayList list = new ArrayList();
                String s1 = s.split(",")[0];
                list.add(s1);
                return list.iterator();
            }
        });
        stringJavaRDD.foreach(new VoidFunction<String>() {
            @Override
            public void call(String s) throws Exception {
                System.out.println(s);
            }
        });

    }
}
