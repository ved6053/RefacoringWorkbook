package com.refacoring.workbook.duplication;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.crypto.spec.PSource;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class RemoveDuplicationTest  {
    private static RemoveDuplication removeDuplication = new RemoveDuplication();;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }
    @Test
    public void testRemoveTemplate(){
        String sourceTemplate = "alKGLDLHSL%CODE%125337538hjkaGHDKHSK%ALTCODE%21583967963";
        String replaceWith = "32514327586597538";
        removeDuplication.printTemplate(sourceTemplate, replaceWith);
        assertEquals(outContent.toString(), "alKGLDLHSL32514327586597538125337538hjkaGHDKHSK%ALTCODE%21583967963alKGLDLHSL%CODE%125337538hjkaGHDKHSK32514-32721583967963");
    }

    @Test
    public void testRemoveTemplateWhenCODEMissing(){
        String sourceTemplate = "hjkaGHDKHSK%ALTCODE%21583967963";
        String replaceWith = "32514327586597538";
        removeDuplication.printTemplate(sourceTemplate, replaceWith);
        assertEquals(outContent.toString(), "Error in substitute()");
    }

    @Test
    public void testRemoveTemplateWhenALTCODECODEMissing(){
        String sourceTemplate = "hjkaGHDKHSK%CODE%21583967963";
        String replaceWith = "32514327586597538";
        removeDuplication.printTemplate(sourceTemplate, replaceWith);
        assertEquals(outContent.toString(), "hjkaGHDKHSK3251432758659753821583967963Error in substitute()");
    }
}
