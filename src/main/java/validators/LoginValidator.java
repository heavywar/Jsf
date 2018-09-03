package validators;

import java.util.ResourceBundle;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("validators.LoginValidator")
public class LoginValidator implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {

        try {
            if (value.toString().length() < 5) {
               throw new IllegalArgumentException("Слово должно быть больше 5 знаков");
            }
            if (!Character.isLetter(value.toString().charAt(0))) {
                throw new IllegalArgumentException("Слово должно начинаться с буквы");

            }
        }catch (IllegalArgumentException e) {
            FacesMessage message = new FacesMessage(e.getMessage());

            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(message);
        }
    }
    
}
