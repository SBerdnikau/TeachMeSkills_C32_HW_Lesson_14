package com.teachmeskills.lesson_14.task1.validator;

import com.teachmeskills.lesson_14.task1.constant.Constants;
import com.teachmeskills.lesson_14.task1.exception.WrongDocumentException;
import com.teachmeskills.lesson_14.task1.exception.WrongFileException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileManager {

   public void parserDocument() throws WrongFileException {
       try {
           List<String> documents = Files.readAllLines(Paths.get(Constants.RESOURCE_PATH_DOCUMENTS));
           List<String> validContract = new ArrayList<>();
           List<String> validDocum = new ArrayList<>();
           List<String> invalidDocument = new ArrayList<>();

           for (String document : documents){
               try {
                   Validator.validDocument(document);
                   if (document.startsWith(Constants.PREFIX_DOCNUM)){
                       validDocum.add(document);
                   } else if (document.startsWith(Constants.PREFIX_CONTRACT)) {
                       validContract.add(document);
                   }
               }catch (WrongDocumentException e){
                   invalidDocument.add(document + " - " + e.getMessage() + Constants.CODE_ERR_NUMBER + e.getErrorCode());
               }

           }

           writeDocument(validContract, validDocum, invalidDocument);

       } catch (IOException e) {
           throw new WrongFileException(Constants.FILE_NOT_FOUND, 400);
       }catch (Exception e){
           throw new WrongFileException(Constants.INCORRECT_READ_FILE, 401);
       }
   }

   private void writeDocument(List<String> validContract, List<String> validDocum, List<String> invalidDocument) throws IOException {
       Files.write(Paths.get(Constants.PATH_REPORT_CONTRACT), validContract);
       Files.write(Paths.get(Constants.PATH_REPORT_DOCNUM), validDocum);
       Files.write(Paths.get(Constants.PATH_REPORT_INVALID_DOCUMENT), invalidDocument);
   }

}


