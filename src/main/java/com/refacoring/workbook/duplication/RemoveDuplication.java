package com.refacoring.workbook.duplication;
import static java.lang.System.out;

public class RemoveDuplication {

    void printTemplate(String sourceTemplate, String replaceWith) {
        try {
            out.print(getTemplate(sourceTemplate, replaceWith, "%CODE%"));
            out.print(getTemplate(sourceTemplate, replaceWith.substring(0,5) + "-" + replaceWith.substring(5,8), "%ALTCODE%"));
        } catch (Exception e) {
            out.print("Error in substitute()");
        }
    }

   String  getTemplate(String template,String replaceWith, String suffix) {
       int templateSplitBegin = template.indexOf(suffix);
       int templateSplitEnd = templateSplitBegin + suffix.length();
       return template.substring(0, templateSplitBegin) + replaceWith +  template.substring(templateSplitEnd, template.length());
   }

}
