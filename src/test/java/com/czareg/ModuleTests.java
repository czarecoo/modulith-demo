package com.czareg;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.modulith.core.ApplicationModules;

@SpringBootTest
class ModuleTests {

    @Test
    void verifiesModularStructure() {
        ApplicationModules modules = ApplicationModules.of(Main.class);
        modules.verify();
    }
}
