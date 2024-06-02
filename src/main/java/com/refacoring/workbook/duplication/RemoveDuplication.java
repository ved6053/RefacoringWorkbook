package com.refacoring.workbook.duplication;
import static java.lang.System.out;

public class RemoveDuplication {

    void printTemplate(String sourceTemplate, String reqId) {
        try {    String template = new String(sourceTemplate);
            // Substitute for %CODE%
            int templateSplitBegin = template.indexOf("%CODE%");
            int templateSplitEnd = templateSplitBegin + 6;
            String templatePartOne = new String(
                    template.substring(0, templateSplitBegin));
            String templatePartTwo = new String(
                    template.substring(templateSplitEnd, template.length()));
            String code = new String(reqId);
            out.print(new String(templatePartOne + code + templatePartTwo));

            // Substitute for %ALTCODE%
            templateSplitBegin = template.indexOf("%ALTCODE%");
            templateSplitEnd = templateSplitBegin + 9;
            templatePartOne = new String(
                    template.substring(0, templateSplitBegin));
            templatePartTwo = new String(
                    template.substring(templateSplitEnd, template.length()));
           String altcode = code.substring(0,5) + "-" + code.substring(5,8);
            out.print(templatePartOne + altcode + templatePartTwo);
        } catch (Exception e) {
            out.println("Error in substitute()");
        }
    }

}