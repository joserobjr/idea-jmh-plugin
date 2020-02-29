# JMHack

This is a fork of the popular [JMH plugin](https://github.com/artyushov/idea-jmh-plugin).

## Why do I need this?

This is a plugin that allows you to use [JMH](http://openjdk.java.net/projects/code-tools/jmh/) in the same way as
JUnit. Here are the features that are already implemented:

1. ```@Benchmark``` method generation
2. Running a separate ```@Benchmark``` method
3. Running all the benchmarks in a class

## How do I use this?

First of all, you must have ```jmh-core``` and ```jmh-generator-annprocess``` on the classpath of your module.

After that install the plugin. You can do this directly from IDEA — search for `JMH` in plugin repositories.

Then you can use the plugin the same way you use JUnit. To generate a new benchmark method run ```Generate...``` action. In Mac OS it is ```Ctrl + N```
Or just right click in your editor pane and select ```Generate micro benchmark```.

To run a separate benchmark method move the cursor to the method declaration and invoke ```Run``` action.
In Mac OS it is ```Ctrl + Shift + F10```.
Do the same actions to run all the benchmarks in a class, just move your cursor to the class declaration.

Invoking `Run` actions will create a new configuration with default parameters JMH provides. If you want to change these parameters just edit this configuration.
To edit default parameters for all your benchmarks, modify the "JMH" run configuration template.

Please, note that when running a benchmark Annotation processing is automatically enabled in your IDE.

## Doesn't it affect the quality of my benchmarks?

A brief research shows that benchmark results *are* affected, but not that much. The whole research is described in
[Research results](https://github.com/artyushov/idea-jmh-plugin/blob/master/research/results.md). Long story short, the maximum means difference observed was **2.2%**.

## Common problems

Under Windows the following error might show up:

    ERROR: org.openjdk.jmh.runner.RunnerException:
    ERROR: Exception while trying to acquire the JMH lock (C:\WINDOWS\/jmh.lock):

This is caused by running JMH benchmarks with an empty environment. To fix this error, define a `TMP` or `TEMP` environment variable which points to a writable directory. Alternatively, specify the JVM argument `java.io.tmpdir` and set it to a writable directory, for instance `-Djava.io.tmpdir=C:\temp`.
