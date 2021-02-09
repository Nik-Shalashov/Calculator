package ru.android1.calculator;

public class ButtonsProcessing {

    private long firstArg;
    private long secondArg;
    private long actionSelected;
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
        }
    }

    public void onActionClick(int actionId) {

    }

    public String getText() {
        return inputInfo.toString();
    }

}
