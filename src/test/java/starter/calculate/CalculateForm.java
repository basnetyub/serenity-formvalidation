package starter.calculate;

import net.serenitybdd.core.steps.UIInteractionSteps;
import net.serenitybdd.screenplay.targets.Target;

public class CalculateForm extends UIInteractionSteps {
    public static Target CLICK_ME_BUTTON = Target.the("Click me button").locatedBy("css:button#first");
    public static Target NOW_CLICK_ME_BUTTON = Target.the("Now Click me button").locatedBy("css:button#second");

    public static Target NUMBER_OF_SEED_INPUT = Target.the("Number of seed input text field").locatedBy("#form input[name='seeds']");
    public static Target NAME_INPUT = Target.the("Name input text field").locatedBy("#form input[name='name']");
    public static Target DATE_INPUT = Target.the("Date input time").locatedBy("#form input[name='time']");
    public static Target TREE_TYPE_INPUT = Target.the("Tree type dropdown").locatedBy("#form select[name='type']");
    public static Target USE_ALTERNATE_METHOD_INPUT = Target.the("Use alternate method checkbox").locatedBy("#form input[name='method']");
    public static Target SUBMIT_BUTTON = Target.the("Submit Button").locatedBy("#form button[type='submit']");

    public static Target RESULT_LABEL = Target.the("Result Displaying Paragraph").locatedBy("form p");

    public static Target VALIDATION_MESSAGES = Target.the("List of Validation Messages").locatedBy("#errors li");

}
