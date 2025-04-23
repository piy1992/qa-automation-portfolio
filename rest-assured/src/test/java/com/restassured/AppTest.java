package com.restassured;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import io.github.cdimascio.dotenv.Dotenv;
import projectname.api.utils.EnvReader;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        EnvReader ev = new EnvReader();
        Dotenv a = ev.loaDotenv("development");
        System.out.println("here"+(a.get("BASE_URL")));
    }
}
