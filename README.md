# dropfulgwt
A hello world example of a [Dropwizard](http://www.dropwizard.io/) backend with a [RestyGWT](http://resty-gwt.github.io/) frontend.

Dropwizard is a very interesting "production ready stack". I created this example as I wanted to see how easy it was to create and bundle a GWT app with the runnable JAR. It contains a slightly modified version of the Getting started sample of dropwizard, and a simple RestyGWT based application that use this API.

The "bundling" of the GWT app feels a bit hackish but it works. Pull requests are most welcome!

## How to run it

> mvn package
> cd dropfulgwt-server
> java -jar target/dropfulgwt-server-1.0.jar server hello-world.yml

## My current workflow

* Start a GWT runner inside the IDE and store the compiled output to the assets folder
** Using (Super)Devmode: `-war /absolute/path/to/dropfulgwt-server/src/main/resources/assets`
** Using Codeserver directly: `-launcherDir /absolute/path/to/dropfulgwt-server/src/main/resources/assets`
* Start the dropwizard application (in debug mode to allow hot swapping)
* Rock on!
