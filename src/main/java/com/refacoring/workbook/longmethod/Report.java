package com.refacoring.workbook.longmethod;

import java.util.*;
import java.io.*;

public class Report {
    public static void report(Writer out, List<Machine> machines, Robot robot)
            throws IOException
    {
        out.write("FACTORY REPORT\n");
        writeMachines(out, machines);
        writeRobot(out, robot);
        out.write("========\n");

    }

    private static void writeMachines(Writer out, List<Machine> machines) throws IOException {
        for(Machine machine:machines) {
            writeMachine(out, machine);
        }
        out.write("\n");
    }
    private static void writeMachine(Writer out,  Machine machine) throws IOException {
        out.write("Machine " + machine.name());
        if (machine.bin() != null)
            out.write(" bin=" + machine.bin());
        out.write("\n");
    }

    private static void writeRobot(Writer out, Robot robot) throws IOException{
        out.write("Robot");
        if (robot.location() != null)
            out.write(" location=" + robot.location().name());

        if (robot.bin() != null)
            out.write(" bin=" + robot.bin());
        out.write("\n");

    }
}
