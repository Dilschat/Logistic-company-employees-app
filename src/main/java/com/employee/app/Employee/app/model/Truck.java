package com.employee.app.Employee.app.model;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;

/**
 * Created by niyaz on 21.10.2018.
 */
@JsonDeserialize(using = Truck.TruckDeserializer.class)
public class Truck {

    private long id;
    private double longitude, latitude;
    private final String type = "truck";

    public Truck(long id, double x, double y) {
        this.id = id;
        this.longitude = x;
        this.latitude = y;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }


    public class TruckDeserializer extends StdDeserializer<Truck> {
        protected TruckDeserializer(Class<?> vc) {
            super(vc);
        }

        @Override
        public Truck deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            ObjectCodec oc = jsonParser.getCodec();
            JsonNode node = oc.readTree(jsonParser);
            return new Truck(node.get("id").asLong(), node.get("longitude").asDouble(), node.get("latitude").asDouble());
        }
    }
}
