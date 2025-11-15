package com.algaworks.algasensors.temperature.processing;

import com.algaworks.algasensors.temperature.processing.common.IdGenerator;
import com.algaworks.algasensors.temperature.processing.common.UUIDv7Utils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.OffsetDateTime;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

public class UUIDv7Test {

    @Test
    public void shouldTestUUIDv7() {
        UUID uuid1 = IdGenerator.generateTimeBasedUUID();
        UUID uuid2 = IdGenerator.generateTimeBasedUUID();
        UUID uuid3 = IdGenerator.generateTimeBasedUUID();
        UUID uuid4 = IdGenerator.generateTimeBasedUUID();

        System.out.println("UUID 1: " + uuid1);
        System.out.println("UUID 2: " + uuid2);
        System.out.println("UUID 3: " + uuid3);
        System.out.println("UUID 4: " + uuid4);

        System.out.println("UUID val 1: " + UUIDv7Utils.extractOffsetDateTime(uuid1));
        System.out.println("UUID val 2: " + UUIDv7Utils.extractOffsetDateTime(uuid2));
        System.out.println("UUID val 3: " + UUIDv7Utils.extractOffsetDateTime(uuid3));
        System.out.println("UUID val 4: " + UUIDv7Utils.extractOffsetDateTime(uuid4));

        OffsetDateTime uuidDateTime = UUIDv7Utils.extractOffsetDateTime(uuid1).truncatedTo(ChronoUnit.MINUTES);
        OffsetDateTime currentDateTime = OffsetDateTime.now().truncatedTo(ChronoUnit.MINUTES);

        Assertions.assertEquals(currentDateTime, uuidDateTime);
    }

}
