package io.openliberty.guides.graphql;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import io.openliberty.guides.graphql.client.SystemServiceAPI;
import io.openliberty.guides.graphql.models.SystemInfo;
import io.smallrye.graphql.client.typesafe.api.GraphQlClientBuilder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SystemIT {
    
    private static SystemServiceAPI systemServiceApi;
    
    @BeforeAll
    public static void setUp() {
        systemServiceApi = GraphQlClientBuilder
                .newBuilder()
                .endpoint("http://localhost:9080/graphql")
                .build(SystemServiceAPI.class);
    }
    
    @Test
    @Order(1)
    public void testGetSystem() {
        SystemInfo sys = systemServiceApi.getSystemInfo();
        assertNotNull(sys, "No system info received");
    }
    
    @Test
    @Order(2)
    public void testEditNote() {
        String expectedNote = "This is a test note";
        systemServiceApi.editNote(expectedNote);
        String actualNote = systemServiceApi.getSystemInfo().getNote();
        assertEquals(expectedNote, actualNote, "Returned note not the same as input note");
    }
}
