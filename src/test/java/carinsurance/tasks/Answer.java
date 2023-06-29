package carinsurance.tasks;

import carinsurance.model.QuestionAndAnswer;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.questions.Visibility;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.ui.RadioButton;
import net.serenitybdd.screenplay.ui.Select;
import org.openqa.selenium.By;

public class Answer {

    private static final Target RADIO_BUTTON_WITH_LABEL_A = Target.the("'{0}' with value '{1}'")
            .locatedBy("//div[contains(@class,'base-question')][contains(.,'{0}')]//span[@class='base-radio__text'][contains(.,'{1}')]");

    private static final Target RADIO_BUTTON_WITH_LABEL_B = Target.the("'{0}' with value '{1}'")
            .locatedBy("//*[contains(.,'{0}')]//label[contains(.,'{1}')]");


    public static Performable theQuestion(QuestionAndAnswer questionAndAnswer) {
        return Task.where("{0} answers the question " + questionAndAnswer,
                actor -> {
                    Target questionRadioA = RADIO_BUTTON_WITH_LABEL_A.of(questionAndAnswer.question(), questionAndAnswer.answer());
                    Target questionRadioB = RADIO_BUTTON_WITH_LABEL_B.of(questionAndAnswer.question(), questionAndAnswer.answer());

                    boolean isQuestionARadioButtonA = actor.asksFor(Visibility.of(questionRadioA));
                    boolean isQuestionARadioButtonB = actor.asksFor(Visibility.of(questionRadioB));

                    if (isQuestionARadioButtonA) {
                        actor.attemptsTo(JavaScriptClick.on(questionRadioA));
                    } else if (isQuestionARadioButtonB){
                        actor.attemptsTo(JavaScriptClick.on(questionRadioB));
                    }

                }
        );
    }
}
