package com.kppay.platform.template;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.library.dependencies.SlicesRuleDefinition;

@AnalyzeClasses(
		packages = "com.kppay.platform.template",
		importOptions = ImportOption.DoNotIncludeTests.class)
class ArchitectureRulesTests {

	@ArchTest
	static final ArchRule DOMAIN_IS_FRAMEWORK_INDEPENDENT = noClasses()
		.that().resideInAPackage("..domain..")
		.should().dependOnClassesThat().resideInAnyPackage(
			"org.springframework..",
			"jakarta..",
			"..adapter..",
			"..configuration..")
		.allowEmptyShould(true);

	@ArchTest
	static final ArchRule APPLICATION_DOES_NOT_DEPEND_ON_ADAPTERS = noClasses()
		.that().resideInAPackage("..application..")
		.should().dependOnClassesThat().resideInAnyPackage("..adapter..", "..configuration..")
		.allowEmptyShould(true);

	@ArchTest
	static final ArchRule INBOUND_ADAPTERS_DO_NOT_CALL_OUTBOUND_ADAPTERS = noClasses()
		.that().resideInAPackage("..adapter.in..")
		.should().dependOnClassesThat().resideInAPackage("..adapter.out..")
		.allowEmptyShould(true);

	@ArchTest
	static final ArchRule TOP_LEVEL_PACKAGES_ARE_FREE_OF_CYCLES = SlicesRuleDefinition.slices()
		.matching("com.kppay.platform.template.(*)..")
		.should().beFreeOfCycles();

	private ArchitectureRulesTests() {
	}
}
