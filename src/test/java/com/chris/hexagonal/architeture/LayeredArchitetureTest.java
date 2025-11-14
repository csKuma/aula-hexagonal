package com.chris.hexagonal.architeture;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.library.Architectures;
import org.junit.jupiter.api.AfterEach;
import org.springframework.boot.test.context.SpringBootTest;

import static com.tngtech.archunit.library.Architectures.layeredArchitecture;

@SpringBootTest
@AnalyzeClasses(packages = "com.chris.hexagonal")
public class LayeredArchitetureTest {


    @ArchTest
    public static final ArchRule layer_architeture_teste = layeredArchitecture()
            .consideringAllDependencies()
            .layer("AdaptersIn").definedBy("..adapters.in..")
            .layer("AdaptersOut").definedBy("..adapters.out..")
            .layer("UseCase").definedBy("..application.core.usecase..")
            .layer("PortsIn").definedBy("..application.core.ports.in..")
            .layer("PortsOut").definedBy("..application.core.ports.out..")
            .layer("Config").definedBy("..config..")
            .whereLayer("AdaptersIn").mayOnlyAccessLayers("Config")
            .whereLayer("AdaptersOut").mayOnlyAccessLayers("Config")
            .whereLayer("UseCase").mayOnlyAccessLayers("Config")
            .whereLayer("PortsIn").mayOnlyAccessLayers("UseCase","AdaptersIn")
            .whereLayer("PortsOut").mayOnlyAccessLayers("UseCase","AdaptersOut")
            .whereLayer("Config").mayNotBeAccessedByAnyLayer();

}
