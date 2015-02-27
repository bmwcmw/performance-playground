package playground.conversion;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.guava.GuavaModule;
import com.fasterxml.jackson.datatype.joda.JodaModule;

/**
 * Provides the configuration for an {@link com.fasterxml.jackson.databind.ObjectMapper} that is close to how an
 * ObjectMapper may be configured in a production environment in order to provide more accurate benchmarks.
 *
 * @author egillespie
 */
public class StandardObjectMapper extends ObjectMapper {
    public StandardObjectMapper() {
        registerModule(new GuavaModule());
        registerModule(new JodaModule());
    }
}
