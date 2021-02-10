package ru.android1.calculator;

import android.annotation.SuppressLint;

public class ButtonsProcessing {

    private double firstArg;
    private double secondArg;
    private int actionSelected;
    private State state;

    private enum State {
        firstArgInput,
        operationSelected,
        secondArgInput,
        resultShow
    }

    StringBuilder inputInfo = new StringBuilder();

    public ButtonsProcessing() {
        state = State.firstArgInput;
    }

    @SuppressLint("NonConstantResourceId")
    public void onNumberClick(int buttonID) {
        if (state == State.resultShow) {
            state = State.firstArgInput;
            inputInfo.setLength(0);
        }

        if (state == State.operationSelected) {
            state = State.secondArgInput;
            inputInfo.setLength(0);
        }

        switch (buttonID) {
            case R.id.button0:
                if (inputInfo.length() != 0) {
                    inputInfo.append("0");
                }
                break;
            case R.id.button1:
                inputInfo.append("1");
                break;
            case R.id.button2:
                inputInfo.append("2");
                break;
            case R.id.button3:
                inputInfo.append("3");
                break;
            case R.id.button4:
                inputInfo.append("4");
                break;
            case R.id.button5:
                inputInfo.append("5");
                break;
            case R.id.button6:
                inputInfo.append("6");
                break;
            case R.id.button7:
                inputInfo.append("7");
                break;
            case R.id.button8:
                inputInfo.append("8");
                break;
            case R.id.button9:
                inputInfo.append("9");
                break;
            case R.id.buttonPoint:
                inputInfo.append(".");
        }
    }

    @SuppressLint("NonConstantResourceId")
    public void onActionClick(int actionId) {
        if (actionId == R.id.buttonResult && state == State.secondArgInput && inputInfo.length() > 0) {
            secondArg = Double.parseDouble(inputInfo.toString());
            state = State.resultShow;
            inputInfo.setLength(0);
            switch (actionSelected) {
                case R.id.buttonAddition:
                    inputInfo.append(firstArg + secondArg);
                    break;
                case R.id.buttonSubtraction:
                    inputInfo.append(firstArg - secondArg);
                    break;
                case R.id.buttonMultiply:
                    inputInfo.append(firstArg * secondArg);
                    break;
                case R.id.buttonDivide:
                    inputInfo.append(firstArg / secondArg);
                    break;
            }

        } else if (inputInfo.length() > 0 && state == State.firstArgInput) {
            firstArg = Double.parseDouble(inputInfo.toString());
            state = State.operationSelected;
            actionSelected = actionId;
        }
    }

    public String getText() {
        StringBuilder str = new StringBuilder();
        switch (state) {
            default:
                return inputInfo.toString();
            case operationSelected:
                return str.append(firstArg).append(' ')
                        .append(getOperationChar())
                        .toString();
            case secondArgInput:
                return str.append(firstArg).append(' ')
                        .append(getOperationChar())
                        .append(' ')
                        .append(inputInfo)
                        .toString();
            case resultShow:
                return str.append(firstArg).append(' ')
                        .append(getOperationChar())
                        .append(' ')
                        .append(secondArg)
                        .append(" = ")
                        .append(inputInfo.toString())
                        .toString();
        }
    }

    @SuppressLint("NonConstantResourceId")
    private char getOperationChar() {
        switch (actionSelected) {
            case R.id.buttonAddition:
                return '+';
            case R.id.buttonSubtraction:
                return '-';
            case R.id.buttonMultiply:
                return '*';
            case R.id.buttonDivide:
            default:
                return '/';
        }
    }

    public void reset() {
        state = State.firstArgInput;
        inputInfo.setLength(0);
    }

}
