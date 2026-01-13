package com.fluidpay.sdk.models.transactions;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * Custom deserializer for ProcessorSpecific that handles empty strings.
 * The API may return processor_specific as an empty string instead of null or an object.
 */
public class ProcessorSpecificDeserializer extends JsonDeserializer<ProcessorSpecific> {
    @Override
    public ProcessorSpecific deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        JsonNode node = p.getCodec().readTree(p);
        
        // If it's an empty string or null, return null
        if (node.isTextual() && node.asText().isEmpty()) {
            return null;
        }
        
        // If it's null, return null
        if (node.isNull()) {
            return null;
        }
        
        // Otherwise, deserialize as normal object using ObjectMapper
        ObjectMapper mapper = (ObjectMapper) p.getCodec();
        return mapper.treeToValue(node, ProcessorSpecific.class);
    }
}
