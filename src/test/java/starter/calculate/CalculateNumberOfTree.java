package starter.calculate;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.conditions.Check;
import org.openqa.selenium.By;
import starter.CalculationData;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculateNumberOfTree extends UIInteractionSteps {
    public static Performable usingDefaultMethod(CalculationData values) {
        return Task.where("{0} calculate Tree using default method",
                Enter.theValue(values.numberOfSeeds()).into(CalculateForm.NUMBER_OF_SEED_INPUT),
                Enter.theValue(values.name()).into(CalculateForm.NAME_INPUT),
                Enter.theValue(values.time().replaceAll("[^0-9a-zA-Z]", "")).into(CalculateForm.DATE_INPUT),
                Check.whether(!(values.treeType().equals(CalculationData.TreeType.NONE)))
                        .andIfSo(SelectFromOptions.byVisibleText(values.treeType().getName()).from(CalculateForm.TREE_TYPE_INPUT))
        );
    }

    public static Performable calculate() {
        return Task.where("{0} calculate Total Number of Trees",
                Click.on(CalculateForm.SUBMIT_BUTTON));
    }

    public static Performable selectMethod(String method) {
        Serenity.reportThat("Confirm Alternate Method is not selected",
                () -> assertThat(Serenity.getDriver().findElement(By.cssSelector(CalculateForm.USE_ALTERNATE_METHOD_INPUT.getCssOrXPathSelector())).isSelected()).isFalse()
        );
        switch (method.toLowerCase()) {
            case "default":
                return Task.where("{0} calculate Tree using " + method + " method");
            case "alternate":
                System.out.println("alternate");
                return Task.where("{0} calculate Tree using " + method + " method", Click.on(CalculateForm.USE_ALTERNATE_METHOD_INPUT));
            default:
                throw new IllegalArgumentException("The method: " + method + "is incorrect. Allowed value default or alternate");
        }
    }

}
