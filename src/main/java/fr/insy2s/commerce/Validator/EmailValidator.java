package fr.insy2s.commerce.Validator;


import org.springframework.stereotype.Service;

import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class EmailValidator implements Predicate<String> {

    private static final String EMAIL_PATTERN = "^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";

    private static final Pattern pattern = Pattern.compile(EMAIL_PATTERN);
    @Override
    public boolean test(final String email){
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();

    }
}
