package utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.fasterxml.jackson.databind.node.ArrayNode;

/**
 * o fac singleton ca sa mi fie lejer sa accesez mereu acest ArrayNode in care pun output ul
 */
public class JsonOutManager {
    private static JsonOutManager instance = null;
    private ArrayNode output;

    private JsonOutManager() {}

    public static JsonOutManager getInstance() {
        if(instance == null) {
            instance = new JsonOutManager();
        }
        return instance;
    }
    public void setOutput(ArrayNode output) {
        this.output = output;
    }
    public ArrayNode getOutput() {
        return output;
    }
    public void addToOutput(Object object) {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode out = mapper.valueToTree(object);
        output.add(out);
    }
}
