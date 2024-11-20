package com.teachmeskills.lesson_14.task1.validator;

import com.teachmeskills.lesson_14.task1.constant.Constants;
import com.teachmeskills.lesson_14.task1.exception.WrongDocumentException;

import java.util.regex.Pattern;

public class Validator {

    private final static Pattern PATTERN = Pattern.compile(Constants.REGEXP);

    public static void validDocument(String document) throws WrongDocumentException {
        if (document.length() != 15){
            throw new WrongDocumentException(Constants.INCORRECT_LENGTH, 100);
        }
        if (!document.startsWith(Constants.PREFIX_DOCNUM)  && !document.startsWith(Constants.PREFIX_CONTRACT) ){
            throw new WrongDocumentException(Constants.INCORRECT_FORMAT, 200);
        }

        if (!PATTERN.matcher(document).matches()){
            throw new WrongDocumentException(Constants.INCORRECT_CHARACTERS, 300);
        }
    }
}
