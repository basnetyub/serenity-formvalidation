package getyourlawyer.question;

import getyourlawyer.userinterface.CalculateForm;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

import java.time.Duration;
import java.util.Collection;

public class CalculationContents {
    public static Question<String> resultDisplayed() {
        return Text.of(CalculateForm.RESULT_LABEL.waitingForNoMoreThan(Duration.ofSeconds(5)));
    }

    public static Question<Collection<String>> validationMessages() {
        return Text.ofEach(CalculateForm.VALIDATION_MESSAGES);
    }
}
