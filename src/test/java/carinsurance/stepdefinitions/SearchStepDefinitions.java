package carinsurance.stepdefinitions;

import carinsurance.model.MakeAndModel;
import carinsurance.model.QuestionAndAnswer;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import net.serenitybdd.screenplay.ui.Button;
import net.serenitybdd.screenplay.ui.Link;
import net.serenitybdd.screenplay.ui.Select;
import net.serenitybdd.screenplay.waits.Wait;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.lang.annotation.Target;
import java.time.Duration;
import java.util.List;
import java.util.Map;

public class SearchStepDefinitions {


    @Given("{actor} wants to insure his/her car")
    public void actor_wants_to_insure_his_car(Actor actor) {
        actor.attemptsTo(
                Open.url("https://www.moneysupermarket.com/dialogue/motor/questions/your-car"),
                Click.on(Button.withText("Accept all"))
        );
    }

    @DataTableType
    public MakeAndModel makeAndModel(Map<String,String> makeAndModelData){
        return new MakeAndModel(makeAndModelData.get("Make"), makeAndModelData.get("Model"));
    }

    @When("{actor} finds his/her car by make and model:")
    public void he_finds_his_car_by_make_and_model(Actor actor,MakeAndModel makeAndModel) {
        actor.attemptsTo(
                Click.on(Link.withText("find your car by make or model")),
                Select.option(makeAndModel.make()).from("#makeId-radio-group"),
                Select.option(makeAndModel.model()).from("#modelId-radio-select")
        );
    }

    @DataTableType
    public QuestionAndAnswer questionAndAnswer(Map<String, String> questionAndAnswerFields){
        return new QuestionAndAnswer(questionAndAnswerFields.get("Question"), questionAndAnswerFields.get("Answer"));
    }
    @When("he provides the following additional details:")
    public void he_provides_the_following_additional_details(List<QuestionAndAnswer> questionsAndAnswers) {

    }
    @Then("he should be proposed the following cars:")
    public void he_should_be_proposed_the_following_cars(List<String> proposedCars) {

    }

}
