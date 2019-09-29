package com.pismery.study.gof23.pattern.behavior.interpreter;

import com.pismery.study.gof23.pattern.behavior.interpreter.nonterminal.AimNode;
import com.pismery.study.gof23.pattern.behavior.interpreter.nonterminal.DirectionNode;
import com.pismery.study.gof23.pattern.behavior.interpreter.nonterminal.ExpressionNode;
import com.pismery.study.gof23.pattern.behavior.interpreter.terminal.DbNameNode;
import com.pismery.study.gof23.pattern.behavior.interpreter.terminal.OperationNode;

public class Interperter {

    public static final int VIEW_COMMAND_LENGTH = 6;
    public static final int TABLE_COMMAND_LENGTH = 7;

    private Interperter() {
    }

    public static String interperter(String command) {
        String[] commandStrs = command.split(" ");

        if (commandStrs.length == VIEW_COMMAND_LENGTH)
            return viewInterpert(commandStrs);

        if (commandStrs.length == TABLE_COMMAND_LENGTH)
            return tableInterpert(commandStrs);

        return errorInterpert();
    }


    private static String viewInterpert(String[] commandStrs) {

        if (!validateViewCommand(commandStrs))
            return errorInterpert();

        AbstractNode operationNode = new OperationNode(KeyWord.valueOf(commandStrs[0].toUpperCase()));
        AbstractNode aimNode = new AimNode(KeyWord.valueOf(commandStrs[1].toUpperCase()), null);
        AbstractNode directionNode = new DirectionNode(new DbNameNode(commandStrs[3]), new DbNameNode(commandStrs[5]));

        return new ExpressionNode(operationNode, aimNode, directionNode).interpert();
    }

    private static String tableInterpert(String[] commandStrs) {

        if (!validateTableCommand(commandStrs))
            return errorInterpert();

        AbstractNode operationNode = new OperationNode(KeyWord.valueOf(commandStrs[0].toUpperCase()));
        AbstractNode aimNode = new AimNode(KeyWord.valueOf(commandStrs[1].toUpperCase()), new DbNameNode(commandStrs[2]));
        AbstractNode directionNode = new DirectionNode(new DbNameNode(commandStrs[4]), new DbNameNode(commandStrs[6]));

        return new ExpressionNode(operationNode, aimNode, directionNode).interpert();
    }

    private static boolean validateViewCommand(String[] commandStrs) {
        if (commandStrs.length != VIEW_COMMAND_LENGTH)
            return false;

        if (!KeyWord.isKeyWork(commandStrs[0], KeyWord.MOVE)
                && !KeyWord.isKeyWork(commandStrs[0], KeyWord.COPY))
            return false;

        if (!KeyWord.isKeyWork(commandStrs[1], KeyWord.VIEW))
            return false;

        if (!KeyWord.isKeyWork(commandStrs[2], KeyWord.FROM))
            return false;

        if (!KeyWord.isKeyWork(commandStrs[4], KeyWord.TO))
            return false;

        return true;
    }

    private static boolean validateTableCommand(String[] commandStrs) {
        if (commandStrs.length != TABLE_COMMAND_LENGTH)
            return false;

        if (!KeyWord.isKeyWork(commandStrs[0], KeyWord.MOVE)
                && !KeyWord.isKeyWork(commandStrs[0], KeyWord.COPY))
            return false;

        if (!KeyWord.isKeyWork(commandStrs[1], KeyWord.TABLE))
            return false;

        if (!KeyWord.isKeyWork(commandStrs[3], KeyWord.FROM))
            return false;

        if (!KeyWord.isKeyWork(commandStrs[5], KeyWord.TO))
            return false;

        return true;
    }

    private static String errorInterpert() {
        return "命令格式错误";
    }
}
