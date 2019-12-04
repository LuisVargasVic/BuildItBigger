package com.udacity.gradle.builditbigger.backend;

import com.baxter.javoker.Javoker;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

/** An endpoint class we are exposing */
@Api(
        name = "myApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.builditbigger.gradle.udacity.com",
                ownerName = "backend.builditbigger.gradle.udacity.com",
                packagePath = ""
        )
)
public class MyEndpoint {

    /** A simple endpoint method that takes a name and says Hi back */
    @ApiMethod(name = "javoke")
    public Joke javoke() {
        Joke joke = new Joke();
        Javoker javoker = new Javoker();
        joke.setData(javoker.tellJoke());

        return joke;
    }

}
