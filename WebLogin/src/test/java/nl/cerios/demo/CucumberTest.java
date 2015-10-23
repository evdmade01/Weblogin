package nl.cerios.demo;


import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

/**
 * JUnit/Cucumber runner voor alle features
 *
 * Tijdens ontwikkeling is het vaak handig om alleen de feature waar je mee bezig bent te draaien. 
 * In die gevallen kun je "name" vervangen van ".*" (alle features) naar iets als "2.7.1.*"; het
 * gaat om de naam van de feature, niet om de filenaam. Het is een regexp (dus de punt staat voor
 * any character). Je kunt dus ook dingen zeggen als "3.1.*" (voor alles onder 3.1) of "2.7.1.*|3.1.3.*" voor
 * features 2.7.1 en 3.1.3. 
 */
@RunWith(Cucumber.class)
@CucumberOptions(
	monochrome = true,
	features = {"src/test/resources/features"}, 
	glue = {"nl.cerios.demo"},
	name = "^.*"
)

public class CucumberTest {

}
